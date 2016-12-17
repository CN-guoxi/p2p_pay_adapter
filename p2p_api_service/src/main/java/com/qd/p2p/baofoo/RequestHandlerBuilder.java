package com.qd.p2p.baofoo;

import com.qd.p2p.baofoo.impl.DefaultRequestHandler;

/**
 * 请求工具类，该类对RequestHandler、RequestParam、Response进行了封装
 * 该类可以灵活地选择RequestHandler和RequestParam进行请求，
 * 返回的响应对象为设置的responseClass类型
 * <p>
 * <code>
 * BaseRequestParam param = new BaseRequestParam();
 * UserAccountResponse response = RequestHandlerBuilder.build()
 * .setRequestParam(param)
 * .setResponseClass(UserAccountResponse.class)
 * .submit();
 * </code>
 * </p>
 * <code>
 * BaseRequestParam param = new BaseRequestParam();
 * SubmitResponse response = RequestHandlerBuilder.submit(param, SubmitResponse.class);
 * </code>
 *
 * @author linya 2015-12-21
 */
public class RequestHandlerBuilder {

    IRequestHandler handler = new DefaultRequestHandler();

    IRequestParam param;

    Class<? extends IResponse> responseClass;

    private RequestHandlerBuilder() {

    }

    public static RequestHandlerBuilder build() {
        RequestHandlerBuilder builder = new RequestHandlerBuilder();
        return builder;
    }

    public RequestHandlerBuilder setRequestParam(IRequestParam param) {
        this.param = param;
        return this;
    }

    public RequestHandlerBuilder setResponseClass(Class<? extends IResponse> responseClass) {
        this.responseClass = responseClass;
        return this;
    }
    
    public RequestHandlerBuilder setRequestHandler(IRequestHandler handler){
    	this.handler = handler;
    	return this;
    }

    @SuppressWarnings("unchecked")
	public <T extends IResponse> T submit() {
        return (T) handler.submit(param, responseClass);
    }

    public static <T extends IResponse> T submit(IRequestParam param, Class<? extends IResponse> responseClass) {
        return build().setRequestParam(param).setResponseClass(responseClass).submit();
    }
}
