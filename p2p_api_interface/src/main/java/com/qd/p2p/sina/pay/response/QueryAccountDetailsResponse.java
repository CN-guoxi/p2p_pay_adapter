package com.qd.p2p.sina.pay.response;


import java.util.List;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;

@SuppressWarnings("serial")
public class QueryAccountDetailsResponse extends AbstractResponse implements IEntityResponse{

    @Param("detail_list")
    String detailList;
    
    @Param(value="detail_list", type=ParamType.ENTITY)
    List<Entity> list;

    @Param(value = "page_no", type = ParamType.INT)
    Integer pageNo;

    @Param(value = "page_size", type = ParamType.INT)
    Integer pageSize;

    @Param(value = "total_item", type = ParamType.INT)
    Integer totalItem;

    @Param(value = "total_income", type = ParamType.DOUBLE)
    Double totalIncome;

    @Param(value = "total_payout", type = ParamType.DOUBLE)
    Double totalPayout;

    public String getDetailList() {
        return detailList;
    }

    public void setDetailList(String detailList) {
        this.detailList = detailList;
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

    public Double getTotalPayout() {
        return totalPayout;
    }

    public void setTotalPayout(Double totalPayout) {
        this.totalPayout = totalPayout;
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
		return new String[]{"remark", "time", "sign", "changeAmount", "accountBalance", "description"};
	}
	
	
	/**
	 * 响应格式：  1223-收益^20151223000000^+^0.94^9406.47^BONUS|手动投标^20151222200238^-^350.00^9405.53^OUT
	 * @author linya 2015-12-23
	 */
	public static class Entity implements IEntity{
		
		private String remark;									//备注
		
		private String time;									//时间
		
		private String sign;									//资金符号，+表示资金增加，-表示资金减少
		
		@Param(value="changeAmount", type=ParamType.DOUBLE)
		private Double changeAmount = 0.0D;						//变更金额
		
		@Param(value="accountBalance", type=ParamType.DOUBLE)
		private Double accountBalance = 0.0D;					//账户余额
		
		private String description;								//描述

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getSign() {
			return sign;
		}

		public void setSign(String sign) {
			this.sign = sign;
		}

		public Double getChangeAmount() {
			return changeAmount;
		}

		public void setChangeAmount(Double changeAmount) {
			this.changeAmount = changeAmount;
		}

		public Double getAccountBalance() {
			return accountBalance;
		}

		public void setAccountBalance(Double accountBalance) {
			this.accountBalance = accountBalance;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
	}

}
