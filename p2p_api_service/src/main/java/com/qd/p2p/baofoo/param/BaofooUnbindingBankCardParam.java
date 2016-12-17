package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.UnBindingBankCardParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * (十八)银行卡解绑接口请求参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.UNBINDING_BANK_CARD, aesEncrypt=true)
@XStreamAlias("custody_req")
@Adapted(value=AdaptePlatform.BAOFOO, adaptedClass=UnBindingBankCardParameter.class)
public class BaofooUnbindingBankCardParam extends AbstractRequestParam implements ParameterAdapter<UnBindingBankCardParameter>{

	//用户ID
	@XStreamAlias("user_id")
	private String userId;
	
	//银行卡号
	@XStreamAlias("card_id")
	private String cardId;
	
	//手机验证码   - 三、绑定验证码获取
	@XStreamAlias("validate_code")
	private String validateCode;	
	
	public String getUserId() {
		return userId;
	}

	public String getValidateCode() {
		return validateCode;
	}

	@Override
	public void adapter(UnBindingBankCardParameter t) {
		userId = t.getPlatformUserId();
		cardId = t.getCardId();
		validateCode = t.getValidateCode();
	}

}
