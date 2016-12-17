package com.qd.p2p.sina.pay.enums;

/**
 * Created by wuaj on 2015/12/23.
 */
public enum BankCode {
    ABC("农业银行"),
    BCCB("北京银行"),
    BJRCB("北京农商行"),
    BOC("中国银行"),
    BOS("上海银行"),
    GNXS("广州市农信社"),
    GZCB("广州市商业银行"),
    HCCB("杭州银行"),
    HKBCHINA("汉口银行"),
    HSBANK("徽商银行"),
    CBHB("渤海银行"),
    CCB("建设银行"),
    CCQTGB("重庆三峡银行"),
    CEB("光大银行"),
    CIB("兴业银行"),
    CITIC("中信银行"),
    CMB("招商银行"),
    CMBC("民生银行"),
    COMM("交通银行"),
    CSCB("长沙银行"),
    CZB("浙商银行"),
    CZCB("浙江稠州商业银行"),
    GDB("广东发展银行"),
    HXB("华夏银行"),
    ICBC("工商银行"),
    NBCB("宁波银行"),
    NJCB("南京银行"),
    PSBC("中国邮储银行"),
    SHRCB("上海农村商业银行"),
    SNXS("深圳农村商业银行"),
    SPDB("浦东发展银行"),
    SXJS("晋城市商业银行"),
    SZPAB("平安银行"),
    UPOP("银联在线支付"),
    WZCB("温州市商业银行");

    private String bankName;

    BankCode(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return this.bankName;
    }
    
    public static BankCode getByCode(String bankCode){
    	for(BankCode en: BankCode.values()){
    		if(en.name().equals(bankCode)){
    			return en;
    		}
    	}
    	return null;
    }
    
    public static BankCode getByName(String bankName){
    	for(BankCode en: BankCode.values()){
    		if(en.bankName.equals(bankName)){
    			return en;
    		}
    	}
    	return null;
    }
    
	@Override
    public String toString(){
    	return this.name();
    }
}