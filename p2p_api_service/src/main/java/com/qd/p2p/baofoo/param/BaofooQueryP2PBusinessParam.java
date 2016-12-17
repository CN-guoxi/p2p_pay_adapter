package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.QueryBalanceParameter;
import com.qd.p2p.adapter.param.QueryP2PBusinessParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.22业务查询接口（服务端接口）请求参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
@Strategy(ServiceStrategy.QUERY_P2P_BUSINESS)
@XStreamAlias("custody_req")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=QueryP2PBusinessParameter.class)
public class BaofooQueryP2PBusinessParam extends AbstractRequestParam implements ParameterAdapter<QueryP2PBusinessParameter> {

    // p2p订单ID,多ID之间使用英文逗号间隔,单ID不需要逗号。订单号至多100个。超出报错.
    // 用户信息查询,传递值改为user_id
    @XStreamAlias("order_id")
    private String orderId;

    // type 当前共五种类型：1-投标 2-满标 3-流标 4-还款 5-充值 6-提现 7-转账 8-用户信息
    private Integer type;

    // 查询开始时间毫秒数，查询周期最多为1天
    @XStreamAlias("start_time")
    private Long startTime;

    // 查询结束时间毫秒数，查询周期最多为1天
    @XStreamAlias("end_time")
    private Long endTime;

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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Override
    public void adapter(QueryP2PBusinessParameter t) {
        this.orderId = t.getOrderId();
        this.type = t.getType();
        this.startTime = t.getStartTime();
        this.endTime = t.getEndTime();
    }

}
