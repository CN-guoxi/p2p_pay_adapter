package com.qd.p2p.adapter.response;

import com.qd.p2p.adapter.AbstractResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 响应- 获取会员银行卡信息
 * Created by hongbinglin on 2016/4/8.
 */
@SuppressWarnings("serial")
public class BankCardListResponse extends AbstractResponse {

    List<Bank> bankList;

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }
    
    public boolean hasBank(){
    	return bankList !=null && bankList.size() > 0;
    }
    
    public Bank getBank(String cardId){
    	
    	if(!hasBank()){
    		return null;
    	}
    	
    	Bank bank = null;
    	
    	for(Bank b: bankList){
    		String card = b.getCardId();
    		if(card != null && card.equals(cardId)){
    			return b;
    		}
    	}
    	
    	return bank;
    }

    @SuppressWarnings("serial")
	public static class Bank implements Serializable{

    	//平台绑卡ID
    	private String cardId;
    	
        // 银行卡号
        private String bankNo;
        
        //银行名称
        private String bankName;

        
        public String getCardId() {
			return cardId;
		}

		public void setCardId(String cardId) {
			this.cardId = cardId;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getBankNo() {
            return bankNo;
        }

        public void setBankNo(String bankNo) {
            this.bankNo = bankNo;
        }

    }

}
