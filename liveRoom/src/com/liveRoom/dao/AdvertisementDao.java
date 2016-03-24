package com.liveRoom.dao;

import java.util.Map;

public interface AdvertisementDao {
	
	/**
	 * 广告列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的数据
	 * @return
	 */
	public Map<String, Object> getAdvertisementList(int pageNum, int pageSize);
	
	/**
	 * 添加广告
	 * 
	 * @author 周化益
	 * @param mapData 添加的数据
	 * @return
	 */
	public boolean addAdvertise(Map<String, Object> mapData);
	
	/**
	 * 修改广告
	 * 
	 * @author 周化益
	 * @param mapData 修改的数据
	 * @return
	 */
	public boolean updateAdvertise(Map<String, Object> mapData);
	
	/**
	 * 删除单条广告
	 * 
	 * @author 周化益
	 * @param advertiseId 广告ID
	 * @return
	 */
	public boolean deleteAdvertise(long advertiseId);
	
	/**
	 * 删除多条单条广告
	 * 
	 * @author 周化益
	 * @param advertiseIds 广告ID集合
	 * @return
	 */
	public boolean deletesAdvertise(String advertiseIds); 
	
	/**
	 * 广告列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的数据
	 * @param orderBy 排序方式
	 * @param whereSql 查询条件
	 * @return
	 */
	public Map<String, Object> getAdvertisementList(int pageNum, int pageSize, 
			Map<String, Object> orderBy, String whereSql);
	
	/**
	 * 根据ID获取广告内容
	 * 
	 * @author 周化益
	 * @param advertiseId 广告ID
	 * @return
	 */
	public Map<String, Object> findAdvertisement(long advertiseId);
}
