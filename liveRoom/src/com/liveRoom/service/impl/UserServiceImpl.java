package com.liveRoom.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liveRoom.bean.User;
import com.liveRoom.dao.UserDao;
import com.liveRoom.service.UserService;
import com.liveRoom.util.DateStrConvert;
import com.liveRoom.util.MD5Util;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDaoImpl;
	@Resource
	private UserDao userDao;

	@Override
	public Map<String, Object> userLogin(String account, String password,String loginIP) {
		password = MD5Util.string2MD5(password);
		Map<String, Object> userMap = userDaoImpl.userLogin(account, password);
		if(userMap != null) {
			if (userMap != null && userMap.size() > 0) {
				userDaoImpl.updateLoginTime((Integer) userMap.get("user_id"),loginIP);
			}
		}
		return userMap;
	}

	@Override
	public boolean addUser(Map<String, Object> userMap) {
		userMap.put("user_registerDate",
				DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		userMap.put("user_lastTime",
				DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		userMap.put("user_pwd",
				MD5Util.string2MD5(userMap.get("user_pwd").toString()));
		return userDaoImpl.addUser(userMap);
	}

	@Override
	public boolean updateUser(Map<String, Object> userMap) {
		if (userMap.get("user_pwd") != null && !userMap.get("user_pwd").equals("")) {
			userMap.put("user_pwd",MD5Util.string2MD5(userMap.get("user_pwd").toString()));
		}
		if (userMap.containsKey("user_role") && userMap.get("user_role").equals("")) {
			userMap.remove("user_role");
		}
		return userDaoImpl.updateUser(userMap);	
	}

	@Override
	public boolean validateAccount(String account) {
		return userDaoImpl.validateAccount(account);
	}

	@Override
	public Map<String, Object> getAllUser(int page, int rows,
			Map<String, Object> params, Map<String, Object> orderBy,
			String whereSql) {
		if (params.size() > 0) {
			whereSql = " where 1 = 1";
			if (params.get("search") != null
					&& !params.get("search").equals("")) {
				whereSql += " and (u.user_account like '%"
						+ MessageFormat.format("{0}", params.get("search"))
						+ "%'" + " or u.user_name like '%"
						+ MessageFormat.format("{0}", params.get("search"))
						+ "%'" + " or u.user_realName like '%"
						+ MessageFormat.format("{0}", params.get("search"))
						+ "%')";
			} 
			if (params.get("roles") != null && !params.get("roles").equals("")) {
				whereSql += " and u.user_role =" + MessageFormat.format("{0}", params.get("roles"));
			}
			if(params.get("state") != null && !params.get("state").equals(""))
			{
				whereSql +=" and u.user_state ="+MessageFormat.format("{0}",params.get("state"));
			}
			
			if(params.get("user_teacher").equals(1)) {
				whereSql += " and (ISNULL(u.user_role) or u.user_role ='')";
				if(params.get("teacher") != null && !params.get("teacher").equals(2)) {
					whereSql += " and u.user_teacher = " + params.get("teacher");
				}
			} else {
				whereSql += " and u.user_role is not null";
			}
			System.out.println(whereSql);
		}
		
		Map<String, Object> userMap = userDaoImpl.getAllUser(page, rows, whereSql, orderBy);
		return userMap;
	}

	@Override
	public boolean deleteUser(long userId) {
		return userDaoImpl.deleteUser(userId);
	}

	@Override
	public boolean deletesUser(String userIds) {
		return userDaoImpl.deletesUser(userIds);
	}

	@Override
	public boolean updateState(long userId) {
		return userDaoImpl.updateState(userId);
	}

	@Override
	public boolean updatesState(String userIds) {
		return userDaoImpl.updatesState(userIds);
	}

	@Override
	public int insertSelective(User record) {
		return userDao.insertSelective(record);
	}

	/**
	 * 条件查询所有
	 * 
	 * @author hj
	 * @param wheresql
	 *            wheresql 查询的条件
	 * @return
	 */
	public List<Map<String, Object>> getAllListUser(String wheresql) {
		return userDaoImpl.getAllListUser(wheresql);
	}

	@Override
	public User selectByPrimaryKey(Integer userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public int searUserByRoleId(int roleId) {
		return userDaoImpl.searUserByRoleId(roleId);
	}

	@Override
	public long searcountByRoleIds(String roleIds) {
		return userDaoImpl.searcountByRoleIds(roleIds);
	}

	@Override
	public boolean updatePwd(long userId, String pwd) {
		return userDaoImpl.updatePwd(userId, pwd);
	}

	@Override
	public Map<String, Object> getUserById(int userId) {
		// User user=new User();
		// MD5Util.convertMD5(MD5Util.convertMD5(user.getUser_pwd().toString()));
		Map<String, Object> map = userDaoImpl.getUserById(userId);
		return map;
	}
	
	@Override
	public Map<String, Object> getUserById(String sql) {
		// User user=new User();
		// MD5Util.convertMD5(MD5Util.convertMD5(user.getUser_pwd().toString()));
		Map<String, Object> map = userDaoImpl.getUserById(sql);
		return map;
	}

	@Override
	public Map<String, Object> getAllTeacher(int page, int rows, String params,
			Map<String, Object> orderBy) {
		String whereSql = " where user_role = (select role_id from role where role_identity = 'FJLS')";
		if (params != null && !params.equals("")) {
			whereSql += " and user_realName like '%"
					+ MessageFormat.format("{0}", params) + "%'"
					+ " or user_name like '%"
					+ MessageFormat.format("{0}", params) + "%')";
		}

		return userDaoImpl.getAllUser(page, rows, whereSql, orderBy);
	}

	@Override
	public Map<String, Object> getAllUsers(int userId) {
		Map<String, Object> map = userDaoImpl.getAllUsers(userId);
		return map;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> getTeachers(Integer pageNum, Integer pageSize,int userId) {
		Map<String, Object> userMap = userDaoImpl.getTeachers(pageNum, pageSize,userId);
		List<Map<String,Object>> listMap = (ArrayList<Map<String,Object>>)userMap.get("rows");
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : listMap) {
			if(map.get("user_head") == null || map.get("user_head").equals("")) {
				map.put("user_head","image/head.jpg");
			} 
			rows.add(map);
		}
		userMap.put("rows", rows);
		return userMap;
	}
	
	@Override
	public Map<String, Object> findTeacherInfo(int teacherId, int userId)  {
		System.out.println(teacherId);
		System.out.println(userId);
		Map<String, Object> map = userDaoImpl.findTeacherInfo(teacherId,userId);
		if(map.get("user_head") == null || map.get("user_head").equals("")) {
			map.put("user_head","image/head.jpg");
		}
		return map;
	}
	
	@Override
	public Map<String, Object> findUserInfo(int userId) {
		Map<String, Object> map = userDaoImpl.findUserInfo(userId);
		if(map.get("user_head") == null || map.get("user_head").equals("")) {
			map.put("user_head","image/head.jpg");
		}
		return map;
	}
	
	@Override
	public Map<String, Object> myAttention(int userId, int pageNum, int pageSize) {
		Map<String, Object> userMap = userDaoImpl.myAttention(userId, pageNum, pageSize);
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> listMap = (ArrayList<Map<String,Object>>)userMap.get("rows");
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : listMap) {
			if(map.get("user_head") == null || map.get("user_head").equals("")) {
				map.put("user_head","image/head.jpg");
			}
			rows.add(map);
		}
		userMap.put("rows", rows);
		return userMap;
	}
	
	@Override
	public int beforeRegister(User user) {
		return userDao.insertSelective(user);
	}
	
	@Override
	public boolean beforeEditPWD(int userId, String oldPwd, String newPwd) {
		return userDaoImpl.beforeEditPWD(userId, oldPwd, newPwd);
	}
	
	@Override
	public boolean beforeForgotPWD(String userPhone,String newPwd) {
		return userDaoImpl.beforeForgotPWD(userPhone, newPwd);
	}
	
	@Override
	public boolean addAttention(int userId, int teacherId) {
		return userDaoImpl.addAttention(userId, teacherId);
	}
	
	@Override
	public boolean removeAttention(int teacherId, int userId)  {
		return userDaoImpl.removeAttention(teacherId, userId);
	}
	
	@Override
	public boolean validateAttention(int teacherId, int userId) {
		return userDaoImpl.validateAttention(teacherId, userId);
	}

	@Override
	public boolean restoreState(long userId) {
		return userDaoImpl.restoreState(userId);
	}

	@Override
	public boolean restoresState(String userIds) {
		return userDaoImpl.restoresState(userIds);
	}
	
	@Override
	public boolean validatePhone(String phone) {
		return userDaoImpl.validatePhone(phone);
	}
}
