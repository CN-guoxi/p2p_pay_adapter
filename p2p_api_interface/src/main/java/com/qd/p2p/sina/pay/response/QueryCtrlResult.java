package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

/**
 * 查询冻结解冻结果
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
public class QueryCtrlResult extends AbstractResponse {

	//冻结解冻订单号   返回入参的冻结解冻订单号
	@Param(value="out_ctrl_no")
	private String outCtrlNo;
	
	//订单状态，冻结解冻订单状态
	@Param(value="ctrl_status")
	private String ctrlStatus;
	
	//错误信息，冻结解冻失败原因
	@Param(value="error_msg")
	private String errorMsg;

	public String getOutCtrlNo() {
		return outCtrlNo;
	}

	public void setOutCtrlNo(String outCtrlNo) {
		this.outCtrlNo = outCtrlNo;
	}

	public String getCtrlStatus() {
		return ctrlStatus;
	}

	public void setCtrlStatus(String ctrlStatus) {
		this.ctrlStatus = ctrlStatus;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
}
