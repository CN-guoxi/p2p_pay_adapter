package com.qd.p2p.baofoo.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.QueryP2PBusinessResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.22业务查询接口（服务端接口） 返回参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-6
 */
@XStreamAlias("crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass= QueryP2PBusinessResponse.class)
public class BaofooQueryP2PBusinessResponse extends AbstractResponse implements ResponseAdapter<QueryP2PBusinessResponse> {

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
        
        @XStreamAlias("user_id")
        private String userId;
        
        @XStreamAlias("account_name")
        private String accountName;
        
        @XStreamAlias("create_time")
        private String createTime;
        
        /**
		 * @return userId
		 */
		public String getUserId() {
			return userId;
		}

		/**
		 * @param userId 要设置的 userId
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
		 * @return accountName
		 */
		public String getAccountName() {
			return accountName;
		}

		/**
		 * @param accountName 要设置的 accountName
		 */
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}

		/**
		 * @return createTime
		 */
		public String getCreateTime() {
			return createTime;
		}

		/**
		 * @param createTime 要设置的 createTime
		 */
		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		/**
		 * @return mobile
		 */
		public String getMobile() {
			return mobile;
		}

		/**
		 * @param mobile 要设置的 mobile
		 */
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		@XStreamAlias("mobile")
        private String mobile;

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
    public QueryP2PBusinessResponse adapter() {
        QueryP2PBusinessResponse item = new QueryP2PBusinessResponse();
        List<QueryP2PBusinessResponse.Order> orderItemList = new ArrayList<QueryP2PBusinessResponse.Order>();
        if (null != result && result.size() > 0) {
            for (Order order : result) {
                QueryP2PBusinessResponse.Order orderItem = new QueryP2PBusinessResponse.Order();
                BeanUtils.copyProperties(order, orderItem);
                orderItemList.add(orderItem);
            }
        }
        item.setResult(orderItemList);
        item.setResponseCode(this.getCode());
        item.setResponseMsg(this.getMsg());
        item.setStatus(getStatus());
        return item;
    }

}
