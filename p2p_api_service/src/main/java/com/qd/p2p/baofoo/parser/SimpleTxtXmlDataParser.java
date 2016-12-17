package com.qd.p2p.baofoo.parser;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.RequestHandlerException;
import com.qd.p2p.baofoo.param.ITxtRequestParam;

/**
 * 文本(txt)类型数据解析器
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
public class SimpleTxtXmlDataParser extends AbstarctXmlDataParser {

	@Override
	public Class<? extends IRequestParam> supportsRequestParam() {
		return ITxtRequestParam.class;
	}

	@Override
	public String parseRequest(IRequestParam param) throws RequestHandlerException {
		ITxtRequestParam paramTxt = (ITxtRequestParam) param;
		return paramTxt.getRequestParams();
	}

	@Override
	public <T extends IResponse> T parseResponse(String responseString, Class<T> responseClass) throws RequestHandlerException {
		return xml2Object(responseString, responseClass);
	}

}
