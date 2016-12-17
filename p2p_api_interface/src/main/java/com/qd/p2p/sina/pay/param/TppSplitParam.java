package com.qd.p2p.sina.pay.param;

/**
 * <p>分账信息(用于代付)</p>
 * @author Kaiju Zhao 2016年2月16日 下午2:27:45
 * @version V1.0   
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2016年2月16日 下午2:27:45
 * @modify by reason:{原因}
 */
public class TppSplitParam {
    
    /** 付款人标识 */
    private String payIdentityId;

    /** 付款人标识类型 */
    private String payIdentityType;

    /** 付款人账户类型 */
    private String payAccountType;

    /** 收款人标识 */
    private String collIdentifyId;

    /** 收款人标识类型 */
    private String collIdentityType;

    /** 收款人账户类型 */
    private String collAccountType;

    /** 金额 */
    private String amount;

    /** 备注 */
    private String remark;
    
    @Override
    public String toString() {
        StringBuilder splitParam = new StringBuilder();
        splitParam.append(payIdentityId).append("^");
        splitParam.append(payIdentityType).append("^");
        splitParam.append(payAccountType).append("^");
        splitParam.append(collIdentifyId).append("^");
        splitParam.append(collIdentityType).append("^");
        splitParam.append(collAccountType).append("^");
        splitParam.append(amount).append("^");
        splitParam.append(remark);
        return splitParam.toString();
    }
    
    public String getPayIdentityId() {
        return payIdentityId;
    }
    
    public void setPayIdentityId(String payIdentityId) {
        this.payIdentityId = payIdentityId;
    }

    public String getPayIdentityType() {
        return payIdentityType;
    }

    public void setPayIdentityType(String payIdentityType) {
        this.payIdentityType = payIdentityType;
    }

    public String getPayAccountType() {
        return payAccountType;
    }

    public void setPayAccountType(String payAccountType) {
        this.payAccountType = payAccountType;
    }

    public String getCollIdentifyId() {
        return collIdentifyId;
    }

    public void setCollIdentifyId(String collIdentifyId) {
        this.collIdentifyId = collIdentifyId;
    }

    public String getCollIdentityType() {
        return collIdentityType;
    }

    public void setCollIdentityType(String collIdentityType) {
        this.collIdentityType = collIdentityType;
    }

    public String getCollAccountType() {
        return collAccountType;
    }

    public void setCollAccountType(String collAccountType) {
        this.collAccountType = collAccountType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
