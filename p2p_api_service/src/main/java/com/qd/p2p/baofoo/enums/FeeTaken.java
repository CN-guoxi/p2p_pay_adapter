package com.qd.p2p.baofoo.enums;

/**
 * 手续费承当方
 * @author linya
 */
public enum FeeTaken {

	PLATFORM(1,"平台"),
	USER(2, "用户自担");
	
	int type;
	
	String name;
	
	FeeTaken(int type, String name){
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
