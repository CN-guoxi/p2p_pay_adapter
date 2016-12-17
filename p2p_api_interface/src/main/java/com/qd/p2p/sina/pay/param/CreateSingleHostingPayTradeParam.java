package com.qd.p2p.sina.pay.param;

import java.util.List;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;
import com.qdlc.p2p.common.constant.TradeCode;
import com.qdlc.p2p.common.util.CollectionUtils;

/**
 * 创建托管代付交易
 * @author linya 2015-12-25
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.CREATE_SINGLE_HOSTING_PAY_TRADE)
public class CreateSingleHostingPayTradeParam extends AbstractNotifyRequestParam {
	
    //交易订单号，商户网站交易订单号，商户内部保证唯一
	@Param(value="out_trade_no", required = true)	
	private String outTradeNo;
	
    //交易码，商户网站代收交易业务码，见附录
    @Param(value = "out_trade_code", required = true)
    private TradeCode outTradeCode;
    
	//收款人标识，商户系统用户ID、钱包系统会员ID
	@Param(value="payee_identity_id", required=true)
	private String payeeIdentityId;
	
	//收款人标识类型，ID的类型，参考“标志类型”
	@Param(value="payee_identity_type", required=true)
	private IdentityType payeeIdentityType;
	
	//收款人账户类型
	@Param(value="account_type")
	private AccountType accountType;
	
	@Param(required = true)
	private double amount;
	
	//分账信息列表
	@Param(value = "split_list")
	private String splitList;
	
	//摘要
    @Param(value = "summary", required = true)
    private String summary;
    
    //扩展信息， 业务扩展信息，参数格式：参数名1^参数值1|参数名2^参数值2|……
    @Param(value = "extend_param")
    private String extendParam;

    //商户标的号，对应“标的录入”接口中的标的号，用来关联此笔代收和标的
    @Param(value = "goods_id")
    private String goodsId;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public CreateSingleHostingPayTradeParam setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
		return this;
	}

	public TradeCode getOutTradeCode() {
		return outTradeCode;
	}

	public CreateSingleHostingPayTradeParam setOutTradeCode(TradeCode outTradeCode) {
		this.outTradeCode = outTradeCode;
		return this;
	}

	public String getPayeeIdentityId() {
		return payeeIdentityId;
	}

	public CreateSingleHostingPayTradeParam setPayeeIdentityId(String payeeIdentityId) {
		this.payeeIdentityId = payeeIdentityId;
		return this;
	}

	public IdentityType getPayeeIdentityType() {
		return payeeIdentityType;
	}

	public CreateSingleHostingPayTradeParam setPayeeIdentityType(IdentityType payeeIdentityType) {
		this.payeeIdentityType = payeeIdentityType;
		return this;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public CreateSingleHostingPayTradeParam setAccountType(AccountType accountType) {
		this.accountType = accountType;
		return this;
	}

	public double getAmount() {
		return amount;
	}

	public CreateSingleHostingPayTradeParam setAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public String getSplitList() {
		return splitList;
	}
	
	public CreateSingleHostingPayTradeParam setSplitList(String splitList) {
        this.splitList = splitList;
        return this;
    }

	/**
	 * <p>兼容原先代付接口</p>
	 * @author Kaiju Zhao 2016年2月16日 下午2:38:25
	 * @param splitList
	 * @return
	 * @modificationHistory=========================逻辑或功能性重大变更记录
	 * @modify by user: {修改人} 2016年2月16日 下午2:38:25
	 * @modify by reason:{原因}
	 */
	public CreateSingleHostingPayTradeParam setSplitList(List<TppSplitParam> splitList) {
	    String splitListStr = "";
        if (CollectionUtils.isNotNullOrEmpty(splitList)) {
            StringBuilder splitLists = new StringBuilder();
            for (TppSplitParam splitParam : splitList) {
                splitLists.append(splitParam.toString()).append("|");
            }
            splitListStr = splitLists.substring(0, splitLists.length() - 1);
        }
        this.splitList = splitListStr;
        return this;
    }

	public String getSummary() {
		return summary;
	}

	public CreateSingleHostingPayTradeParam setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public CreateSingleHostingPayTradeParam setExtendParam(String extendParam) {
		this.extendParam = extendParam;
		return this;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public CreateSingleHostingPayTradeParam setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}


}