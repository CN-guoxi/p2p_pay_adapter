package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-满标放款
 *
 * @author wuaj
 * @version 1.0.0
 * @date 2016-4-5
 */
public class FullBorrowLoanParam extends AbstractParameter {
    /**
     * 标信息
     */
    private String orderId;

    /**
     * 请求时间
     */
    private long reqTime;

    /**
     * 标ID
     */
    private String borrowId;

    /**
     * 标名
     */
    private String borrowName;

    /**
     * 借款人ID
     */
    private String borrowUserId;

    /**
     * 借款姓名
     */
    private String borrowUserName;

    /**
     * 金额
     */
    private double amount;

    /**
     * 平台收取费用
     */
    private double fee;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getReqTime() {
        return reqTime;
    }

    public void setReqTime(long reqTime) {
        this.reqTime = reqTime;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(String borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public String getBorrowUserName() {
        return borrowUserName;
    }

    public void setBorrowUserName(String borrowUserName) {
        this.borrowUserName = borrowUserName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
