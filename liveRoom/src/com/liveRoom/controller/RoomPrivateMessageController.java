package com.liveRoom.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.RoomPrivateMessageService;
import com.liveRoom.util.MapAction;
@Controller
public class RoomPrivateMessageController {
	@Autowired
	private RoomPrivateMessageService roomPrivateMessageService;
	/**
	 * 通过分页获取所有房间私聊信息
	 * 
	 * @author 李琼雅
	 * @param pageNum 显示第几页
	 * @param pageSize 每页显示的数量
	 * @param whereSql 查询的条件
	 * @param mapVo 分页的参数
	 * @param request
	 * @return
	 */
	@RequestMapping("getAllRoomPrivateMessage.do")
	@ResponseBody
	public Map<String, Object> roomPrivateMessageList(int pageNum, int pageSize,
			String whereSql, MapAction mapVo, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (whereSql != null && !whereSql.equals("")) {
			params.put("search", whereSql);
		}
		return roomPrivateMessageService.roomPrivateMessageList(pageNum, pageSize, params,whereSql, mapVo.getMapVo());
	}
	/**
	 * 修改单条状态
	 * 
	 * @author 李琼雅
	 * @param roomprivateMessageId 聊天记录ID
	 * @return
	 */
	@RequestMapping("deleteroomprivateMessage.do")
	@ResponseBody
	public boolean updateState(long roomprivateMessageId) {
		return roomPrivateMessageService.updateState(roomprivateMessageId);
	}
	
	/**
	 * 修改多条状态
	 * 
	 * @author 李琼雅
	 * @param roomprivateMessageIds 聊天记录ID集合
	 * @return
	 */
	@RequestMapping("deletesroomprivateMessage.do")
	@ResponseBody
	public boolean updatesState(String roomprivateMessageIds) {
		return roomPrivateMessageService.updatesState(roomprivateMessageIds);
	}
}
