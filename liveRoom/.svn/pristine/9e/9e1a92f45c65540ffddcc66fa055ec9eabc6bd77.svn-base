package com.liveRoom.service;

import java.util.Map;

public interface FeedBackService {
	/**
	 * 添加反馈信息
	 * 
	 * @author 周化益
	 * @param mapData 反馈的信息
	 * @return
	 */
	public Map<String, Object> addFeedBack(Map<String, Object> mapData);
	
	/**
	 *  查询反馈列表数据
	 * 
	 * @author 周化益
	 * @param pageNum 	第几页的数据
	 * @param pageSize 	每页显示的数据
	 * @param orderBy 	排序 
	 * @param whereSql	查询的条件
	 * @return
	 */
	public Map<String, Object> searchList(int pageNum, int pageSize, 
			Map<String, Object> orderBy, String whereSql);
	
	/**
	 * 删除单个反馈
	 * 
	 * @author 周化益
	 * @param feedBackId 反馈ID
	 * @return
	 */
	public boolean deleteFeedBack(long feedBackId);
	
	/**
	 * 删除多个反馈
	 * 
	 * @author 周化益
	 * @param feedBackIds 反馈ID集合
	 * @return
	 */
	public boolean deleteFeedBacks(String feedBackIds);
}
