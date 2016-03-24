package com.liveRoom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.PowerService;
import com.liveRoom.util.MapAction;

@Controller
public class PowerControoller {
	@Autowired
	private PowerService powerService;
	
	@RequestMapping("powerListByRole.do")
	@ResponseBody
	public List<Map<String, Object>> powerList(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, Object> user = (HashMap<String, Object>)request.getSession().getAttribute("user");
		return powerService.powerList((Integer)user.get("user_role"));
	}
	
	@RequestMapping("powerList.do")
	@ResponseBody
	public List<Map<String, Object>> powerList() {
		return powerService.powerList();
	}
	
	/**
	 * 通过分页获取所有权限信息
	 * 
	 * @author 李琼雅
	 * @param pageNum 显示第几页
	 * @param pageSize 每页显示的数量
	 * @param whereSql 查询的条件
	 * @param mapVo 分页的参数
	 * @param request
	 * @return
	 */
	@RequestMapping("getAllPower.do")
	@ResponseBody
	public Map<String, Object> powersList(int pageNum, int pageSize,
			String whereSql, MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(whereSql != null && !whereSql.equals("")) {
			params.put("search", whereSql);
		}
		return powerService.powersList(pageNum, pageSize,params, whereSql,mapVo.getMapVo());
				}
	

	/**
	 * 权限添加
	 * 
	 * @author 李琼雅
	 * @param mapVo 权限数据
	 * @param request
	 * @return
	 */
	@RequestMapping("addPower.do")
	@ResponseBody
	public boolean addPower(MapAction mapVo,HttpServletRequest request) {
		return powerService.addPower(mapVo.getMapVo());
	}
	
	/**
	 * 权限信息修改
	 * 
	 * @author 李琼雅
	 * @param mapVo 权限数据
	 * @param request
	 * @return
	 */
	@RequestMapping("editPower.do")
	@ResponseBody
	public boolean editPower(MapAction mapVo,HttpServletRequest request) {
		return powerService.updatePower(mapVo.getMapVo());
	}
	
	/**
	 * 跳转修改页面
	 * 
	 * @author 李琼雅
	 * @param powerId 权限ID
	 * @param request
	 * @return
	 */
	@RequestMapping("openPowerEdit.do")
	public String updatePower(int powerId, HttpServletRequest request) {
		request.setAttribute("power",powerService.getPowerById(powerId));
		return "powerEdit";
	}
	
	/**
	 * 单条删除权限
	 * 
	 * @author 李琼雅
	 * @param powerId 权限ID
	 * @return
	 */
	@RequestMapping("deletePower.do")
	@ResponseBody
	public boolean deletePower(long powerId) {
		return powerService.deletePower(powerId);
	}
	
	/**
	 * 多条删除权限
	 * 
	 * @author 周化益
	 * @param powerIds 用户ID集合
	 * @return
	 */
	@RequestMapping("deletePowers.do")
	@ResponseBody
	public boolean deletePowers(String powerIds) {
		return powerService.deletePowers(powerIds);
	}
	
}
