package com.liveRoom.service;

import java.util.List;
import java.util.Map;

import com.liveRoom.bean.News;

public interface NewsService {
	/**
	 * 添加新闻数据
	 * 
	 * @author 周化益
	 * @param news
	 * @return
	 */
	int insertSelective(News news);
	
	/**
     * 根据ID查询单条新闻信息
     * 
     * @author 周化益
     * @param newsId 新闻ID
     * @return
     */
    public Map<String, Object> getNewsById(int newsId);
	
	/**
	 * 添加新闻
	 * 
	 * @author 周化益
	 * @param newsMap 添加的数据
	 * @return
	 */
	public boolean addNews(Map<String, Object> newsMap);
	
	/**
	 * 删除多个新闻
	 * 
	 * @author 周化益
	 * @param newsIds 新闻ID集合
	 * @return
	 */
	public boolean deleteNewss(String newsIds);
	
	/**
	 * 删除单个新闻
	 * 
	 * @author 周化益
	 * @param newsId 新闻ID
	 * @return
	 */
	public boolean deleteNews(long newsId);
	
	/**
	 * 修改新闻
	 * 
	 * @author 周化益
	 * @param newsMap 修改的数据
	 * @return
	 */
	public boolean updateNews(Map<String, Object> newsMap);
	
	/**
	 * 查询分页新闻列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> newsList(int pageNum, int pageSize, Map<String, Object> params, Map<String, Object> orderBy);
	
	/**
	 * 查询所有新闻
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页的数量
	 * @return
	 */
	public Map<String, Object> allNews(int pageNum, int pageSize, int type);
	
	/**
	 * 相关咨询
	 */
	public Map<String, Object> relatedNews(int pageSize, int type);
	
	/**
	 * 获取新闻类型列表
	 * 
	 * @author 周化益
	 * @return
	 */
	public List<Map<String, Object>> newsTypeList();
}
