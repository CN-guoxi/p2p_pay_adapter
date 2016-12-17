package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 托管退款
 */
@Strategy(ServiceStrategy.CREATE_HOSTING_REFUND)
public class CreateHostingRefundParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 0255462554236673741746L;

    /**交易订单号*/
    @Param(value = "out_trade_no", required = true)
    private String outTradeNo;

    /**需要退款的商户订单号*/
    @Param(value = "orig_outer_trade_no",required = true)
    private String origOuterTradeNo;

    /**退款金额*/
    @Param(value = "refund_amount",required = true,type = ParamType.DOUBLE)
    private double refundAmount;

    /**摘要*/
    @Param(value = "summary",required = true)
    private String summary;

    /**分账信息列表*/
    @Param("split_list")
    private String splitList;

    /**扩展信息*/
    @Param("extend_param")
    private String extendParaml;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOrigOuterTradeNo() {
        return origOuterTradeNo;
    }

    public void setOrigOuterTradeNo(String origOuterTradeNo) {
        this.origOuterTradeNo = origOuterTradeNo;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSplitList() {
        return splitList;
    }

    public void setSplitList(String splitList) {
        this.splitList = splitList;
    }

    public String getExtendParaml() {
        return extendParaml;
    }

    public void setExtendParaml(String extendParaml) {
        this.extendParaml = extendParaml;
    }
}