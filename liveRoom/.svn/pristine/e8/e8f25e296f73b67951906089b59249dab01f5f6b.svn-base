package com.liveRoom.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.RoomMessage;
import com.liveRoom.dao.RoomMessageDao;

@Repository("roomMessageDaoImpl")
public class RoomMessageDaoImpl extends CommonDaoImpl<RoomMessage> implements RoomMessageDao {
		//主键字段名
		protected final String PRIMARYKEYNAME = "room_message_Id";
		//实体类名
		protected final Class<RoomMessage> ROLECLASS = RoomMessage.class;
		

	@Override
	public Map<String, Object> roomMessageList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		StringBuffer sql = new StringBuffer();
		sql.append("select rm.room_message_id,u.user_name,r.room_name,rm.room_message_date,rm.room_message_content")
		.append(" from roommessage rm,room r,`user` u ");
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from roommessage rm,room r,`user` u ");
		return super.getMapListClass(sql.toString(),countSql.toString() , pageNum, pageSize, whereSql,orderBy);
	}


	@Override
	public boolean updateState(long roomMessageId) {
		return super.update(ROLECLASS, "room_message_State",0, PRIMARYKEYNAME, roomMessageId);
	}


	@Override
	public boolean updatesState(String roomMessageIds) {
		return super.update(ROLECLASS, "room_message_State",0, PRIMARYKEYNAME, roomMessageIds);
	}

}
