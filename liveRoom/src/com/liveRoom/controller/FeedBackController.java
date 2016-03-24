package com.liveRoom.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.FeedBackService;
import com.liveRoom.util.DateStrConvert;

@Controller
public class FeedBackController {
	@Autowired
	private FeedBackService feedBackService;
	
	/**
	 * 反馈意见
	 * 
	 * @author 周化益
	 * @param phone 	联系方式
	 * @param content	反馈内容
	 * @param userId	反馈人
	 * @return
	 */
	@RequestMapping("addFeedBack.do")
	@ResponseBody
	public Map<String, Object> addFeedBack(String phone,String content, long userId,HttpServletRequest request) {
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("phone", phone);
		try {
			byte[] byteStr = content.getBytes("ISO8859-1");
			mapData.put("content", new String(byteStr, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			mapData.put("content",content);
		}
		mapData.put("userId", userId);
		mapData.put("times", DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return feedBackService.addFeedBack(mapData);
	}
	
	/**
	 * 反馈列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示额数据
	 * @param search 搜索的条件
	 * @param request
	 * @return
	 */
	@RequestMapping("searchFeedList.do")
	@ResponseBody
	public Map<String, Object> searchFeedBackList(int pageNum, int pageSize, String whereSql) {
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("id", "desc");
		return feedBackService.searchList(pageNum, pageSize, orderBy, whereSql);
	}
	
	
	/**
	 * 删除单个反馈
	 * 
	 * @author 周化益
	 * @param FeedBackId 反馈ID
	 * @return
	 */
	@RequestMapping("deleteFeedBack.do")
	@ResponseBody
	public boolean deleteFeedBack(long feedBackId) {
		return feedBackService.deleteFeedBack(feedBackId);
	}
	
	/**
	 * 删除多个反馈
	 * 
	 * @author 周化益
	 * @param feedBackIds 反馈ID集合
	 * @return
	 */
	@RequestMapping("deleteFeedBacks.do")
	@ResponseBody
	public boolean deleteFeedBacks(String feedBackIds) {
		return feedBackService.deleteFeedBacks(feedBackIds);
	}
	
	
	
}
