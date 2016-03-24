package com.liveRoom.service;

import java.util.List;

public interface Role_PowerService {
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
	 * 修改角色权限
	 * 
	 * @author 周化益
	 * @param powerIds 权限ID集合
	 * @param roleId 角色ID
	 */
	public boolean updateRolePower(long roleId,List<Integer> powerIds);
	
	/**
	 * 根据角色获取权限
	 * 
	 * @author 周化益
	 * @param roleId 角色ID
	 * @return
	 */
	public List<Long> getPowerByrole(long roleId);
}
