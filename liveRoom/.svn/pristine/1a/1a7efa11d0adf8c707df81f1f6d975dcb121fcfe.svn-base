package com.liveRoom.dao;

import java.util.List;
import java.util.Map;

import com.liveRoom.bean.Role;

public interface RoleDao {
	
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
     * 根据ID查询单条角色信息
     * 
     * @author 周化益
     * @param roleId 角色ID
     * @return
     */
    public Map<String, Object> getRoleById(long roleId);
	
	/**
	 * 添加角色
	 * 
	 * @author 周化益
	 * @param roleMap 添加的数据
	 * @return
	 */
	public boolean addRole(Map<String, Object> roleMap);
	
	/**
	 * 删除多个角色
	 * 
	 * @author 周化益
	 * @param roleIds 角色ID集合
	 * @return
	 */
	public boolean deleteRoles(String roleIds);
	
	/**
	 * 删除单个角色
	 * 
	 * @author 周化益
	 * @param roleId 角色ID
	 * @return
	 */
	public boolean deleteRole(long roleId);
	
	/**
	 * 修改角色
	 * 
	 * @author 周化益
	 * @param roleMap 修改的数据
	 * @return
	 */
	public boolean updateRole(Map<String, Object> roleMap);
	
	/**
	 * 查询分页角色列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> roleList(int pageNum, int pageSize, String whereSql, Map<String, Object> orderBy);
	
	/**
	 * 查询所有角色ID于角色名称
	 * 
	 * @author 周化益
	 * @return
	 */
	public List<Map<String, Object>> roleObjList();
}
