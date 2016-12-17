package com.qd.p2p.adapter.response;

import com.qd.p2p.adapter.AbstractResponse;

/**
 * 响应-账户余额查询
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-04-08
 */
public class QueryBalanceResponse extends AbstractResponse {

    //表示账户金额数，单元：元; 账户未绑定或余额查询异常返回-1
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
