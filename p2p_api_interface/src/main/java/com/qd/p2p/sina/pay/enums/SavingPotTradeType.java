package com.qd.p2p.sina.pay.enums;

/**
 * 存钱罐交易类型
 * @author linya 2015-12-23
 */
public enum SavingPotTradeType {

	IN("申购"),
	OUT("赎回"),
	BONUS("收益");

	String name;
	
	SavingPotTradeType(String name){
		this.name = name;
	}
	
}
