package com.qd.p2p.baofoo.parser;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;

import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.RequestHandlerException;
import com.qd.p2p.baofoo.param.BaofooBankCardListParam;
import com.qd.p2p.baofoo.util.CommonUtil;

public class GetBankCardListXmlDataParser extends AbstarctXmlDataParser {

	@Override
	public Class<? extends IRequestParam> supportsRequestParam() {
		return BaofooBankCardListParam.class;
	}

	@Override
	public String parseRequest(IRequestParam param) throws RequestHandlerException {
		BaofooBankCardListParam bankCardListParam = (BaofooBankCardListParam)param;
		String params = bankCardListParam.getUserId();
		return params;
	}

	@Override
	public <T extends IResponse> T parseResponse(String responseString, Class<T> responseClass) throws RequestHandlerException {
		T response = null;
		try {
			XPath xPath= XPathFactory.newInstance().newXPath();
			Document root = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(responseString.getBytes("utf-8")));
			String info = xPath.evaluate("crs/info", root);
			String decryptResponseString = null;
			if(StringUtils.isBlank(info)){
				decryptResponseString = responseString.replace("<info>" + info + "</info>", "");
			}else{
				//解密
				String decryptInfo = CommonUtil.aesDecryptKey16(info, ConfigurationConsts.KEY_PWD);
				//替换成解密后的数据
				decryptResponseString = responseString.replace("<info>" + info + "</info>", decryptInfo);
			}
			response = xml2Object(decryptResponseString, responseClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
