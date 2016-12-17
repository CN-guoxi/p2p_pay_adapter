package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 存钱罐基金收益率查询
 * @author linya 2015-12-24
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.QUERY_FUND_YIELD, isMember=true)
public class QueryFundYieldParam extends AbstractRequestParam{

	//基金代码， 标准基金代码，例如000330（汇添富）
	@Param(value="fund_code", required=true)
	private String fundCode;

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	
}
