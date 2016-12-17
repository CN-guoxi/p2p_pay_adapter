package com.qd.p2p.sina.pay.enums;

public enum AccountType {

	BASIC("基本户"),
	ENSURE("保证金户"),
	RESERVE("准备金"),
	SAVING_POT("存钱罐");
	
	String accountName;
	
	AccountType(String accountName){
		this.accountName = accountName;
	}

	public String getAccountName() {
		return accountName;
	}
	
	@Override
    public String toString(){
    	return this.name();
    }
	
}
