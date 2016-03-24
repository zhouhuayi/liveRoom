package com.liveRoom.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.RoomRadioService;
import com.liveRoom.util.DateStrConvert;
import com.liveRoom.util.MapAction;
import com.liveRoom.util.UtilController;

@Controller
public class RoomRadioController {
	@Autowired
	private RoomRadioService roomRadioService;
	
	@RequestMapping("getRoomRadioList.do")
	@ResponseBody
	public Map<String, Object> getRoomRadioList(int pageNum, int pageSize,
			String whereSql, MapAction mapVo, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_id", UtilController.getUserByRequest(request).get("user_id").toString());
		if(whereSql != null && !whereSql.equals("")) {
			params.put("search", whereSql);
		}
		return roomRadioService.roomRadioList(pageNum, pageSize, params, mapVo.getMapVo());
	}
	
	/**
	 * 房间通知数据添加
	 * 
	 * @author 周化益
	 * @param mapVo 房间通知数据
	 * @param request
	 * @return
	 */
	@RequestMapping("addRoomRadio.do")
	@ResponseBody
	public boolean addVideo(MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> roomRadio = mapVo.getMapVo();
		roomRadio.put("createtime", DateStrConvert.dateToStr(new Date(), "yyy-MM-dd HH:mm:ss"));
		return roomRadioService.addRoomRadio(roomRadio);
	}
	
	/**
	 * 房间通知数据修改
	 * 
	 * @author 周化益
	 * @param mapVo 房间通知数据
	 * @param request
	 * @return
	 */
	@RequestMapping("editRoomRadio.do")
	@ResponseBody
	public boolean editVideo(MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> roomRadio = mapVo.getMapVo();
		roomRadio.put("createtime", DateStrConvert.dateToStr(new Date(), "yyy-MM-dd HH:mm:ss"));
		return roomRadioService.updateRoomRadio(roomRadio);
	}
	
	/**
	 * 跳转修改页面
	 * 
	 * @author 周化益
	 * @param RoomRadioId 房间通知ID
	 * @param request
	 * @return
	 */
	@RequestMapping("openRoomRadioEdit.do")
	public String updateRole(int roomRadioId, HttpServletRequest request) {
		request.setAttribute("roomRadio",roomRadioService.getRoomRadioById(roomRadioId));
		return "roomRadioEdit";
	}
	
	/**
	 * 删除单个房间通知
	 * 
	 * @param RoomRadioId 房间通知ID集合
	 * @return
	 */
	@RequestMapping("deleteRoomRadio.do")
	@ResponseBody
	public boolean deleteRole(long roomRadioId) {
		return roomRadioService.deleteRoomRadio(roomRadioId);
	}
	
	/**
	 * 删除多个房间通知
	 * 
	 * @param RoomRadioIds 房间通知集合
	 * @return
	 */
	@RequestMapping("deleteManyRoomRadio.do")
	@ResponseBody
	public boolean deleteManyRole(String roomRadioIds) {
		return roomRadioService.deleteRoomRadios(roomRadioIds);
	}
}
