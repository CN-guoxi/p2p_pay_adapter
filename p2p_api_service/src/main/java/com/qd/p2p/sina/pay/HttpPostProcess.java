package com.qd.p2p.sina.pay;

import com.google.common.collect.Maps;
import com.qd.p2p.sina.pay.util.ConfigurationConsts;
import com.qd.p2p.sina.pay.util.DataUtils;
import com.qd.p2p.sina.pay.util.DateUtil;
import com.qd.p2p.sina.pay.util.SignUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.qd.p2p.sina.pay.util.HttpUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 请求工具类
 *
 * @author linya 2015-12-22
 */
public class HttpPostProcess {

	private static Logger log = Logger.getLogger(HttpPostProcess.class);

	private final static String VERSION = "1.0";

    private final static String INPUT_CHARSET = "UTF-8";

    private static String PARTNER_ID;

    private static String SIGN_TYPE;

    private static String RSA_SIGN_KEY;

    private static String MD5_SIGN_KEY;

    private static String SIGN_KEY;
    
    private static String CHECK_SIGN_KEY;

    private static String URL;

    private static String MEMBER_URL;
    
    private static volatile boolean inited = false;

    public static void init(){
    	if(inited){
    		return;
    	}
    	inited = true;
    	PARTNER_ID = ConfigurationConsts.MERCHANT_ID;
    	RSA_SIGN_KEY = ConfigurationConsts.RSA_PUBLIC;
    	MD5_SIGN_KEY = ConfigurationConsts.GOODS_KEY;
    	CHECK_SIGN_KEY = ConfigurationConsts.CHECK_SIGN_KEY;
    	SIGN_TYPE = com.qdlc.p2p.common.util.DataUtils.def(ConfigurationConsts.SIGN_TYPE, "MD5");
    	SIGN_KEY = "MD5".equalsIgnoreCase(SIGN_TYPE) ? MD5_SIGN_KEY : RSA_SIGN_KEY;
    	URL = ConfigurationConsts.SINA_URL;
    	MEMBER_URL = ConfigurationConsts.SINA_MEMBER_URL;
    }
    
    /**
     * 通过功能号调用中台Action层方法(参考struts.xml配置)
     *
     * @return
     * @author linya 2015-10-19
     */
    public static Map<String, Object> request(IRequestParam param) throws Exception {
    	init();
        Map<String, Object> pars = param.toMap();
        pars.put("version", VERSION);// 接口版本
        pars.put("request_time", DateUtil.dateStr3(DateUtil.getNow()));// 请求时间
        pars.put("partner_id", PARTNER_ID);// 合作伙伴id
        pars.put("_input_charset", INPUT_CHARSET);// 字符集编码

        // 获取签名
        String sign = getSign(pars);
        if (StringUtils.isEmpty(sign)) {
            throw new SignException("签名失败");
        }

        pars.put("sign", sign);// 签名类型
        pars.put("sign_type", SIGN_TYPE);
        String urlParam = createLinkString(pars, true);
        log.info("++++ request param:" + urlParam);
        String url = param.isMember() ? MEMBER_URL : URL;
        Map<String, Object> content = HttpUtils.sendPost(url, urlParam, INPUT_CHARSET);
        if (content.containsKey("req_html")) return content;

        Map<String, Object> cloneContent = new HashMap<String, Object>(content);

        String checkSign = DataUtils.toString(content.get("sign"));

        // 返回验证
        content.remove("sign");
        content.remove("sign_type");
        content.remove("sign_version");
        content.remove("req_status");
        String checkResult = createLinkString(content, false);
        if (!SignUtils.checkSign(checkResult, checkSign, SIGN_TYPE, CHECK_SIGN_KEY, INPUT_CHARSET)) {
            throw new SignException("验签失败,可能被篡改!");
        }
        return cloneContent;
    }

    /**
     * 签名
     *
     * @return
     */
    private static String getSign(Map<String, Object> requestMap) {
        // 签名时去掉sign_type
        Map<String, Object> signMap = Maps.newHashMap();
        signMap.putAll(requestMap);
        try {
            // 获取签名
            return SignUtils.sign(createLinkString(requestMap, false), SIGN_TYPE, SIGN_KEY, INPUT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @param encode 是否需要urlEncode
     * @return 拼接后字符串
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static String createLinkString(Map params, boolean encode) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuffer preStr = new StringBuffer(200);
        String charset = DataUtils.toString(params.get("_input_charset"));
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = DataUtils.toString(params.get(key));
            if (encode) {
                try {
                    value = URLEncoder.encode(URLEncoder.encode(value, charset), charset);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            
            // 拼接时，不包括最后一个&字符
            preStr.append(key).append("=").append(value);
            if(i != keys.size() - 1){
            	preStr.append("&");
            }
        }
        return preStr.toString();
    }
}
