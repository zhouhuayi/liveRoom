package com.liveRoom.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.Advertisement;
import com.liveRoom.dao.AdvertisementDao;

@Repository("advertisementDaoImpl")
public class AdvertisementDaoImpl extends CommonDaoImpl<Advertisement> 
	implements AdvertisementDao {
	
	@Override
	public Map<String, Object> getAdvertisementList(int pageNum, int pageSize) {
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("id", "desc");
		return super.getMapListClass(Advertisement.class, pageNum, pageSize, "", orderBy);
	}
	
	@Override
	public boolean addAdvertise(Map<String, Object> mapData) {
		return super.addClass(Advertisement.class, mapData);
	}
	
	@Override
	public boolean deleteAdvertise(long advertiseId) {
		return super.deleteClass(Advertisement.class, "id", advertiseId);
	}
	
	@Override
	public boolean deletesAdvertise(String advertiseIds) {
		return super.deletetClass(Advertisement.class, "id", advertiseIds);
	}
	
	@Override
	public boolean updateAdvertise(Map<String, Object> mapData) {
		return super.update(Advertisement.class, mapData, "id");
	}
	
	@Override
	public Map<String, Object> getAdvertisementList(int pageNum, int pageSize,
			Map<String, Object> orderBy, String whereSql) {
		return super.getMapListClass(Advertisement.class, pageNum, pageSize, whereSql, orderBy);
	}
	
	@Override
	public Map<String, Object> findAdvertisement(long advertiseId) {
		return super.findById(Advertisement.class, "id", advertiseId);
	}
}
