package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.QueryBalanceParameter;
import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.5商户会员托管账户余额查询 请求参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
@Strategy(ServiceStrategy.QUERY_BALANCE)
@XStreamAlias("custody_req")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=QueryBalanceParameter.class)
public class BaofooQueryBalanceParam extends AbstractRequestParam implements ParameterAdapter<QueryBalanceParameter> {

    // 商户号
    @XStreamAlias("merchant_id")
    private String merchantId;

    // 用户编号(唯一)
    @XStreamAlias("user_id")
    private String userId;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void adapter(QueryBalanceParameter t) {
        this.merchantId = ConfigurationConsts.MERCHANT_ID;
        this.userId = t.getPlatformUserId();
    }

}
