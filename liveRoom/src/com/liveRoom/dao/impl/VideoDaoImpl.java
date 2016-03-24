package com.liveRoom.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.Video;
import com.liveRoom.dao.VideoDao;

@Repository("videoDaoImpl")
public class VideoDaoImpl extends CommonDaoImpl<Video> implements VideoDao {
	// 主键字段名
	protected final String PRIMARYKEYNAME = "video_Id";
	// 实体类名
	protected final Class<Video> VIDEOCLASS = Video.class;

	@Override
	public int insertSelective(Video video) {
		return insertSelective(video);
	}

	@Override
	public Map<String, Object> getVideoById(int videoId) {
		return super.findById(VIDEOCLASS, PRIMARYKEYNAME, videoId);
	}

	@Override
	public boolean addVideo(Map<String, Object> videoMap) {
		return super.addClass(VIDEOCLASS, videoMap);
	}

	@Override
	public boolean deleteVideos(String videoIds) {
		return super.deletetClass(VIDEOCLASS, PRIMARYKEYNAME, videoIds);
	}

	@Override
	public boolean deleteVideo(long videoId) {
		return super.deleteClass(VIDEOCLASS, PRIMARYKEYNAME, videoId);
	}

	@Override
	public boolean updateVideo(Map<String, Object> videoMap) {
		return super.update(VIDEOCLASS, videoMap, PRIMARYKEYNAME);
	}

	@Override
	public Map<String, Object> videoList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select v.video_id,v.video_name,v.video_describe,v.video_address,v.video_uploadtime,")
		.append("v.video_type,v.video_plays,v.video_thumbup,u.user_realName ")
		.append(" from video v LEFT JOIN `user` u ON v.video_userid = u.user_id");
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from video ")
		.append("v LEFT JOIN `user` u ON v.video_userid = u.user_id");
		return super.getMapListClass(sql.toString(),countSql.toString() , pageNum, pageSize, whereSql,orderBy);
	}
	
	@Override
	public Map<String, Object> courseCommend(int pageSize) {
		StringBuffer sql = new StringBuffer();
		sql.append("select v.video_id,v.video_name,v.video_describe,v.video_address,v.video_uploadtime,")
		.append("v.video_type,v.video_plays,v.video_thumbup,u.user_realName,u.user_id,v.video_playTime ")
		.append(" from `user` u right JOIN video v ON v.video_userid = u.user_id");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from video ")
		.append("v LEFT JOIN `user` u ON v.video_userid = u.user_id");
		
		String whereSql = " where u.user_state = 0";
		
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("v.video_plays", "desc");
		orderBy.put("v.video_thumbup", "desc");
		return super.getMapListClass(sql.toString(),countSql.toString() , 1, pageSize, whereSql,orderBy);
	}
	
	@Override
	public List<Map<String, Object>> indexCourse() {
		//String sql = "select * from (select * from video v ORDER BY v.video_id DESC) vi  GROUP BY vi.video_type LIMIT 0,3";
		String sql = "select * from video order by video_id desc limit 0,3";
//		Map<String, Object> orderBy = new HashMap<String, Object>();
//		orderBy.put("v.video_plays", "desc");
//		orderBy.put("v.video_thumbup", "desc");
		return super.getListAll(sql);
	}
	
	@Override
	public Map<String, Object> courseAll(int pageNum, int pageSize, int type) {
		StringBuffer sql = new StringBuffer();
		sql.append("select v.video_id,v.video_name,v.video_describe,v.video_address,v.video_uploadtime,")
		.append("v.video_playTime,v.video_plays,v.video_thumbup,u.user_realName,u.user_id ")
		.append(" from `user` u right JOIN video v ON v.video_userid = u.user_id");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from video ")
		.append("v LEFT JOIN `user` u ON v.video_userid = u.user_id ");
		
		String whereSql = " where u.user_state = 0 and v.video_type = 0";
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("v.video_id", "desc"); 
		System.out.println(sql);
		return super.getMapListClass(sql.toString(),countSql.toString() , pageNum, pageSize, whereSql,orderBy);
	}
	
	@Override
	public Map<String, Object> courseAll1(int pageNum, int pageSize, int type) {
		StringBuffer sql = new StringBuffer();
		sql.append("select v.video_id,v.video_name,v.video_images,v.video_describe,v.video_address,v.video_uploadtime,")
		.append("v.video_playTime,v.video_plays,v.video_thumbup,u.user_realName,u.user_id ")
		.append(" from `user` u right JOIN video v ON v.video_userid = u.user_id");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from video ")
		.append("v LEFT JOIN `user` u ON v.video_userid = u.user_id");
		
		String whereSql = " where u.user_state = 0 and v.video_type="+type;
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("v.video_id", "desc");
		return super.getMapListClass(sql.toString(),countSql.toString() , pageNum, pageSize, whereSql,orderBy);
	}
	
	@Override
	public boolean updatePlays(int videoId) {
		String sql = "update video set video_plays = video_plays + 1 where video_id = " + videoId;
		return super.addClass(sql);
	}
	
	@Override
	public boolean updateThumbup(int videoId) {
		String sql = "update video set video_thumbup = video_thumbup + 1 where video_id = " + videoId;
		return super.addClass(sql);
	}
	
	@Override
	public Map<String, Object> getVideoByUid(int teacherId) {
		String sql = "select * from video where and " + "video_userid = " + teacherId + " limit 0,1";
		return findBySql(sql);
	}
}
