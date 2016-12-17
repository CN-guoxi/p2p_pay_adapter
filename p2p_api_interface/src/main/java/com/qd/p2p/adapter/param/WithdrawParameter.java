package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-提现
 * @author linya
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
public class WithdrawParameter extends AbstractParameter{

	//提现订单号（唯一）
	private String orderId;
	
	//支付平台用户编号(唯一)
	private String platformUserId;

	//金额，单位：元
	private double amount;
	
	//平台收取的手续费, 单位:元 
	private double fee;
	
	//手续费，收取方
	private int feeTakenOn;
	
	//银行卡号
	private String bankNo;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPlatformUserId() {
		return platformUserId;
	}

	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
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

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	
}
