package com.qd.p2p.adapter.response;

import java.io.Serializable;
import java.util.List;

import com.qd.p2p.adapter.AbstractResponse;

/**
 * 响应-业务查询接口（用户信息）
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-04-08
 */
public class QueryP2PBusinessUserInfoResponse extends AbstractResponse {

	private List<UserInfo> result;

	public List<UserInfo> getResult() {
		return result;
	}

	public void setResult(List<UserInfo> result) {
		this.result = result;
	}

	/**
	 * 用户信息查询结果类
	 *
	 * @author Kaiju Zhao
	 */
	public static class UserInfo implements Serializable {

		private static final long serialVersionUID = -8667526157458901931L;

		// 商户的用户ID，如20140501
		private String platformUserId;

		/**
		 * 用户信息返回状态：
		 * 1 正常 0未授权 -1已注销
		 */
		private Integer state;

		// 会员账号，如15000900900
		private String accountName;

		// 创建时间,如2015-01-01 01:01:01
		private String createTime;

		// 会员手机，如15000900911
		private String mobile;

		// 会员邮箱，如123456@qq.com
		private String email;

		public String getPlatformUserId() {
			return platformUserId;
		}

		public void setPlatformUserId(String platformUserId) {
			this.platformUserId = platformUserId;
		}

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}

		public String getAccountName() {
			return accountName;
		}

		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}

}
