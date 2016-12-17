package com.qd.p2p.baofoo.response;

import java.util.ArrayList;
import java.util.List;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.BankCardListForEnterpriseResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * （十九）获取会员银行卡信息  请求参数
 *
 * @author linya
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")

@XStreamAlias("crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass= BankCardListForEnterpriseResponse.class)
public class BaofooBankCardListForEnterpriseResponse extends AbstractResponse implements ResponseAdapter<BankCardListForEnterpriseResponse> {

	@XStreamAlias("bankList")
	List<Bank> bankList;
	
	public List<Bank> getBankList() {
		return bankList;
	}

	public void setBankList(List<Bank> bankList) {
		this.bankList = bankList;
	}

	@Override
	public BankCardListForEnterpriseResponse adapter() {
		BankCardListForEnterpriseResponse response = new BankCardListForEnterpriseResponse();
		response.setResponseCode(getCode());
		response.setResponseMsg(getMsg());
		response.setStatus(getStatus());
		List<BankCardListForEnterpriseResponse.Bank> bankList = new ArrayList<BankCardListForEnterpriseResponse.Bank>();
		if(getBankList() != null){
			for (Bank bank:getBankList()) {
				BankCardListForEnterpriseResponse.Bank bankResponse = new BankCardListForEnterpriseResponse.Bank();
				bankResponse.setBankName(bank.getBankName());
				bankResponse.setBankNo(bank.getBankNo());
				bankResponse.setCardId(bank.getCardId());
				bankList.add(bankResponse);
			}
		}
		response.setBankList(bankList);
		return response;
	}

	@XStreamAlias("bank")
	public static class Bank{
		
		// 宝付平台绑卡ID
		@XStreamAlias("card_id")
		private String cardId;
	
		// 银行卡号
		@XStreamAlias("bank_no")
		private String bankNo;
		
		// 开户行
		@XStreamAlias("bank_name")
		private String bankName;
		
        //省份
		@XStreamAlias("pro_value")
        private String provice;
        
        //城市
		@XStreamAlias("city_value")
        private String city;
        
        //开卡分行地址
		@XStreamAlias("bank_address")
        private String bankAddress;
		
		public String getCardId() {
			return cardId;
		}

		public void setCardId(String cardId) {
			this.cardId = cardId;
		}

		public String getBankNo() {
			return bankNo;
		}

		public void setBankNo(String bankNo) {
			this.bankNo = bankNo;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getProvice() {
			return provice;
		}

		public void setProvice(String provice) {
			this.provice = provice;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getBankAddress() {
			return bankAddress;
		}

		public void setBankAddress(String bankAddress) {
			this.bankAddress = bankAddress;
		}

	}
	
}
