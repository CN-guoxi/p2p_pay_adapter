package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 支付推进
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.ADVANCE_HOSTING_PAY)
public class AdvanceHostingPayParam extends AbstractNotifyRequestParam {

	//绑卡时返回的, ticket有效期为15分钟，可以多次使用（最多5次）
	@Param(value="out_advance_no", required=true)
	private String outAdvanceNo;
		
	//绑卡时返回的, ticket有效期为15分钟，可以多次使用（最多5次）
	@Param(required=true)
	private String ticket;		
	
	//短信验证码, 用户绑卡手机收到的验证码
	@Param(value="validate_code", required=true)
	private String validateCode;	

	public String getOutAdvanceNo() {
		return outAdvanceNo;
	}

	public void setOutAdvanceNo(String outAdvanceNo) {
		this.outAdvanceNo = outAdvanceNo;
	}

	public String getTicket() {
		return ticket;
	}

	public AdvanceHostingPayParam setTicket(String ticket) {
		this.ticket = ticket;
		return this;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public AdvanceHostingPayParam setValidateCode(String validateCode) {
		this.validateCode = validateCode;
		return this;
	}

	
}
