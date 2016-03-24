package com.liveRoom.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.Power;
import com.liveRoom.dao.PowerDao;

@Repository("powerDaoImpl")
public class PowerDaoImpl extends CommonDaoImpl<Power> implements PowerDao {
	//主键字段名
	protected final String PRIMARYKEYNAME = "power_id";
	//实体类名
	protected final Class<Power> POWERCLASS = Power.class;
	
	
	@Override
	public List<Map<String, Object>> powerList() {
		return super.getListAll(POWERCLASS);
	}

	@Override
	public List<Map<String, Object>> powerList(String powerIds) {
		String whereSql = " where power_id in(" + powerIds + ')';
		return super.getListByWhere(POWERCLASS, whereSql);
	}

	@Override
	public boolean addPower(Map<String, Object> powerMap) {
		return super.addClass(POWERCLASS, powerMap);
	}

	@Override
	public boolean updatePower(Map<String, Object> powerMap) {
		return super.update(POWERCLASS, powerMap, PRIMARYKEYNAME);
	}

	@Override
	public boolean deletePower(long powerId) {
		return super.deleteClass(POWERCLASS, PRIMARYKEYNAME, powerId);
	}

	@Override
	public boolean deletePowers(String powerIds) {
		return super.deletetClass(POWERCLASS, PRIMARYKEYNAME, powerIds);
	}

	@Override
	public Map<String, Object> powersList(int pageNum, int pageSize,String whereSql, Map<String, Object> orderBy) {
		StringBuffer sql = new StringBuffer();
		sql.append("select p.power_id,p.power_name,p.power_url,cp.power_name pname")
		.append(" from power p LEFT JOIN power cp ON p.power_parentId=cp.power_id");
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from power p LEFT JOIN power cp ON p.power_parentId=cp.power_id");
		return super.getMapListClass(sql.toString(),countSql.toString(),pageNum,pageSize,whereSql,orderBy);
	}

	@Override
	public int insertSelective(Power record) {
		return insertSelective(record);
	}

	@Override
	public Map<String, Object> getPowerById(int powerId) {
		return super.findById(POWERCLASS, PRIMARYKEYNAME, powerId);
	}

}
