package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

@SuppressWarnings("serial")
public class CreateHostingDepositResponse extends AbstractResponse {

    /** 商户网站交易订单号，商户内部 */
    @Param("out_trade_no")
    private String outTradeNo;

    @Param("deposit_status")
    private String depositStatus;

    /** 如果支付需要推进则会返回此参数，支付推进时需要带上此参数，ticket有效期为15分钟，只能使用一次 */
    @Param("ticket")
    private String ticket;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getDepositStatus() {
		return depositStatus;
	}

	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
    
}
