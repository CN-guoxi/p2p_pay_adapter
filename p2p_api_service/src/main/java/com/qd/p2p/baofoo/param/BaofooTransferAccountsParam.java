package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.TransferAccountsParameter;
import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.14单笔转账（服务端接口）请求参数
 *
 * @author ygw
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@Strategy(ServiceStrategy.TRANSFER)
@XStreamAlias("custody_req")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=TransferAccountsParameter.class)
public class BaofooTransferAccountsParam extends AbstractRequestParam implements ParameterAdapter<TransferAccountsParameter> {
	
	/**
     * 商户号
     */
    @XStreamAlias("merchant_id")
    private String merchantId;
    
    /**
     * 订单号
     */
    @XStreamAlias("order_id")
    private String orderId;
    
    /**
     * 付款方用户号(如对应的类型为1 则为商户号，否则为平台user_id)
     */
    @XStreamAlias("payer_user_id")
    private String payerUserId;
    
    /**
     * 收款方用户号(如对应的类型为1 则为商户号，否则为平台user_id)
     */
    @XStreamAlias("payee_user_id")
    private String payeeUserId;
    
    /**
     * 付款方帐号类型(0为普通用户(平台的user_id) 1为商户号)
     */
    @XStreamAlias("payer_type")
    private int payerType;
    
    /**
     * 收款方帐号类型(0为普通用户(平台的user_id) 1为商户号)
     */
    @XStreamAlias("payee_type")
    private int payeeType;
    
    /**
     * 转账金额
     */
    @XStreamAlias("amount")
  	private double amount;
    
    /**
     * 手续费(该费用将会从指定费用方账户收取到平台可用账户)
     */
    @XStreamAlias("fee")
    private double fee;
    
    /**
     * 费用收取方(0付款方1收款方)
     */
    @XStreamAlias("fee_taken_on")
    private int feeTakenOn;
    
    /**
     * 请求时间
     */
    @XStreamAlias("req_time")
    private String reqTime;

	/**
	 * @return merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return orderId 订单号
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
	 * @return payerUserId 付款方用户号
	 */
	public String getPayerUserId() {
		return payerUserId;
	}

	/**
	 * @param payerUserId 付款方用户号
	 */
	public void setPayerUserId(String payerUserId) {
		this.payerUserId = payerUserId;
	}

	/**
	 * @return payeeUserId 收款方用户号
	 */
	public String getPayeeUserId() {
		return payeeUserId;
	}

	/**
	 * @param payeeUserId 收款方用户号
	 */
	public void setPayeeUserId(String payeeUserId) {
		this.payeeUserId = payeeUserId;
	}

	/**
	 * @return payerType 付款方帐号类型0或1(0为普通用户(平台的user_id) 1为商户号)
	 */
	public int getPayerType() {
		return payerType;
	}

	/**
	 * @param payerType 付款方帐号类型0或1(0为普通用户(平台的user_id) 1为商户号)
	 */
	public void setPayerType(int payerType) {
		this.payerType = payerType;
	}

	/**
	 * @return payeeType 收款方帐号类型0或1(0为普通用户(平台的user_id) 1为商户号)
	 */
	public int getPayeeType() {
		return payeeType;
	}

	/**
	 * @param payeeType 收款方帐号类型0或1(0为普通用户(平台的user_id) 1为商户号)
	 */
	public void setPayeeType(int payeeType) {
		this.payeeType = payeeType;
	}

	/**
	 * @return amount 转账金额
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
	 * @return fee 手续费
	 */
	public double getFee() {
		return fee;
	}

	/**
	 * @param fee 手续费
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}

	/**
	 * @return feeTakenOn 费用收取方0或1（0付款方1收款方）
	 */
	public int getFeeTakenOn() {
		return feeTakenOn;
	}

	/**
	 * @param feeTakenOn 费用收取方0或1（0付款方1收款方）
	 */
	public void setFeeTakenOn(int feeTakenOn) {
		this.feeTakenOn = feeTakenOn;
	}

	/**
	 * @return reqTime 请求时间
	 */
	public String getReqTime() {
		return reqTime;
	}

	/**
	 * @param reqTime 请求时间
	 */
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	@Override
	public void adapter(TransferAccountsParameter t) {
		this.merchantId = ConfigurationConsts.MERCHANT_ID;
		this.orderId = t.getOrderId();
	    this.payerUserId = t.getPayerUserId();
	    this.payeeUserId = t.getPayeeUserId();
	    this.payerType = t.getPayerType();
	    this.payeeType = t.getPayeeType();
	    this.amount = t.getAmount();
	    this.fee = t.getFee();
	    this.feeTakenOn = t.getFeeTakenOn();
	    this.reqTime = String.valueOf(t.getReqTime());
	}

}
