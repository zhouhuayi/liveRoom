package com.liveRoom.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.FriendPrivateChatService;
import com.liveRoom.util.MapAction;

@Controller
public class FriendPrivateChatControoller {
	@Autowired
	private FriendPrivateChatService friendPrivateChatService;

	/**
	 * 通过分页获取所有好友私聊信息
	 * 
	 * @author 李琼雅
	 * @param pageNum 显示第几页
	 * @param pageSize 每页显示的数量
	 * @param whereSql 查询的条件
	 * @param mapVo 分页的参数
	 * @param request
	 * @return
	 */
	@RequestMapping("getAllFriendChat.do")
	@ResponseBody
	public Map<String, Object> FriendChatList(int pageNum, int pageSize,
			String whereSql, MapAction mapVo, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (whereSql != null && !whereSql.equals("")) {
			params.put("search", whereSql);
		}
		return friendPrivateChatService.FriendChatList(pageNum, pageSize, params,whereSql, mapVo.getMapVo());
	}
	
	/**
	 * 修改单条状态
	 * 
	 * @author 李琼雅
	 * @param friendchatId 聊天记录ID
	 * @return
	 */
	@RequestMapping("deletefriendchat.do")
	@ResponseBody
	public boolean updateState(long friendchatId) {
		return friendPrivateChatService.updateState(friendchatId);
	}
	
	/**
	 * 修改多条状态
	 * 
	 * @author 李琼雅
	 * @param friendchatIds 聊天记录ID集合
	 * @return
	 */
	@RequestMapping("deletesfriendchat.do")
	@ResponseBody
	public boolean updatesState(String friendchatIds) {
		return friendPrivateChatService.updatesState(friendchatIds);
	}

}
