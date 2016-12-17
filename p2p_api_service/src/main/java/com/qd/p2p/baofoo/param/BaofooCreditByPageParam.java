package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.CreditByPageParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.24获取资金托管商户认证书（页面）
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-05-03
 */
@Strategy(value=ServiceStrategy.CREDIT_PAGE)
@XStreamAlias("custody_req")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = CreditByPageParameter.class)
public class BaofooCreditByPageParam extends AbstractRequestParam implements ParameterAdapter<CreditByPageParameter>, IHtmlResponsiveRequestParam {

    @Override
    public void adapter(CreditByPageParameter t) {

    }

}
