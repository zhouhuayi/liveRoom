package com.liveRoom.service;

import java.util.Map;

import com.liveRoom.bean.CommentTable;

public interface CommentService {
	/**
	 * 获取老师发布博客的所有品论与回复
	 * 
	 * @param blogId
	 * @param page 起始页
	 * @param rows 每页显示的数量
	 * @return
	 */
	public Map<String, Object> getAllCommentByBId(int page, int rows, long blogId);
	
	/**
	 * 添加方法返回带主键评论数据
	 * 
	 * @author 周化益
	 * @param comment 评论实体数据
	 * @return
	 */
	public int insertSelective(CommentTable comment);
	
	/**
	 * 删除评论
	 * 
	 * @author 周化益
	 * @param commentId 评论ID
	 * @return
	 */
	public boolean deleteComment(long commentId);
	
	/**
	 * 查询个人发表的评论
	 * 
	 * @author 周化益
	 * @param userId 当前查看的用户ID
	 * @param blogId 动态ID
	 * @return
	 */
	public Map<String, Object> searchCommentById(int page, int rows,long blogId, long userId,long teacherId);
}