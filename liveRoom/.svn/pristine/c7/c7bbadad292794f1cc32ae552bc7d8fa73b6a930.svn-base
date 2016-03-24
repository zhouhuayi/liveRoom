package com.liveRoom.service;

import java.util.Map;

public interface VideoCommentsService {
	/**
	 * 添加视频评论
	 * 
	 * @author 周化益
	 * @param commentUser 发表评论的人
	 * @param videoId 视频ID
	 * @param content 评论的内容
	 * @return
	 */
	public Map<String, Object> addVideoComment(int commentUser, int videoId, String content);
	
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
	public Map<String, Object> getVideoUserComment(int page, int rows, long videoId, 
			long teacherId, long userId);
}
