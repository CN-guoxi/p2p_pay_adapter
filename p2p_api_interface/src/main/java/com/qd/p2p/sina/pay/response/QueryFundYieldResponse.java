package com.qd.p2p.sina.pay.response;

import java.util.List;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;


/**
 * 存钱罐基金收益率查询
 * @author linya 2015-12-23
 */
@SuppressWarnings("serial")
public class QueryFundYieldResponse extends AbstractResponse implements
		IEntityResponse {

	//最近30日收益率及净值
	@Param(value="yield_list", type=ParamType.ENTITY)
	private List<Entity> list;
	
	@Override
	public Class<? extends IEntity> getEntityClass() {
		return Entity.class;
	}

	@Override
	public String[] getPlaceholderFields() {
		return new String[]{"date", "annualizedYield", "worth"};
	}

	public static class Entity implements IEntity{
		
		//日期， 格式： yyyyMMdd
		private String date;
		
		//7日年化收益率
		@Param(type=ParamType.DOUBLE)
		private Double annualizedYield; 
		
		//万份净值
		@Param(type=ParamType.DOUBLE)
		private Double worth;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Double getAnnualizedYield() {
			return annualizedYield;
		}

		public void setAnnualizedYield(Double annualizedYield) {
			this.annualizedYield = annualizedYield;
		}

		public Double getWorth() {
			return worth;
		}

		public void setWorth(Double worth) {
			this.worth = worth;
		}
	}
}
