package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.QueryTotalBalanceParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;

/**
 * 4.6商户会员托管账户余额总额查询 请求参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
@Strategy(ServiceStrategy.QUERY_TOTAL_BALANCE)
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=QueryTotalBalanceParameter.class)
public class BaofooQueryTotalBalanceParam extends AbstractRequestParam implements ITxtRequestParam, ParameterAdapter<QueryTotalBalanceParameter> {

    // 请求参数 当前日期8位 格式 yyyyMMdd
    private String requestParams;

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    @Override
    public void adapter(QueryTotalBalanceParameter t) {
        this.requestParams = t.getCurrentDate();
    }

}
