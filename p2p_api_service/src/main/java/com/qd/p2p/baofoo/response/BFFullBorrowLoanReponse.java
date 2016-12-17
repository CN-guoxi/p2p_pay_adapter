package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.FullBorrowLoanResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("crs")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = FullBorrowLoanResponse.class)
public class BFFullBorrowLoanReponse extends AbstractResponse implements ResponseAdapter<FullBorrowLoanResponse> {
    @Override
    public FullBorrowLoanResponse adapter() {
        FullBorrowLoanResponse response = new FullBorrowLoanResponse();
        response.setResponseCode(getCode());
        response.setResponseMsg(getMsg());
        response.setStatus(getStatus());
        return response;
    }
}
