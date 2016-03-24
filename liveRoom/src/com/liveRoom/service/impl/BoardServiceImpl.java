package com.liveRoom.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.dao.BoardDao;
import com.liveRoom.service.BoardService;
import com.liveRoom.util.DateStrConvert;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Resource
	private BoardDao boardDaoImpl;
	
	@Override
	public Map<String, Object> addBard(Long userId, String text, String phone, String address) {
		Map<String, Object> mapData = new HashMap<String, Object>();
		Map<String, Object> messageMap = new HashMap<String, Object>();
		messageMap.put("type", "fail");
		messageMap.put("message", "留言失败，系统繁忙，请稍后再试。");
		
		if(userId != null && userId.getClass().toString().contains("Long")) {
			mapData.put("userId", userId);
		}
		
		if (text != null && !text.trim().equals("")) {
			mapData.put("content", text);
		} else {
			messageMap.put("message", "留言不能为空或空格。");
		}
		
		if (address != null && !address.trim().equals("")) {
			mapData.put("address", address);
		} else {
			messageMap.put("address", "");
		}
		
		if (phone != null && !phone.trim().equals("")) {
			mapData.put("phone", phone);
		} else {
			mapData.put("phone", "");
		}
		
		mapData.put("times", DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		boolean bool = boardDaoImpl.addBard(mapData);
		if(bool) {
			messageMap.put("type", "success");
			messageMap.put("message", "留言成功");
		}
		
		return messageMap;
	}

	@Override
	public boolean updateBard(Map<String, Object> mapData) {
		return boardDaoImpl.updateBard(mapData);
	}

	@Override
	public Map<String, Object> searchBardList(int pageNum, int pageSize,
			Map<String, Object> orderBy, String whereSql) {
		if(whereSql == null || whereSql.trim().equals("")) {
			whereSql = "";
		} else {
			whereSql=whereSql.replaceAll("[`~!@#$^&*()=|{}':;%',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]","");
			System.out.println(whereSql);
			whereSql = " where address like '%" + whereSql + "%' or content like '%" + whereSql + "%'";
		}
		return boardDaoImpl.searchBardList(pageNum, pageSize, orderBy, whereSql);
	}
	
	@Override
	public Map<String, Object> messageBoard(int pageNum, int pageSize) {
		return boardDaoImpl.messageBoard(pageNum, pageSize);
	}

	@Override
	public boolean deleteBoard(long boardId) {
		return boardDaoImpl.deleteBoard(boardId);
	}

	@Override
	public boolean deleteBoards(String boardIds) {
		return boardDaoImpl.deleteBoards(boardIds);
	}

}
