package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 解冻余额
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.BALANCE_UNFREEZE, isMember=true)
public class BalanceUnfreezeParam extends AbstractRequestParam {

    //解冻订单号，商户网站解冻订单号，商户内部保证唯一
	@Param(value="out_unfreeze_no", required = true)	
	private String outUnfreezeNo;
	
	//原冻结订单号，商户网站冻结订单号，商户内部保证唯一
	@Param(value="out_freeze_no", required = true)	
	private String outFreezeNo;
	
    //用户标识信息，商户系统用户ID(字母或数字)
    @Param(value = "identity_id", required = true)
    private String identityId;

    //用户标识类型，ID的类型，目前只包括UID
    @Param(value = "identity_type", required = true) 
    private IdentityType identityType;

    //解冻金额，为空表示全额解冻
    @Param(value = "amount")
    private String amount;
    
    //摘要
    @Param(value = "summary", required = true)
    private String summary;

    //扩展信息， 业务扩展信息，参数格式：参数名1^参数值1|参数名2^参数值2|……
    @Param(value = "extend_param")
    private String extendParam;

    public String getOutUnfreezeNo() {
		return outUnfreezeNo;
	}

	public BalanceUnfreezeParam setOutUnfreezeNo(String outUnfreezeNo) {
		this.outUnfreezeNo = outUnfreezeNo;
		return this;
	}

	public String getOutFreezeNo() {
		return outFreezeNo;
	}

	public BalanceUnfreezeParam setOutFreezeNo(String outFreezeNo) {
		this.outFreezeNo = outFreezeNo;
		return this;
	}

	public String getIdentityId() {
        return identityId;
    }

    public BalanceUnfreezeParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public BalanceUnfreezeParam setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
        return this;
    }

	public String getAmount() {
		return amount;
	}

	public BalanceUnfreezeParam setAmount(String amount) {
		this.amount = amount;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public BalanceUnfreezeParam setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getExtendParam() {
        return extendParam;
    }

    public BalanceUnfreezeParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }
}