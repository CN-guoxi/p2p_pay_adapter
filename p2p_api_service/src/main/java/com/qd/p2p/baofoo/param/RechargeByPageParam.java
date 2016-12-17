package com.qd.p2p.baofoo.param;

import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.FeeTaken;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;


@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.RECHARGE_PAGE)
@XStreamAlias("custody_req")
public class RechargeByPageParam extends AbstractRequestParam implements IHtmlResponsiveRequestParam{

	//商户号
	@XStreamAlias("merchant_id")
	private String merchant_id;
	
	//用户编号(唯一)
	@XStreamAlias("user_id")
	private String userId;
	
	//订单号 (唯一不可重复)
	@XStreamAlias("order_id")
	private String orderId;
	
	//充值金额，单位：元
	private double amount;
	
	//充值手续费,单位：元
	private double fee;
	
	//费用承担方(宝付收取的费用)
	@XStreamAlias("fee_taken_on")
	private int feeTakenOn;
	
	//其它信息
	@XStreamAlias("additional_info")
	private String additionalInfo;
	
	//充值页面资源请求url
	@XStreamAlias("page_url")
	private String pageUrl;
	
	//充值后台资源请求url
	@XStreamAlias("return_url")
	private String returnUrl;

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public void setFeeTakenOn(FeeTaken feeTaken) {
		this.feeTakenOn = feeTaken.getType();
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	
}
