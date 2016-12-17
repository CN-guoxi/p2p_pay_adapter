package com.qd.p2p.baofoo;

/**
 * 自定义请求功能异常
 * @author linya 2015-11-30
 *
 */
public class RequestHandlerException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public RequestHandlerException(String message) {
		super(message);
	}

	public RequestHandlerException(String message, Throwable e){
		super(message, e);
	}
}
