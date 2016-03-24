package com.liveRoom.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.FeedBack;
import com.liveRoom.dao.FeedBackDao;

@Repository("feedBackDaoImpl")
public class FeedBackDaoImpl extends CommonDaoImpl<FeedBack> implements FeedBackDao {

	@Override
	public boolean addFeedBack(Map<String, Object> mapData) {
		return super.addClass(FeedBack.class, mapData);
	}

	@Override
	public Map<String, Object> searchList(int pageNum, int pageSize,
			Map<String, Object> orderBy, String whereSql) {
		String sql = "select f.id,f.content,f.phone,f.times,u.user_realName "
				+ " from FeedBack f left join User u on f.userId = u.user_id";
		String countSql = "select count(*) from feedBack";
		return super.getMapListClass(sql,countSql, pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public boolean deleteFeedBack(long feedBackId) {
		return super.deleteClass(FeedBack.class, "id", feedBackId);
	}
	
	@Override
	public boolean deleteFeedBacks(String feedBackIds) {
		return super.deletetClass(FeedBack.class, "id", feedBackIds);
	}
}
