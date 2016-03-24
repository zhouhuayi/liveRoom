package com.liveRoom.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.liveRoom.bean.Role;
import com.liveRoom.service.RoleService;
import com.liveRoom.service.UserService;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.FileLoad;
import com.liveRoom.util.MapAction;
import com.liveRoom.util.UtilController;

@Controller
public class RoleControoller {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	/**
	 * 通过分页获取所有角色信息
	 * 
	 * @author 周化益
	 * @param pageNum 显示第几页
	 * @param pageSize 每页显示的数量
	 * @param whereSql 查询的条件
	 * @param mapVo 分页的参数
	 * @param request
	 * @return
	 */
	@RequestMapping("getAllRole.do")
	@ResponseBody
	public Map<String, Object> roleList(int pageNum, int pageSize,
			String whereSql, MapAction mapVo, HttpServletRequest request) {
		return roleService.roleList(pageNum, pageSize, whereSql, mapVo.getMapVo());
	}
	
	/**
	 * 添加角色
	 * 
	 * @author 周化益
	 * @param fileData 上传的文件
	 * @param role_name 角色名称
	 * @param powerIds 所分配的权限ID集合
	 * @param fileName 上传的文件名
	 * @param request
	 * @return
	 */
	@RequestMapping("addRole.do")
	@ResponseBody
	public boolean addRole( String role_name,String powerIds,String suffixName, HttpServletRequest request) {
		try {
			Role role = new Role();
			role.setRole_icon(suffixName);
			role.setRole_name(role_name);
			roleService.insert(role,powerIds);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 跳转修改页面
	 * 
	 * @author 周化益
	 * @param roleId 角色ID
	 * @param request
	 * @return
	 */
	@RequestMapping("updateRole.do")
	public String updateRole(String roleId, HttpServletRequest request) {
		request.setAttribute("role", roleService.getRoleById(Integer.valueOf(roleId)));
		return "roleEdit";
	}
	
	/**
	 * 修改角色信息
	 * 
	 * @author 周化益
	 * @param fileData 上传的文件
	 * @param role_name 角色名称
	 * @param powerIds 所分配的权限ID集合
	 * @param fileName 上传的文件名
	 * @return
	 */
	@RequestMapping("editRole.do")
	@ResponseBody
	public boolean editRole(MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> roleMap = mapVo.getMapVo();
		Long userId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
		if(roleMap.get("role_icon") != null) {
			String role_icon = CommonUtil.readFilePath(Role.class, userId, 
					roleMap.get("role_icon").toString());
			roleMap.put("role_icon",role_icon);
			String rolePath = roleMap.remove("rolePath").toString();
			CommonUtil.clearFile(rolePath);
		}
		return roleService.updateRole(mapVo.getMapVo());
	}
	
	/**
	 * 上传角色图标
	 * 
	 * @author 周化益
	 * @param fileData 视频文件
	 * @param fileName 视频文件名
	 * @param videoId 视频ID
	 * @return
	 */
	@RequestMapping("uploadRole.do")
	@ResponseBody
	public boolean uploadRole(MultipartFile fileData, String fileName, int roleId,HttpServletRequest request) {
		try {
			System.out.println("进入角色上传！");
			
			if(fileData == null) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				fileData = multipartRequest.getFile("fileData");
				System.out.println(fileData);
			}
			CommonUtil.upLoadPath(Role.class,roleId, fileData.getInputStream(), fileName,false);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除单个角色
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping("deleteRole.do")
	@ResponseBody
	public int deleteRole(int roleId) {
		int  state = userService.searUserByRoleId(roleId);;
		if(state == 1) {
			return state;
		} else if(roleService.deleteRole(roleId)) {
			state = 2;
			FileLoad.deleteFile(Role.class, roleId);
		} else {
			state = 0;
		}
		return state;
	}
	
	/**
	 * 删除单个角色
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping("deleteManyRole.do")
	@ResponseBody
	public long deleteManyRole(String roleIds) {
		long  state = userService.searcountByRoleIds(roleIds);;
		if(state > 0) {
			state = 1;
		} else if(roleService.deleteRoles(roleIds)) {
			state = 2;
			FileLoad.deleteFile(Role.class, roleIds);
		} else {
			state = 0;
		}
		return state;
	}
}
