package com.qd.p2p.adapter.param;

import java.io.Serializable;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-投标
 *
 * @author wuaj
 * @version 1.0.0
 * @date 2016-4-5
 */
public class TenderBorrowParam extends AbstractParameter {
    /**
     * 订单ID
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
     * 投标用户
     */
    private TenderUser tenderUser;

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

    public TenderUser getTenderUser() {
        return tenderUser;
    }

    public void setTenderUser(TenderUser tenderUser) {
        this.tenderUser = tenderUser;
    }

    public static class TenderUser implements Serializable {
        /**
         * 投标用户ID
         */
        private String userId;

        /**
         * 投票用户名
         */
        private String userName;

        /**
         * 投标金额
         */
        private double amount;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
