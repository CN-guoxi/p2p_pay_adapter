package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-解绑银行卡
 * @author linya
 */
@SuppressWarnings("serial")
public class BindingBankCardParameter extends AbstractParameter{

	//支付平台用户编号(唯一)
	private String platformUserId;
	
	//银行卡预留手机号码
	private String mobile;
	
	//银行卡号
	private String bankNo;
	
	//手机验证码
	private String validateCode;

	public String getPlatformUserId() {
		return platformUserId;
	}

	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}
