package com.liveRoom.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.CommentTable;
import com.liveRoom.dao.CommentDao;

@Repository("commentDaoImpl")
public class CommentDaoImpl extends CommonDaoImpl<CommentTable> implements CommentDao {
	//主键字段名
	protected final String PRIMARYKEYNAME = "id";
	//实体类名
	protected final Class<CommentTable> COMMENTCLASS = CommentTable.class;
	
	@Override
	public Map<String, Object> getAllCommentByBId(int page, int rows,long blogId) {
		String sql = "SELECT c.*,u.user_id,u.user_name,u.user_head,u.user_teacher "
				+ "from commenttable c LEFT JOIN attentionnewstable a ON a.id = c.blogID "
				+ "LEFT JOIN `user` u ON c.userId=u.user_id";
		
		String countSql = "SELECT count(*) from commenttable c";
		String whereSql = " where c.blogId = " + blogId;
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("id", "desc");
		
		return super.getMapListClass(sql,countSql, page, rows, whereSql, orderBy);
	}
	
	@Override
	public int insertSelective(CommentTable comment) {
		return insertSelective(comment);
	}
	
	@Override
	public boolean deleteComment(Long commentId) {
		return super.deleteClass(COMMENTCLASS, PRIMARYKEYNAME, commentId);
	}
	
	@Override
	public Map<String, Object> searchCommentById(int page, int rows, long blogId,long userId, long teacherId) {
		String sql = "SELECT c.*,u.user_id,u.user_name,u.user_head,u.user_teacher "
				+ "from commenttable c LEFT JOIN attentionnewstable a ON a.id = c.blogID "
				+ "LEFT JOIN `user` u ON c.userId=u.user_id";
		
		String countSql = "SELECT count(*) from commenttable c";
		String whereSql = " where (c.userId = " + userId + " or c.userId = " + teacherId + ") and c.blogId = " + blogId;
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("id", "desc");
		
		return super.getMapListClass(sql,countSql, page, rows, whereSql, orderBy);
	}
}
