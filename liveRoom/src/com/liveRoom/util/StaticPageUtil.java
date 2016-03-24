package com.liveRoom.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liveRoom.bean.News;
import com.liveRoom.bean.Room;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class StaticPageUtil {
	private static Configuration config = null;

	/**
	 * 如果目录不存在，则自动创建
	 * 
	 * @param path
	 * @return boolean 是否成功
	 */
	private static boolean creatDirs(String path) {
		File aFile = new File(path);
		if (!aFile.exists()) {
			return aFile.mkdirs();
		} else {
			return true;
		}
	}

	/**
	 * 模板生成静态html的方法
	 * 
	 * @param templateFileName
	 *            (模板文件名)
	 * @param templateFilePath
	 *            (指定模板目录)
	 * @param contextMap
	 *            (用于处理模板的属性Object映射)
	 * @param htmlFilePath
	 *            (指定生成静态html的目录)
	 * @param htmlFileName
	 *            (生成的静态文件名)
	 */
	public static void geneHtmlFile(String templateFileName,
			String templateFilePath, Map<String, Object> contextMap,
			String htmlFilePath, String htmlFileName) {

		try {
			Template t = getFreeMarkerCFG(templateFilePath).getTemplate(templateFileName);
			// 如果根路径存在,则递归创建子目录
			creatDirs(htmlFilePath);
			
			File afile = new File(htmlFilePath + "/" + htmlFileName);
			OutputStreamWriter outWrite = new OutputStreamWriter(new FileOutputStream(afile));
			Writer out = new BufferedWriter(outWrite);
			t.process(contextMap, out);
			out.flush();
			out.close();
		} catch (TemplateException e) {
			System.out.print(e.getMessage());
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/**
	 * 
	 * 获取freemarker的配置，freemarker本身支持classpath,目录或从ServletContext获取.
	 * 
	 * @param templateFilePath
	 *            获取模板路径
	 * @return Configuration 返回freemaker的配置属性
	 * @throws Exception
	 */
	private static Configuration getFreeMarkerCFG(String templateFilePath)
			throws Exception {
		if (null == config) {

			config = new Configuration();
			try {
				config.setDirectoryForTemplateLoading(new File(templateFilePath));
			} catch (Exception ex) {
				throw ex;
			}
		}
		return config;
	}

	/**
	 * 房间静态
	 * 
	 * @param room
	 * @return
	 */
	public static boolean roomPage(Room room,String path) {
		boolean bool = true;
		try {
			String newsPath = path + "\\" + "room";
			Map<String, Object> roomMap = new HashMap<String, Object>();
			roomMap.put("roomfwed", room);
			geneHtmlFile(FileLoad.getPropertyByKey("staticRoomPage", null), newsPath, roomMap,
					newsPath, room.getRoom_id()+".html");
		} catch (Exception e) {
			bool = false;
			e.printStackTrace();
		}
		return bool;
	}
	
	/**
	 * 新闻静态页面
	 * 
	 * @author 周化益
	 * @param news 新闻类 
	 * @return
	 */
	public static boolean newsPage(News news,String path,Map<String, Object> newList) {
		boolean bool = true;
		try {
			String fromPath = path + "\\" + "news";
			Map<String, Object> roomMap = new HashMap<String, Object>();
			List<Map<String, Object>> listMap = (ArrayList<Map<String, Object>>)newList.get("rows");
			int i = 1;
			for (Map<String, Object> map : listMap) {
				map.put("display", "block");
				roomMap.put("news"+i, map);
				map.put("news_Address", "/liveRoom/"+map.get("news_Address"));
				map.put("news_photo", "../"+map.get("news_photo"));
				if(map.get("news_Content") != null && !map.get("news_Content").equals("")) {
					map.put("news_Content", map.get("news_Content").toString().replaceAll("upload/image","../upload/image"));
				}
				i++;
			}
			for (int j = i; j <= 4; j++) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("news_Address", "#");
				map.put("news_Title", "");
				map.put("display", "none");
				roomMap.put("news"+j, map);
			}
			Map<String, Object> newsMap = BeanConvertMap.convertBean(news);
			newsMap.put("news_photo", "../"+newsMap.get("news_photo"));
			newsMap.put("news_Address", "/liveRoom/"+newsMap.get("news_Address"));
			newsMap.put("news_Uploadtime", DateStrConvert.dateToStr((Date)newsMap.get("news_Uploadtime"), "yyyy-MM-dd HH:mm:ss"));
			newsMap.put("news_Content", newsMap.get("news_Content").toString().replaceAll("upload/image","../upload/image"));
			roomMap.put("news", newsMap);
			geneHtmlFile("news.html", fromPath, roomMap,fromPath, news.getNews_Id()+".html");
		} catch (Exception e) {
			bool = false;
			e.printStackTrace();
		}
		return bool;
	}
	
	/**
	 * 新闻静态页面
	 * 
	 * @author 周化益
	 * @param news 新闻类 
	 * @return
	 */
	public static boolean newsPage(Map<String,Object> news,String path,Map<String, Object> newList) {
		boolean bool = true;
		try {
			String fromPath = path + "\\" + "news";
			Map<String, Object> roomMap = new HashMap<String, Object>();
			List<Map<String, Object>> listMap = (ArrayList<Map<String, Object>>)newList.get("rows");
			int i = 1;
			for (Map<String, Object> map : listMap) {
				map.put("display", "block");
				map.put("news_Address", "/liveRoom/"+map.get("news_Address"));
				map.put("news_photo", "../"+map.get("news_photo"));
				map.put("news_Content", map.get("news_Content").toString().replaceAll("upload/image","../upload/image"));
				roomMap.put("news"+i, map);
				i++;
			}
			for (int j = i; j <= 4; j++) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("news_Address", "#");
				map.put("news_Title", "");
				map.put("display", "none");
				roomMap.put("news"+j, map);
			}
			news.put("news_photo", "../"+news.get("news_photo"));
			news.put("news_Address", "/liveRoom/"+news.get("news_Address"));
			news.put("news_Content", news.get("news_Content").toString().replaceAll("upload/image","../upload/image"));
			roomMap.put("news", news);
			geneHtmlFile("news.html", fromPath, roomMap,fromPath, news.get("news_Id")+".html");
		} catch (Exception e) {
			bool = false;
			e.printStackTrace();
		}
		return bool;
	}
	
	public static void main(String[] args) {
		Room room = new Room();
		room.setRoom_id(2);
		roomPage(room,"D:\\Tomcat\\tomcat64\\apache-tomcat-7.0.54\\webapps\\liveRoom");
	}
}
