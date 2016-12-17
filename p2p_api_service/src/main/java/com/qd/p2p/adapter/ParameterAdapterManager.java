package com.qd.p2p.adapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.qd.p2p.commons.ScanPackageUtil;

/**
 * 参数适配器管理器
 * @author linya
 */
@SuppressWarnings("rawtypes")
public class ParameterAdapterManager {

	//参数适配器映射
	private static final Map<AdapterKey, Class<? extends ParameterAdapter>> globalParameterAdapterMap = new HashMap<AdapterKey, Class<? extends ParameterAdapter>>();
	
	//响应适配器映射
	private static final Map<AdapterKey, Class<? extends ResponseAdapter>> globalResponseAdapterMap = new HashMap<AdapterKey, Class<? extends ResponseAdapter>>();
	
	
	/**
	 * 获取适配后的参数对象
	 * @param parameter
	 * @param platform
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ParameterAdapter getParameterAdapter(Parameter parameter, AdaptePlatform platform){
		Class<? extends ParameterAdapter> adapterClass = globalParameterAdapterMap.get(new AdapterKey(parameter.getClass(), platform));
		ParameterAdapter adapter = null;
		try {
			adapter = adapterClass.newInstance();
			adapter.adapter(parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(adapter == null){
			throw new IllegalArgumentException("++++ no find a ParameterAdapter for " + parameter.getClass() + " at platform " + platform.name());
		}
		return adapter;
	}
	
	/**
	 * 注册参数适配器
	 */
	@SuppressWarnings("unchecked")
	public static void registerParameterAdapter(Class<? extends ParameterAdapter> adapterClass){
		Adapted adapted = adapterClass.getAnnotation(Adapted.class);
		if(adapted == null){
			throw new IllegalArgumentException("++++ please set @Adapted for " + adapterClass.getName());
		}
		AdaptePlatform platform = adapted.value();
		Class<? extends Parameter>[] parameterClassList = (Class<? extends Parameter>[]) adapted.adaptedClass();
		for (Class<? extends Parameter> parameterClass:parameterClassList) {
			AdapterKey key = new AdapterKey(parameterClass, platform);
			globalParameterAdapterMap.put(key, adapterClass);
		}
	}
	
	/**
	 * 扫包注册参数适配器
	 * @param basePackage
	 */
	public static void registerParameterAdapter(String basePackage){
		Set<Class<ParameterAdapter>> parameterAdapterClasses = ScanPackageUtil.getClasses(basePackage, ParameterAdapter.class);
		for(Class<ParameterAdapter> adapterClass: parameterAdapterClasses){
			registerParameterAdapter(adapterClass);
		}
	}
	
	/**
	 * 获取响应适配器
	 * @param adaptedResponseClass
	 * @param platform
	 * @return
	 */
	public static Class<? extends ResponseAdapter> getResponseAdapter(Class adaptedResponseClass, AdaptePlatform platform){
		Class<? extends ResponseAdapter> adapterClass = globalResponseAdapterMap.get(new AdapterKey(adaptedResponseClass, platform));
		if(adapterClass == null){
			throw new IllegalArgumentException("++++ no find a ResponseAdapter for " + adaptedResponseClass + " at platform " + platform.name());
		}
		return adapterClass;
	}
	
	/**
	 * 注册响应适配器
	 */
	@SuppressWarnings("unchecked")
	public static void registerResponseAdapter(Class<? extends ResponseAdapter> responseAdapterClass){
		Adapted adapted = responseAdapterClass.getAnnotation(Adapted.class);
		if(adapted == null){
			throw new IllegalArgumentException("++++ please set @Adapted for " + responseAdapterClass.getName());
		}
		AdaptePlatform platform = adapted.value();
		Class<? extends Response>[] adaptedResponseClassList = (Class<? extends Response>[]) adapted.adaptedClass();
		for (Class<? extends Response> adaptedResponseClass:adaptedResponseClassList) {
			AdapterKey key = new AdapterKey(adaptedResponseClass, platform);
			globalResponseAdapterMap.put(key, responseAdapterClass);
		}
	}
	
	/**
	 * 扫包注册响应适配器
	 * @param basePackage
	 */
	public static void registerResponseAdapter(String basePackage){
		Set<Class<ResponseAdapter>> responseAdapterClasses = ScanPackageUtil.getClasses(basePackage, ResponseAdapter.class);
		for(Class<ResponseAdapter> responseAdapterClass: responseAdapterClasses){
			registerResponseAdapter(responseAdapterClass);
		}
	}
	
	/**
	 * 适配器Key
	 */
	private static class AdapterKey{
		
		Class adaptedClass;
		
		AdaptePlatform platform;
		
		AdapterKey(Class adaptedClass, AdaptePlatform platform){
			this.adaptedClass = adaptedClass;
			this.platform = platform;
		}

		@Override
		public int hashCode() {
			int hashCode = 17;
			hashCode = hashCode * 37 + adaptedClass.hashCode();
			hashCode = hashCode * 37 + platform.name().hashCode();
			return hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj){
				return true;
			}
			if(!(obj instanceof AdapterKey)){
				return false;
			}
			AdapterKey other = (AdapterKey)obj;
			if(other.adaptedClass == null || this.adaptedClass == null
					|| other.platform == null || this.platform == null){
				return false;
			}
			return adaptedClass.equals(other.adaptedClass) && platform.equals(other.platform);
		}
		
	}
}
