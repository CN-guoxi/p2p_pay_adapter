package com.qd.p2p.sina.pay.param;

import java.util.ArrayList;
import java.util.List;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.PayType;
import com.qd.p2p.sina.pay.enums.Strategy;

@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.PAY_HOSTING_TRADE, isMember=true)
public class PayHostingTradeParam extends AbstractRequestParam {

    //支付请求号，商户网站支付订单号，商户内部保证唯一
	@Param(value="out_pay_no", required = true)	
	private String outPayNo;
	
    //商户网站唯一交易订单号集合，钱包合作商户网站唯一订单号（确保在合作伙伴系统中唯一）。总数不超过十笔
    @Param(value = "outer_trade_no_list", required = true)
    private String outerTradeNoList;
    
    @Param(enabled=false)
    private List<String> tradeNoList;

    //扩展信息， 业务扩展信息，参数格式：参数名1^参数值1|参数名2^参数值2|……
    @Param(value = "extend_param")
    private String extendParam;

    //付款用户ID，商户系统用户ID(字母或数字)
    @Param(value = "payer_id", required = true)
    private String payerId;
    
    //支付方式，格式：支付方式^金额^扩展|支付方式^金额^扩展。扩展信息内容以“，”分隔，针对不同支付方式的扩展定义见附录 “支付方式扩展”	非空	网银：online_bank^260.00^ICBC，DEBIT,C ICBC是银行代码，C是对公对私，DEBIT是借记贷记
    @Param(value = "pay_method", required = true)
    private String payMethod;

    @Param(enabled = false, required = true)
    DepositExtendParam payParam;

	public String getOutPayNo() {
		return outPayNo;
	}

	public PayHostingTradeParam setOutPayNo(String outPayNo) {
		this.outPayNo = outPayNo;
		return this;
	}

	public String getOuterTradeNoList() {
		if(tradeNoList != null){
			StringBuffer buffer = new StringBuffer(50);
			for(String tradeNo: tradeNoList){
				buffer.append(tradeNo).append("^");
			}
			if(buffer.length() > 0){
				buffer.deleteCharAt(buffer.length() - 1);
			}
		}
		return outerTradeNoList;
	}

	public PayHostingTradeParam addOuterTradeNoList(String outerTradeNo) {
		if(tradeNoList == null){
			tradeNoList = new ArrayList<String>();
		}
		tradeNoList.add(outerTradeNo);
		return this;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public PayHostingTradeParam setExtendParam(String extendParam) {
		this.extendParam = extendParam;
		return this;
	}

	public String getPayerId() {
		return payerId;
	}

	public PayHostingTradeParam setPayerId(String payerId) {
		this.payerId = payerId;
		return this;
	}

	public String getPayMethod() {
		PayType payType = payParam.getPayType();
		payMethod = payType.toString() + "^" + payParam.getExtendParam();
		return payMethod;
	}

	public void setPayParam(DepositExtendParam payParam) {
		this.payParam = payParam;
	}
	
	@Override
	protected boolean restrictCheck() {
		if(payParam != null){
			return payParam.check();
		}
		return super.restrictCheck();
	}
}
