package com.qd.p2p.baofoo.datagram;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.param.AbstractRequestParam;
import com.qd.p2p.sina.pay.util.DataUtils;

public class BaseDatagramGenerator<T extends AbstractRequestParam> implements DatagramGenerator<T> {

	//报文数据
	protected Map<String, Object> datagramMap = new HashMap<String, Object>();
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<T> supportsRequestParam() {
		return (Class<T>) AbstractRequestParam.class;
	}

	/**
	 * 为请求参数对象生产报文字符串
	 * @param param
	 * @param content
	 * @param dataType
	 * @return
	 */
	@Override
	public String generate(T param, String content, String sign) {
		baseDatagram(param, content, sign);
		String datagram = createLinkedParams(datagramMap, false);
		return datagram;
	}
	
	/**
	 * 定义基本报文参数
	 * @param param
	 * @param content
	 * @param dataType
	 */
	protected void baseDatagram(T param, String content, String sign){
		datagramMap.put("requestParams", content);
		datagramMap.put("sign", sign);
		datagramMap.put("merchant_id", ConfigurationConsts.MERCHANT_ID);
		datagramMap.put("terminal_id", ConfigurationConsts.TERMINAL_ID);
		addDatagram(param, datagramMap);
	}
	
	/**
	 * 子类实现添加报文参数（钩子方法）
	 * @param datagramMap
	 */
	protected void addDatagram(T param, Map<String, Object> datagramMap){
		
	}

	/**
	 * 创建请求参数
	 * @param params
	 * @param encode
	 * @return
	 */
	private static String createLinkedParams(Map<String, Object> params, boolean encode) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuffer preStr = new StringBuffer(200);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = DataUtils.toString(params.get(key));
            if (encode) {
                try {
                    value = URLEncoder.encode(URLEncoder.encode(value, "utf-8"), "utf-8");
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
