package com.qd.p2p.sina.pay.enums;

/**
 * 卡属性
 * @author linya 2015-12-23
 */
public enum CardAttribute {

	C("对私"),
	B("对公");

	String name;
	
	CardAttribute(String name){
		this.name = name;
	}
	
	@Override
    public String toString(){
    	return this.name();
    }
	
}
