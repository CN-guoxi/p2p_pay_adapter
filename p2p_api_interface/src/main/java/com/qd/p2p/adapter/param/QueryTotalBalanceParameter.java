package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-账户余额总额查询
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-04-08
 */
public class QueryTotalBalanceParameter extends AbstractParameter {

    // 当前日期8位 格式 yyyyMMdd
    private String currentDate;

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

}
