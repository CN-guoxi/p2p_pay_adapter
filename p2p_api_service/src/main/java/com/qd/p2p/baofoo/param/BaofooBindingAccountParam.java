package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.BindingAccountParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Param;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * (二)绑定宝付账户（服务端接口）请求参数
 *
 * @author wu huan
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.BINDING_ACCOUNT_BY_SERVER, aesEncrypt = true)
@XStreamAlias("custody_req")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = BindingAccountParameter.class)
public class BaofooBindingAccountParam extends AbstractRequestParam implements ParameterAdapter<BindingAccountParameter> {

	// 是否已有宝付会员账号（0 无 、 1有）
	@XStreamAlias("has_bf_account")
	@Param(required = true)
	private int hasAccount;

	// 宝付会员账号 (手机或邮箱)
	@XStreamAlias("bf_account")
	@Param(required = true)
	private String account;

	// 用户编号(唯一) BIGINT类型 <= 20位
	@XStreamAlias("user_id")
	@Param(required = true)
	private String userId;

	// 用户真实姓名
	@XStreamAlias("real_name")
	@Param(required = true)
	private String realName;

	// 用户真实身份证号码
	@XStreamAlias("id_card")
	@Param(required = true)
	private String idCard;

	// 平台绑定码,已有宝付账号的时候验证,默认 0
	@XStreamAlias("bind_code")
	@Param(required = true)
	private String bindCode;

	// 会员账户类型 1：手机注册(唯一支持)
	@XStreamAlias("account_type")
	@Param(required = true)
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

	@Override
	public void adapter(BindingAccountParameter t) {
		this.hasAccount = t.getHasAccount();
		this.account = t.getAccount();
		this.accountType = t.getAccountType();
		this.bindCode = t.getBindCode();
		this.idCard = t.getIdCard();
		this.userId = t.getUserId();
		this.realName = t.getRealName();
	}

}
