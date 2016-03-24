package com.liveRoom.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.liveRoom.bean.News;
import com.liveRoom.service.NewsService;
import com.liveRoom.util.BeanConvertMap;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.MapAction;
import com.liveRoom.util.StaticPageUtil;
import com.liveRoom.util.UtilController;

@Controller
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("getNewsList.do")
	@ResponseBody
	public Map<String, Object> getNewsList(int pageNum, int pageSize,
			String whereSql, MapAction mapVo, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_id",UtilController.getUserByRequest(request).get("user_id").toString());
		params.put("search", whereSql);
		Map<String, Object> orderBy = new HashMap<String, Object>();
		if(mapVo.getMapVo() == null || mapVo.getMapVo().size() == 0) {
			orderBy.put("news_id", "desc");
		} else {
			orderBy = mapVo.getMapVo();
		}
		return newsService.newsList(pageNum, pageSize, params, orderBy);
	}
	
	
	/**
	 * 新闻数据添加
	 * 
	 * @author 周化益
	 * @param mapVo 新闻数据
	 * @param request
	 * @return
	 */
	@RequestMapping("addNews.do")
	@ResponseBody
	public long addNews(MapAction mapVo,HttpServletRequest request) {
		News news = BeanConvertMap.convertMap(News.class, mapVo.getMapVo());
		Long userId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
		news.setNews_photo(CommonUtil.readFilePath(News.class, userId, news.getNews_photo()));
		int count = newsService.insertSelective(news);
		System.out.println(count);
		if(count > 0) {
			Map<String, Object> listMap = newsService.relatedNews(4, news.getNews_Type());
			StaticPageUtil.newsPage(news, request.getSession().getServletContext().getRealPath(""), listMap);
		}
		return news.getNews_Id();
	}
	
	/**
	 * 新闻数据修改
	 * 
	 * @author 周化益
	 * @param mapVo 新闻数据
	 * @param request
	 * @return
	 */
	@RequestMapping("editNews.do")
	@ResponseBody
	public long editNews(MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> newsMap = mapVo.getMapVo();
		String photoPath = newsMap.remove("photoPath").toString();
		if(newsMap.get("news_photo") != null) {
			Long userId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
			String path = CommonUtil.readFilePath(News.class, userId, newsMap.get("news_photo").toString());
			newsMap.put("news_photo",path);
			photoPath = path;
			CommonUtil.clearFile(photoPath);
		}
		
		if(newsService.updateNews(newsMap)) {
			newsMap.put("news_photo", photoPath);
			Map<String, Object> listMap = newsService.relatedNews(4, Integer.parseInt(
					newsMap.get("news_Type").toString()));
			StaticPageUtil.newsPage(newsMap, request.getSession().getServletContext().getRealPath(""), listMap);
			return Long.parseLong(newsMap.get("news_Id").toString());
		}
		return 0;
	}
	
	/**
	 * 跳转修改页面
	 * 
	 * @author 周化益
	 * @param newsId 新闻ID
	 * @param request
	 * @return
	 */
	@RequestMapping("openNewsEdit.do")
	public String updateNews(int newsId, HttpServletRequest request) {
		request.setAttribute("news",newsService.getNewsById(newsId));
		return "newsEdit";
	}
	
	/**
	 * 删除单个新闻
	 * 
	 * @param newsId 新闻ID集合
	 * @return
	 */
	@RequestMapping("deleteNews.do")
	@ResponseBody
	public boolean deleteNews(long newsId) {
		return newsService.deleteNews(newsId);
	}
	
	/**
	 * 删除多个新闻
	 * 
	 * @param newsIds 新闻集合
	 * @return
	 */
	@RequestMapping("deleteManyNews.do")
	@ResponseBody
	public boolean deleteManyNews(String newsIds) {
		return newsService.deleteNewss(newsIds);
	}
	
	/**
	 * 上传视频
	 * 
	 * @author 周化益
	 * @param fileData 视频文件
	 * @param fileName 视频文件名
	 * @param videoId 视频ID
	 * @return
	 */
	@RequestMapping("uploadNews.do")
	@ResponseBody
	public boolean uploadVideo(MultipartFile fileData, String fileName, int newsId, HttpServletRequest request) {
		try {
			CommonUtil.upLoadPath(News.class,newsId, fileData.getInputStream(), fileName,false);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 上传视频
	 * 
	 * @author 周化益
	 * @param fileData 视频文件
	 * @param fileName 视频文件名
	 * @param videoId 视频ID
	 * @return
	 */
	@RequestMapping("uploadimage.do")
	@ResponseBody
	public boolean uploadimage(MultipartFile fileData, String fileName, int newsId, HttpServletRequest request) {
		try {
			CommonUtil.upLoadPath(News.class,newsId, fileData.getInputStream(), fileName,false);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*==============================接口处============================*/
	
	/**
	 * 查询所有新闻
	 * @author 周化益
	 * @return
	 */
	@RequestMapping("allNews.do")
	@ResponseBody
	public Map<String, Object> allNews(Integer pageNum, Integer pageSize, Integer type) {
		if(pageSize == null) {
			pageNum = 0;
			pageSize = 0;
		}
		System.out.println("第几页："+pageNum);
		System.out.println("每页显示数量："+pageSize);
		System.out.println("新闻的类型："+type);
		Map<String, Object> newsMap = newsService.allNews(pageNum, pageSize,type);
		return newsMap;
	}
	
	/**
	 * 查询相关资讯
	 * 
	 * @author 周化益
	 * @param pageSize 显示的条数
	 * @param type 当前新闻的类型
	 * @return
	 */
	@RequestMapping("relatedNews.do")
	@ResponseBody
	public Map<String, Object> relatedNews(int pageSize,int type) {
			return newsService.relatedNews(pageSize, type);
	}
	
	/**
	 * 获取新闻类型列表
	 * 
	 * @author 周化益
	 * @return
	 */
	@RequestMapping("newsTypeList.do")
	@ResponseBody
	public List<Map<String, Object>> newsTypeList() {
		return newsService.newsTypeList();
	}
}
