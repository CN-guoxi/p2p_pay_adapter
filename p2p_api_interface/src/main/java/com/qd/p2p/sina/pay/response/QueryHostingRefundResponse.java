package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;

/**
 * 提交查询的响应基类
 *
 * @author linya 2015-11-30
 */
public class QueryHostingRefundResponse extends AbstractResponse {

    @Param(enabled = false)
    private static final long serialVersionUID = 01202157537511021627012L;

    @Param(value = "trade_list")
    String tradeList;

    @Param("page_no")
    String pageNo;

    @Param("page_size")
    String pageSize;

    @Param(value = "total_item", type = ParamType.INT)
    int totalItem;

    public String getTradeList() {
        return tradeList;
    }

    public void setTradeList(String tradeList) {
        this.tradeList = tradeList;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
}
