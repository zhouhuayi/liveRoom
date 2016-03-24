package com.liveRoom.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.Role;
import com.liveRoom.dao.RoleDao;

@Repository("roleDaoImpl")
public class RoleDaoImpl extends CommonDaoImpl<Role> implements RoleDao{
	//主键字段名
	protected final String PRIMARYKEYNAME = "role_id";
	//实体类名
	protected final Class<Role> ROLECLASS = Role.class;
	
	@Override
	public boolean addRole(Map<String, Object> roleMap) {
		return super.addClass(ROLECLASS, roleMap);
	}

	@Override
	public boolean deleteRoles(String roleIds) {
		return super.deletetClass(ROLECLASS, PRIMARYKEYNAME, roleIds);
	}

	@Override
	public boolean deleteRole(long roleId) {
		return super.deleteClass(ROLECLASS, PRIMARYKEYNAME, roleId);
	}

	@Override
	public boolean updateRole(Map<String, Object> roleMap) {
		return super.update(ROLECLASS, roleMap, PRIMARYKEYNAME);
	}

	@Override
	public List<Map<String, Object>> roleObjList() {
		return super.getListAll(ROLECLASS);
	}

	@Override
	public Map<String, Object> roleList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		return super.getMapListClass(ROLECLASS, pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public int deleteByPrimaryKey(Integer roleId) {
		return deleteByPrimaryKey(roleId);
	}

	@Override
	public int insert(Role record) {
		return 0;
	}

	@Override
	public int insertSelective(Role record) {
		return insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(Integer roleId) {
		return selectByPrimaryKey(roleId);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return updateByPrimaryKey(record);
	}

	@Override
	public Map<String, Object> getRoleById(long roleId) {
		return super.findById(ROLECLASS, PRIMARYKEYNAME, roleId);
	}

}
