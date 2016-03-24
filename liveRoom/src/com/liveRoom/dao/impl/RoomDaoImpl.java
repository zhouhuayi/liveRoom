package com.liveRoom.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.Room;
import com.liveRoom.dao.RoomDao;

@Repository("roomDaoImpl")
public class RoomDaoImpl extends CommonDaoImpl<Room> implements RoomDao{
	//主键字段名
	protected final String PRIMARYKEYNAME = "room_id";
	//实体类名
	protected final Class<Room> ROOMCLASS = Room.class;
	
	@Override
	public boolean addRoom(Map<String, Object> roomMap) {
		return super.addClass(ROOMCLASS, roomMap);
	}

	@Override
	public boolean deleteRooms(String roomIds,int roomstate) {
		return super.update(ROOMCLASS, "room_state", roomstate, PRIMARYKEYNAME, roomIds);
	}
	/**
	 * 修改房间的状态
	 */
	@Override
	public boolean deleteRoom(long roomId,int roomstate) {
		return super.update(ROOMCLASS,"room_state", roomstate, PRIMARYKEYNAME, roomId);
	}

	@Override
	public boolean updateRoom(Map<String, Object> roomMap) {
		return super.update(ROOMCLASS, roomMap, PRIMARYKEYNAME);
	}

	@Override
	public List<Map<String, Object>> roomObjList() {
		return super.getSelectList(ROOMCLASS, PRIMARYKEYNAME, "room_name");
	}

	@Override
	public Map<String, Object> roomList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		return super.getMapListClass(ROOMCLASS, pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public Map<String, Object> selectOne(String whereSql) {
		//return super.getMapListClass(sql, page, rows, whereSql, orderBy);
		return super.findBySql(whereSql);
	}
	
	public List<Map<String,Object>> selectAll(){
		return super.getListAll(ROOMCLASS);
	}

	@Override
	public long VerificationRoomName(String wheresql) {
		// TODO Auto-generated method stub
		return super.getCount(ROOMCLASS, wheresql);
	}

	@Override
	public Map<String, Object> roomPageList(String sql, String countSql, int pageNum,
			int pageSize, String whereSql, Map<String, Object> orderBy) {
		// TODO Auto-generated method stub
		return super.getMapListClass(sql, countSql, pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public int insertSelective(Room video) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addUserlevel(String sql) {
		// TODO Auto-generated method stub
		return super.addClass(sql);
	}

	@Override
	public boolean updateRoommember(String sql) {
		// TODO Auto-generated method stub
		return super.addClass(sql);
	}

	

}
