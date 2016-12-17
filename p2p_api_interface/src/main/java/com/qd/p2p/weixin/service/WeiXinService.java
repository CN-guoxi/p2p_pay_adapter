package com.qd.p2p.weixin.service;

import java.util.List;
import java.util.Map;

public interface WeiXinService {
    
	/**
	 * 发送模板消息
	 * 
	 * @param toUser 用户openid
	 * @param templateId 模板id
	 * @param title 模板title
	 * @param url 模板消息跳转url 可以为空
	 * @param data 模板数据 map中的key对应模板中的字段 map中的value对应发送的具体值
	 * @return 是否成功
	 */
	public Boolean sendTemplateMessage(String toUser, String templateId, String title, String url,
									   Map<String, String> data);

	/**
	 * 以队列方式发送模板消息
	 * 
	 * @param toUsers 用户openids
	 * @param templateId 模板id
	 * @param title 模板title
	 * @param url 模板消息跳转url 可以为空
	 * @param data 模板数据 map中的key对应模板中的字段 map中的value对应发送的具体值
	 * @return 是否成功
	 */
	public void sendTemplateMessages(List<String> toUsers, String templateId, String title, String url,
									 Map<String, String> data);
	
	/**
	 * <p>添加微信菜单</p>
	 * @author Kaiju Zhao 2016年1月19日 下午1:43:58
	 * @param menuName 菜单名称
	 * @param menuContent 菜单类型
	 * @param parentId 父菜单Id
	 * @param level 菜单层级
	 * @param buttonType 菜单类型
	 * @return 操作结果和创建的菜单信息
	 * @modificationHistory=========================逻辑或功能性重大变更记录
	 * @modify by user: {修改人} 2016年1月19日 下午1:43:58
	 * @modify by reason:{原因}
	 */
	String createWeChatMenu(String menuName, String menuContent, Long parentId, Byte level, Byte buttonType);
	
	/**
	 * <p>修改微信菜单</p>
	 * @author Kaiju Zhao 2016年1月19日 下午1:48:40
	 * @param menuId 菜单Id
     * @param menuName 菜单名称
	 * @param menuContent 菜单内容 (当buttonType为1时，content设置为url,否则为key)
	 * @param buttonType 菜单类型
	 * @return 操作结果和更新的菜单信息
	 * @modificationHistory=========================逻辑或功能性重大变更记录
	 * @modify by user: {修改人} 2016年1月19日 下午1:48:40
	 * @modify by reason:{原因}
	 */
	String updateWeChatMenu(Long menuId, String menuName, String menuContent, Byte buttonType);
	
    /**
     * <p>删除微信菜单</p>
     * @author Kaiju Zhao 2016年1月19日 下午1:50:09
     * @param menuId 菜单Id
     * @return 操作结果
     * @modificationHistory=========================逻辑或功能性重大变更记录
     * @modify by user: {修改人} 2016年1月19日 下午1:50:09
     * @modify by reason:{原因}
     */
	String deleteWeChatMenu(Long menuId);
	
	/**
	 * <p>获取所有的微信菜单</p>
	 * @author Kaiju Zhao 2016年1月19日 下午1:54:14
	 * @param isDelete 是否被删除标志
	 * @return 操作结果和微信菜单列表信息
	 * @modificationHistory=========================逻辑或功能性重大变更记录
	 * @modify by user: {修改人} 2016年1月19日 下午1:54:14
	 * @modify by reason:{原因}
	 */
	String listWeChatMenus(Boolean isDelete);
	
	/**
	 * <p>将系统配置好的菜单推送到微信公众平台</p>
	 * @author Kaiju Zhao 2016年1月19日 下午5:35:44
	 * @return
	 * @modificationHistory=========================逻辑或功能性重大变更记录
	 * @modify by user: {修改人} 2016年1月19日 下午5:35:44
	 * @modify by reason:{原因}
	 */
	String pushAllMenusToMP();
}
