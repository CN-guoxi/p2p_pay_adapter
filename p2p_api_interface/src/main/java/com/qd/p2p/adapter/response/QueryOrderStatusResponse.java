package com.qd.p2p.adapter.response;


import com.qd.p2p.adapter.AbstractResponse;
import com.qd.p2p.adapter.enums.ResponseOrderStatus;

/**
 * 响应-业务查询接口
 *
 * @author Wuaj
 * @version V1.0.0
 * @date 2016-04-08
 */
public class QueryOrderStatusResponse extends AbstractResponse {

    private ResponseOrderStatus orderStatus;

    private Integer relStatus;

    public ResponseOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(ResponseOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getRelStatus() {
        return relStatus;
    }

    public void setRelStatus(int relStatus) {
        this.relStatus = relStatus;
    }
}
