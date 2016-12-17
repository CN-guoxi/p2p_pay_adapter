package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.PayType;
import com.qd.p2p.sina.pay.enums.Strategy;
import com.qdlc.p2p.common.constant.TradeCode;

/**
 * 创建托管代收交易
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.CREATE_HOSTING_COLLECT_TRADE)
public class CreateHostingCollectTradeParam extends AbstractNotifyRequestParam {

	@Param(enabled=false, required = true)
	private double amount;
	
    //交易订单号，商户网站交易订单号，商户内部保证唯一
	@Param(value="out_trade_no", required = true)	
	private String outTradeNo;
	
    //交易码，商户网站代收交易业务码，见附录
    @Param(value = "out_trade_code", required = true)
    private TradeCode outTradeCode;
    
    //摘要
    @Param(value = "summary", required = true)
    private String summary;

    //交易关闭时间，设置未付款交易的超时时间，一旦超时，该笔交易就会自动被关闭。取值范围：1m～15d m-分钟，h-小时，d-天不接受小数点，如1.5d，可转换为36h。
    @Param(value = "trade_close_time") 
    private String tradeCloseTime;

    //支付失败后是否可以再次支付，支付失败后，是否可以重复发起支付，取值范围：Y、N(忽略大小写)Y：可以再次支付N：不能再次支付默认值为Y
    @Param(value = "can_repay_on_failed")
    private String canRepayOnFailed;
    
    //商户标的号，对应“标的录入”接口中的标的号，用来关联此笔代收和标的
    @Param(value = "goods_id")
    private String goodsId;

    //扩展信息， 业务扩展信息，参数格式：参数名1^参数值1|参数名2^参数值2|……
    @Param(value = "extend_param")
    private String extendParam;
    
    //付款用户ID，商户系统用户ID(字母或数字)
    @Param(value = "payer_id", required = true)
    private String payerId;
    
    //标识类型，ID的类型，参考“标志类型”
    @Param(value = "payer_identity_type", required = true)
    private IdentityType payerIdentityType;
    
    //付款用户IP地址，用户在商户平台发起支付时候的IP地址，公网IP，不是内网IP   用于风控校验	可空	202.114.12.45
    @Param(value = "payer_ip")
    private String payerIp;
    
    //支付方式，格式：支付方式^金额^扩展|支付方式^金额^扩展。扩展信息内容以“，”分隔，针对不同支付方式的扩展定义见附录 “支付方式扩展”	非空	网银：online_bank^260.00^ICBC，DEBIT,C ICBC是银行代码，C是对公对私，DEBIT是借记贷记
    @Param(value = "pay_method", required = true)
    private String payMethod;

    @Param(enabled = false, required = true)
    DepositExtendParam payParam;

	public double getAmount() {
		return amount;
	}

	public CreateHostingCollectTradeParam setAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public CreateHostingCollectTradeParam setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
		return this;
	}

	public TradeCode getOutTradeCode() {
		return outTradeCode;
	}

	public CreateHostingCollectTradeParam setOutTradeCode(TradeCode outTradeCode) {
		this.outTradeCode = outTradeCode;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public CreateHostingCollectTradeParam setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getTradeCloseTime() {
		return tradeCloseTime;
	}

	public CreateHostingCollectTradeParam setTradeCloseTime(String tradeCloseTime) {
		this.tradeCloseTime = tradeCloseTime;
		return this;
	}

	public String getCanRepayOnFailed() {
		return canRepayOnFailed;
	}

	public CreateHostingCollectTradeParam setCanRepayOnFailed(String canRepayOnFailed) {
		this.canRepayOnFailed = canRepayOnFailed;
		return this;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public CreateHostingCollectTradeParam setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public CreateHostingCollectTradeParam setExtendParam(String extendParam) {
		this.extendParam = extendParam;
		return this;
	}

	public String getPayerId() {
		return payerId;
	}

	public CreateHostingCollectTradeParam setPayerId(String payerId) {
		this.payerId = payerId;
		return this;
	}

	public IdentityType getPayerIdentityType() {
		return payerIdentityType;
	}

	public CreateHostingCollectTradeParam setPayerIdentityType(IdentityType payerIdentityType) {
		this.payerIdentityType = payerIdentityType;
		return this;
	}

	public String getPayerIp() {
		return payerIp;
	}

	public CreateHostingCollectTradeParam setPayerIp(String payerIp) {
		this.payerIp = payerIp;
		return this;
	}

	public String getPayMethod() {
		PayType payType = payParam.getPayType();
		payMethod = payType.toString() + "^" + amount + "^" + payParam.getExtendParam();
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