package com.qd.p2p.sina.pay.param;

import org.apache.commons.lang3.StringUtils;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 托管充值查询
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.QUERY_HOSTING_DEPOSIT)
public class QueryHostingDepositParam extends AbstractRequestParam {

	/** 商户系统用户ID(字母或数字) */
    @Param(value = "identity_id", required = true)
    private String identityId;

    /** 用户标识类型，ID的类型，目前包括UID、MEMBER_ID*/
    @Param(value = "identity_type", required = true)
    private IdentityType identityType;
    
    /** 账户类型（基本户、保证金户,存钱罐）。默认基本户 */
    @Param(value = "account_type")
    private AccountType accountType;
	
    /** 商户网站交易订单号，商户内部 */
    @Param(value = "out_trade_no")
    private String outTradeNo;

    /**开始时间*/
    @Param("start_time")
    private String startTime;

    /**结束时间*/
    @Param("end_time")
    private String endTime;
    
    /**扩展信息*/
    @Param("extend_param")
    private String extendParam;

    /**页号*/
    @Param(value = "page_no", type = ParamType.INT)
    private int pageNo;

    /**每页大小*/
    @Param(value = "page_size", type = ParamType.INT)
    private int pageSize;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public QueryHostingDepositParam setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }


    public String getIdentityId() {
        return identityId;
    }

    public QueryHostingDepositParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

	public AccountType getAccountType() {
		return accountType;
	}

	public QueryHostingDepositParam setAccountType(AccountType accountType) {
		this.accountType = accountType;
		return this;
	}

	public String getExtendParam() {
        return extendParam;
    }

    public QueryHostingDepositParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }

	public IdentityType getIdentityType() {
		return identityType;
	}

	public QueryHostingDepositParam setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
		return this;
	}

	public String getStartTime() {
		return startTime;
	}

	public QueryHostingDepositParam setStartTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	public String getEndTime() {
		return endTime;
	}

	public QueryHostingDepositParam setEndTime(String endTime) {
		this.endTime = endTime;
		return this;
	}

	public int getPageNo() {
		return pageNo;
	}

	public QueryHostingDepositParam setPageNo(int pageNo) {
		this.pageNo = pageNo;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public QueryHostingDepositParam setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	
	/**
     * 约束性判断，子类实现
     *
     * @return
     */
    @Override
    public boolean restrictCheck() {
        if(StringUtils.isEmpty(outTradeNo))
        {
            return StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime);
        } else {
            return true;
        }
    }

}
