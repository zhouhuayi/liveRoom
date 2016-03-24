package com.liveRoom.dao;

import java.util.List;
import java.util.Map;

/**
 * 类名称：通用DAO接口
 * 描述：处理通用的数据交互
 * 创建人：周化益
 * 创建时间：2015-08-05
 */
public interface CommonDao {
	/**添加*/
	public int add(String sql);
	
	/**修改*/
	public int update(String sql);
	
	/**删除*/
	public int delete(String sql);
	
	/**查询单条数据*/
	public Map<String, Object> getMapClass(String sql);
	
	/**查询多条数据*/
	public List<Map<String, Object>> getMapListClass(String sql);
	
	/**查询数量*/
	public long getCount(String sql);
	
	public List<Long> getListObject(String sql);
	
	/**获取单个值*/
	public String getOneValue(String sql);
}
