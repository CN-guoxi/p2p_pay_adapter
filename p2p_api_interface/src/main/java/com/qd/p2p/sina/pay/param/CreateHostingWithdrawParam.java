package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 托管提现
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.CREATE_HOSTING_WITHDRAW)
public class CreateHostingWithdrawParam extends AbstractNotifyRequestParam {

    //商户网站交易订单号，商户内部 
    @Param(value = "out_trade_no", required = true)
    private String outTradeNo;

    //充值内容摘要
    private String summary;

    //商户系统用户ID(字母或数字)
    @Param(value = "identity_id", required = true)
    private String identityId;

    //ID的类型，参考“标志类型”
    @Param(value = "identity_type", required = true)
    private IdentityType identityIype;

    //账户类型（基本户、保证金户,存钱罐）。默认基本户
    @Param("account_type")
    private AccountType accountType;

    //单位为：RMB Yuan。精确到小数点后两位
    @Param(value = "amount", required = true)
    private Double amount;

    //用户承担的手续费金额
    @Param(value = "user_fee", type=ParamType.DOUBLE)
    private Double userFee;

    //银行卡ID，用户绑定银行卡ID，即绑定银行卡返回的ID，如果走收银台可为空
    @Param("card_id")
    private String cardId;
    
    //提现方式，安全模式商户需要填写CASHDESK，既跳转新浪支付资金托管站点进行提现。
    @Param("withdraw_mode")
    private String withdrawMode;

    @Param(value = "extend_param")
    private String extendParam;
    
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public CreateHostingWithdrawParam setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public CreateHostingWithdrawParam setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getIdentityId() {
		return identityId;
	}

	public CreateHostingWithdrawParam setIdentityId(String identityId) {
		this.identityId = identityId;
		return this;
	}

	public IdentityType getIdentityIype() {
		return identityIype;
	}

	public CreateHostingWithdrawParam setIdentityIype(IdentityType identityIype) {
		this.identityIype = identityIype;
		return this;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public CreateHostingWithdrawParam setAccountType(AccountType accountType) {
		this.accountType = accountType;
		return this;
	}

	public Double getAmount() {
		return amount;
	}

	public CreateHostingWithdrawParam setAmount(Double amount) {
		this.amount = amount;
		return this;
	}

	public Double getUserFee() {
		return userFee;
	}

	public CreateHostingWithdrawParam setUserFee(Double userFee) {
		this.userFee = userFee;
		return this;
	}

	public String getCardId() {
		return cardId;
	}

	public CreateHostingWithdrawParam setCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}

	public String getWithdrawMode() {
		return withdrawMode;
	}

	public CreateHostingWithdrawParam setWithdrawMode(String withdrawMode) {
		this.withdrawMode = withdrawMode;
		return this;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public CreateHostingWithdrawParam setExtendParam(String extendParam) {
		this.extendParam = extendParam;
		return this;
	}
    
}
