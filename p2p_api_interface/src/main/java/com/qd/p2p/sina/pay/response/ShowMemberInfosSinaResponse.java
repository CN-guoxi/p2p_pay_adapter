package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

/**
 * 提交查询的响应基类
 */
public class ShowMemberInfosSinaResponse extends AbstractResponse {

    @Param(enabled = false)
    private static final long serialVersionUID = 01202157537511021627012L;

    @Param("req_html")
    String html;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
