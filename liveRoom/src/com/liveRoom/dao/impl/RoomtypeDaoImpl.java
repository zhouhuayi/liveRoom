package com.liveRoom.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.RoomType;
import com.liveRoom.dao.RoomTypeDao;

@Repository("roomtypeDaoImpl")
public class RoomtypeDaoImpl extends CommonDaoImpl<RoomType> implements RoomTypeDao {

	//主键字段名
	protected final String PRIMARYKEYNAME = "roomtype_id";
	//实体类名
	protected final Class<RoomType> ROOMTYPRCLASS = RoomType.class;
	
	@Override
	public List<Map<String, Object>> selectType() {
		// TODO Auto-generated method stub
		System.out.println("开始查询房间类型");
		return super.getListAll(ROOMTYPRCLASS);
	}

	@Override
	public Map<String, Object> insertType(Map<String, Object> roomType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updataType(Map<String, Object> toomType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteType(int typeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
