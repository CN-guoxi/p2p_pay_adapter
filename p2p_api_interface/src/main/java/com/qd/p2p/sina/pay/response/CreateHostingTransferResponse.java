package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

/**
 * 转账接口
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
public class CreateHostingTransferResponse extends AbstractResponse {

	//交易订单号，商户网站交易订单号，商户内部保证唯一
	@Param("out_trade_no")
	private String outTradeNo;
	
	//交易状态，交易状态，详见附录“交易状态”
	@Param("trade_status")
	private String tradeStatus;

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
	
}
