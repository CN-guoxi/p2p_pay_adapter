package com.qd.p2p.sina.pay.util;

public class RSAUtils {

	/**
	 * 使用公钥加密数据
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String data){
		try {
			byte[] bytes = data.getBytes();
			String publicKey = ConfigurationConsts.RSA_PUBLIC;
			byte[] rsa = RSA.encryptByPublicKey(bytes, publicKey);
			String dataEncrpyt = Base64.encode(rsa);
			return dataEncrpyt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
