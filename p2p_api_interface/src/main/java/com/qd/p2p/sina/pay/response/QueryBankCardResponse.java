package com.qd.p2p.sina.pay.response;

import java.util.ArrayList;
import java.util.List;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;

@SuppressWarnings("serial")
public class QueryBankCardResponse extends AbstractResponse implements IEntityResponse{

    @Param("card_list")
    String cardList;
    
    @Param(value="card_list", type=ParamType.ENTITY)
    List<Entity> list = new ArrayList<QueryBankCardResponse.Entity>();

    public String getCardList() {
        return cardList;
    }

    public void setCardList(String cardList) {
        this.cardList = cardList;
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
		return new String[]{"cardId", "bankCode", "bankAccountNo", "accountName",
				"cardType", "cardAttribute", "verifyed", "createTime", "cardSafe"};
	}

	/**
	 * 响应格式：
	 * 卡ID^银行编号^银行卡号^户名^卡类型^卡属性^校验^创建时间^安全卡标识
	 * 56263^ICBC^***************5309^**军^DEBIT^C^N^20151223185257^N
	 * @author linya 2015-12-24
	 */
	public static class Entity implements IEntity{
		
		//卡信息ID
		private String cardId;
		
		//银行编号
		private String bankCode;
		
		//银行卡号(掩码)
		private String bankAccountNo;
		
		//户名(掩码)
		private String accountName;
		
		//卡类型
		private String cardType;
		
		//卡属性
		private String cardAttribute;
		
		//校验，绑卡时如果verify_mode 选择是SIGN,则返回Y，否则返回N
		@Param(type=ParamType.BOOLEAN)
		private boolean verifyed;
		
		//创建时间  数字串，一共14位格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位] 
		private String createTime;
		
		//安全卡标识  银行卡是否为安全卡，Y：安全卡；N：非安全卡
		@Param(type=ParamType.BOOLEAN)
		private boolean cardSafe;

		public String getCardId() {
			return cardId;
		}

		public void setCardId(String cardId) {
			this.cardId = cardId;
		}

		public String getBankCode() {
			return bankCode;
		}

		public void setBankCode(String bankCode) {
			this.bankCode = bankCode;
		}

		public String getBankAccountNo() {
			return bankAccountNo;
		}

		public void setBankAccountNo(String bankAccountNo) {
			this.bankAccountNo = bankAccountNo;
		}

		public String getAccountName() {
			return accountName;
		}

		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}

		public String getCardType() {
			return cardType;
		}

		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		public String getCardAttribute() {
			return cardAttribute;
		}

		public void setCardAttribute(String cardAttribute) {
			this.cardAttribute = cardAttribute;
		}

		public boolean isVerifyed() {
			return verifyed;
		}

		public void setVerifyed(boolean verifyed) {
			this.verifyed = verifyed;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public boolean isCardSafe() {
			return cardSafe;
		}

		public void setCardSafe(boolean cardSafe) {
			this.cardSafe = cardSafe;
		}

		public String toString() {
			StringBuffer buffer = new StringBuffer(300);
			buffer.append("{")
				.append("cardId:").append(cardId).append(",")
				.append("bankCode:").append(bankCode).append(",")
				.append("bankAccountNo:").append(bankAccountNo).append(",")
				.append("accountName:").append(accountName).append(",")
				.append("cardAttribute:").append(cardAttribute).append(",")
				.append("verifyed:").append(verifyed).append(",")
				.append("createTime:").append(createTime).append(",")
				.append("cardSafe:").append(cardSafe)
				.append("}");
			return buffer.toString();
		}
		
	}
	
}
