package com.liveRoom.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.RoomRadio;
import com.liveRoom.dao.RoomRadioDao;

@Repository("roomRadioDaoImpl")
public class RoomRadioDaoImpl extends CommonDaoImpl<RoomRadio> implements RoomRadioDao {
	//主键字段名
	protected final String PRIMARYKEYNAME = "id";
	//实体类名
	protected final Class<RoomRadio> ROOMRADIOCLASS = RoomRadio.class;
	
	@Override
	public int insertSelective(RoomRadio roomRadio) {
		return insertSelective(roomRadio);
	}

	@Override
	public Map<String, Object> getRoomRadioById(int roomRadioId) {
		return super.findById(ROOMRADIOCLASS, PRIMARYKEYNAME, roomRadioId);
	}

	@Override
	public boolean addRoomRadio(Map<String, Object> roomRadioMap) {
		return super.addClass(ROOMRADIOCLASS, roomRadioMap);
	}

	@Override
	public boolean deleteRoomRadios(String roomRadioIds) {
		return super.deletetClass(ROOMRADIOCLASS, PRIMARYKEYNAME, roomRadioIds);
	}

	@Override
	public boolean deleteRoomRadio(long roomRadioId) {
		return super.deleteClass(ROOMRADIOCLASS, PRIMARYKEYNAME, roomRadioId);
	}

	@Override
	public boolean updateRoomRadio(Map<String, Object> roomRadioMap) {
		return super.update(ROOMRADIOCLASS, roomRadioMap, PRIMARYKEYNAME);
	}

	@Override
	public Map<String, Object> roomRadioList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		StringBuffer sql = new StringBuffer();
		sql.append("select rd.id,rd.content,rd.createtime,u.user_realName,r.room_name,rd.type ")
		.append(" from roomRadio rd LEFT JOIN `user` u ON rd.publisher = u.user_id")
		.append(" left join room r on r.room_id = rd.roomid");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*)  from roomRadio rd LEFT JOIN `user` u ON rd.publisher = u.user_id")
		.append(" left join room r on r.room_id = rd.roomid");
		return super.getMapListClass(sql.toString(),countSql.toString(), pageNum, pageSize, whereSql, orderBy);
	}

}
