package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;


/**
 * 提交查询的响应基类
 *
 * @author linya 2015-11-30
 */
public class QueryPayResponse extends AbstractResponse {

    @Param(enabled = false)
    private static final long serialVersionUID = -6877570600621625846L;

    @Param(value = "out_pay_no", type = ParamType.LONG)
    long outPayNo;

    @Param("pay_status")
    String payStatus;

    public long getOutPayNo() {
        return outPayNo;
    }

    public void setOutPayNo(long outPayNo) {
        this.outPayNo = outPayNo;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

}
