package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.param.RepayBorrowParam;
import com.qd.p2p.adapter.response.FullBorrowLoanResponse;
import com.qd.p2p.adapter.response.RepayBorrowResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("crs")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = RepayBorrowResponse.class)
public class BFRepayBorrowReponse extends AbstractResponse implements ResponseAdapter<RepayBorrowResponse> {
    @Override
    public RepayBorrowResponse adapter() {
        RepayBorrowResponse response = new RepayBorrowResponse();
        response.setResponseCode(getCode());
        response.setResponseMsg(getMsg());
        response.setStatus(getStatus());
        return response;
    }
}
