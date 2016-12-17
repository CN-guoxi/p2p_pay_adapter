package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-充值
 * @author linya
 */
@SuppressWarnings("serial")
public class RechargeParameter extends AbstractParameter {

	//用户编号(唯一)
	private String platformUserId;
	
	//订单号 (唯一不可重复)
	private String orderId;
	
	//充值金额，单位:分
	private double amount;
	
	//充值手续费,单位:元
	private double fee;
	
	//费用承担方(宝付收取的费用)
	private int feeTakenOn;
	
	//商户平台服务端通知地址
	private String returnUrl;

	public String getPlatformUserId() {
		return platformUserId;
	}

	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getFeeTakenOn() {
		return feeTakenOn;
	}

	public void setFeeTakenOn(int feeTakenOn) {
		this.feeTakenOn = feeTakenOn;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	
	
}
