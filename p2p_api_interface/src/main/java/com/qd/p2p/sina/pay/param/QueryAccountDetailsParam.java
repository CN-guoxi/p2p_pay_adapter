package com.qd.p2p.sina.pay.param;


import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 查询收支明细
 * @author linya 2015-12-23
 *
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.QUERY_ACCOUNT_DETAILS, isMember=true)
public class QueryAccountDetailsParam extends AbstractRequestParam {

	//用户标识信息(必填);商户系统用户ID(字母或数字)
	@Param("identity_id")	
	private String identityId;			
	
	//用户标识类型(必填);ID的类型，目前只包括UID
	@Param("identity_type")
	private IdentityType identityType;		
	
	//账户类型;账户类型（基本户-BASIC、保证金户、存钱罐）。默认基本户
	@Param("account_type")
	private AccountType accountType;			
	
	//开始时间(必填);数字串，一共14位，格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
	@Param("start_time")
	private String startTime;			 

	//结束时间(必填);数字串，一共14位，格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
	@Param("end_time")
	private String endTime;				 
	
	//页号，从1开始，默认为1
	@Param("page_no")
	private Integer pageNo;				
	
	//每页记录数，不超过30，默认20
	@Param("page_size")
	private Integer pageSize;			

	public String getIdentityId() {
		return identityId;
	}

	public QueryAccountDetailsParam setIdentityId(String identityId) {
		this.identityId = identityId;
		return this;
	}

	public IdentityType getIdentityType() {
		return identityType;
	}

	public QueryAccountDetailsParam setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
		return this;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public QueryAccountDetailsParam setAccountType(AccountType accountType) {
		this.accountType = accountType;
		return this;
	}

	public String getStartTime() {
		return startTime;
	}

	public QueryAccountDetailsParam setStartTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	public String getEndTime() {
		return endTime;
	}

	public QueryAccountDetailsParam setEndTime(String endTime) {
		this.endTime = endTime;
		return this;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public QueryAccountDetailsParam setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
		return this;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public QueryAccountDetailsParam setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this; 
	}
	
}
