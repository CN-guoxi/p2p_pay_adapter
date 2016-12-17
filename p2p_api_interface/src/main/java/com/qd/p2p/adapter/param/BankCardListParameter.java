package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-获取会员银行卡信息
 * Created by hongbinglin on 2016/4/8.
 */
@SuppressWarnings("serial")
public class BankCardListParameter extends AbstractParameter {

    //用户ID
    private String platformUserId;

	public String getPlatformUserId() {
		return platformUserId;
	}

	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
	}

}
