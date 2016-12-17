package com.qd.p2p.baofoo.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.QueryOrderStatusResponse;
import com.qd.p2p.adapter.response.QueryP2PBusinessResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.22业务查询接口（服务端接口） 返回参数
 *
 * @author Wuaj
 * @version V1.0.0
 * @date 2016-4-6
 */
@XStreamAlias("crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass= QueryOrderStatusResponse.class)
public class BFQueryOrderStatusResponse extends AbstractResponse implements ResponseAdapter<QueryOrderStatusResponse> {

    @XStreamAlias("result")
    private List<Order> result;

    public List<Order> getResult() {
        return result;
    }

    public void setResult(List<Order> result) {
        this.result = result;
    }

    /**
     * 订单查询结果类
     *
     * @author Kaiju Zhao
     */
    @XStreamAlias(value="order")
    public static class Order {

        // 商户订单ID
        @XStreamAlias("order_id")
        private String orderId;

        /**
         * 其他
         * 1成功  0失败
         * 充值返回状态含义：
         *      1成功  0处理中
         * 提现返回状态含义：
         *      1成功  0 初始化  -1失败  5转账处理中
         * 用户信息返回状态：
         *      1 正常  0未授权 -1已注销
         */
        private Integer state;

        // 成功金额,如200.00元
        @XStreamAlias("succ_amount")
        private double succAmount;

        // 成功时间,如2014-08-08 12:12:12
        @XStreamAlias("succ_time")
        private String succTime;

        // 商户手续费,如1.00元
        private double fee;

        // 宝付手续费,如0.20元
        @XStreamAlias("baofoo_fee")
        private double baofooFee;

        // 手续费收取方，1商户 2用户
        @XStreamAlias("fee_taken_on")
        private Integer feeTakenOn;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public double getSuccAmount() {
            return succAmount;
        }

        public void setSuccAmount(double succAmount) {
            this.succAmount = succAmount;
        }

        public String getSuccTime() {
            return succTime;
        }

        public void setSuccTime(String succTime) {
            this.succTime = succTime;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        public double getBaofooFee() {
            return baofooFee;
        }

        public void setBaofooFee(double baofooFee) {
            this.baofooFee = baofooFee;
        }

        public Integer getFeeTakenOn() {
            return feeTakenOn;
        }

        public void setFeeTakenOn(Integer feeTakenOn) {
            this.feeTakenOn = feeTakenOn;
        }
    }

    @Override
    public QueryOrderStatusResponse adapter() {
        QueryOrderStatusResponse response = new QueryOrderStatusResponse();
        if (null != result && result.size() > 0) {
            Order order = result.get(0);
            response.setRelStatus(order.getState());
        }
        response.setResponseCode(this.getCode());
        response.setResponseMsg(this.getMsg());
        response.setStatus(getStatus());
        return response;
    }
}
