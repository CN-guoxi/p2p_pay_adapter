package com.qd.p2p.adapter.response;

import com.qd.p2p.adapter.AbstractResponse;

/**
 * 响应-页面充值
 * Created by hongbinglin on 2016/4/12.
 */
public class RechargeByPageResponse extends AbstractResponse {

    //商户充值订单号
    private String orderId;
    //充值结算金额(实际到账)
    private double incashMoney;
    //宝付收取费用
    private double fee;
    //商户收取的手续费
    private double merFee;
    //宝付收取的手续费，承担方：1平台2个人承担
    private int feeTakenOn;
    //其他信息
    private String additionalInfo;
    //成功时间
    private String succTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getIncashMoney() {
        return incashMoney;
    }

    public void setIncashMoney(double incashMoney) {
        this.incashMoney = incashMoney;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getMerFee() {
        return merFee;
    }

    public void setMerFee(double merFee) {
        this.merFee = merFee;
    }

    public int getFeeTakenOn() {
        return feeTakenOn;
    }

    public void setFeeTakenOn(int feeTakenOn) {
        this.feeTakenOn = feeTakenOn;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSuccTime() {
        return succTime;
    }

    public void setSuccTime(String succTime) {
        this.succTime = succTime;
    }
}
