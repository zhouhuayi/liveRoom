package com.liveRoom.dao;

import java.util.List;

public interface Role_PowerDao {
	/**
	 * 添加角色权限
	 * 
	 * @author 周化益
	 * @param roleId 角色ID
	 * @param powerIds 权限ID集合
	 * @return
	 */
	public boolean addRolePower(long roleId, List<Integer> powerIds);
	
	/**
	 * 删除角色权限
	 * 
	 * @author 周化益
	 * @param roleId 角色ID
	 */
	public boolean deleteRolePower(long roleId);
	
	/**
	 * 根据角色获取权限
	 * 
	 * @author 周化益
	 * @param roleId 角色ID
	 * @return
	 */
	public List<Long> getPowerByrole(long roleId);
	
	/**
	 * 删除多个角色的权限
	 * 
	 * @author 周化益
	 * @param roleIds 角色IDS
	 * @return
	 */
	public boolean deleteRolePowers(String roleIds);
}
