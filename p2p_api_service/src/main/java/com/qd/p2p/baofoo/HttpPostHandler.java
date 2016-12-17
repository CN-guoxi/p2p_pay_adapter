package com.qd.p2p.baofoo;

import com.qd.p2p.baofoo.datagram.DatagramGenerator;
import com.qd.p2p.baofoo.datagram.DatagramGeneratorFactory;
import com.qd.p2p.baofoo.http.PostSenderHelper;
import com.qd.p2p.baofoo.parser.DataType;
import com.qd.p2p.baofoo.util.CommonUtil;
import com.qd.p2p.baofoo.util.Log;

public class HttpPostHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String request(IRequestParam param, String content, DataType dataType) throws RequestHandlerException{
		
		//发送请求
		String responseStr = null;
		
		try {
			Log.info("[加密报文前]:" + content);
			
			//AES加密
			if(param.aesEncrypt()){
				content = CommonUtil.aesEncryptKey16(content, ConfigurationConsts.KEY_PWD);
			}
			
			//签名
			String sign = CommonUtil.MD5(content +"~|~"+ ConfigurationConsts.KEY_PWD);
			
			//获取报文参数
			DatagramGenerator generator = DatagramGeneratorFactory.getDatagramGenerator(param);
			String params = generator.generate(param, content, sign);
			
			//请求URL
			String urlSuffix = param.getUrlSuffix();
			String requestUrl = ConfigurationConsts.DOMAIN + urlSuffix;
			Log.info("[请求地址]:" + requestUrl + "?" + params);
			
			//发起请求，获得响应字符串
			responseStr = PostSenderHelper.send(param, requestUrl, params, "utf-8");
			
			System.out.println("[返回报文]:" + responseStr);
		} catch (Exception e) {
			throw new RequestHandlerException("++++ Baofoo HTTP请求失败", e);
		}
		
		return responseStr;
	}
	
}
