package com.qd.p2p.baofoo.parser;

public enum DataType {
	
	JSON, XML;
	
	public static DataType getDataType(String dataType){
		
		if(dataType == null){
			return JSON;
		}
		
		if(XML.name().equalsIgnoreCase(dataType)){
			return XML;
		}
		
		return JSON;
	}
}
