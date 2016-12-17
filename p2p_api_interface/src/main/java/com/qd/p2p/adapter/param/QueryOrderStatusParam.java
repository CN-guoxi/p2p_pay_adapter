package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-业务查询接口
 *
 * @author Wuaj
 * @version V1.0.0
 * @date 2016-04-08
 */
public class QueryOrderStatusParam extends AbstractParameter {

    // p2p订单ID,多ID之间使用英文逗号间隔,单ID不需要逗号。订单号至多100个。超出报错.
    // 用户信息查询,传递值改为user_id
    private String orderId;

    // type 当前共五种类型：1-投标 2-满标 3-流标 4-还款 5-充值 6-提现 7-转账 8-用户信息
    private Integer type;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
