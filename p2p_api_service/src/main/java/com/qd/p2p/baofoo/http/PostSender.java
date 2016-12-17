package com.qd.p2p.baofoo.http;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.RequestHandlerException;

/**
 * 请求发送器
 * @author linya
 */
public interface PostSender {

	/**
	 * 判断是否支持url
	 * @param url
	 * @return
	 */
	boolean supports(String url);
	
	/**
	 * 请求URL
	 * @param requestParam
	 * @param url
	 * @param param
	 * @param chartSet
	 * @return
	 */
	String send(IRequestParam requestParam, String url, String param, String chartSet) throws RequestHandlerException;
	
}
