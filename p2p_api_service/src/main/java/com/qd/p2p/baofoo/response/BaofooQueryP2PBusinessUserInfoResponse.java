package com.qd.p2p.baofoo.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.QueryP2PBusinessUserInfoResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.22业务查询接口（服务端接口）（用户信息） 返回参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-6
 */
@XStreamAlias("crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=QueryP2PBusinessUserInfoResponse.class)
public class BaofooQueryP2PBusinessUserInfoResponse extends AbstractResponse implements ResponseAdapter<QueryP2PBusinessUserInfoResponse> {

    @XStreamAlias("result")
    private List<Order> result;

    public List<Order> getResult() {
        return result;
    }

    public void setResult(List<Order> result) {
        this.result = result;
    }

    /**
     * 用户信息查询结果类
     *
     * @author Kaiju Zhao
     */
    @XStreamAlias(value="order")
    public static class Order {

        // 商户的用户ID，如20140501
        @XStreamAlias("user_id")
        private String userId;

        /**
         * 用户信息返回状态：
         *      1 正常  0未授权 -1已注销
         */
        private Integer state;

        // 会员账号，如15000900900
        @XStreamAlias("account_name")
        private String accountName;

        // 创建时间,如2015-01-01 01:01:01
        @XStreamAlias("create_time")
        private String createTime;

        // 会员手机，如15000900911
        private String mobile;

        // 会员邮箱，如123456@qq.com
        private String email;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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

    @Override
    public QueryP2PBusinessUserInfoResponse adapter() {
        QueryP2PBusinessUserInfoResponse item = new QueryP2PBusinessUserInfoResponse();
        List<QueryP2PBusinessUserInfoResponse.UserInfo> userInfoList = new ArrayList<QueryP2PBusinessUserInfoResponse.UserInfo>();
        if (null != result && result.size() > 0) {
            for (Order order : result) {
                QueryP2PBusinessUserInfoResponse.UserInfo userInfo = new QueryP2PBusinessUserInfoResponse.UserInfo();
                BeanUtils.copyProperties(order, userInfo);
                userInfo.setPlatformUserId(order.getUserId());
                userInfoList.add(userInfo);
            }
        }
        item.setResult(userInfoList);
        item.setResponseCode(this.getCode());
        item.setResponseMsg(this.getMsg());
        item.setStatus(getStatus());
        return item;
    }
}
