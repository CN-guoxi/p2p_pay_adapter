package com.qd.p2p.sina.pay.enums;

/**
 * 通知方式
 * @author linya 2015-12-23
 */
public enum NotifyMethod {

	single_notify("逐笔通知"),
	batch_notify("批量通知");
	
	String name;
	
	NotifyMethod(String name){
		this.name = name;
	}

}
