package com.qd.p2p.sina.pay.enums;

/**
 * 卡认证方式
 * @author linya 2015-12-23
 */
public enum VerifyMode {

	SIGN("签约认证");
	
	String name;
	
	VerifyMode(String name){
		this.name = name;
	}
	
}
