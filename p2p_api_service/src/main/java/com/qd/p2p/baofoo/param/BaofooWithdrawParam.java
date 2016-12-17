package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.WithdrawParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Param;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * （十）提现 (服务端接口)
 * 
 * @author linya
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.WITHDRAW)
@XStreamAlias("custody_req")
@Adapted(value=AdaptePlatform.BAOFOO, adaptedClass=WithdrawParameter.class)
public class BaofooWithdrawParam extends AbstractRequestParam implements ParameterAdapter<WithdrawParameter>{

	//提现订单号（唯一）
	@XStreamAlias("order_id")
	@Param(required=true)
	private String orderId;
	
	//用户编号(唯一)
	@XStreamAlias("user_id")
	@Param(required=true)
	private String userId;

	//金额，单位：元
	@Param(required=true)
	private double amount;
	
	//平台收取的手续费, 单位:元
	@Param(required=true)
	private double fee;
	
	//宝付手续费，收取方
	@XStreamAlias("fee_taken_on")
	@Param(required=true)
	private int feeTakenOn;
	
	//银行卡号
	@XStreamAlias("bank_no")
	@Param(required=true)
	private String bankNo;

	public String getOrderId() {
		return orderId;
	}
	
	public String getUserId() {
		return userId;
	}

	public double getAmount() {
		return amount;
	}

	public double getFee() {
		return fee;
	}

	public int getFeeTakenOn() {
		return feeTakenOn;
	}

	public String getBankNo() {
		return bankNo;
	}

	@Override
	public void adapter(WithdrawParameter t) {
		this.orderId = t.getOrderId();
		this.userId = t.getPlatformUserId();
		this.amount = t.getAmount();
		this.fee = t.getFee();
		this.feeTakenOn = t.getFeeTakenOn();
		this.bankNo = t.getBankNo();
	}
	
}
