package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 解绑银行卡请求参数
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.UNBINDING_BANK_CARD, isMember = true)
public class UnbindingBankCardParam extends AbstractRequestParam {

    /** 用户标识信息(非空);商户系统用户ID(字母或数字),例如：2000011212 */
    @Param(value = "identity_id", required = true)
    private String identityId;

    /** ID的类型(非空);目前只包括UID，例如：UID */
    @Param(value = "identity_type", required = true)
    private IdentityType identityType;

    /** 钱包系统卡ID，绑卡返回的ID */
    @Param(value = "card_id", required = true)
    private String cardId;

    /** 业务扩展信息，参数格式：参数名1^参数值1|参数名2^参数值2|…… */
    @Param(value = "extend_param")
    private String extendParam;

    public String getIdentityId() {
        return identityId;
    }

    public UnbindingBankCardParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
		return identityType;
	}

	public UnbindingBankCardParam setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
		return this;
	}

	public String getCardId() {
        return cardId;
    }

    public UnbindingBankCardParam setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public UnbindingBankCardParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }
}
