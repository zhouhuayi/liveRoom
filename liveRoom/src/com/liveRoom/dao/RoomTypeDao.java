package com.liveRoom.dao;

import java.util.List;
import java.util.Map;

public interface RoomTypeDao {
	
	/**
	 * 查询房间所有类型信息
	 * @author hj
	 * @return
	 */
	public List<Map<String,Object>> selectType();
	
	/**
	 * 添加房间类型
	 * @author hj
	 * @param toomType 房间类型的信息
	 * @return
	 */
	public Map<String,Object> insertType(Map<String,Object> roomType);
	
	/**
	 * 修改房间类型信息
	 * @param toomType 更新的信息
	 * @author hj
	 * @return
	 */
	public Map<String,Object> updataType(Map<String,Object> toomType);
	
	/**
	 * 删除房间属性
	 * @param typeId 属性ID
	 * @author hj
	 * @return
	 */
	public boolean deleteType(int typeId);
}
