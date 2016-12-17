package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.RechargeParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Param;
import com.qd.p2p.baofoo.enums.Strategy;
import com.qd.p2p.baofoo.util.DataUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * (八)SDK充值（服务端接口）请求参数
 *
 * @author linya
 * @version V1.0.0
 * @date 2016-4-5
 */

@SuppressWarnings("serial")
@Strategy(ServiceStrategy.RECHARGE)
@XStreamAlias("custody_req")
@Adapted(value=AdaptePlatform.BAOFOO, adaptedClass=RechargeParameter.class)
public class BaofooRechargeBySDKParam extends AbstractRequestParam implements ParameterAdapter<RechargeParameter>{

	//用户编号(唯一)
	@XStreamAlias("user_id")
	@Param(required=true)
	private String userId;
	
	//订单号 (唯一不可重复)
	@XStreamAlias("order_id")
	@Param(required=true)
	private String orderId;
	
	//充值金额，单位:分
	@Param(required=true)
	private double amount;
	
	//充值手续费,单位:元
	@Param(required=true)
	private double fee;
	
	//费用承担方(宝付收取的费用)
	@XStreamAlias("fee_taken_on")
	@Param(required=true)
	private int feeTakenOn;
	
	//其它信息
	@XStreamAlias("additional_info")
	private String additionalInfo;
	
	//商户平台服务端通知地址
	@XStreamAlias("return_url")
	@Param(required=true)
	private String returnUrl;

	public String getUserId() {
		return userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public double getAmount() {
		return amount;
	}

	public double getFee() {
		return fee;
	}

	public double getFeeTakenOn() {
		return feeTakenOn;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	@Override
	public void adapter(RechargeParameter t) {
		userId = t.getPlatformUserId();
		orderId = t.getOrderId();
		amount = t.getAmount();
		fee = t.getFee();
		feeTakenOn = t.getFeeTakenOn();
		returnUrl = t.getReturnUrl();
		additionalInfo = DataUtils.toString(t.getExtraParameter("additionalInfo"));
	}
	
}
