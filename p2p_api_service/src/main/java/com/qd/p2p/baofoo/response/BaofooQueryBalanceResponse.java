package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.QueryBalanceResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.5商户会员托管账户余额查询 返回参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
@XStreamAlias(value="crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass= QueryBalanceResponse.class)
public class BaofooQueryBalanceResponse extends AbstractResponse implements ResponseAdapter<QueryBalanceResponse> {

    //表示账户金额数，单元：元; 账户未绑定或余额查询异常返回-1
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public com.qd.p2p.adapter.response.QueryBalanceResponse adapter() {
        QueryBalanceResponse item = new QueryBalanceResponse();
        item.setBalance(this.getBalance());
        item.setResponseCode(this.getCode());
        item.setResponseMsg(this.getMsg());
        item.setStatus(getStatus());
        return item;
    }

}
