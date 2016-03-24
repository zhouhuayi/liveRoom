package com.liveRoom.dao;

import java.util.List;
import java.util.Map;

import com.liveRoom.bean.AttentionNewsTable;

public interface AttentionNewsTableDao {
	
	public int insertSelective(AttentionNewsTable attentionNewsTable);
	
	/**
     * 根据ID查询单条关注消息表信息
     * 
     * @author 周化益
     * @param attentionNewsTableId 关注消息表ID
     * @return
     */
    public Map<String, Object> getAttentionNewsTableById(int attentionNewsTableId);
	
	/**
	 * 添加关注消息表
	 * 
	 * @author 周化益
	 * @param attentionNewsTableMap 添加的数据
	 * @return
	 */
	public boolean addAttentionNewsTable(Map<String, Object> attentionNewsTableMap);
	
	/**
	 * 删除多个关注消息表
	 * 
	 * @author 周化益
	 * @param attentionNewsTableIds 关注消息表ID集合
	 * @return
	 */
	public boolean deleteAttentionNewsTables(String attentionNewsTableIds);
	
	/**
	 * 删除单个关注消息表
	 * 
	 * @author 周化益
	 * @param attentionNewsTableId 关注消息表ID
	 * @return
	 */
	public boolean deleteAttentionNewsTable(long attentionNewsTableId);
	
	/**
	 * 修改关注消息表
	 * 
	 * @author 周化益
	 * @param attentionNewsTableMap 修改的数据
	 * @return
	 */
	public boolean updateAttentionNewsTable(Map<String, Object> attentionNewsTableMap);
	
	/**
	 * 获取关注消息表
	 * 
	 * @author 周化益
	 * @param userId 发布者ID
	 * @return
	 */
	public Map<String, Object> getAttentionNews(int pageNum, int pageSize, long userId);
	
	/**
	 * 查询分页关注消息表列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> AttentionNewsTableList(int pageNum, int pageSize, String whereSql, Map<String, Object> orderBy);
	
	/**
	 * 老师动态点赞
	 * 
	 * @author 周化益
	 * @param teacherId 老师ID
	 * @return
	 */
	public boolean updatePraise(int teacherId);
	
	/**
	 * 得到所有博客用户
	 * 
	 * @author 周化益
	 * @param sql查询的语句
	 * @return
	 */
	public List<Map<String, Object>> getAllBlogUser(String sql);
}
