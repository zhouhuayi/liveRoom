package com.liveRoom.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.CommentTable;
import com.liveRoom.dao.CommentDao;
import com.liveRoom.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentDao commentDaoImpl;
	@Resource
	private CommentDao commentDao;
	
	@Override
	public Map<String, Object> getAllCommentByBId(int page, int rows,long blogId) {
		Map<String, Object> map = commentDaoImpl.getAllCommentByBId(page, rows, blogId);
		List<Map<String, Object>> listMap = (ArrayList<Map<String,Object>>)map.get("rows");
		List<Map<String, Object>> rowsList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map2 : listMap) {
			map2.put("commenttime", map2.get("commenttime").toString());
			rowsList.add(map2);
		}
		map.put("rows", rowsList);
		return map;
	}
	
	@Override
	public int insertSelective(CommentTable comment) {
		return commentDao.insertSelective(comment);
	}
	
	@Override
	public boolean deleteComment(long commentId) {
		return commentDaoImpl.deleteComment(commentId);
	}
	
	@Override
	public Map<String, Object> searchCommentById(int page, int rows,long blogId, long userId, long teacherId) {
		Map<String, Object> map = commentDaoImpl.searchCommentById(page, rows, blogId, userId, teacherId);
		List<Map<String, Object>> listMap = (ArrayList<Map<String,Object>>)map.get("rows");
		List<Map<String, Object>> rowsList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map2 : listMap) {
			map2.put("commenttime", map2.get("commenttime").toString());
			rowsList.add(map2);
		}
		map.put("rows", rowsList);
		return map;
	}
}
