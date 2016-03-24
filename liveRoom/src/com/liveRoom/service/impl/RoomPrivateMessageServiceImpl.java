package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.dao.RoomPrivateMessageDao;
import com.liveRoom.service.RoomPrivateMessageService;

@Service("roomPrivateMessageService")
public class RoomPrivateMessageServiceImpl implements RoomPrivateMessageService{
	
	@Resource
	private RoomPrivateMessageDao roomPrivateMessageDao;
	
	@Resource
	private RoomPrivateMessageDao roomPrivateMessageDaoImpl;

	@Override
	public Map<String, Object> roomPrivateMessageList(int pageNum,
			int pageSize,Map<String, Object> params, String whereSql, Map<String, Object> orderBy) {
		whereSql=" where rm.room_private_message_state=1";
		if (params.get("search") != null) {
			whereSql += " and (u.user_name like '%"
					+ MessageFormat.format("{0}", params.get("search")) + "%'"
					+ " or r.room_name like '%"
					+ MessageFormat.format("{0}", params.get("search")) + "%'"
					+ " or us.user_name like '%"
					+ MessageFormat.format("{0}", params.get("search")) + "%')";
		}
		return roomPrivateMessageDaoImpl.roomPrivateMessageList(pageNum, pageSize, whereSql,orderBy);
	}

	@Override
	public boolean updateState(long roomprivateMessageId) {
		return roomPrivateMessageDaoImpl.updateState(roomprivateMessageId);
	}

	@Override
	public boolean updatesState(String roomprivateMessageIds) {
		return roomPrivateMessageDaoImpl.updatesState(roomprivateMessageIds);
	}

}
