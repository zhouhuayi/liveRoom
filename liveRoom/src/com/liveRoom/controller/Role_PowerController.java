package com.liveRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.Role_PowerService;

@Controller
public class Role_PowerController {
	@Autowired
	private Role_PowerService role_powerService;
	
	@RequestMapping("getPowerIdByRole.do")
	@ResponseBody
	public List<Long> getPowerIdByRole(int roleId) {
		return role_powerService.getPowerByrole(roleId);
	}
}
