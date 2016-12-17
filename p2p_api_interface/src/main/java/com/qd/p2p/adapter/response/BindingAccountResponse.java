package com.qd.p2p.adapter.response;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qd.p2p.adapter.AbstractResponse;

/**
 * 响应-绑定账号
 * 
 * @author wu huan
 */
public class BindingAccountResponse extends AbstractResponse implements Serializable {

	private static final long serialVersionUID = 6076165913125100978L;

	private boolean hasAccount;

	public boolean isHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
