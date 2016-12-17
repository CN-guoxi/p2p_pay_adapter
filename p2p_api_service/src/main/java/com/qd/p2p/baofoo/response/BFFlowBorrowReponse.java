package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.FlowBorrowResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("crs")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = FlowBorrowResponse.class)
public class BFFlowBorrowReponse extends AbstractResponse implements ResponseAdapter<FlowBorrowResponse> {
    @Override
    public FlowBorrowResponse adapter() {
        FlowBorrowResponse response = new FlowBorrowResponse();
        response.setResponseCode(getCode());
        response.setResponseMsg(getMsg());
        response.setStatus(getStatus());
        return response;
    }
}
