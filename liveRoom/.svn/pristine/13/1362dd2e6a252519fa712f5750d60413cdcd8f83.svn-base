package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.dao.FriendPrivateChatDao;
import com.liveRoom.service.FriendPrivateChatService;

@Service("friendPrivateChatService")
public class FriendPrivateChatServiceImpl implements FriendPrivateChatService{
	
	@Resource
	private FriendPrivateChatDao friendPrivateChatDaoImpl;
	
	/**
	 * 查询所有好友私聊信息
	 */
	@Override
	public Map<String, Object> FriendChatList(int pageNum, int pageSize,
			Map<String, Object> params,String whereSql, Map<String, Object> orderBy) {
		whereSql=" where f.state=1";
		if (params.get("search") != null) {
			whereSql += " and (u.user_name like '%"
					+ MessageFormat.format("{0}", params.get("search")) + "%'"
					+ " or us.user_name like '%"
					+ MessageFormat.format("{0}", params.get("search")) + "%')";
		}
		return friendPrivateChatDaoImpl.FriendChatList(pageNum, pageSize, whereSql,orderBy);
	}

	@Override
	public boolean updateState(long friendchatId) {
		return friendPrivateChatDaoImpl.updateState(friendchatId);
	}

	@Override
	public boolean updatesState(String friendchatIds) {
		return friendPrivateChatDaoImpl.updatesState(friendchatIds);
	}

}
