package com.liveRoom.dao;

import java.util.List;
import java.util.Map;

import com.liveRoom.bean.Power;

public interface PowerDao {
	/**
	 * 添加权限
	 * @author 李琼雅
	 * @param record
	 * @return
	 */
	int insertSelective(Power record);
	/**
	 * 查询所有权限
	 * 
	 * @author 周化益
	 * @return
	 */
	public List<Map<String, Object>> powerList();
	
	/**
	 * 查询角色对应的权限
	 * @author 周化益
	 * @param powerIds 权限ID
	 * @return
	 */
	public List<Map<String, Object>> powerList(String powerIds);
	
	/**
	 * 添加权限
	 * 
	 * @author 周化益
	 * @param powerMap 添加的权限数据
	 * @return
	 */
	public boolean addPower(Map<String,Object> powerMap);
	/**
     * 根据ID查询单条权限信息
     * 
     * @author 李琼雅
     * @param powerId 权限ID
     * @return
     */
    public Map<String, Object> getPowerById(int powerId);
	
	/**
	 * 修改权限
	 * 
	 * @author 周化益
	 * @param powerMap 修改的权限数据
	 * @return
	 */
	public boolean updatePower(Map<String, Object> powerMap);
	
	/**
	 * 删除单个权限
	 * 
	 * @author 周化益
	 * @param powerId 权限ID
	 * @return
	 */
	public boolean deletePower(long powerId);
	
	/**
	 * 删除多个权限
	 * 
	 * @author 周化益
	 * @param powerIds 权限ID集合
	 * @return
	 */
	public boolean deletePowers(String powerIds);
	/**
	 * 查询所有权限信息
	 * 
	 * @author 李琼雅
	 * @param page 第几页
	 * @param rows 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> powersList(int pageNum, int pageSize,String whereSql, Map<String, Object> orderBy);
}
