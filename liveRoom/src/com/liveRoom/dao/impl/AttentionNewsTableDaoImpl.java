package com.liveRoom.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.AttentionNewsTable;
import com.liveRoom.dao.AttentionNewsTableDao;

@Repository("attentionNewsTableDaoImpl")
public class AttentionNewsTableDaoImpl extends CommonDaoImpl<AttentionNewsTable> implements AttentionNewsTableDao {
	//主键字段名
	protected final String PRIMARYKEYNAME = "id";
	//实体类名
	protected final Class<AttentionNewsTable> ATCLASS = AttentionNewsTable.class;
	
	@Override
	public int insertSelective(AttentionNewsTable attentionNewsTable) {
		return 0;
	}
	
	@Override
	public boolean addAttentionNewsTable(Map<String, Object> attentionNewsTableMap) {
		return super.addClass(ATCLASS, attentionNewsTableMap);
	}
	
	@Override
	public Map<String, Object> AttentionNewsTableList(int pageNum,
			int pageSize, String whereSql, Map<String, Object> orderBy) {
		String sql = "select a.id,a.user_id,a.content,a.praise,a.title,"
				+ "(date_format(a.times,'%Y-%c-%d %H:%i:%s')) as times,"
				+ "u.user_realName,u.user_head from AttentionNewsTable a "
				+ " left join User u on a.user_id = u.user_id ";
		
		String countSql = "select count(*) from AttentionNewsTable a "
				+ " left join User u on a.user_id = u.user_id";
		return super.getMapListClass(sql,countSql, pageNum, pageSize, whereSql, orderBy);
	}
	
	@Override
	public boolean deleteAttentionNewsTable(long attentionNewsTableId) {
		return super.deleteClass(ATCLASS, PRIMARYKEYNAME, attentionNewsTableId);
	}
	
	@Override
	public boolean deleteAttentionNewsTables(String attentionNewsTableIds) {
		return super.deletetClass(ATCLASS, PRIMARYKEYNAME, attentionNewsTableIds);
	}
	
	@Override
	public Map<String, Object> getAttentionNewsTableById(int attentionNewsTableId) {
		String sql = "SELECT a.*,u.user_realName,(select count(*) FROM commenttable c WHERE c.blogID = a.id) "
				+ "comment FROM attentionnewstable a left join user u on u.user_id = a.user_id"
				+ " where id = " + attentionNewsTableId;
		return super.findBySql(sql);
	}
	
	@Override
	public boolean updateAttentionNewsTable(Map<String, Object> attentionNewsTableMap) {
		return super.update(ATCLASS, attentionNewsTableMap, PRIMARYKEYNAME);
	}
	
	@Override
	public Map<String, Object> getAttentionNews(int pageNum, int pageSize, long userId) {
		String sql = "SELECT a.*,u.user_realName,"
				+ "(select count(*) FROM commenttable c WHERE c.blogID = a.id) comment "
				+ "FROM attentionnewstable a left join user u on u.user_id = a.user_id ";
		String countSql = "SELECT count(*) FROM attentionnewstable a";
		String whereSql = " where a.user_id = " + userId;
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put(PRIMARYKEYNAME, "desc");
		return super.getMapListClass(sql,countSql, pageNum, pageSize, whereSql, orderBy);
	}
	
	@Override
	public boolean updatePraise(int blogId) {
		String sql = "update attentionnewstable set praise = praise + 1 where id = " + blogId;
		return super.addClass(sql);
	}
	
	@Override
	public List<Map<String, Object>> getAllBlogUser(String sql) {
		return super.getListAll(sql);
	}
}
