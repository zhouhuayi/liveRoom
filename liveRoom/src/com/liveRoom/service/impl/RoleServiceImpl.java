package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.News;
import com.liveRoom.bean.Role;
import com.liveRoom.dao.RoleDao;
import com.liveRoom.dao.Role_PowerDao;
import com.liveRoom.service.RoleService;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.FirstCharConvert;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	@Resource
	private RoleDao roleDaoImpl;
	@Resource
	private Role_PowerDao role_PowerDaoImpl;

	@Override
	public boolean addRole(Map<String, Object> roleMap) {
		roleMap.put("role_identity", FirstCharConvert.cn2py(roleMap.get("role_name").toString()));
		return roleDaoImpl.addRole(roleMap);
	}

	@Override
	public boolean deleteRoles(String roleIds) {
		boolean bool = role_PowerDaoImpl.deleteRolePowers(roleIds);
		bool = roleDaoImpl.deleteRoles(roleIds);
		return bool;
	}

	@Override
	public boolean deleteRole(long roleId) {
		boolean bool = role_PowerDaoImpl.deleteRolePower(roleId);
		bool = roleDaoImpl.deleteRole(roleId);
		return bool;
	}

	@Override
	public boolean updateRole(Map<String, Object> roleMap) {
		long roleId = Long.parseLong(roleMap.get("role_id").toString());
		List<Integer> powerIds = CommonUtil.strToList(Integer.class, roleMap.remove("powerIds").toString()) ;
		role_PowerDaoImpl.deleteRolePower(roleId);
		if(powerIds != null && powerIds.size() > 0) {
			role_PowerDaoImpl.addRolePower(roleId, powerIds);
		}
		if(roleMap.get("role_name") != null) {
			roleMap.put("role_identity", FirstCharConvert.cn2py(roleMap.get("role_name").toString()));
		}
		return roleDaoImpl.updateRole(roleMap);
	}

	@Override
	public Map<String, Object> roleList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		if(orderBy == null) {
			orderBy = new HashMap<String, Object>();
			orderBy.put("role_id", "desc");
		}
		
		if(whereSql != null && !whereSql.equals("")) {
			whereSql = " where role_name like '%" +MessageFormat.format("{0}", whereSql) +"%'";
		}
		
		Map<String, Object> rolesMap = roleDaoImpl.roleList(pageNum, pageSize, whereSql, orderBy);
		return rolesMap;
	}

	@Override
	public List<Map<String, Object>> roleObjList() {
		return roleDaoImpl.roleObjList();
	}

	@Override
	public int deleteByPrimaryKey(Integer roleId) {
		return roleDao.deleteByPrimaryKey(roleId);
	}

	@Override
	public int insert(Role record, String powerIds) {
		if(record.getRole_name() != null) {
			record.setRole_identity(FirstCharConvert.cn2py(record.getRole_name().toString()));
		}
		roleDao.insertSelective(record);
		boolean bool = true;
		if(powerIds != null && !powerIds.equals("")) {
			bool = role_PowerDaoImpl.addRolePower(record.getRole_id(),
					CommonUtil.strToList(Integer.class, powerIds));
		}

		if (bool) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Map<String, Object> getRoleById(int roleId) {
		return roleDaoImpl.getRoleById(roleId);
	}
	
	@Override
	public int insertSelective(Role record) {
		return roleDao.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(Integer roleId) {
		return roleDao.selectByPrimaryKey(roleId);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return roleDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return roleDao.updateByPrimaryKey(record);
	}

	@Override
	public Map<String, Object> roleObjOne(long roleId) {
		return roleDaoImpl.getRoleById(roleId);
	}
	
}
