package com.qd.p2p.baofoo;

public interface IPayService {

    /**
     * 请求调用，根据请求参数对象获取到响应对象
     * @param param
     * @param responseClass
     * @return
     */
    <T extends IResponse> T invoke(IRequestParam param, Class<T> responseClass);

}
