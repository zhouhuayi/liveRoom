package com.liveRoom.dao;

import java.util.Map;

public interface FriendPrivateChatDao {
	/**
	 * 查询分页好友私聊列表
	 * 
	 * @author 李琼雅
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> FriendChatList(int pageNum, int pageSize, String whereSql, Map<String, Object> orderBy);
	/**
	 * 修改单条状态
	 * 
	 * @author 李琼雅
	 * @param friendchatId 聊天记录ID
	 * @return
	 */
	public boolean updateState(long friendchatId);
	
	/**
	 * 修改多条状态
	 * 
	 * @author 李琼雅
	 * @param friendchatIds 聊天记录ID集合
	 * @return
	 */
	public boolean updatesState(String friendchatIds);
}
