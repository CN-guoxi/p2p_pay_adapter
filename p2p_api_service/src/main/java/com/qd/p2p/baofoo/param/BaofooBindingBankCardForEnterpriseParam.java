package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.BindingBankCardForEnterpriseParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.BINDING_BANK_CARD_FOR_ENTERPRISE, aesEncrypt=true)
@XStreamAlias("custody_req")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = BindingBankCardForEnterpriseParameter.class)
public class BaofooBindingBankCardForEnterpriseParam extends AbstractRequestParam implements ParameterAdapter<BindingBankCardForEnterpriseParameter>{

	//用户ID
	@XStreamAlias("user_id")
	private String userId;
	
	//类型:0-删除,1-新增
	private int type;
	
	//银行卡号
	@XStreamAlias("bank_no")
	private String bankNo;
	
	//省份
	@XStreamAlias("pro_value")
	private String province;
	
	//市区
	@XStreamAlias("city_value")
	private String city;
	
	//开户行
	@XStreamAlias("bank_name")
	private String bankName;
	
	//开户行详细
	@XStreamAlias("bank_address")
	private String bankAddress;
	
	//手机验证码   - 三、绑定验证码获取
	@XStreamAlias("validate_code")
	private String validateCode;
	
	@Override
	public void adapter(BindingBankCardForEnterpriseParameter t) {
		userId = t.getPlatformUserId();
		type = t.getType();
		bankNo = t.getBankNo();
		province = t.getProvince();
		city = t.getCity();
		bankName = t.getBankName();
		bankAddress = t.getBankAddress();
		validateCode = t.getValidateCode();
	}

	public String getUserId() {
		return userId;
	}

	public int getType() {
		return type;
	}

	public String getBankNo() {
		return bankNo;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getBankName() {
		return bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public String getValidateCode() {
		return validateCode;
	}

}
