package com.qd.p2p.sina.pay;

/**
 * 自定义请求功能异常
 * @author linya 2015-12-22
 *
 */
public class SignException extends Exception {

	private static final long serialVersionUID = 1L;

	public SignException(String message) {
		super(message);
	}

	public SignException(String message, Throwable e){
		super(message, e);
	}
}
