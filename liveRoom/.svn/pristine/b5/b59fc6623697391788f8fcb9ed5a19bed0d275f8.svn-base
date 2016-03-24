package com.liveRoom.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.AttentionNewsTable;
import com.liveRoom.dao.AttentionNewsTableDao;
import com.liveRoom.service.AttentionNewsTableService;
import com.liveRoom.util.BeanConvertMap;
import com.liveRoom.util.DateStrConvert;

@Service("attentionNewsTableService")
public class AttentionNewsTableServiceImpl implements AttentionNewsTableService {
	@Resource
	private AttentionNewsTableDao attentionNewsTableDaoImpl;
	@Resource
	private AttentionNewsTableDao attentionNewsTableDao;
	
	@Override
	public int addAttentionNewsTable(Map<String, Object> attentionNewsTableMap) {
		attentionNewsTableMap.put("times",
				DateStrConvert.strToDate(DateStrConvert.dateToStr(new Date(), 
						"yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(attentionNewsTableMap);
		AttentionNewsTable attentionNewsTable = BeanConvertMap.convertMap(AttentionNewsTable.class, attentionNewsTableMap);
		if(attentionNewsTableDao.insertSelective(attentionNewsTable) > 0) {
			return attentionNewsTable.getId();
		} else {
			return 0;
		}
	}
	
	@Override
	public Map<String, Object> AttentionNewsTableList(int pageNum,
			int pageSize, String whereSql, Map<String, Object> orderBy) {
		if(orderBy == null || orderBy.size() == 0) {
			orderBy = new HashMap<String, Object>();
			orderBy.put("id", "desc");
		}
		if(whereSql == null) {
			whereSql = "";
		} else {
			whereSql = " where u.user_realName like '%" + whereSql + "%'";
		}
		return attentionNewsTableDaoImpl.AttentionNewsTableList(pageNum, pageSize, whereSql, orderBy);
	}
	
	@Override
	public boolean deleteAttentionNewsTable(long attentionNewsTableId) {
		return attentionNewsTableDaoImpl.deleteAttentionNewsTable(attentionNewsTableId);
	}
	
	@Override
	public boolean deleteAttentionNewsTables(String attentionNewsTableIds) {
		return attentionNewsTableDaoImpl.deleteAttentionNewsTables(attentionNewsTableIds);
	}
	
	@Override
	public Map<String, Object> getAttentionNewsTableById(int attentionNewsTableId) {
		return attentionNewsTableDaoImpl.getAttentionNewsTableById(attentionNewsTableId);
	}
	
	@Override
	public boolean updateAttentionNewsTable(Map<String, Object> attentionNewsTableMap) {
		return attentionNewsTableDaoImpl.updateAttentionNewsTable(attentionNewsTableMap);
	}
	
	@Override
	public Map<String, Object> getAttentionNews(int pageNum, int pageSize, long userId)  {
		Map<String, Object> attentionmap = attentionNewsTableDaoImpl.getAttentionNews(pageNum,pageSize,userId);
		List<Map<String,Object>> listMap = (ArrayList<Map<String,Object>>)attentionmap.get("rows");
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : listMap) {
			map.put("times", map.get("times").toString());
			rows.add(map);
		}
		attentionmap.put("rows", rows);
		return attentionmap;
	}
	
	@Override
	public Map<String, Object> getBlogInfo(int blogId) {
		Map<String, Object> map = attentionNewsTableDaoImpl.getAttentionNewsTableById(blogId);
		System.out.println(map);
		map.put("times", map.get("times").toString());
		return map;
	}
	
	@Override
	public boolean updatePraise(int blogId) {
		return attentionNewsTableDaoImpl.updatePraise(blogId);
	}
	
	@Override
	public List<Map<String, Object>> getAllBlogUser() {
		String sql = "select user_id,user_RealName from user where user_teacher = 1 and user_state = 0";
		return attentionNewsTableDaoImpl.getAllBlogUser(sql);
	}
}
