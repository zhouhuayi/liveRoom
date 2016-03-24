package com.liveRoom.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.News;
import com.liveRoom.dao.NewsDao;

@Repository("newsDaoImpl")
public class NewsDaoImpl extends CommonDaoImpl<News> implements NewsDao{
	//主键字段名
	protected final String PRIMARYKEYNAME = "news_Id";
	//实体类名
	protected final Class<News> NEWSCLASS = News.class;
	
	@Override
	public int insertSelective(News News) {
		return insertSelective(News);
	}

	@Override
	public Map<String, Object> getNewsById(int newsId) {
		return super.findById(NEWSCLASS, PRIMARYKEYNAME, newsId);
	}

	@Override
	public boolean addNews(Map<String, Object> newsMap) {
		return super.addClass(NEWSCLASS, newsMap);
	}

	@Override
	public boolean deleteNewss(String newsIds) {
		return super.deletetClass(NEWSCLASS, PRIMARYKEYNAME, newsIds);
	}

	@Override
	public boolean deleteNews(long newsId) {
		return super.deleteClass(NEWSCLASS, PRIMARYKEYNAME, newsId);
	}

	@Override
	public boolean updateNews(Map<String, Object> newsMap) {
		return super.update(NEWSCLASS, newsMap, PRIMARYKEYNAME);
	}

	@Override
	public Map<String, Object> newsList(int pageNum, int pageSize,
			String whereSql, Map<String, Object> orderBy) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select n.news_id,n.news_title,n.news_describe,n.news_address,n.news_uploadtime,")
		.append("ny.name,n.news_thumbup,u.user_realName,n.news_content,n.news_photo ")
		.append(" from news n LEFT JOIN `user` u ON n.news_userid = u.user_id left join newstype ny on ny.id=n.news_type");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from news ")
		.append("n LEFT JOIN `user` u ON n.news_userid = u.user_id");
		
		return super.getMapListClass(sql.toString(),countSql.toString(), pageNum, pageSize, whereSql, orderBy);
	}
	
	@Override
	public Map<String, Object> allNews(int pageNum, int pageSize,int type) {
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put(PRIMARYKEYNAME, "desc");
		String whereSql = "";
		if(type > 0) {
			whereSql = " where n.news_type = " + type;
		}
		String sql = "select n.news_Id,n.news_Title,n.news_Address,n.news_Uploadtime,n.news_Type,n.news_photo,n.news_Describe,nt.name from news n left join newstype nt on n.news_type = nt.id";
		String countSql = "select count(*) from news n";
		return super.getMapListClass(sql,countSql, pageNum, pageSize, whereSql, orderBy);
	}

	@Override
	public Map<String, Object> relatedNews(int pageSize, int type) {
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put(PRIMARYKEYNAME, "desc");
		String whereSql = "";
		if(type > 1) {
			whereSql = " where news_type = " + type;
		}
		return super.getMapListClass(NEWSCLASS, 1, pageSize, whereSql, orderBy);
	}
	
	@Override
	public List<Map<String, Object>> newsTypeList() {
		String sql = "select * from newsType";
		return super.getListAll(sql);
	}
}
