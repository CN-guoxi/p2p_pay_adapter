package com.qd.p2p.baofoo.param;

import com.qd.p2p.baofoo.IRequestParam;

/**
 * 请求内容为txt的文本
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-6
 */
public interface ITxtRequestParam extends IRequestParam {

    /**
     * 获取请求内容为txt的文本
     *
     * @author Kaiju Zhao
     */
    String getRequestParams();
}
