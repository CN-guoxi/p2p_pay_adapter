package com.qd.p2p.sina.pay.enums;

/**
 * 证件类型
 * @author linya 2015-12-23
 *
 */
public enum CertType {
	
	IC("身份证");
	
	String name;
	
	CertType(String name){
		this.name = name;
	}
	
	@Override
    public String toString(){
    	return this.name();
    }
	
}
