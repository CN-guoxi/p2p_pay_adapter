package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-绑定账户
 * 
 * @author wu huan
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
public class BindingAccountParameter extends AbstractParameter {

	// 是否已有会员账号（0 无 、 1有）
	private int hasAccount;

	// 会员账号 (手机或邮箱)
	private String account;

	// 用户编号(唯一) BIGINT类型 <= 20位
	private String userId;

	// 用户真实姓名
	private String realName;

	// 用户真实身份证号码
	private String idCard;

	// 平台绑定码,已有账号的时候验证,默认 0
	private String bindCode;

	// 会员账户类型 1：手机注册(唯一支持)
	private String accountType = "1";

	public int getHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(int hasAccount) {
		this.hasAccount = hasAccount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getBindCode() {
		return bindCode;
	}

	public void setBindCode(String bindCode) {
		this.bindCode = bindCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
