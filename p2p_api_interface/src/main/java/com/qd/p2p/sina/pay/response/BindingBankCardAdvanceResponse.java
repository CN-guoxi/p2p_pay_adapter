package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;

/**
 * 绑定银行卡推进
 * @author linya 2015-12-23
 */
@SuppressWarnings("serial")
public class BindingBankCardAdvanceResponse extends AbstractResponse {

	//卡ID
	@Param(value="card_id")
	private String cardId;
	
	//是否已认证
	@Param(value="is_verified", type=ParamType.BOOLEAN)
	private boolean verified;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	
}
