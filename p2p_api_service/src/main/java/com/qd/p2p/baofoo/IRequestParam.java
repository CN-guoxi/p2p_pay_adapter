package com.qd.p2p.baofoo;

import java.io.Serializable;

/**
 * 定义查询参数接口
 *
 * @author linya 2015-11-27
 */
public interface IRequestParam extends Serializable {
    
	/**
	 * 请求URL
	 * @return
	 */
	String getUrlSuffix();
	
	/**
	 * 参数是否进行AES加密
	 * @return
	 */
	boolean aesEncrypt();
	
    /**
     * 参数判断
     */
    boolean checkParameter();
    
}
