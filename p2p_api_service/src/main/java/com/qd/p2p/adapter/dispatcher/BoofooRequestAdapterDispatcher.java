package com.qd.p2p.adapter.dispatcher;

import java.util.Properties;

import org.springframework.beans.BeansException;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.ParameterAdapterManager;
import com.qd.p2p.adapter.Response;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.impl.DefaultRequestHandler;
import com.qd.p2p.baofoo.param.AbstractRequestParam;
import com.qd.p2p.baofoo.response.AbstractResponse;
import com.qd.p2p.commons.PropertyPlaceholderConfigurerHelper;

public class BoofooRequestAdapterDispatcher implements RequsetAdapterDispatcher {
	
    @Override
	public AdaptePlatform support() {
		return AdaptePlatform.BAOFOO;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Response submit(ParameterAdapter parameterAdapter, Class<?> responseAdapterClass) {
		
		//被适配的响应
		Response adaptedResponse = null;
		
		//请求参数（适配处理后的请求参数）
		IRequestParam requsetParam = (IRequestParam)parameterAdapter;
		
		//响应类型
		Class<IResponse> responseClass = (Class<IResponse>) responseAdapterClass;
    	
		//宝付请求处理器
		DefaultRequestHandler handler = new DefaultRequestHandler();
    	IResponse response = handler.submit(requsetParam, responseClass);
    	
    	//获取响应，并获取适配处理后的响应
    	if(response != null){
    		adaptedResponse = ((ResponseAdapter)response).adapter();
    	}
    	
        return adaptedResponse;
	}

	@Override
	public void initAdaptedPlatformInfo() throws BeansException {
		Properties props = PropertyPlaceholderConfigurerHelper.getProperties();
		ConfigurationConsts.init(props);
		//初始化宝付参数响应适配器
		ParameterAdapterManager.registerParameterAdapter(AbstractRequestParam.class.getPackage().getName());
		ParameterAdapterManager.registerResponseAdapter(AbstractResponse.class.getPackage().getName());
	}
	
}
