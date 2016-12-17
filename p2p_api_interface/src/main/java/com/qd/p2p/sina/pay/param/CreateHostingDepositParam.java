package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.PayType;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 充值
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.CREATE_HOSTING_DEPOSIT)
public class CreateHostingDepositParam extends AbstractNotifyRequestParam {

    /** 商户网站交易订单号，商户内部 */
    @Param(value = "out_trade_no", required = true)
    private String outTradeNo;

    /** 充值内容摘要 */
    @Param(value = "summary")
    private String summary;

    /** 商户系统用户ID(字母或数字) */
    @Param(value = "identity_id", required = true)
    private String identityId;

    /** ID的类型，参考“标志类型” */
    @Param(value = "identity_type", required = true)
    private IdentityType identityIype;

    /** 账户类型（基本户、保证金户,存钱罐）。默认基本户 */
    @Param(value = "account_type")
    private AccountType accountType;

    /** 单位为：RMB Yuan。精确到小数点后两位 */
    @Param(value = "amount", required = true)
    private Double amount;

    /** 用户承担的手续费金额 */
    @Param(value = "user_fee")
    private Double userFee;

    /** 用户在商户平台发起支付时候的IP地址，公网IP，不是内网IP用于风控校验 */
    @Param(value = "payer_ip")
    private Double payerIp;

    /** 格式：支付方式^金额^扩展|支付方式^金额^扩展。扩展信息内容以“，”分隔，针对不同支付方式的扩展定义见附录 “支付方式扩展” */
    @Param(value = "pay_method", required = true)
    private String payMethod;
    
    @Param(enabled=false, required=true)
    private DepositExtendParam depositExtendParam;

    @Param(value = "extend_param")
    private String extendParam;


    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public IdentityType getIdentityIype() {
		return identityIype;
	}

	public void setIdentityIype(IdentityType identityIype) {
		this.identityIype = identityIype;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getUserFee() {
        return userFee;
    }

    public void setUserFee(Double userFee) {
        this.userFee = userFee;
    }

    public Double getPayerIp() {
        return payerIp;
    }

    public void setPayerIp(Double payerIp) {
        this.payerIp = payerIp;
    }

    public String getPayMethod() {
    	PayType payType = depositExtendParam.getPayType();
    	String payMethod = payType.toString() + "^" + amount + "^" + depositExtendParam.getExtendParam();
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public void setDepositExtendParam(DepositExtendParam depositExtendParam) {
		this.depositExtendParam = depositExtendParam;
	}

	public String getExtendParam() {
        return extendParam;
    }

    public void setExtendParam(String extendParam) {
        this.extendParam = extendParam;
    }

	@Override
	protected boolean restrictCheck() {
		if(depositExtendParam != null){
			return depositExtendParam.check();
		}
		return super.restrictCheck();
	}
    
}
