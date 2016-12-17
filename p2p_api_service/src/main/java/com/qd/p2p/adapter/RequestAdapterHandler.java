package com.qd.p2p.adapter;

import com.qd.p2p.adapter.dispatcher.RequsetAdapterDispatcher;
import com.qd.p2p.adapter.dispatcher.RequsetAdapterDispatcherFactory;
import com.qd.p2p.commons.PropertyPlaceholderConfigurerHelper;

public class RequestAdapterHandler {

	public static final String PLATFORM = "common.platform";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T extends Response> T submit(Parameter requestParam, Class<T> adpatedResponseClass) {

		// 获取支付平台
		String platform = PropertyPlaceholderConfigurerHelper.getValue(PLATFORM);
		AdaptePlatform adapterPlatform = AdaptePlatform.getPlatform(platform);

		// 请求适配转发器
		RequsetAdapterDispatcher dispatcher = RequsetAdapterDispatcherFactory
				.getRequsetAdapterDispatcher(adapterPlatform);

		// 获取到参数适配器
		ParameterAdapter parameterAdapter = ParameterAdapterManager.getParameterAdapter(requestParam, adapterPlatform);

		// 获取到响应适配器
		Class<? extends ResponseAdapter> responseAdapterClass = ParameterAdapterManager
				.getResponseAdapter(adpatedResponseClass, adapterPlatform);

		// 提交参数请求
		Response response = dispatcher.submit(parameterAdapter, responseAdapterClass);

		return (T) response;
	}

}
