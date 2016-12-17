package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;
import com.qd.p2p.sina.pay.ServiceStrategy;

@Strategy(ServiceStrategy.QUERY_PAY__RESULT)
public class QueryPayParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 3127282395211875302L;

    @Param(value = "out_pay_no", required = true)
    private String outPayNo;

    public String getOutPayNo() {
        return outPayNo;
    }

    public void setOutPayNo(String outPayNo) {
        this.outPayNo = outPayNo;
    }
}