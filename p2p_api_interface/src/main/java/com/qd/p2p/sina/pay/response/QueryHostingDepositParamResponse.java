package com.qd.p2p.sina.pay.response;


import java.util.List;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;

@SuppressWarnings("serial")
public class QueryHostingDepositParamResponse extends AbstractResponse implements IEntityResponse{

	@Param("deposit_list")
	String detailList;

	@Param(value="deposit_list", type=ParamType.ENTITY)
	List<Entity> list;

	@Param("page_no")
	String pageNo;

	@Param("page_size")
	String pageSize;

	@Param(value = "total_list", type = ParamType.INT)
	int totalList;

	public String getDetailList() {
		return detailList;
	}

	public void setDetailList(String detailList) {
		this.detailList = detailList;
	}

	public String getPageNo() {
		return pageNo;
	}

	public List<Entity> getList() {
		return list;
	}

	public void setList(List<Entity> list) {
		this.list = list;
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

	public int getTotalList() {
		return totalList;
	}

	public void setTotalList(int totalList) {
		this.totalList = totalList;
	}

	@Override
	public Class<? extends IEntity> getEntityClass() {
		return Entity.class;
	}

	@Override
	public String[] getPlaceholderFields() {
		return new String[]{"outTradeNo","depositAmount","depositStatus","createTime", "lastModifiedTime"};
	}

	/**
	 * 返回实体内容格式为：  
	 * 充值订单号^充值金额^充值状态^创建时间^最后修改时间
	 * 20131117020101^30^ WAIT_PAY^20131117020101^201311170201
	 * @author hongbl 2015-12-25
	 *
	 */
	public static class Entity implements IEntity{

		//充值订单号，外部交易号，即out_trade_no
		String outTradeNo;

		//充值金额，单位为：RMB Yuan。精确到小数点后两位
		@Param(type=ParamType.DOUBLE)
		Double depositAmount;

		//充值状态
		String depositStatus;

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

		public Double getDepositAmount() {
			return depositAmount;
		}

		public void setDepositAmount(Double depositAmount) {
			this.depositAmount = depositAmount;
		}

		public String getDepositStatus() {
			return depositStatus;
		}

		public void setDepositStatus(String depositStatus) {
			this.depositStatus = depositStatus;
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
					.append("depositAmount:").append(depositAmount).append(",")
					.append("depositStatus:").append(depositStatus).append(",")
					.append("createTime:").append(createTime).append(",")
					.append("lastModifiedTime:").append(lastModifiedTime)
					.append("}");
			return buffer.toString();
		}

	}

}


