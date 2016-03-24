package com.liveRoom.dao;

import java.util.List;
import java.util.Map;

import com.liveRoom.bean.Video;

public interface VideoDao {
	/**
	 * 添加视频数据
	 * 
	 * @author 周化益
	 * @param video
	 * @return
	 */
	int insertSelective(Video video);
	
	/**
     * 根据ID查询单条视频信息
     * 
     * @author 周化益
     * @param videoId 视频ID
     * @return
     */
    public Map<String, Object> getVideoById(int videoId);
    
    /**
     * 首页课程
     * 
     * @author 周化益
     * @return
     */
    public List<Map<String, Object>> indexCourse();
	
	/**
	 * 添加视频
	 * 
	 * @author 周化益
	 * @param videoMap 添加的数据
	 * @return
	 */
	public boolean addVideo(Map<String, Object> videoMap);
	
	/**
	 * 删除多个视频
	 * 
	 * @author 周化益
	 * @param videoIds 视频ID集合
	 * @return
	 */
	public boolean deleteVideos(String videoIds);
	
	/**
	 * 删除单个视频
	 * 
	 * @author 周化益
	 * @param videoId 视频ID
	 * @return
	 */
	public boolean deleteVideo(long videoId);
	
	/**
	 * 修改视频
	 * 
	 * @author 周化益
	 * @param videoMap 修改的数据
	 * @return
	 */
	public boolean updateVideo(Map<String, Object> videoMap);
	
	/**
	 * 查询分页视频列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> videoList(int pageNum, int pageSize, String whereSql, Map<String, Object> orderBy);
	
	/**
	 * 查找热门推荐视频
	 * 
	 * @author 周化益
	 * @param pageSize 显示的条数
	 * @return
	 */
	public Map<String, Object> courseCommend(int pageSize);
	
	/**
	 * 查找所有课程
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 显示的条数
	 * @param type 播放类型
	 * @return
	 */
	public Map<String, Object> courseAll(int pageNum, int pageSize, int type);
	
	/**
	 * 查找所有课程
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 显示的条数
	 * @param type 播放类型
	 * @return
	 */
	public Map<String, Object> courseAll1(int pageNum, int pageSize, int type);
	
	/**
	 * 播放量修改
	 * 
	 * @author 周化益
	 * @param videoId 视频ID
	 * @return
	 */
	public boolean updatePlays(int videoId);
	
	/**
	 * 点赞量修改
	 * 
	 * @author 周化益
	 * @param videoId 视频ID
	 * @return
	 */
	public boolean updateThumbup(int videoId);
	
	
	/**
	 * 获取老师第一条直播视频
	 * 
	 * @author 周化益
	 * @param teacherId 老师ID
	 * @return
	 */
	public Map<String, Object> getVideoByUid(int teacherId);
}
