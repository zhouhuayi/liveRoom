package com.liveRoom.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.dao.AdvertisementDao;
import com.liveRoom.service.AdvertisementService;

@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {
	@Resource
	private AdvertisementDao advertisementDaoImpl;
	
	@Override
	public Map<String, Object> getAdvertisementList(int pageNum, int pageSize) {
		return advertisementDaoImpl.getAdvertisementList(pageNum, pageSize);
	}

	@Override
	public boolean addAdvertise(Map<String, Object> mapData) {
		return advertisementDaoImpl.addAdvertise(mapData);
	}

	@Override
	public boolean updateAdvertise(Map<String, Object> mapData) {
		return advertisementDaoImpl.updateAdvertise(mapData);
	}

	@Override
	public boolean deleteAdvertise(long advertiseId) {
		return advertisementDaoImpl.deleteAdvertise(advertiseId);
	}

	@Override
	public boolean deletesAdvertise(String advertiseIds) {
		return advertisementDaoImpl.deletesAdvertise(advertiseIds);
	}
	
	@Override
	public Map<String, Object> getAdvertisementList(int pageNum, int pageSize,
			Map<String, Object> orderBy, String whereSql) {
		if(orderBy == null || orderBy.size() == 0) {
			orderBy = new HashMap<String, Object>();
			orderBy.put("id", "desc");
		}
		
		if(whereSql == null) {
			whereSql = "";
		}
		
		return advertisementDaoImpl.getAdvertisementList(pageNum, pageSize, orderBy, whereSql);
	}
	
	@Override
	public Map<String, Object> findAdvertisement(long advertiseId) {
		return advertisementDaoImpl.findAdvertisement(advertiseId);
	}
}
