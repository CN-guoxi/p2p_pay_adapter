package com.qd.p2p.adapter;

/**
 * 定义适配平台
 * @author linya
 */
public enum AdaptePlatform {

	BAOFOO, SINA;
	
	public static AdaptePlatform getPlatform(String platform){
		if(platform == null){
			return BAOFOO;
		}
		for(AdaptePlatform en: AdaptePlatform.values()){
			if(en.name().equalsIgnoreCase(platform)){
				return en;
			}
		}
		return BAOFOO;
	}
}
