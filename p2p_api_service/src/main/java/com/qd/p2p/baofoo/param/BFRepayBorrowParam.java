package com.qd.p2p.baofoo.param;

import java.util.List;

import com.google.common.collect.Lists;
import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.FlowBorrowParam;
import com.qd.p2p.adapter.param.FullBorrowLoanParam;
import com.qd.p2p.adapter.param.RepayBorrowParam;
import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 流标 接口请求参数
 *
 * @author Wuaj
 * @version V1.0.0
 * @date 2016-04-06
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.P2P_REQUEST)
@XStreamAlias("custody_req")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = RepayBorrowParam.class)
public class BFRepayBorrowParam extends AbstractRequestParam implements ParameterAdapter<RepayBorrowParam> {
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
         * 还款专用(还款人转平台的费用标志)
         */
        @XStreamAlias("special")
        private String special;

        /**
         * 平台收取的管理费
         */
        @XStreamAlias("fee")
        private Double fee;

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
    }

    @Override
    public void adapter(RepayBorrowParam param) {
        this.merchantId = ConfigurationConsts.MERCHANT_ID;
        this.actionType = 4; // 还标
        this.orderId = param.getOrderId(); // 订单号
        this.brwId = param.getBorrowUserId(); // 借款人用户ID
        this.cusId = param.getBorrowId(); // 标ID
        this.cusName = param.getBorrowName(); // 标名
        this.reqTime = param.getReqTime(); // 请求时间
        this.timeout = 1000;
        this.fee = param.getFee(); // 转给平台的管理费

        /* 投标用户 */
        List<RepayBorrowParam.TenderUser> tenderUsers = param.getTenderUsers();
        Action action;
        List<Action> actions = Lists.newArrayList();

        // 投标的用户
        for (RepayBorrowParam.TenderUser tenderUser : tenderUsers) {
            action = new Action();
            action.setUserId(String.valueOf(tenderUser.getUserId())); // 投标人用户ID
            action.setUserName(tenderUser.getUserName()); // 投标人用户ID
            action.setAmount(tenderUser.getAmount()); // 投标金额
            action.setFee(tenderUser.getFee()); // 平台收取投资人管理费
            actions.add(action);
        }

        // 平台收取还款人管理费
        //if (this.fee > 0) {
            action = new Action();
            action.setUserId(this.brwId); // 借款人用户ID
            action.setUserName(param.getBorrowUserName()); // 借款人用户名
            action.setSpecial("1");
            action.setAmount(this.fee);
            actions.add(action);
        //}
        this.actions = actions;
    }
}
