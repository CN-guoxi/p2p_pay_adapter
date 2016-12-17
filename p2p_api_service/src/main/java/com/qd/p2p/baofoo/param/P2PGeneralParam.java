package com.qd.p2p.baofoo.param;

import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * (十四)(投标、流标、满标、还款) 服务端接口请求参数
 *
 * @author Wuaj
 * @version V1.0.0
 * @date 2016-04-06
 */
@XStreamAlias("custody_req")
@Strategy(ServiceStrategy.P2P_REQUEST)
public class P2PGeneralParam extends AbstractRequestParam {

    /**
     * 商户号
     */
    @XStreamAlias("merchant_id")
    private String merchantId;

    /**
     * 请求类型 投标 1 满标:2 流标:3 还标:4
     */
    @XStreamAlias("action_type")
    private Integer actionType;

    /**
     * 订单号
     */
    @XStreamAlias("order_id")
    private String orderId;

    /**
     * 标ID
     */
    @XStreamAlias("cus_id")
    private String cusId;

    /**
     * 标名称
     */
    @XStreamAlias("cus_name")
    private String cusName;

    /**
     * 借款人
     */
    @XStreamAlias("brw_id")
    private String brwId;

    /**
     * 请求时间
     */
    @XStreamAlias("req_time")
    private Long reqTime;
    /**
     * 请求时间
     */
    @XStreamAlias("timeout")
    private Integer timeout;

    @XStreamAlias("actions")
    private List<Action> actions;

    /**
     * 用户编号
     */
    @XStreamAlias("user_id")
    private String userId;

    /**
     * 金额
     */
    @XStreamAlias("amount")
    private Double amount;

    /**
     * 特殊标识(还标专用), 该编号对应的用户，为还款人。如20140374
     */
    @XStreamAlias("special")
    private String special;

    /**
     * 手续费( 满标专用)
     */
    @XStreamAlias("fee")
    private Double fee;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getBrwId() {
        return brwId;
    }

    public void setBrwId(String brwId) {
        this.brwId = brwId;
    }

    public Long getReqTime() {
        return reqTime;
    }

    public void setReqTime(Long reqTime) {
        this.reqTime = reqTime;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    @XStreamAlias("action")
    public static class Action {

        /**
         * 用户ID
         */
        @XStreamAlias("user_id")
        private String userId;

        /**
         * 用户名
         */
        @XStreamAlias("user_name")
        private String userName;

        /**
         * 投标金额
         */
        @XStreamAlias("amount")
        private Double amount;

        /**
         * 投标金额
         */
        @XStreamAlias("is_voucher")
        private String isVoucher;

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

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }


        public String getIsVoucher() {
            return isVoucher;
        }

        public void setIsVoucher(String isVoucher) {
            this.isVoucher = isVoucher;
        }
    }
}
