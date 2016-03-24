package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.News;
import com.liveRoom.dao.NewsDao;
import com.liveRoom.service.NewsService;
import com.liveRoom.util.DateStrConvert;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
	@Resource
	private NewsDao newsDaoImpl;
	@Resource
	private NewsDao newsDao;
	
	@Override
	public int insertSelective(News news) {
		return newsDao.insertSelective(news);
	}

	@Override
	public Map<String, Object> getNewsById(int newsId) {
		Map<String, Object> newsMap = newsDaoImpl.getNewsById(newsId);
		return newsMap;
	}

	@Override
	public boolean addNews(Map<String, Object> newsMap) {
		return newsDaoImpl.addNews(newsMap);
	}

	@Override
	public boolean deleteNewss(String newsIds) {
		return newsDaoImpl.deleteNewss(newsIds);
	}

	@Override
	public boolean deleteNews(long newsId) {
		return newsDaoImpl.deleteNews(newsId);
	}

	@Override
	public boolean updateNews(Map<String, Object> newsMap) {
		return newsDaoImpl.updateNews(newsMap);
	}

	@Override
	public Map<String, Object> newsList(int pageNum, int pageSize,
			Map<String, Object> params, Map<String, Object> orderBy) {
		String whereSql = " where n.news_userid = " + params.get("user_id");
		if(params.get("search") != null) {
			whereSql += " and n.news_title like '%" +MessageFormat.format("{0}", params.get("search")) +"%'"
			+ " or n.news_describe like '%" +MessageFormat.format("{0}", params.get("search")) +"%'"
			+ " or n.news_type like '%" +MessageFormat.format("{0}", params.get("search")) +"%'"
			+ " or n.news_content like '%" +MessageFormat.format("{0}", params.get("search")) +"%'";
		}
		
		Map<String, Object> newsMap = newsDaoImpl.newsList(pageNum, pageSize, whereSql, orderBy);
		return newsMap;
	}
	
	@Override
	public Map<String, Object> allNews(int pageNum, int pageSize, int type) {
		Map<String, Object> newsMap = newsDaoImpl.allNews(pageNum, pageSize, type);
		
		if(newsMap == null || newsMap.size() ==0) {
			return newsMap;
		}
		
		List<Map<String,Object>> listMap = (ArrayList<Map<String,Object>>)newsMap.get("rows");
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : listMap) {
			if(map.get("news_Uploadtime") == null) {
				map.put("news_Uploadtime", DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
			} else {
				map.put("news_Uploadtime", map.get("news_Uploadtime").toString());
			}
			if(map.get("news_Address") == null || map.get("news_Address").equals("")) {
				map.put("news_Address", "news/"+ map.get("news_Id")+".html");
			}
			if(map.get("news_Describe") == null){
				map.put("news_Describe", "");
			}
			rows.add(map);
		}
		newsMap.put("rows", rows);
		return newsMap;
	}
	
	@Override
	public Map<String, Object> relatedNews(int pageSize, int type) {
		Map<String, Object> newsMap = newsDaoImpl.relatedNews(pageSize, type);
		List<Map<String,Object>> listMap = (ArrayList<Map<String,Object>>)newsMap.get("rows");
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : listMap) {
			if(map.get("news_Address") == null || map.get("news_Address").equals("")) {
				map.put("news_Address", "news/"+ map.get("news_Id")+".html");
			}
			if(map.get("news_Describe") == null){
				map.put("news_Describe", "");
			}
			rows.add(map);
		}
		newsMap.put("rows", rows);
		return newsMap;
	}
	
	@Override
	public List<Map<String, Object>> newsTypeList() {
		return newsDaoImpl.newsTypeList();
	}
}
