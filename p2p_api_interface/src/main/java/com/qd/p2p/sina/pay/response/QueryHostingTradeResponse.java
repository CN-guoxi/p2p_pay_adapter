package com.qd.p2p.sina.pay.response;

import java.util.List;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;

/**
 * 提交查询的响应基类
 *
 * @author linya 2015-11-30
 */
public class QueryHostingTradeResponse extends AbstractResponse implements IEntityResponse{

    @Param(enabled = false)
    private static final long serialVersionUID = 01202157537511021627012L;

    @Param("trade_list")
    String tradeList;
    
    @Param(value="trade_list", type=ParamType.ENTITY)
    List<Entity> list;

    @Param(value = "total_item", type = ParamType.INT)
    int totalItem;

    @Param("page_no")
    private String pageNo;

    @Param("page_size")
    private String pageSize;

    public String getTradeList() {
        return tradeList;
    }

    public void setTradeList(String tradeList) {
        this.tradeList = tradeList;
    }

	public List<Entity> getList() {
		return list;
	}

	public void setList(List<Entity> list) {
		this.list = list;
	}

	public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
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

	@Override
	public Class<? extends IEntity> getEntityClass() {
		return Entity.class;
	}

	@Override
	public String[] getPlaceholderFields() {
		return new String[]{"outTradeNo", "summary","tradeAmount","tradeStatus","createTime", "lastModifiedTime"};
	}
	
	/**
	 * 返回实体内容格式为：  
	 * 交易订单号^摘要^交易金额^交易状态^创建时间^最后修改时间
	 * 1512112082776409^手动投标^100.00^TRADE_FINISHED^20151211154436^20151211154439
	 * @author linya 2015-12-24
	 *
	 */
	public static class Entity implements IEntity{
		
		//交易订单号，外部交易号，即out_trade_no
		String outTradeNo;
		
		//摘要，明细摘要（用途）
		String summary;
		
		//交易金额，单位为：RMB Yuan。精确到小数点后两位
		@Param(type=ParamType.DOUBLE)
		Double tradeAmount;

		//交易状态
		String tradeStatus;
		
		//创建时间，数字串，一共14位格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位] 
		String createTime;
		
		//最后修改时间，数字串，一共14位格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
		String lastModifiedTime;

		public String getOutTradeNo() {
			return outTradeNo;
		}

		public void setOutTradeNo(String outTradeNo) {
			this.outTradeNo = outTradeNo;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public Double getTradeAmount() {
			return tradeAmount;
		}

		public void setTradeAmount(Double tradeAmount) {
			this.tradeAmount = tradeAmount;
		}

		public String getTradeStatus() {
			return tradeStatus;
		}

		public void setTradeStatus(String tradeStatus) {
			this.tradeStatus = tradeStatus;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public String getLastModifiedTime() {
			return lastModifiedTime;
		}

		public void setLastModifiedTime(String lastModifiedTime) {
			this.lastModifiedTime = lastModifiedTime;
		}

		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer(100);
			buffer.append("{")
				.append("outTradeNo:").append(outTradeNo).append(",")
				.append("summary:").append(summary).append(",")
				.append("tradeAmount:").append(tradeAmount).append(",")
				.append("tradeStatus:").append(tradeStatus).append(",")
				.append("createTime:").append(createTime).append(",")
				.append("lastModifiedTime:").append(lastModifiedTime)
				.append("}");
			return buffer.toString();
		}
		
	}
}
