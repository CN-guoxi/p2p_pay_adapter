package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

/**
 * 创建托管代收交易
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
public class CreateHostingCollectTradeResponse extends AbstractResponse {

	//交易订单号，商户网站交易订单号，商户内部保证唯一
	@Param(value="out_trade_no")
	private String outTradeNo;
	
	//交易状态，详见附录“交易状态”
	@Param(value="trade_status")
	private String tradeStatus;
	
	//支付状态，详见附录“支付状态”
	@Param(value="pay_status")
	private String payStatus;	
	
	//后续推进需要的参数，如果支付需要推进则会返回此参数，支付推进时需要带上此参数，ticket有效期为15分钟，可以多次使用（最多5次） 
	@Param(value="ticket")
	private String ticket;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
}
