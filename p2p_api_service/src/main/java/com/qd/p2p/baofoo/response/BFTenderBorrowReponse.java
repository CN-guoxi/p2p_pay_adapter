package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.TenderBorrowResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("crs")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = TenderBorrowResponse.class)
public class BFTenderBorrowReponse extends AbstractResponse implements ResponseAdapter<TenderBorrowResponse> {
    @Override
    public TenderBorrowResponse adapter() {
        TenderBorrowResponse response = new TenderBorrowResponse();
        response.setResponseCode(getCode());
        response.setResponseMsg(getMsg());
        response.setStatus(getStatus());
        return response;
    }
}
