package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.QueryTotalBalanceResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.6商户会员托管账户余额总额查询 返回参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
@XStreamAlias(value="crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=QueryTotalBalanceResponse.class)
public class BaofooQueryTotalBalanceResponse extends AbstractResponse implements ResponseAdapter<QueryTotalBalanceResponse> {

    //表示账户金额数，单元：元; 账户未绑定或余额查询异常返回-1
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public QueryTotalBalanceResponse adapter() {
        QueryTotalBalanceResponse item = new QueryTotalBalanceResponse();
        item.setBalance(this.getBalance());
        item.setResponseCode(this.getCode());
        item.setResponseMsg(this.getMsg());
        item.setStatus(getStatus());
        return item;
    }

}
