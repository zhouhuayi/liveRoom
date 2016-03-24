package com.liveRoom.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.Board;
import com.liveRoom.dao.BoardDao;

@Repository("boardDaoImpl")
public class BoardDaoImpl extends CommonDaoImpl<Board> implements BoardDao {

	@Override
	public boolean addBard(Map<String, Object> mapData) {
		return super.addClass(Board.class, mapData);
	}

	@Override
	public boolean updateBard(Map<String, Object> mapData) {
		return super.update(Board.class, mapData, "id");
	}

	@Override
	public Map<String, Object> searchBardList(int pageNum, int pageSize,
			Map<String, Object> orderBy, String whereSql) {
		return super.getMapListClass(Board.class, pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public boolean deleteBoard(long boardId) {
		return super.deleteClass(Board.class, "id", boardId);
	}

	@Override
	public boolean deleteBoards(String boardIds) {
		return super.deletetClass(Board.class, "id", boardIds);
	}
	
	@Override
	public Map<String, Object> messageBoard(int pageNum, int pageSize) {
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("times", "desc");
		String sql = "select b.id, b.content, b.userId, (date_format(b.times,'%Y-%c-%d %H:%i:%s')) as times, "
				+ "CASE WHEN u.user_head IS NULL THEN 'image/head.jpg' ELSE u.user_head END AS head "
				+ "from Board b left join user u on b.userId = u.user_id";
		
		String countSql = "select count(*) from Board";
		
		return super.getMapListClass(sql, countSql, pageNum, pageSize, "", orderBy);
	}
}
