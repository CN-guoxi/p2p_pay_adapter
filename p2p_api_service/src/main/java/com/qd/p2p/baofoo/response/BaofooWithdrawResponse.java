package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.WithdrawResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 提现 (服务端接口) 返回参数
 *
 * @author linya
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@XStreamAlias("crs")
@Adapted(value=AdaptePlatform.BAOFOO, adaptedClass=WithdrawResponse.class)
public class BaofooWithdrawResponse extends AbstractResponse implements ResponseAdapter<WithdrawResponse>{

	@XStreamAlias("msg")
	private Message message;
	
	public static class Message{
		
		@XStreamAlias("order_id")
		private String orderId;
		
		private double amount;
		
		private double fee;
		
		@XStreamAlias("fee_taken_on")
		private double feeTakenOn;
		
		@XStreamAlias("mer_fee")
		private double merFee;

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
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

		public double getFeeTakenOn() {
			return feeTakenOn;
		}

		public void setFeeTakenOn(double feeTakenOn) {
			this.feeTakenOn = feeTakenOn;
		}

		public double getMerFee() {
			return merFee;
		}

		public void setMerFee(double merFee) {
			this.merFee = merFee;
		}
		
	}

	@Override
	public WithdrawResponse adapter() {
		WithdrawResponse response = new WithdrawResponse();
		response.setResponseCode(getCode());
		response.setResponseMsg(getMsg());
		response.setStatus(getStatus());
		return response;
	}
	
}
