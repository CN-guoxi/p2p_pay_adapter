package com.qd.p2p.baofoo.http;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.RequestHandlerException;
import com.qd.p2p.baofoo.param.IExcelRequestParam;
import com.qd.p2p.baofoo.util.HttpRequestUtil;

/**
 * Http请求发送器
 * @author linya
 */
public class HttpPostSender implements PostSender {

	protected HttpPostSender(){}
	
	@Override
	public boolean supports(String url) {
		return url.startsWith("http") && !url.startsWith("https");
	}

	@Override
	public String send(IRequestParam requestParam, String url, String param, String chartSet) throws RequestHandlerException {
		String responseString;
		try {
			// 导出为Excel文件
			if (requestParam instanceof IExcelRequestParam) {
				responseString = HttpRequestUtil.sendHttpPostExcel(url, param);
			} else {
				responseString = HttpRequestUtil.sendHttpPost(url, param);
			}
		} catch (Exception e) {
			throw new RequestHandlerException("++++ Baofoo HTTP请求失败", e);
		}
		return responseString;
	}

}
