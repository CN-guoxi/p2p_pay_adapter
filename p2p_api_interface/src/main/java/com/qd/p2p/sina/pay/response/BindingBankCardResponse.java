package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

@SuppressWarnings("serial")
public class BindingBankCardResponse extends AbstractResponse {

	//卡ID,钱包系统卡ID
	@Param("card_id")
	private String cardId;		
	
	//是否采用卡认证的方式; 如果之前请求中此卡采用的是卡认证的方式（verify_mode不为空），则返回Y，注意此参数和卡是否通过银行认证无关
	@Param("is_verified")
	private String verified;	
	
	//后续推进需要的参数; 如果需要推进则会返回此参数，支付推进时需要带上此参数，ticket有效期为15分钟，可以多次使用（最多5次）
	private String ticket;		

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
