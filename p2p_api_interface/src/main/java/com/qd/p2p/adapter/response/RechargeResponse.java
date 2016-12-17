package com.qd.p2p.adapter.response;

import com.qd.p2p.adapter.AbstractResponse;

/**
 * 响应-充值
 * @author linya
 */
public class RechargeResponse extends AbstractResponse {

	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
