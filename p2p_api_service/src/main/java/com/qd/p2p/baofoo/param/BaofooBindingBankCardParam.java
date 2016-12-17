package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.BindingBankCardParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * (十八)银行卡 绑定,删除 接口请求参数
 *
 * @author linya
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.BINDING_BANK_CARD, aesEncrypt=true)
@XStreamAlias("custody_req")
@Adapted(value=AdaptePlatform.BAOFOO, adaptedClass=BindingBankCardParameter.class)
public class BaofooBindingBankCardParam extends AbstractRequestParam implements ParameterAdapter<BindingBankCardParameter>{

	//用户ID
	@XStreamAlias("user_id")
	private String userId;
	
	//银行卡预留手机号码
	@XStreamAlias("mobile")
	private String mobile;
	
	//银行卡号
	@XStreamAlias("bank_no")
	private String bankNo;
	
	//手机验证码   - 三、绑定验证码获取
	@XStreamAlias("validate_code")
	private String validateCode;

	public String getUserId() {
		return userId;
	}

	public String getBankNo() {
		return bankNo;
	}

	public String getValidateCode() {
		return validateCode;
	}

	@Override
	public void adapter(BindingBankCardParameter t) {
		userId = t.getPlatformUserId();
		bankNo = t.getBankNo();
		mobile = t.getMobile();
		validateCode = t.getValidateCode();
	}
	
}
