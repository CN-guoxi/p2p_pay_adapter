package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.enums.Param;

import org.apache.log4j.Logger;

/**
 * 提供回调请求查询参数的抽象类
 *
 * @author linya 2015-11-25
 */
public abstract class AbstractNotifyRequestParam extends AbstractRequestParam {

	@Param(enabled = false)
	private static final long serialVersionUID = -3364416421051241583L;

    @Param(enabled = false)
    private static final Logger log = Logger.getLogger(AbstractNotifyRequestParam.class);

    @Param("notify_url")
    private String notifyUrl;
    
    @Param("return_url")
    private String returnUrl;

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public AbstractNotifyRequestParam setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
		return this;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public AbstractNotifyRequestParam setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}
    
}
