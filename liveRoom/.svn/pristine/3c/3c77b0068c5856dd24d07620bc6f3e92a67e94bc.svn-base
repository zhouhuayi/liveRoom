package com.liveRoom.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.Role_Power;
import com.liveRoom.dao.Role_PowerDao;

@Repository("role_PowerDaoImpl")
public class Role_PowerDaoImpl extends CommonDaoImpl<Role_Power> implements Role_PowerDao {

	@Override
	public boolean addRolePower(long role_Id, List<Integer> powerIds) {
		String sql = "insert into Role_Power(role_Id,power_Id) values(" + role_Id + ',';
		boolean bool = true;
		try {
			for (Object powerId : powerIds) {
				super.addClass(sql+powerId+')');
			}
		} catch (Exception e) {
			e.printStackTrace();
			bool = false;
		}
		
		return bool;
	}

	@Override
	public boolean deleteRolePower(long role_Id) {
		return super.deleteClass(Role_Power.class, "role_Id", role_Id);
	}

	@Override
	public List<Long> getPowerByrole(long role_Id) {
		String whereSql = " where role_Id = " + role_Id;
		return super.getListOne(Role_Power.class, "power_Id", whereSql);
	}
	
	@Override
	public boolean deleteRolePowers(String role_Ids) {
		String whereSql = " where role_Id in(" + role_Ids + ')';
		return super.deleteClass(Role_Power.class, whereSql);
	}
}
