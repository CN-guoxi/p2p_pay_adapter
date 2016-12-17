package com.qd.p2p.sina.pay.impl;

import com.qd.p2p.sina.pay.IPayService;
import com.qd.p2p.sina.pay.IRequestParam;
import com.qd.p2p.sina.pay.IResponse;
import com.qd.p2p.sina.pay.RequestHandlerBuilder;
import org.springframework.stereotype.Service;

/**
 * 新浪支付接口
 * @author linya 2015-12-22
 * 
 */
@Service
public class PayServiceImpl implements IPayService {

    @SuppressWarnings("unchecked")
	@Override
    public <T extends IResponse> T invoke(IRequestParam param,
                                          Class<T> responseClass) {
        return (T) RequestHandlerBuilder.submit(param, responseClass);
    }
}