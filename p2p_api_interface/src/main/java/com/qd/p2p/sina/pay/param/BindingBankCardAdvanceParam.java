package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 绑定银行卡推荐
 * @author linya 2015-12-23
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.BINDING_BANK_CARD_ADVANCE, isMember=true)
public class BindingBankCardAdvanceParam extends AbstractRequestParam {

	//绑卡时返回的, ticket有效期为15分钟，可以多次使用（最多5次）
	@Param(required=true)
	private String ticket;		
	
	//短信验证码, 用户绑卡手机收到的验证码
	@Param(value="valid_code", required=true)
	private String validCode;	

	public String getTicket() {
		return ticket;
	}

	public BindingBankCardAdvanceParam setTicket(String ticket) {
		this.ticket = ticket;
		return this;
	}

	public String getValidCode() {
		return validCode;
	}

	public BindingBankCardAdvanceParam setValidCode(String validCode) {
		this.validCode = validCode;
		return this;
	}
	
}
