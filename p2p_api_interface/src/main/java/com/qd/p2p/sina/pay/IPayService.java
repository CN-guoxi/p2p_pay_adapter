package com.qd.p2p.sina.pay;

public interface IPayService {

    <T extends IResponse> T invoke(IRequestParam param, Class<T> responseClass);

}
