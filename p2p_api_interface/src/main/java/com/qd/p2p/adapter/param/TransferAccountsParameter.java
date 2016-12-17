package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-单笔转账
 *
 * @author ygw
 * @version V1.0.0
 * @date 2016-04-08
 */
@SuppressWarnings("serial")
public class TransferAccountsParameter extends AbstractParameter {

    /**
     * 订单号
     */
    private String orderId;
    
    /**
     * 付款方用户号(如对应的类型为1 则为商户号，否则为平台user_id)
     */
    private String payerUserId;
    
    /**
     * 收款方用户号(如对应的类型为1 则为商户号，否则为平台user_id)
     */
    private String payeeUserId;
    
    /**
     * 付款方帐号类型(0为普通用户(平台的user_id) 1为商户号)
     */
    private int payerType;
    
    /**
     * 收款方帐号类型(0为普通用户(平台的user_id) 1为商户号)
     */
    private int payeeType;
    
    /**
     * 转账金额
     */
  	private double amount;
    
    /**
     * 手续费(该费用将会从指定费用方账户收取到平台可用账户)
     */
    private double fee;
    
    /**
     * 费用收取方(0付款方1收款方)
     */
    private int feeTakenOn;

	/**
	 * 请求时间
	 */
	private long reqTime;

    /**
	 * @return orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId 订单号
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return payerUserId
	 */
	public String getPayerUserId() {
		return payerUserId;
	}

	/**
	 * @param payerUserId 付款方用户号(如对应的类型为1 则为商户号，否则为平台user_id)
	 */
	public void setPayerUserId(String payerUserId) {
		this.payerUserId = payerUserId;
	}

	/**
	 * @return payeeUserId
	 */
	public String getPayeeUserId() {
		return payeeUserId;
	}

	/**
	 * @param payeeUserId 收款方用户号(如对应的类型为1 则为商户号，否则为平台user_id)
	 */
	public void setPayeeUserId(String payeeUserId) {
		this.payeeUserId = payeeUserId;
	}

	/**
	 * @return payerType
	 */
	public int getPayerType() {
		return payerType;
	}

	/**
	 * @param payerType 付款方帐号类型(0为普通用户(平台的user_id) 1为商户号)
	 */
	public void setPayerType(int payerType) {
		this.payerType = payerType;
	}

	/**
	 * @return payeeType
	 */
	public int getPayeeType() {
		return payeeType;
	}

	/**
	 * @param payeeType 收款方帐号类型(0为普通用户(平台的user_id) 1为商户号)
	 */
	public void setPayeeType(int payeeType) {
		this.payeeType = payeeType;
	}

	/**
	 * @return amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount 转账金额
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return fee
	 */
	public double getFee() {
		return fee;
	}

	/**
	 * @param fee 手续费(该费用将会从指定费用方账户收取到平台可用账户)
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}

	/**
	 * @return feeTakenOn
	 */
	public int getFeeTakenOn() {
		return feeTakenOn;
	}

	/**
	 * @param feeTakenOn 费用收取方(0付款方1收款方)
	 */
	public void setFeeTakenOn(int feeTakenOn) {
		this.feeTakenOn = feeTakenOn;
	}

	/**
	 * @return reqTime
	 */
	public long getReqTime() {
		return reqTime;
	}

	/**
	 * @param reqTime 请求时间
	 */
	public void setReqTime(long reqTime) {
		this.reqTime = reqTime;
	}


    
}
