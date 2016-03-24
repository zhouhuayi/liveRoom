package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.dao.RoomMessageDao;
import com.liveRoom.service.RoomMessageService;

@Service("roomMessageService")
public class RoomMessageServiceImpl implements RoomMessageService {

	@Resource
	private RoomMessageDao roomMessageDao;

	@Resource
	private RoomMessageDao roomMessageDaoImpl;

	@Override
	public Map<String, Object> roomMessageList(int pageNum, int pageSize,
			Map<String, Object> params, String whereSql,
			Map<String, Object> orderBy) {
		whereSql=" where rm.room_message_room = r.room_id and rm.room_message_user = u.user_id and rm.room_message_state=1";
		if (params.get("search") != null) {
			whereSql += " and (u.user_name like '%"
					+ MessageFormat.format("{0}", params.get("search")) + "%'"
					+ " or r.room_name like '%"
					+ MessageFormat.format("{0}", params.get("search")) + "%')";
		}
		return roomMessageDaoImpl.roomMessageList(pageNum, pageSize, whereSql,
				orderBy);
	}

	@Override
	public boolean updateState(long roomMessageId) {
		return roomMessageDaoImpl.updateState(roomMessageId);
	}

	@Override
	public boolean updatesState(String roomMessageIds) {
		return roomMessageDaoImpl.updatesState(roomMessageIds);
	}

}
