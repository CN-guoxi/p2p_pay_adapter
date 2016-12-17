package com.qd.p2p.baofoo.http;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.RequestHandlerException;

/**
 * 请求发送帮助类
 * @author linya
 */
public class PostSenderHelper {

	private static PostSender httpSender = new HttpPostSender();
	private static PostSender httpsSender = new HttpsPostSender();
	
	public static String send(IRequestParam param, String url, String params, String charset) throws RequestHandlerException{
		boolean supports = httpSender.supports(url);
		PostSender sender = (supports ? httpSender : httpsSender);
		String responseString = sender.send(param, url, params, charset);
		return responseString;
	}
	
}
