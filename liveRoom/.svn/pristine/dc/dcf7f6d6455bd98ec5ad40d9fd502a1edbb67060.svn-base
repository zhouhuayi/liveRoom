package com.liveRoom.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.VideoComments;
import com.liveRoom.dao.VideoCommentsDao;

@Repository("videoCommentsDaoImpl")
public class VideoCommentsDaoImpl extends CommonDaoImpl<VideoComments> implements VideoCommentsDao {
    //主键字段名
	protected final String PRIMARYKEYNAME = "videocomments_id";
	//实体类名
	protected final Class<VideoComments> COMMENTCLASS = VideoComments.class;
	
	@Override
	public boolean addComment(Map<String, Object> commentMap) {
		return super.addClass(COMMENTCLASS, commentMap);
	}
	
	@Override
	public Map<String, Object> getAllCommentByBId(int page, int rows,long videoId) {
		String whereSql = " where videocomments_videoid = " + videoId;
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put(PRIMARYKEYNAME, "desc");
		
		String sql = "select v.*,u.user_id,u.user_name,u.user_head from videocomments v left JOIN `user` u ON v.videocomments_userid = u.user_id";
		String countSql = "select count(*) from videocomments v left JOIN `user` u ON v.videocomments_userid = u.user_id";
		return super.getMapListClass(sql,countSql, page, rows, whereSql, orderBy);
	}
	
	public Map<String, Object> getAllCommentByBId(int page, int rows,long videoId, long teacherId,long userId) {
		String whereSql = " where videocomments_videoid = " + videoId + " and (v.videocomments_userid = " + teacherId +
				" or v.videocomments_userid = " + userId + ")";
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put(PRIMARYKEYNAME, "desc");
		
		String sql = "select v.*,u.user_id,u.user_name,u.user_head from videocomments v left JOIN `user` u ON v.videocomments_userid = u.user_id";
		String countSql = "select count(*) from videocomments v left JOIN `user` u ON v.videocomments_userid = u.user_id";
		return super.getMapListClass(sql,countSql, page, rows, whereSql, orderBy);
	}
	
	@Override
	public int insertSelective(VideoComments videoComments) {
		return insertSelective(videoComments);
	}
}
