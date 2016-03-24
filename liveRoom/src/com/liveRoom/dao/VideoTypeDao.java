package com.liveRoom.dao;

import java.util.List;
import java.util.Map;

public interface VideoTypeDao {
	/**
	 * 查询类型列表
	 * 
	 * @author 周化益
	 * @return
	 */
	public List<Map<String, Object>> searchTypeList();
}
