package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 转账接口
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.CREATE_HOSTING_TRANSFER, isMember=true)
public class CreateHostingTransferParam extends AbstractRequestParam {

	//交易订单号，商户网站交易订单号，商户内部保证唯一
	@Param(value="out_trade_no", required=true)
	private String outTradeNo;
	
	//付款人标识，商户系统用户ID(字母或数字)
	@Param(value="payer_identity_id", required=true)
	private String payerIdentityId;
	
	//付款人标识类型，ID的类型，参考“标志类型”
	@Param(value="payer_identity_type", required=true)
	private IdentityType payerIdentityType;
	
	//付款人账户类型，账户类型（基本户、保证金户）。默认基本户，见附录
	@Param(value="payer_account_type")
	private AccountType payerAccountType;
	
	//收款人标识，商户系统用户ID、钱包系统会员ID
	@Param(value="payee_identity_id", required=true)
	private String payeeIdentityId;
	
	//收款人标识类型，ID的类型，参考“标志类型”
	@Param(value="payee_identity_type", required=true)
	private IdentityType payeeIdentityType;
	
	//收款人账户类型，账户类型（基本户、保证金户）。默认基本户，见附录
	@Param(value="payee_account_type")
	private AccountType payeeAccountType;
	
	//转账金额
	@Param(required=true)
	private String amount;
	
	//摘要
	private String summary;
	
	@Param("extend_param")
	private String extendParam;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getPayerIdentityId() {
		return payerIdentityId;
	}

	public void setPayerIdentityId(String payerIdentityId) {
		this.payerIdentityId = payerIdentityId;
	}

	public IdentityType getPayerIdentityType() {
		return payerIdentityType;
	}

	public void setPayerIdentityType(IdentityType payerIdentityType) {
		this.payerIdentityType = payerIdentityType;
	}

	public AccountType getPayerAccountType() {
		return payerAccountType;
	}

	public void setPayerAccountType(AccountType payerAccountType) {
		this.payerAccountType = payerAccountType;
	}

	public String getPayeeIdentityId() {
		return payeeIdentityId;
	}

	public void setPayeeIdentityId(String payeeIdentityId) {
		this.payeeIdentityId = payeeIdentityId;
	}

	public IdentityType getPayeeIdentityType() {
		return payeeIdentityType;
	}

	public void setPayeeIdentityType(IdentityType payeeIdentityType) {
		this.payeeIdentityType = payeeIdentityType;
	}

	public AccountType getPayeeAccountType() {
		return payeeAccountType;
	}

	public void setPayeeAccountType(AccountType payeeAccountType) {
		this.payeeAccountType = payeeAccountType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
}
