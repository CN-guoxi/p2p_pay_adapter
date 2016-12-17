package com.qd.p2p.sina.pay.enums;

public enum IdentityType {

	UID("商户用户ID"),
	MOBILE("钱包绑定手机号"),
	EMAIL("钱包绑定邮箱"),
	MEMBER_ID("用户在SINA支付的会员编号");
	
	String name;
	
	IdentityType(String name){
		this.name = name;
	}

	public String toString() {
		return name();
	}

	
}
