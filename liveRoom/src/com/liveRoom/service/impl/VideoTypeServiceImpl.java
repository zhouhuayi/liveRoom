package com.liveRoom.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.dao.VideoTypeDao;
import com.liveRoom.service.VideoTypeService;

@Service("videoTypeService")
public class VideoTypeServiceImpl implements VideoTypeService {
	@Resource
	private VideoTypeDao videoTypeDaoImpl;
	
	@Override
	public List<Map<String, Object>> searchTypeList() {
		return videoTypeDaoImpl.searchTypeList();
	}
}
