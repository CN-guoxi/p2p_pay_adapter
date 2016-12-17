package com.qd.p2p.adapter;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 托管平台相关信息
 */
public class PlatformInfo implements Serializable {

	private static final long serialVersionUID = 5175439974670661357L;
	private String name; // 平台名称
	private String domain; // 平台域名
	private String merchantId; // 商户号
	private String terminalId; // 客户号

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
