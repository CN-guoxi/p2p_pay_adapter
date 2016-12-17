package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 查询银行卡
 * @author linya 2015-12-23
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.QUERY_BANK_CARD, isMember = true)
public class QueryBankCardParam extends AbstractRequestParam {

	//用户标识信息(非空);商户系统用户ID(字母或数字)
    @Param(value = "identity_id", required = true)
    String identityId;                

    //用户标识类型(非空);ID的类型，目前只包括UID
    @Param(value = "identity_type", required = true)
    IdentityType identityType;            

    //钱包系统卡ID，绑卡返回的ID
    @Param("card_id")
    String cardId;                    

    public String getIdentityId() {
        return identityId;
    }

    public QueryBankCardParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
		return identityType;
	}

	public QueryBankCardParam setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
		return this;
	}

	public String getCardId() {
        return cardId;
    }

    public QueryBankCardParam setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

}
