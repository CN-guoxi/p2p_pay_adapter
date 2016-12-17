package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 冻结余额
 * @author linya 2015-12-24
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.BALANCE_FREEZE,isMember=true)
public class BalanceFreezeParam extends AbstractRequestParam {

    //冻结订单号，商户网站冻结订单号，商户内部保证唯一
	@Param(value="out_freeze_no", required = true)	
	private String outFreezeNo;
	
    //用户标识信息，商户系统用户ID(字母或数字)
    @Param(value = "identity_id", required = true)
    private String identityId;

    //用户标识类型，ID的类型，目前只包括UID
    @Param(value = "identity_type", required = true) 
    private IdentityType identityType;

    //账户类型，账户类型（基本户、保证金户）。默认基本户。
    @Param(value = "account_type")
    private AccountType accountType;
    
    //金额，单位为：RMB Yuan。精确到小数点后两位。
    @Param(value = "amount", required = true)
    private String amount;
    
    //摘要
    @Param(value = "summary", required = true)
    private String summary;

    //扩展信息， 业务扩展信息，参数格式：参数名1^参数值1|参数名2^参数值2|……
    @Param(value = "extend_param")
    private String extendParam;

    public String getOutFreezeNo() {
		return outFreezeNo;
	}

	public BalanceFreezeParam setOutFreezeNo(String outFreezeNo) {
		this.outFreezeNo = outFreezeNo;
		return this;
	}

	public String getIdentityId() {
        return identityId;
    }

    public BalanceFreezeParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public BalanceFreezeParam setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
        return this;
    }

	public AccountType getAccountType() {
		return accountType;
	}

	public BalanceFreezeParam setAccountType(AccountType accountType) {
		this.accountType = accountType;
		return this;
	}

	public String getAmount() {
		return amount;
	}

	public BalanceFreezeParam setAmount(String amount) {
		this.amount = amount;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public BalanceFreezeParam setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getExtendParam() {
        return extendParam;
    }

    public BalanceFreezeParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }
}