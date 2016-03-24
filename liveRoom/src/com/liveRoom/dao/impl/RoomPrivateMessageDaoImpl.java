package com.liveRoom.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.RoomPrivateMessage;
import com.liveRoom.dao.RoomPrivateMessageDao;

@Repository("roomPrivateMessageDaoImpl")
public class RoomPrivateMessageDaoImpl extends
		CommonDaoImpl<RoomPrivateMessage> implements RoomPrivateMessageDao {

	// 主键字段名
	protected final String PRIMARYKEYNAME = "room_private_message_Id";
	// 实体类名
	protected final Class<RoomPrivateMessage> ROLECLASS = RoomPrivateMessage.class;

	@Override
	public Map<String, Object> roomPrivateMessageList(int pageNum,
			int pageSize, String whereSql, Map<String, Object> orderBy) {
		StringBuffer sql = new StringBuffer();
		sql.append("select rm.room_private_message_id,u.user_name,us.user_name uname,rm.room_private_message_date,rm.room_private_message_content,r.room_name")
		.append(" from roomprivatemessage rm")
		.append(" LEFT JOIN `user` u ON room_private_message_userSend = u.user_id")
		.append(" LEFT JOIN room r ON rm.room_private_message_room = r.room_id")
		.append(" LEFT JOIN `user` us ON rm.room_private_message_userReceive = us.user_id");
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from roomprivatemessage rm LEFT JOIN `user` u ON room_private_message_userSend = u.user_id")
		.append(" LEFT JOIN room r ON rm.room_private_message_room = r.room_id")
		.append(" LEFT JOIN `user` us ON rm.room_private_message_userReceive = us.user_id");
		return super.getMapListClass(sql.toString(), countSql.toString(),
				pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public boolean updateState(long roomprivateMessageId) {
		return super.update(ROLECLASS, "room_private_message_State",0, PRIMARYKEYNAME, roomprivateMessageId);
	}

	@Override
	public boolean updatesState(String roomprivateMessageIds) {
		return super.update(ROLECLASS, "room_private_message_State",0, PRIMARYKEYNAME, roomprivateMessageIds);
	}
}
