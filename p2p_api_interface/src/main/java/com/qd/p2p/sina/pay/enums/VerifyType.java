package com.qd.p2p.sina.pay.enums;

/**
 * 认证类型
 * @author hongbl 2015-12-24
 */
public enum VerifyType {

	MOBILE("手机"),	
	EMAIL("邮箱");	
	
	String verifyName;
	
	VerifyType(String verifyName){
		this.verifyName = verifyName;
	}
	
	@Override
    public String toString(){
    	return this.name();
    }
	
}
