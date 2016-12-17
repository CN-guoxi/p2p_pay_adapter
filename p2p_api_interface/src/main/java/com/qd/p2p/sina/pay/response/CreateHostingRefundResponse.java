package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

/**
 * 托管退款
 */
public class CreateHostingRefundResponse extends AbstractResponse {

    @Param(enabled = false)
    private static final long serialVersionUID = -6877570600621625846L;

    @Param(value = "out_trade_no")
    String outTradeNo;

    @Param("refund_status")
    String refundStatus;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
}
