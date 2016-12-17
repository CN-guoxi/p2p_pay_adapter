package com.qd.p2p.baofoo.parser;

import com.qd.p2p.baofoo.IRequestParam;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public abstract class AbstarctXmlDataParser implements DataParser{

	private static final String XML_HEAD = "<?xml version='1.0' encoding='UTF-8'?>";
	
	@Override
	public DataType supportsDataType() {
		return DataType.XML;
	}
	
	protected String object2Xml(IRequestParam requestParam){
		XStream xstream = new XStream(new XppDriver(new NoNameCoder()));
		xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(requestParam);
		System.out.println("XML-- " + XML_HEAD + xml);
		return XML_HEAD + xml;
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T xml2Object(String responseString, Class<T> clazz){
		XStream xstream = new XStream(new XppDriver(new NoNameCoder()));
		xstream.autodetectAnnotations(true);
		String alias;
		XStreamAlias xStreamAlias = clazz.getAnnotation(XStreamAlias.class);
		if(xStreamAlias == null){
			alias = clazz.getName();
		}else{
			alias = xStreamAlias.value();
		}
		xstream.alias(alias, clazz);
		Object object = xstream.fromXML(responseString);
		return (T)object;
	}
}
