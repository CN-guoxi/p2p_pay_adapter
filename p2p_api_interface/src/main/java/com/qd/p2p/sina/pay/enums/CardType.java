package com.qd.p2p.sina.pay.enums;

/**
 * 卡类型
 * @author linya 2015-12-23
 */
public enum CardType {

	DEBIT("借记"),
	CREDIT("贷记（信用卡）");

	String name;
	
	CardType(String name){
		this.name = name;
	}
	
	@Override
    public String toString(){
    	return this.name();
    }
    
}
