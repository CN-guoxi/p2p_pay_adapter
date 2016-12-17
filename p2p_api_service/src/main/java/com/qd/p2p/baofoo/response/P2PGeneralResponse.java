package com.qd.p2p.baofoo.response;

import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("crs")
@Strategy(ServiceStrategy.P2P_REQUEST)
public class P2PGeneralResponse extends AbstractResponse {

}