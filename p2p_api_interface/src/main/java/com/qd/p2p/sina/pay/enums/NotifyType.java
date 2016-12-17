package com.qd.p2p.sina.pay.enums;

/**
 * 通知类型
 * @author linya 2015-12-23
 */
public enum NotifyType {

	trade_status_sync("交易结果通知"),
	refund_status_sync("交易退款结果通知"),
	deposit_status_sync("充值结果通知"),
	withdraw_status_sync("提现结果通知"),
	batch_trade_status_sync("批量交易结果通知"),
	audit_status_sync("审核结果通知");
	
	String name;
	
	NotifyType(String name) {
		this.name = name;
	}

}
