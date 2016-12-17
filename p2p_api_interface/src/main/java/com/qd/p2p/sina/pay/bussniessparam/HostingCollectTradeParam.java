package com.qd.p2p.sina.pay.bussniessparam;


import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;

public class HostingCollectTradeParam {

	String outOrderNo;
	
	String identityId;
	
	IdentityType identityType = IdentityType.UID;
	
	AccountType accountType = AccountType.BASIC;
	
	String goodsId;
	
	double amount;
	
	String canRepayOnFailed;
	
	String payerIp;
	
	String summary;
	
	String nofifyUrl;
	
	private HostingCollectTradeParam() {
		
	}

	public String getOutOrderNo() {
		return outOrderNo;
	}


	public HostingCollectTradeParam setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
		return this;
	}


	public static HostingCollectTradeParam build(){
		return new HostingCollectTradeParam();
	}

	public String getIdentityId() {
		return identityId;
	}

	public IdentityType getIdentityType() {
		return identityType;
	}

	public HostingCollectTradeParam setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
		return this;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public HostingCollectTradeParam setAccountType(AccountType accountType) {
		this.accountType = accountType;
		return this;
	}

	public HostingCollectTradeParam setIdentityId(String identityId) {
		this.identityId = identityId;
		return this;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public HostingCollectTradeParam setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public double getAmount() {
		return amount;
	}

	public HostingCollectTradeParam setAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public String isCanRepayOnFailed() {
		return canRepayOnFailed;
	}

	public HostingCollectTradeParam setCanRepayOnFailed(String canRepayOnFailed) {
		this.canRepayOnFailed = canRepayOnFailed;
		return this;
	}

	public String getPayerIp() {
		return payerIp;
	}

	public HostingCollectTradeParam setPayerIp(String payerIp) {
		this.payerIp = payerIp;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public HostingCollectTradeParam setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getNofifyUrl() {
		return nofifyUrl;
	}

	public HostingCollectTradeParam setNofifyUrl(String nofifyUrl) {
		this.nofifyUrl = nofifyUrl;
		return this;
	}
	
}
