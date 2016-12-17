package com.qd.p2p.sina.pay.response;


import java.util.List;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;
import com.qd.p2p.sina.pay.param.QueryHostingWithdrawParam;

/**
 * 托管提现查询
 * @author linya 2015-12-25
 * @see QueryHostingWithdrawParam
 */
@SuppressWarnings("serial")
public class QueryHostingWithdrawResponse extends AbstractResponse implements IEntityResponse{

    @Param("withdraw_list")
    String withdrawList;
    
    @Param(value="withdraw_list", type=ParamType.ENTITY)
    List<Entity> list;

    @Param(value = "page_no", type = ParamType.INT)
    Integer pageNo;

    @Param(value = "page_size", type = ParamType.INT)
    Integer pageSize;

    @Param(value = "total_item", type = ParamType.INT)
    Integer totalItem;

    @Param(value = "total_income", type = ParamType.DOUBLE)
    Double totalIncome;

    
    public String getWithdrawList() {
		return withdrawList;
	}

	public void setWithdrawList(String withdrawList) {
		this.withdrawList = withdrawList;
	}

	public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

	public List<Entity> getList() {
		return list;
	}

	public void setList(List<Entity> list) {
		this.list = list;
	}

	@Override
	public Class<? extends IEntity> getEntityClass() {
		return Entity.class;
	}

	@Override
	public String[] getPlaceholderFields() {
		return new String[]{"outTradeNo", "withdrawAmount", "withdrawStatus", "createTime", "lastModifiedTime"};
	}
	
	
	/**
	 * 响应格式：  20131117020101^还款^30^ WAIT_BUYER_PAY^20131117020101^20131117020101
	 * @author linya 2015-12-23
	 */
	public static class Entity implements IEntity{
		
		//提现订单号，外部交易号，即out_trade_no
		String outTradeNo;
		
		//提现金额，单位为：RMB Yuan。精确到小数点后两位
		@Param(type=ParamType.DOUBLE)
		Double withdrawAmount;

		//提现状态
		String withdrawStatus;
		
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

		public Double getWithdrawAmount() {
			return withdrawAmount;
		}

		public void setWithdrawAmount(Double withdrawAmount) {
			this.withdrawAmount = withdrawAmount;
		}

		public String getWithdrawStatus() {
			return withdrawStatus;
		}

		public void setWithdrawStatus(String withdrawStatus) {
			this.withdrawStatus = withdrawStatus;
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
		
	}

}
