package com.qd.p2p.baofoo.http;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.RequestHandlerException;
import com.qd.p2p.baofoo.param.IExcelRequestParam;
import com.qd.p2p.baofoo.util.HttpRequestUtil;

/**
 * Https请求发送器
 * @author linya
 */
public class HttpsPostSender implements PostSender {

	protected HttpsPostSender(){}
	
	@Override
	public boolean supports(String url) {
		return url.startsWith("https");
	}

	@Override
	public String send(IRequestParam requestParam, String url, String param, String charset) throws RequestHandlerException {
		String responseString;
		try {
			// 导出为Excel文件
			if (requestParam instanceof IExcelRequestParam) {
				responseString = HttpRequestUtil.sendHttpsPostExcel(url, param, charset);
			} else {
				responseString = HttpRequestUtil.sendHttpsPost(url, param, charset);
			}
		} catch (Exception e) {
			throw new RequestHandlerException("++++ Baofoo Http请求异常", e);
		}
		
		return responseString;
	}
	
}
