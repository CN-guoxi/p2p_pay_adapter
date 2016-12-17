package com.qd.p2p.sina.pay.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.qdlc.p2p.common.util.DataUtils;

public class ConfigurationConsts {
	
	private static final Logger log = Logger.getLogger(ConfigurationConsts.class);

	private static volatile boolean inited = false;
	
	public static String MERCHANT_ID;		//第三方商户号
	
	public static String GOODS_KEY;			//第三方商品key
	
	public static String RSA_PUBLIC;		//第三方RSA公钥
	
	public static String CHECK_SIGN_KEY;    //第三方RSA验签key
	
	public static String SIGN_TYPE;			//第三方验签方式 "RSA" "MD5"
	
	public static String SINA_MEMBER_URL;	//第三方会员网关
	
	public static String SINA_URL;			//第三方收单网关
	
	public static String MEMBER_EMAIL;		//第三方企业钱包登录名邮箱
	
	public static String LOGIN_URL;			//第三方登录地址
	
	public static String TPP_NAME;			//第三方名称
	
	public static String ACCOUNT_TYPE;		//第三方账户类型
	
	public static String FUND_CODE;			//第三方基金代码
	
	public static void init(Properties props){
		if(inited){
			return;
		}
		inited = true;
		
		Field[] fields = ConfigurationConsts.class.getDeclaredFields();
		String currentField = null;
		List<String> emptyFields = new ArrayList<String>();
		try {
			for(Field f: fields){
				currentField = StringUtils.lowerCase(f.getName());
				if("log".equals(currentField) || "inited".equals(currentField)){
					continue;
				}
				Object value = props.get(currentField);
				if(value == null){
					emptyFields.add(currentField);
				}
				f.set(null, DataUtils.toString(value).trim());
			}
			System.out.println("+++" + MERCHANT_ID);
		} catch (Exception e) {
			log.info("++++ 获取属性文件信息发生错误, 当前错误的键为：" + currentField, e);
			e.printStackTrace();
		}finally{
			log.info("++++ 获取属性文件信息，还没有设置的属性有：" + Arrays.toString(emptyFields.toArray()));
		}
	}
}
