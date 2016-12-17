package com.qd.p2p.adapter.dispatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.commons.ScanPackageUtil;

public class RequsetAdapterDispatcherFactory {

	private static Map<AdaptePlatform, RequsetAdapterDispatcher> platformDispatcher;
	
	public static RequsetAdapterDispatcher getRequsetAdapterDispatcher(AdaptePlatform platform){
		RequsetAdapterDispatcher dispatcher = null;
		initDispatcher();
		dispatcher = platformDispatcher.get(platform);
		return dispatcher;
	}
	
	private static void initDispatcher(){
		if(platformDispatcher == null){
			synchronized (RequsetAdapterDispatcherFactory.class) {
				if(platformDispatcher == null){
					newInstance();
				}
			}
		}
	}
	
	private static void newInstance(){
		platformDispatcher = new HashMap<AdaptePlatform, RequsetAdapterDispatcher>();
		Set<Class<RequsetAdapterDispatcher>> sets = ScanPackageUtil.getClasses(RequsetAdapterDispatcherFactory.class.getPackage().getName(), RequsetAdapterDispatcher.class);
		for(Class<RequsetAdapterDispatcher> clazz: sets){
			try {
				RequsetAdapterDispatcher dispatcher = clazz.newInstance();
				dispatcher.initAdaptedPlatformInfo();
				platformDispatcher.put(dispatcher.support(), dispatcher);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
