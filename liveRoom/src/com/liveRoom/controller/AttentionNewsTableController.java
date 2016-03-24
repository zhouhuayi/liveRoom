package com.liveRoom.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.liveRoom.bean.AttentionNewsTable;
import com.liveRoom.service.AttentionNewsTableService;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.DateStrConvert;
import com.liveRoom.util.MapAction;

@Controller
public class AttentionNewsTableController {
	@Autowired
	private AttentionNewsTableService attentionNewsTableService;
	
	/**
	 * 查询老师的动态信息
	 * 
	 * @author 周化益
	 * @param userId 老师ID
	 * @return
	 */
	@RequestMapping("getAttentionNews.do")
	@ResponseBody
	public Map<String, Object> getAttentionNews(Integer pageNum, Integer pageSize, long userId) {
		if(pageSize == null) {
			pageSize = 0;
			pageNum = 0;
		}
		return attentionNewsTableService.getAttentionNews(pageNum,pageSize,userId);
	}
	
	/**
	 * 查询老师的动态信息
	 * 
	 * @author 周化益
	 * @param userId 老师ID
	 * @return
	 */
	@RequestMapping("getBlogInfo.do")
	@ResponseBody
	public Map<String, Object> getAttentionNewsInfo(int blogId) {
		return attentionNewsTableService.getBlogInfo(blogId);
	}
	
	/**
	 * 修改点赞数量
	 * 
	 * @param blogId 动态ID
	 * @return
	 */
	@RequestMapping("updatePraise.do")
	@ResponseBody
	public boolean updatePraise(int blogId) {
		return attentionNewsTableService.updatePraise(blogId);
	}
	
	private String fileName = "";
	
	/**
	 * 添加动态
	 * 
	 * @param teacherId 老师ID
	 * @param title 动态标题
	 * @param content 动态内容
	 * @return
	 */
	@RequestMapping("addAttentionNews.do")
	@ResponseBody
	public int addAttentionNews(String suffex, Integer teacherId, String title, String content) {
		Map<String, Object> attentionNews = new HashMap<String, Object>();
		byte[] temp;
		String newStr = "";
		try {
			temp = content.getBytes("ISO8859-1");
			newStr=new String(temp,"utf-8");//这里写转换后的编码方式
			attentionNews.put("content", newStr);//这里写原编码方式
		} catch (UnsupportedEncodingException e) {
			attentionNews.put("content", content);//这里写原编码方式
		}
		try {
			temp = title.getBytes("ISO8859-1");
			newStr=new String(temp,"utf-8");//这里写转换后的编码方式
			attentionNews.put("title", newStr);//这里写原编码方式
		} catch (UnsupportedEncodingException e) {
			attentionNews.put("title", title);
		}
		
		attentionNews.put("user_Id", teacherId);
		
		attentionNews.put("times",DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		if(suffex != null && !suffex.equals("")) {
			Date date = new Date();
			fileName = date.getTime()+suffex;
			attentionNews.put("images", CommonUtil.readFilePath(AttentionNewsTable.class, teacherId,fileName));
		} 
		return attentionNewsTableService.addAttentionNewsTable(attentionNews);
	}
	
	/**
	 * 老师动态图片上传
	 * 
	 * @author 周化益
	 * @param file 上传的文件流
	 * @param teacherId 老师ID
	 * @return
	 */
	@RequestMapping("uploadBlogPhoto.do")
	@ResponseBody
	public boolean uploadBlogPhoto(MultipartFile file, int teacherId) {
		if(!fileName.equals("")) {
			try {
				CommonUtil.upLoadPath(AttentionNewsTable.class, teacherId, file.getInputStream(), fileName, false);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	
	/**
	 * 删除自己的动态
	 * 
	 * @author 周化益
	 * @param entityId 动态ID
	 * @return
	 */
	@RequestMapping("deleteAttentionNews.do")
	@ResponseBody
	public String deleteAttentionNews(Long entityId) {
		String result = "fail";
		System.out.println(entityId);
		if(entityId != null && entityId > 0) {
			if(attentionNewsTableService.deleteAttentionNewsTable(entityId)) {
				result = "success";
			}
		}
		return result;
	}
	
	/**
	 * 查看动态列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页的大小
	 * @param search 搜索的框的值
	 * @return
	 */
	@RequestMapping("getBlogAll.do")
	@ResponseBody
	public Map<String, Object> getBlogAll(int pageNum, int pageSize, String whereSql) {
		return attentionNewsTableService.AttentionNewsTableList(pageNum, pageSize, whereSql, null);
	}
	
	/**
	 * 添加动态
	 * 
	 * @author 周化益
	 * @param mapVo 动态信息
	 * @param request
	 * @return
	 */
	@RequestMapping("addBlog.do")
	@ResponseBody
	public int addBlogAll(MapAction mapVo, HttpServletRequest request) {
		return attentionNewsTableService.addAttentionNewsTable(mapVo.getMapVo());
	}
	
	/**
	 * 修改动态
	 * 
	 * @author 周化益
	 * @param mapVo 动态信息
	 * @param request
	 * @return
	 */
	@RequestMapping("editBlog.do")
	@ResponseBody
	public boolean editBlogAll(MapAction mapVo, HttpServletRequest request) {
		return attentionNewsTableService.updateAttentionNewsTable(mapVo.getMapVo());
	}
	
	/**
	 * 删除单条动态
	 * 
	 * @author 周化益
	 * @param blogId 动态ID
	 * @return
	 */
	@RequestMapping("deleteBlog.do")
	@ResponseBody
	public boolean deleteBlog(long blogId) {
		return attentionNewsTableService.deleteAttentionNewsTable(blogId);
	}
	
	/**
	 * 删除多条动态
	 * 
	 * @author 周化益
	 * @param blogIds 动态ID集合
	 * @return
	 */
	@RequestMapping("deleteManyBlog.do")
	@ResponseBody
	public boolean deleteManyBlog(String blogIds) {
		return attentionNewsTableService.deleteAttentionNewsTables(blogIds);
	}
	
	/**
	 * 获取老师列表
	 * 
	 * @author 周化益
	 * @return
	 */
	@RequestMapping("getAllBlogUser.do")
	@ResponseBody
	public List<Map<String, Object>> getAllBlogUser() {
		return attentionNewsTableService.getAllBlogUser();
	}
	
	/**
	 * 获取老师列表
	 * 
	 * @author 周化益
	 * @return
	 */
	@RequestMapping("openBlogPage.do")
	public String openBlogPage(int blogId, HttpServletRequest request) {
		request.setAttribute("blog", attentionNewsTableService.getBlogInfo(blogId));
		return "blogEdit";
	}
	
	@RequestMapping("blogList.do")
	@ResponseBody
	public Map<String, Object> blogList(int pageNum, int pageSize) {
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("id", "desc");
		return attentionNewsTableService.AttentionNewsTableList(pageNum, pageSize, "", orderBy);
	}
}
