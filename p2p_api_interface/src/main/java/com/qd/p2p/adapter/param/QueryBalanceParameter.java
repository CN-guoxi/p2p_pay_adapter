package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-账户余额查询
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-04-08
 */
public class QueryBalanceParameter extends AbstractParameter {

    // 支付平台用户编号(唯一)
    private String platformUserId;

    public String getPlatformUserId() {
        return platformUserId;
    }

    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId;
    }

}
