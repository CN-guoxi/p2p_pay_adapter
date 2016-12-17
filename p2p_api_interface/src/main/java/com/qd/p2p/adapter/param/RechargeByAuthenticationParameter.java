package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-认证支付
 * Created by hongbinglin on 2016/4/12.
 */
@SuppressWarnings("serial")
public class RechargeByAuthenticationParameter extends AbstractParameter {

    //用户编号(唯一)
    private String platformUserId;

    //订单号 (唯一不可重复)
    private String orderId;

    //充值金额，单位:分
    private double amount;
    
    //充值页面资源请求url
    private String pageUrl;

    //充值后台资源请求url
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
