package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.RoomRadio;
import com.liveRoom.dao.RoomRadioDao;
import com.liveRoom.service.RoomRadioService;

@Service("roomRadioService")
public class RoomRadioServiceImpl implements RoomRadioService {
	@Resource
	private RoomRadioDao roomRadioDaoImpl;
	
	@Override
	public int insertSelective(RoomRadio roomRadio) {
		return insertSelective(roomRadio);
	}

	@Override
	public Map<String, Object> getRoomRadioById(int roomRadioId) {
		return roomRadioDaoImpl.getRoomRadioById(roomRadioId);
	}

	@Override
	public boolean addRoomRadio(Map<String, Object> roomRadioMap) {
		return roomRadioDaoImpl.addRoomRadio(roomRadioMap);
	}

	@Override
	public boolean deleteRoomRadios(String roomRadioIds) {
		return roomRadioDaoImpl.deleteRoomRadios(roomRadioIds);
	}

	@Override
	public boolean deleteRoomRadio(long roomRadioId) {
		return roomRadioDaoImpl.deleteRoomRadio(roomRadioId);
	}

	@Override
	public boolean updateRoomRadio(Map<String, Object> roomRadioMap) {
		return roomRadioDaoImpl.updateRoomRadio(roomRadioMap);
	}

	@Override
	public Map<String, Object> roomRadioList(int pageNum, int pageSize,
			Map<String, Object> params, Map<String, Object> orderBy) {
		String whereSql = " where rd.publisher = " + params.get("user_id");
		if(params.get("search") != null) {
			whereSql += " and rd.content like '%" +MessageFormat.format("{0}", params.get("search")) +"%'"
			+ " or r.room_name like '%" +MessageFormat.format("{0}", params.get("search")) +"%'"
			+ " or u.user_realName like '%" +MessageFormat.format("{0}", params.get("search")) +"%'";
		}
		return roomRadioDaoImpl.roomRadioList(pageNum, pageSize, whereSql, orderBy);
	}

}
