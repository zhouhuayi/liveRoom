package com.liveRoom.service;

import java.util.List;
import java.util.Map;

public interface VideoTypeService {
	/**
	 * 查询类型列表
	 * 
	 * @author 周化益
	 * @return
	 */
	public List<Map<String, Object>> searchTypeList();
}
