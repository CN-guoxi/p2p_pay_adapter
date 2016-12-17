package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-解绑银行卡
 * @author linya
 */
@SuppressWarnings("serial")
public class BindingBankCardForEnterpriseParameter extends AbstractParameter{

	//用户ID
	private String platformUserId;
	
	//类型:0-删除,1-新增
	private int type;
	
	//银行卡号
	private String bankNo;
	
	//省份
	private String province;
	
	//市区
	private String city;
	
	//开户行
	private String bankName;
	
	//开户行详细
	private String bankAddress;
	
	//手机验证码   - 三、绑定验证码获取
	private String validateCode;

	public String getPlatformUserId() {
		return platformUserId;
	}

	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}
