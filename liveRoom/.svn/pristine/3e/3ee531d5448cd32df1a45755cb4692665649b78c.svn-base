package com.liveRoom.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.VideoType;
import com.liveRoom.dao.VideoTypeDao;

@Repository("videoTypeDaoImpl")
public class VideoTypeDaoImpl extends CommonDaoImpl<VideoType> implements VideoTypeDao {
	@Override
	public List<Map<String, Object>> searchTypeList() {
		return super.getSelectList(VideoType.class, "id", "name");
	}
}
