package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

@SuppressWarnings("serial")
public class UnBindingBankCardParameter extends AbstractParameter {

	//支付平台用户编号(唯一)
	private String platformUserId;
	
	//支付平台绑卡
	private String cardId;
	
	//手机验证码
	private String validateCode;

	public String getPlatformUserId() {
		return platformUserId;
	}

	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}
