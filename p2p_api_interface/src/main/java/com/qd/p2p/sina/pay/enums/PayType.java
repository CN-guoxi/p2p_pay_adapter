package com.qd.p2p.sina.pay.enums;

/**
 * Created by wuaj on 2015/12/23.
 */
public enum PayType {
    online_bank(1, "线上充值"),
    balance(2, "余额"),
    binding_pay(3, "绑卡支付"),
    quick_pay(4, "快捷支付");
    
    int type;
    String name;
    
    PayType(int type, String name){
    	this.type = type;
    	this.name = name;
    }
    
	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	@Override
    public String toString(){
    	return this.name();
    }
}