package com.qd.p2p.baofoo.param;

import com.google.common.collect.Lists;
import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.TenderBorrowParam;
import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * 投标 接口请求参数
 *
 * @author Wuaj
 * @version V1.0.0
 * @date 2016-04-06
 */
@Strategy(value = ServiceStrategy.P2P_REQUEST)
@XStreamAlias("custody_req")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = TenderBorrowParam.class)
public class BFTenderBorrowParam extends AbstractRequestParam implements ParameterAdapter<TenderBorrowParam> {
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
         * 是否有单保人
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

    @Override
    public void adapter(TenderBorrowParam param) {
        this.merchantId = ConfigurationConsts.MERCHANT_ID;
        this.actionType = 1; // 投标
        this.orderId = param.getOrderId(); // 订单号
        this.brwId = param.getBorrowUserId(); // 借款人ID
        this.cusId = param.getBorrowId(); // 标ID
        this.cusName = param.getBorrowName(); // 标名
        this.reqTime = param.getReqTime(); // 请求时间
        this.timeout = 1000;
        this.fee = 0.0d;

        // 单用户投标
        Action action = new Action();
        action.setUserId(String.valueOf(param.getTenderUser().getUserId())); // 投标人用户ID
        action.setUserName(param.getTenderUser().getUserName()); // 投标人用户ID
        action.setAmount(param.getTenderUser().getAmount()); // 投标金额
        List<Action> actions = Lists.newArrayList();
        actions.add(action);
        this.actions = actions;
    }
}
