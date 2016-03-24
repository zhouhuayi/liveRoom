package com.liveRoom.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.Room;
import com.liveRoom.dao.CommonDao;
import com.liveRoom.dao.RoomDao;
import com.liveRoom.dao.RoomTypeDao;
import com.liveRoom.service.RoomService;
import com.liveRoom.util.BeanConvertMap;
import com.liveRoom.util.StaticPageUtil;

@Service("roomService")
public class RoomServiceImpl implements RoomService {
	@Resource
	private RoomDao roomDaoImpl;
	@Resource
	private RoomDao roomDao;
	
	@Resource
	private RoomTypeDao roomtypeDaoImpl;
	
	@Resource
	private CommonDao commonDaoImpl;

	@Override
	public boolean addRoom(Map<String, Object> roomMap) {
		String path = roomMap.remove("path").toString();
		Room room  = BeanConvertMap.convertMap(Room.class, roomMap);
		StaticPageUtil.roomPage(room,path);
		
		return roomDao.insertSelective(room) > 0;
	}

	@Override
	public boolean deleteRooms(String roomIds,int roomstate) {
		return roomDaoImpl.deleteRooms(roomIds,roomstate);
	}

	@Override
	public boolean updateRoom(Map<String, Object> roomMap) {
		return roomDaoImpl.updateRoom(roomMap);
	}

	@Override
	public Map<String, Object> roomList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		return roomDaoImpl.roomList(pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public List<Map<String, Object>> roomObjList() {
		//查询所有房间类型
		return roomtypeDaoImpl.selectType();
	}

	@Override
	public List<Map<String, Object>> roomNameList() {
		return roomDaoImpl.roomObjList();
	}
	
	@Override
	public Map<String, Object> roomOne(String roomOneSql) {
		// TODO Auto-generated method stub
		return roomDaoImpl.selectOne(roomOneSql);
	}

	@Override
	public long VerificationRoomName(String whereSql) {
		// TODO Auto-generated method stub
		return roomDaoImpl.VerificationRoomName(whereSql);
	}

	@Override
	public Map<String, Object> roomPageList(String sql, String countSql, int pageNum,
			int pageSize, String whereSql, Map<String, Object> orderBy) {
		// TODO Auto-generated method stub
		return roomDaoImpl.roomPageList(sql, countSql, pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public boolean deleteRoom(long roomId, int roomstate) {
		// TODO Auto-generated method stub
		return roomDaoImpl.deleteRoom(roomId, roomstate);
	}
	
	@Override
	public Map<String, Object> beforeRoomList(int pageNum, int pageSize) {
		String whereSql = " where room_type = 1";
		Map<String, Object> orderBy = new HashMap<String, Object>();
		
		return roomDaoImpl.roomList(pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public boolean addUserlevel(String sql) {
		// TODO Auto-generated method stub
		return roomDaoImpl.addUserlevel(sql);
	}

	@Override
	public boolean updateRoommember(String sql) {
		// TODO Auto-generated method stub
		return roomDaoImpl.updateRoommember(sql);
	}

}
