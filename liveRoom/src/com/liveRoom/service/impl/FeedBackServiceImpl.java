package com.liveRoom.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.dao.FeedBackDao;
import com.liveRoom.service.FeedBackService;

@Service("feedBackService")
public class FeedBackServiceImpl implements FeedBackService {
	@Resource
	private FeedBackDao feedBackDaoImpl;
	
	@Override
	public Map<String, Object> addFeedBack(Map<String, Object> mapData) {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("type", "fail");
		message.put("message", "网络不好，请稍后再试。谢谢配合！");
		if(mapData.get("userId") == null) {
			message.put("message", "请输入当前登陆者的ID");
		} else if(mapData.get("content") == null) {
			message.put("message", "请输入反馈的内容");
		} else {
			if(feedBackDaoImpl.addFeedBack(mapData)) {
				message.put("message", "感谢您的反馈，有了您的反馈我们才能提供更好的服务。");
				message.put("type", "success");
			}
		}
		return message;
	}

	@Override
	public Map<String, Object> searchList(int pageNum, int pageSize,
			Map<String, Object> orderBy, String whereSql) {
		return feedBackDaoImpl.searchList(pageNum, pageSize, orderBy, whereSql);
	}

	@Override
	public boolean deleteFeedBack(long feedBackId) {
		return feedBackDaoImpl.deleteFeedBack(feedBackId);
	}
	
	@Override
	public boolean deleteFeedBacks(String feedBackIds) {
		return feedBackDaoImpl.deleteFeedBacks(feedBackIds);
	}
}
