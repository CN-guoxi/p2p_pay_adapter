package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-发送绑定账户验证码
 * 
 * @author wu huan
 * @version V1.0.0
 * @date 2016-4-5
 */
public class BindingAccountCodeParameter extends AbstractParameter {

	private static final long serialVersionUID = 5388445520520662024L;

	/**
	 * 账号名称
	 */
	private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
