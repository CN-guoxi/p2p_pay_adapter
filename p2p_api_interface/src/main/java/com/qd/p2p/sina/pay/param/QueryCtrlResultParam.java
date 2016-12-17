package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 查询冻结解冻结果
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.QUERY_CTRL_RESULT, isMember=true)
public class QueryCtrlResultParam extends AbstractRequestParam {

	//冻结解冻订单号，商户网站冻结或解冻订单号，商户内部保证唯一
	@Param(value="out_ctrl_no", required=true)	
	private String outCtrlNo;
	
	//扩展信息，业务扩展信息，参数格式：参数名1^参数值1|参数名2^参数值2|……
	@Param(value="extend_param")
	private String extendParam;

	public String getOutCtrlNo() {
		return outCtrlNo;
	}

	public void setOutCtrlNo(String outCtrlNo) {
		this.outCtrlNo = outCtrlNo;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}

	
}
