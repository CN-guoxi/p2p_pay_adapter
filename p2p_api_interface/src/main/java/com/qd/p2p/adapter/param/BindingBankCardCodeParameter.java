package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-发送绑定银行卡验证码
 * 
 * @author wu huan
 * @version V1.0.0
 * @date 2016-4-5
 */
public class BindingBankCardCodeParameter extends AbstractParameter {

	private static final long serialVersionUID = -1845245031297667083L;
	
	//支付平台用户ID
	private String platformUserId;

	public String getPlatformUserId() {
		return platformUserId;
	}

	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
	}

}
