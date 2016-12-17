package com.qd.p2p.adapter.response;

import java.io.Serializable;
import java.util.List;

import com.qd.p2p.adapter.AbstractResponse;

/**
 * 响应-业务查询接口
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-04-08
 */
public class QueryP2PBusinessResponse extends AbstractResponse {

    private List<Order> result;

    public List<Order> getResult() {
        return result;
    }
    
    public Order getResultByOrderNo(String orderNo){
    	if(result == null  || result.size() == 0){
    		return null;
    	}
    	
    	Order order = null;
    	for(Order o: result){
    		if(o.orderId.equals(orderNo)){
    			return o;
    		}
    	}
    	
    	return order;
    }

    public void setResult(List<Order> result) {
        this.result = result;
    }

    /**
     * 订单查询结果类
     *
     * @author Kaiju Zhao
     */
	public static class Order implements Serializable{

        // 商户订单ID
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
        private double succAmount;

        // 成功时间,如2014-08-08 12:12:12
        private String succTime;

        // 商户手续费,如1.00元
        private double fee;

        // 宝付手续费,如0.20元
        private double baofooFee;

        // 手续费收取方，1商户 2用户
        private Integer feeTakenOn;
        
        private String userId;
        
        private String accountName;
        
        private String createTime;
        
        private String mobile;
        
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

		/**
		 * @return email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email 要设置的 email
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		private String email;

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

}
