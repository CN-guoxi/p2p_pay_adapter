package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.RechargeResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * SDK充值（服务端接口）返回参数
 *
 * @author linya
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@XStreamAlias("crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass= RechargeResponse.class)
public class BaofooRechargeBySDKResponse extends AbstractResponse implements ResponseAdapter<RechargeResponse>{

	@XStreamAlias("order_id")
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public RechargeResponse adapter() {
		RechargeResponse response = new RechargeResponse();
		response.setOrderId(orderId);
		response.setResponseCode(getCode());
		response.setResponseMsg(getMsg());
		response.setStatus(getStatus());
		return response;
	}
	
}
