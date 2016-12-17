package com.qd.p2p.baofoo.parser;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.RequestHandlerException;
import com.qd.p2p.baofoo.param.AbstractRequestParam;

public class SimpleXmlDataParser extends AbstarctXmlDataParser {

	@Override
	public Class<? extends IRequestParam> supportsRequestParam() {
		return AbstractRequestParam.class;
	}

	@Override
	public String parseRequest(IRequestParam param) throws RequestHandlerException {
		String xml = object2Xml(param);
		return xml;
	}

	@Override
	public <T extends IResponse> T parseResponse(String responseString, Class<T> responseClass) throws RequestHandlerException {
		T response = xml2Object(responseString, responseClass);
		System.out.println("Response-- " + response);
		return response;
	}

}
