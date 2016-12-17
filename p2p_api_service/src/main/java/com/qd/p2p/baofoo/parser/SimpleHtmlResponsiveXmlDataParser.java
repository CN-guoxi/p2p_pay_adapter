package com.qd.p2p.baofoo.parser;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.RequestHandlerException;
import com.qd.p2p.baofoo.param.IHtmlResponsiveRequestParam;
import com.qd.p2p.baofoo.response.BaofooHtmlResponse;

public class SimpleHtmlResponsiveXmlDataParser extends AbstarctXmlDataParser {

	@Override
	public Class<? extends IRequestParam> supportsRequestParam() {
		return IHtmlResponsiveRequestParam.class;
	}

	@Override
	public String parseRequest(IRequestParam param) throws RequestHandlerException {
		String xml = object2Xml(param);
		return xml;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IResponse> T parseResponse(String responseString, Class<T> responseClass) throws RequestHandlerException {
		if(!BaofooHtmlResponse.class.equals(responseClass)){
			throw new IllegalArgumentException("++++ request is IHtmlResponsiveRequestParam type, response must to be BaofooHtmlResponse!");
		}
		BaofooHtmlResponse response = new BaofooHtmlResponse();
		response.setHtml(responseString);
		return (T) response;
	}

}
