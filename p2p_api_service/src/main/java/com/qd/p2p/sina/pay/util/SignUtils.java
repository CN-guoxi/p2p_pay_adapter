package com.qd.p2p.sina.pay.util;

/**
 * <p>
 * 签名工具类
 * </p>
 */
public class SignUtils {
    /**
     * 签名
     *
     * @param content  签名内容
     * @param signMsg  网关返回签名
     * @param signType MD5/RSA
     * @param signKey  密钥
     * @param charset  字符集
     * @return
     * @throws Exception
     */
    public static boolean checkSign(String content, String signMsg, String signType, String signKey, String charset) throws Exception {
        if ("MD5".equalsIgnoreCase(signType)) {
            return MD5.verify(content, signMsg, signKey, charset);
        } else if ("RSA".equalsIgnoreCase(signType)) {
            return RSA.verify(content, signMsg, signKey, charset);
        }
        return false;
    }

    public static String sign(String content, String signType, String signKey,
                              String charset) throws Exception {
        if ("MD5".equalsIgnoreCase(signType)) {
            return MD5.sign(content, signKey, charset);
        } else if ("RSA".equalsIgnoreCase(signType)) {
            return RSA.sign(content, signKey, charset);
        }
        return "";
    }
}
