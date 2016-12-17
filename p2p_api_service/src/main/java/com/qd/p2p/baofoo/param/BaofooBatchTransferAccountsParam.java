package com.qd.p2p.baofoo.param;

import java.util.List;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.BatchTransferAccountsParameter;
import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.15批量转账（服务端接口）请求参数
 *
 * @author ygw
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@Strategy(ServiceStrategy.BATCH_TRANSFER)
@XStreamAlias("custody_req")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=BatchTransferAccountsParameter.class)
public class BaofooBatchTransferAccountsParam extends AbstractRequestParam implements ParameterAdapter<BatchTransferAccountsParameter> {
	
	/**
     * 商户号
     */
    @XStreamAlias("merchant_id")
    private String merchantId;
    
    /**
     * 服务端回调URL
     */
    @XStreamAlias("service_url")
    private String serviceUrl;
    
    /**
     * 请求时间
     */
    @XStreamAlias("req_time")
    private String reqTime;
    
    @XStreamAlias("actions")
    private List<Action> actions;
    
    @XStreamAlias("action")
    public static class Action {
    	
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

	/**
	 * @return merchantId 商户号
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId 商户号
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return serviceUrl 服务端回调URL
	 */
	public String getServiceUrl() {
		return serviceUrl;
	}

	/**
	 * @param serviceUrl 服务端回调URL
	 */
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	/**
	 * @return actions
	 */
	public List<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions
	 */
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public void adapter(BatchTransferAccountsParameter t) {
		this.merchantId = ConfigurationConsts.MERCHANT_ID;
		// <TODO>
	}

}
