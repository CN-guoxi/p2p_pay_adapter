package com.qd.p2p.adapter.response;

import com.qd.p2p.adapter.AbstractResponse;

/**
 * 响应-绑定银行卡
 * @author linya
 */
public class BindingBankCardResponse extends AbstractResponse {

	String cardId;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
}
