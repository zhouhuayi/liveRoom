package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.Power;
import com.liveRoom.dao.PowerDao;
import com.liveRoom.dao.Role_PowerDao;
import com.liveRoom.service.PowerService;

@Service("powerService")
public class PowerServiceImpl implements PowerService {
	@Resource
	private PowerDao powerDaoImpl;
	@Resource
	private PowerDao powerDao;
	@Resource
	private Role_PowerDao role_PowerDaoImpl;
	
	@Override
	public List<Map<String, Object>> powerList() {
		return powerDaoImpl.powerList();
	}

	@Override
	public List<Map<String, Object>> powerList(int roleId) {
		List<Long> powerList = role_PowerDaoImpl.getPowerByrole(roleId);
		if(powerList != null && powerList.size() > 0) {
			String powerIds = powerList.toString();
			return powerDaoImpl.powerList(powerIds.substring(1,powerIds.length()-1));
		} 
		return null;
	}

	@Override
	public boolean addPower(Map<String, Object> powerMap) {
		return powerDaoImpl.addPower(powerMap);
	}

	@Override
	public boolean updatePower(Map<String, Object> powerMap) {
		if (powerMap.get("power_parentId").equals("")) {
			powerMap.put("power_parentId", null);
		}
		return powerDaoImpl.updatePower(powerMap);
	}

	@Override
	public boolean deletePower(long powerId) {
		return powerDaoImpl.deletePower(powerId);
	}

	@Override
	public boolean deletePowers(String powerIds) {
		return powerDaoImpl.deletePowers(powerIds);
	}

	@Override
	public Map<String, Object> powersList(int pageNum, int pageSize,
			Map<String, Object> params, String whereSql,
			Map<String, Object> orderBy) {
		if(params.get("search") != null) {
			whereSql = " where p.power_name like '%" +MessageFormat.format("{0}", params.get("search")) +"%'";
		}
		return powerDaoImpl.powersList(pageNum, pageSize,whereSql, orderBy);
	}

	@Override
	public int insertSelective(Power record) {
		return powerDao.insertSelective(record);
	}

	@Override
	public Map<String, Object> getPowerById(int powerId) {
		return powerDaoImpl.getPowerById(powerId);
	}

}
