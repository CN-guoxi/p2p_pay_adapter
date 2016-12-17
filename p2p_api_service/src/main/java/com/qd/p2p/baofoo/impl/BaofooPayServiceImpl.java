package com.qd.p2p.baofoo.impl;

import java.util.Properties;

import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.IPayService;
import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.RequestHandlerBuilder;
import com.qd.p2p.commons.PropertyPlaceholderConfigurerHelper;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 宝付支付接口
 * @author linya 2015-12-22
 */
@Service
public class BaofooPayServiceImpl implements IPayService, InitializingBean{

    @SuppressWarnings("unchecked")
	@Override
    public <T extends IResponse> T invoke(IRequestParam param, Class<T> responseClass) {
        return (T) RequestHandlerBuilder.submit(param, responseClass);
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		//初始化配置文件值
		Properties props = PropertyPlaceholderConfigurerHelper.getProperties();
		ConfigurationConsts.init(props);
	}
    
}