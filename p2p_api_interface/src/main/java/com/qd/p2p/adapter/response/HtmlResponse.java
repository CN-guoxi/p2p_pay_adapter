package com.qd.p2p.adapter.response;

import com.qd.p2p.adapter.AbstractResponse;
import java.io.Serializable;

/**
 * Created by 51ky on 2016/4/13.
 */
public class HtmlResponse extends AbstractResponse implements Serializable {
    private String html;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
