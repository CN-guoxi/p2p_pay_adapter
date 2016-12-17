package com.qd.p2p.sina.pay.param;

import org.apache.commons.lang.StringUtils;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;
import com.qd.p2p.sina.pay.response.QueryHostingWithdrawResponse;

/**
 * 托管提现查询
 * @author linya 2015-12-25
 * @see QueryHostingWithdrawResponse
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.QUERY_HOSTING_WITHDRAW, isMember=true)
public class QueryHostingWithdrawParam extends AbstractRequestParam {

    //用户标识信息，商户系统用户ID(字母或数字)
    @Param(value = "identity_id", required = true)
    private String identityId;

    //用户标识类型，ID的类型，参考“标志类型”
    @Param(value = "identity_type", required = true)
    private IdentityType identityType;

    //账户类型，账户类型（基本户、存钱罐）。默认基本户，见附录
    @Param(value = "account_type")
    private AccountType accountType;

    //交易订单号，商户网站交易订单号，商户内部保证唯一
    @Param(value = "out_trade_no")
    private String outTradeNo;

    //开始时间，数字串，一共14位格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位] 
    @Param(value = "start_time")
    private String startTime;

    //结束时间，数字串，一共14位格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
    @Param(value = "end_time")
    private String endTime;

    //页号，从1开始，默认为1
    @Param(value = "page_no", required = true)
    private String pageNo;
    
    //每页大小，每页记录数，默认20
    @Param(value = "page_size", required = true)
    private String pageSize;
    
    @Param(value = "extend_param")
    private String extendParam;

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public IdentityType getIdentityType() {
		return identityType;
	}

	public void setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}

	@Override
	protected boolean restrictCheck() {
		if(StringUtils.isEmpty(outTradeNo)){
			return StringUtils.isNotEmpty(startTime) && StringUtils.isNotEmpty(endTime);
		}
		return super.restrictCheck();
	}
	
}
