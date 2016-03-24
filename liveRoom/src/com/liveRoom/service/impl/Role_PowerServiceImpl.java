package com.liveRoom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.dao.Role_PowerDao;
import com.liveRoom.service.Role_PowerService;

@Service("role_powerService")
public class Role_PowerServiceImpl implements Role_PowerService {
	@Resource
	private Role_PowerDao role_PowerDaoImpl;

	@Override
	public boolean addRolePower(long roleId, List<Integer> powerIds) {
		return role_PowerDaoImpl.addRolePower(roleId, powerIds);
	}

	@Override
	public boolean updateRolePower(long roleId, List<Integer> powerIds) {
		role_PowerDaoImpl.deleteRolePower(roleId);
		return role_PowerDaoImpl.addRolePower(roleId, powerIds);
	}

	@Override
	public List<Long> getPowerByrole(long roleId) {
		return role_PowerDaoImpl.getPowerByrole(roleId);
	}
}
