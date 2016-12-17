package com.qd.p2p.adapter.dispatcher;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.Response;

public interface RequsetAdapterDispatcher {

	AdaptePlatform support();
	
	void initAdaptedPlatformInfo();
	
	@SuppressWarnings("rawtypes")
	Response submit(ParameterAdapter parameterAdapter, Class<?> responseAdapter);
	
}
