package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 查询余额/基金份额
 */
@Strategy(value=ServiceStrategy.QUERY_BALANCE,isMember=true)
public class QueryBalanceParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 0255462554236673741746L;

    //用户标识信息
    @Param(value = "identity_id", required = true)
    private String identityId;

    //用户标识类型，ID的类型，目前包括UID、MEMBER_ID
    @Param(value = "identity_type", required = true)
    private IdentityType identityType;

    //账户类型，账户类型（基本户、保证金户、存钱罐）。默认基本户，见附录
    @Param(value = "account_type")
    private AccountType accountType;

    //扩展信息 业务扩展信息， 参数格式：参数名1^参数值1|参数名2^参数值2|……
    @Param(value = "extend_param")
    private String extendParam;

    public String getIdentityId() {
        return identityId;
    }

    public QueryBalanceParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public QueryBalanceParam setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
        return this;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public QueryBalanceParam setAccountType(AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public QueryBalanceParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }
}