package com.liveRoom.dao;

import java.util.Map;

import com.liveRoom.bean.VideoComments;

public interface VideoCommentsDao {
	/**
	 * 添加视频评论
	 * 
	 * @author 周化益
	 * @param commentMap 评论的数据
	 * @return
	 */
	public boolean addComment(Map<String, Object> commentMap);
	
	/**
	 * 获取老师发布视频的所有品论与回复
	 * 
	 * @param videoId 视频ID
	 * @param page 起始页
	 * @param rows 每页显示的数量
	 * @return
	 */
	public Map<String, Object> getAllCommentByBId(int page, int rows, long videoId);
	
	/**
	 * 获取老师发布视频的所有品论与回复
	 * 
	 * @param videoId 视频ID
	 * @param page 起始页
	 * @param rows 每页显示的数量
	 * @return
	 */
	public Map<String, Object> getAllCommentByBId(int page, int rows, long videoId,
			long teacherId, long userId);
	
	/**
	 * 添加评论
	 * 
	 * @author 周化益
	 * @param videoComments 评论的内容
	 * @return
	 */
	public int insertSelective(VideoComments videoComments);
}
