package com.liveRoom.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.User;
import com.liveRoom.bean.Video;
import com.liveRoom.bean.VideoComments;
import com.liveRoom.dao.VideoCommentsDao;
import com.liveRoom.service.VideoCommentsService;
import com.liveRoom.util.BeanConvertMap;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.DateStrConvert;

@Service("videoCommentsService")
public class VideoCommentsServiceImpl implements VideoCommentsService {
	@Resource
	private VideoCommentsDao videoCommentsDaoImpl;
	@Resource
	private VideoCommentsDao videoCommentsDao;
	
	@Override
	public Map<String, Object> addVideoComment(int commentUser, int videoId, String content) {
		VideoComments videoComment = new VideoComments();
		videoComment.setVideocomments_content(content);
		videoComment.setVideocomments_date(DateStrConvert.strToDate(
				DateStrConvert.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
		videoComment.setVideocomments_userid(commentUser);
		videoComment.setVideocomments_videoid(videoId);
		videoCommentsDao.insertSelective(videoComment);
		
		Map<String, Object> commentMap = new HashMap<String, Object>();
		commentMap = BeanConvertMap.convertBean(videoComment);
		commentMap.put("videocomments_date", commentMap.get("videocomments_date").toString());
		return commentMap;
	}
	
	@Override
	public Map<String, Object> getAllCommentByBId(int page, int rows,long videoId) {
		Map<String, Object> map =videoCommentsDaoImpl.getAllCommentByBId(page, rows, videoId);
		List<Map<String, Object>> listMap = (ArrayList<Map<String,Object>>)map.get("rows");
		List<Map<String, Object>> rowsList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map2 : listMap) {
			map2.put("videocomments_date", map2.get("videocomments_date").toString());
			rowsList.add(map2);
		}
		map.put("rows", rowsList);
		return map;
	}
	
	@Override
	public Map<String, Object> getVideoUserComment(int page, int rows,
			long videoId, long teacherId, long userId) {
		Map<String, Object> map =videoCommentsDaoImpl.getAllCommentByBId(page, rows, videoId,teacherId,userId);
		List<Map<String, Object>> listMap = (ArrayList<Map<String,Object>>)map.get("rows");
		List<Map<String, Object>> rowsList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map2 : listMap) {
			map2.put("videocomments_date", map2.get("videocomments_date").toString());
			rowsList.add(map2);
		}
		map.put("rows", rowsList);
		return map;
	}
}
