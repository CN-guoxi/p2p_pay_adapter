package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

/**
 * 托管提现
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
public class CreateHostingWithdrawResponse extends AbstractResponse {

	//交易订单号，商户网站交易订单号，商户内部保证唯一
	@Param("out_trade_no")
	private String outTradeNo;
	
	//提现状态，交支付状态，详见附录“提现状态”
	@Param("withdraw_status")
	private String withdrawStatus;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}
	
}
