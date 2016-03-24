package com.liveRoom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.VideoTypeService;

@Controller
public class VideoTypeController {
	@Autowired
	private VideoTypeService videoTypeService;
	
	/**
	 * 获取所有类型列表
	 * 
	 * @author 周化益
	 * @return
	 */
	@RequestMapping("videoTypeList.do")
	@ResponseBody
	public List<Map<String, Object>> searchList() {
		return videoTypeService.searchTypeList();
	}
}
