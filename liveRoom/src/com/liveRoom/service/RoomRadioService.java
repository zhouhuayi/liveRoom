package com.liveRoom.service;

import java.util.Map;

import com.liveRoom.bean.RoomRadio;

public interface RoomRadioService {
	/**
	 * 添加新闻数据
	 * 
	 * @author 周化益
	 * @param roomRadio
	 * @return
	 */
	int insertSelective(RoomRadio roomRadio);
	
	/**
     * 根据ID查询单条新闻信息
     * 
     * @author 周化益
     * @param roomRadioId 新闻ID
     * @return
     */
    public Map<String, Object> getRoomRadioById(int roomRadioId);
	
	/**
	 * 添加新闻
	 * 
	 * @author 周化益
	 * @param roomRadioMap 添加的数据
	 * @return
	 */
	public boolean addRoomRadio(Map<String, Object> roomRadioMap);
	
	/**
	 * 删除多个新闻
	 * 
	 * @author 周化益
	 * @param roomRadioIds 新闻ID集合
	 * @return
	 */
	public boolean deleteRoomRadios(String roomRadioIds);
	
	/**
	 * 删除单个新闻
	 * 
	 * @author 周化益
	 * @param roomRadioId 新闻ID
	 * @return
	 */
	public boolean deleteRoomRadio(long roomRadioId);
	
	/**
	 * 修改新闻
	 * 
	 * @author 周化益
	 * @param roomRadioMap 修改的数据
	 * @return
	 */
	public boolean updateRoomRadio(Map<String, Object> roomRadioMap);
	
	/**
	 * 查询分页新闻列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的条数
	 * @param params 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> roomRadioList(int pageNum, int pageSize, Map<String,Object> params, Map<String, Object> orderBy);
}
