package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.Video;
import com.liveRoom.dao.VideoDao;
import com.liveRoom.service.VideoService;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.DateStrConvert;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	@Resource
	private VideoDao videoDao;
	
	@Resource
	private VideoDao videoDaoImpl;
	
	@Override
	public int insertSelective(Video video) {
		video.setVideo_Uploadtime(new Date());
		return videoDao.insertSelective(video);
	}

	@Override
	public Map<String, Object> getVideoById(int videoId) {
		Map<String, Object> map = videoDaoImpl.getVideoById(videoId);
		map.put("video_Uploadtime", map.get("video_Uploadtime").toString());
		//map.put("video_playTime", map.get("video_playTime").toString());
		return map;
	}

	@Override
	public boolean addVideo(Map<String, Object> videoMap) {
		videoMap.put("video_Uploadtime", DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd :HH:mm:ss"));
		return videoDaoImpl.addVideo(videoMap);
	}

	@Override
	public boolean deleteVideos(String videoIds) {
		return videoDaoImpl.deleteVideos(videoIds);
	}

	@Override
	public boolean deleteVideo(long videoId) {
		return videoDaoImpl.deleteVideo(videoId);
	}

	@Override
	public boolean updateVideo(Map<String, Object> videoMap) {
		return videoDaoImpl.updateVideo(videoMap);
	}

	@Override
	public Map<String, Object> videoList(int pageNum, int pageSize,
			Map<String, Object> params, Map<String, Object> orderBy) {
		String whereSql = " where v.video_userid = " + params.get("user_id");
		if(params.get("search") != null) {
			whereSql += " and v.video_name like '%" +MessageFormat.format("{0}", params.get("search")) +"%'"
			+ " or v.video_describe like '%" +MessageFormat.format("{0}", params.get("search")) +"%'"
			+ " or v.video_type like '%" +MessageFormat.format("{0}", params.get("search")) +"%'";
		}
		
		Map<String, Object> videoMap = videoDaoImpl.videoList(pageNum, pageSize, whereSql, orderBy);
		return videoMap;
	}

	@Override
	public Map<String, Object> courseCommend(int pageSize) {
		Map<String, Object> videoMap = videoDaoImpl.courseCommend(pageSize);
		if(videoMap != null && videoMap.size() > 0) {
			List<Map<String,Object>> listMap = (ArrayList<Map<String,Object>>)videoMap.get("rows");
			List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
			for (Map<String, Object> map : listMap) {
				map.put("video_time", CommonUtil.getVideoTime(map.get("video_address").toString()));
				int pot = map.get("video_address").toString().lastIndexOf(".");
				map.put("video_images", map.get("video_address").toString().substring(0, pot) + ".jpg");
				map.put("video_uploadtime", map.get("video_uploadtime").toString());
				map.put("video_playTime", map.get("video_playTime").toString());
				rows.add(map);
			}
			videoMap.put("rows", rows);
			videoMap.put("total", rows.size());
		}
		return videoMap;
	}
	
	@Override
	public Map<String, Object> courseAll(int pageNum, int pageSize, int type) {
		Map<String, Object> videoMap = videoDaoImpl.courseAll(pageNum, pageSize,type);
		List<Map<String,Object>> listMap = (ArrayList<Map<String,Object>>)videoMap.get("rows");
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : listMap) {
			
//			map.put("video_time", CommonUtil.getVideoTime(map.get("video_address").toString()));
			int pot = map.get("video_address").toString().lastIndexOf(".");
			map.put("video_images", map.get("video_address").toString().substring(0, pot) + ".jpg");
			//map.put("video_playTime", map.get("video_playTime").toString());
			map.put("video_uploadtime", map.get("video_uploadtime").toString());
			rows.add(map);
		}
		videoMap.put("rows", rows);
		return videoMap;
	}
	
	@Override
	public Map<String, Object> courseAll1(int pageNum, int pageSize, int type) {
		Map<String, Object> videoMap = videoDaoImpl.courseAll1(pageNum, pageSize,type);
		List<Map<String,Object>> listMap = (ArrayList<Map<String,Object>>)videoMap.get("rows");
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : listMap) {
			map.put("video_time", CommonUtil.getVideoTime(map.get("video_address").toString()));
			//map.put("video_playTime", map.get("video_playTime").toString());
			map.put("video_uploadtime", map.get("video_uploadtime").toString());
			rows.add(map);
		}
		videoMap.put("rows", rows);
		return videoMap;
	}
	
	@Override
	public void updateNumber(int video_plays, int video_thumbup, int video_Id) {
		Map<String, Object> videoMap = new HashMap<String, Object>();
		videoMap.put("video_plays", video_plays);
		videoMap.put("video_thumbup", video_thumbup);
		videoMap.put("video_Id", video_Id);
		videoDaoImpl.updateVideo(videoMap);
	}
	
	@Override
	public boolean updatePlays(int videoId) {
		return videoDaoImpl.updatePlays(videoId);
	}
	
	@Override
	public boolean updateThumbup(int videoId) {
		return videoDaoImpl.updateThumbup(videoId);
	}
	
	@Override
	public List<Map<String, Object>> indexCourse() {
		List<Map<String, Object>> listMap = videoDaoImpl.indexCourse();
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : listMap) {
//			map.put("video_time", CommonUtil.getVideoTime(map.get("video_address").toString()));
			map.put("video_uploadtime", map.get("video_uploadtime").toString());
			map.put("video_playTime", map.get("video_playTime").toString());
			rows.add(map);
		}
		return rows;
	}
	
	@Override
	public Map<String, Object> getVideoByUid(int teacherId) {
		Map<String, Object> map = videoDaoImpl.getVideoByUid(teacherId);
		if(map != null && map.size() > 0) {
//			map.put("video_time", CommonUtil.getVideoTime(map.get("video_address").toString()));
			map.put("video_playTime", map.get("video_playTime").toString());
			map.put("video_uploadtime", map.get("video_uploadtime").toString());
			int pot = map.get("video_address").toString().lastIndexOf(".");
			map.put("video_images", map.get("video_address").toString().substring(0, pot) + ".jpg");
		}
		return map;
	}
}
