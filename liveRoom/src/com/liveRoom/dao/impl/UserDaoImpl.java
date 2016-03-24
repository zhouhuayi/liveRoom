package com.liveRoom.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liveRoom.bean.User;
import com.liveRoom.dao.UserDao;
import com.liveRoom.util.DateStrConvert;
import com.liveRoom.util.MD5Util;

@Repository("userDaoImpl")
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {
	//主键字段名
	protected final String PRIMARYKEYNAME = "user_id";
	//实体类名
	protected final Class<User> USERCLASS = User.class;
	
	@Override
	public Map<String, Object> userLogin(String account, String password) {
		StringBuffer whereSql = new StringBuffer();
		whereSql.append(" u where u.user_Account = '")
				 .append(account).append("' and u.user_pwd = '")
				 .append(password).append('\'');

		return super.getMapClass(USERCLASS, whereSql.toString());
	}

	@Override
	public boolean addUser(Map<String, Object> userMap) {
		return super.addClass(USERCLASS, userMap);
	}

	@Override
	public boolean updateUser(Map<String, Object> userMap) {
		return super.update(USERCLASS, userMap, PRIMARYKEYNAME);
	}

	@Override
	public boolean validateAccount(String account) {
		StringBuffer whereBuffer = new StringBuffer();
		whereBuffer.append(" where user_Account = '").append(account).append('\'');
		return super.getCount(USERCLASS, whereBuffer.toString()) > 0;
	}

	@Override
	public Map<String, Object> getAllUser(int page, int rows, String whereSql,
			Map<String, Object> orderBy) {
		if(orderBy == null || orderBy.size() == 0) {
			orderBy = new HashMap<String, Object>();
			orderBy.put(PRIMARYKEYNAME, "desc");
		}
		StringBuffer sql = new StringBuffer();
		sql.append("select u.user_id,u.user_account,u.user_name,u.user_address,u.user_realName,u.user_phone,")
		.append("u.user_email,u.user_level,u.user_integral,r.role_name,u.user_lastTime,u.user_registerDate,u.user_state")
		.append(" from user u LEFT JOIN `role` r ON u.user_role = r.role_id");
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from user ")
		.append("u LEFT JOIN `role` r ON u.user_role = r.role_id ");
		return super.getMapListClass(sql.toString(),countSql.toString() , page, rows, whereSql,orderBy);
	}

	@Override
	public boolean deleteUser(long userId) {
		return super.deleteClass(USERCLASS, PRIMARYKEYNAME, userId);
	}

	@Override
	public boolean deletesUser(String userIds) {
		return super.deletetClass(USERCLASS, PRIMARYKEYNAME, userIds);
	}

	@Override
	public boolean updateState(long userId) {
		return super.update(USERCLASS, "user_State",1, PRIMARYKEYNAME, userId);
	}

	@Override
	public boolean updatesState(String userIds) {
		return super.update(USERCLASS, "user_State", 1, PRIMARYKEYNAME, userIds);
	}
	@Override
	public int insertSelective(User record) {
		return insertSelective(record);
	}
	@Override
	public User selectByPrimaryKey(Integer userId) {
		return null;
	}
	
	@Override
	public int searUserByRoleId(int roleId) {
		Map<String, Object> userMap = super.findById(USERCLASS, "user_role", roleId);
		if(userMap != null && userMap.size() > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public long searcountByRoleIds(String roleIds) {
		String whereSql = " where user_role in("+roleIds+")";
		return super.getCount(USERCLASS, whereSql);
	}
	
	@Override
	public boolean updatePwd(long userId, String pwd) {
		return super.update(USERCLASS, "user_pwd", pwd, PRIMARYKEYNAME, userId);
	}

	@Override
	public Map<String, Object> getUserById(int userId) {
		return super.findById(USERCLASS, PRIMARYKEYNAME, userId);
	}
	public List<Map<String, Object>> getAllListUser(String sql){
		return super.findManyBySql(sql);
	}
	
	@Override
	public void updateLoginTime(long userId, String loginIP) {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("user_id", userId);
		userMap.put("user_lastTime", DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		userMap.put("user_loginIP", loginIP);
		super.update(USERCLASS, userMap, PRIMARYKEYNAME);
	}

	@Override
	public Map<String, Object> getAllUsers(int userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select u.user_id,u.user_account,u.user_name,u.user_realName,u.user_age,u.user_sex,u.user_phone,u.user_email,")
		.append("u.user_qq,u.user_address,u.user_level,u.user_lastTime,u.user_integral,r.role_name,u.user_head,u.user_registerDate,u.user_introduction")
		.append(" from `user` u")
		.append(" LEFT JOIN role r on u.user_role = r.role_id  where u.user_id="+userId);
		System.out.println(sql.toString());
		return super.findBySql(sql.toString());
	}
	
	@Override
	public Map<String, Object> getUserById(String sql) {
		// TODO Auto-generated method stub
		return super.findBySql(sql);
	}
	
	@Override
	public Map<String, Object> getTeachers(Integer pageNum, Integer pageSize,int userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT u.user_name,u.user_realName,advantage,u.user_id,u.user_introduction,u.user_qq,u.user_head,u.user_phone, ")
		.append("(SELECT count(*) from attentiontable WHERE blog_id = u.user_id) AS attentionCount")
		.append(",(SELECT count(*) from attentiontable a WHERE a.blog_id=u.user_id AND a.user_id = "+userId+") as isAttention")
		.append(" from USER u");
		
		StringBuffer countSql = new StringBuffer();
		countSql.append("SELECT count(*) from USER u");
		
		String whereSql = " where u.user_teacher=1 and user_state=0";
		
		//String whereSql = " where ru.grade=1";
		Map<String, Object> orderBy = new HashMap<String,Object>();
		orderBy.put("u.user_id", "desc");
		Map<String, Object> teacher = super.getMapListClass(sql.toString(), countSql.toString(), pageNum, pageSize, whereSql, orderBy);
		return teacher;
	}
	
	@Override
	public Map<String, Object> findTeacherInfo(int teacherId, int userId) {
		String sql = "select u.user_id,u.user_head,u.user_realName,u.user_name,u.user_introduction,u.user_qq,"
				+ "u.user_sex,u.user_teacher,advantage,"
				+ "u.user_phone,(SELECT count(*) from attentiontable a WHERE a.blog_id=u.user_id AND a.user_id = "+userId+") as isAttention"
				+ ",(SELECT count(*) from attentiontable WHERE blog_id = u.user_id) AS attentionCount"
				+ " from user u where u.user_id = " + teacherId;
		System.out.println(sql);
		return super.findBySql(sql);
	}
	
	@Override
	public Map<String, Object> findUserInfo(int userId) {
		String sql = "select u.user_id,u.user_head,u.user_realName,u.user_name,u.user_introduction,u.user_qq,advantage,"
				+ "u.user_phone,u.user_address,u.user_sex,u.user_teacher from user u where u.user_id = " + userId;
		return super.findBySql(sql);
	}
	
	@Override
	public Map<String, Object> myAttention(int userId,int pageNum,int pageSize) {
		String sql = "select u.user_id,u.user_qq,u.user_realName,u.user_introduction,u.user_head,a.id"
				+ " from `user` u LEFT JOIN attentiontable a ON a.blog_id=u.user_id";
		
		String countSql = "select count(*) from `user` u LEFT JOIN attentiontable a ON a.blog_id=u.user_id";
		
		String whereSql = " where a.user_id="+userId;
		
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("u.user_id", "desc");
		return super.getMapListClass(sql.toString(), countSql.toString(), pageNum, pageSize, whereSql, orderBy);
	}
	
	@Override
	public boolean beforeEditPWD(int userId, String oldPwd, String newPwd) {
		String sql = "update User set user_pwd = '" + MD5Util.string2MD5(newPwd) + 
				"' where user_id = " + userId + " and user_pwd = '" + MD5Util.string2MD5(oldPwd) + "'";
		System.out.println(sql);
		return super.addClass(sql);
	}
	
	@Override
	public boolean beforeForgotPWD(String userPhone, String newPwd) {
		String sql = "update User set user_pwd = '" + MD5Util.string2MD5(newPwd) + 
				"' where user_phone = '" + userPhone + "'";
		return super.addClass(sql);
	}
	
	@Override
	public boolean addAttention(int userId, int teacherId) {
		String insert = " insert into attentiontable(user_id,blog_id,attentiontime) values(" + userId + "," 
				+ teacherId + ",'" + DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss")+ "')";
		return super.addClass(insert);
	}
	
	@Override
	public boolean removeAttention(int teacherId, int userId) {
		String deleteSql = "delete from attentiontable where user_id = " + userId + " and blog_id = " + teacherId;
		return super.addClass(deleteSql);
	}
	
	@Override
	public boolean validateAttention(int teacherId, int userId) {
		String searchCount = " select count(*) from attentiontable where user_id = " + userId 
				+ " and blog_id = " + teacherId;
		return super.validate(searchCount);
	}
	
	@Override
	public String getUserHead(int userId) {
		String sql = "select user_head from user where user_id = " + userId;
		return super.getOneValue(sql);
	}

	@Override
	public boolean restoreState(long userId) {
		return super.update(USERCLASS, "user_State",0, PRIMARYKEYNAME, userId);
	}

	@Override
	public boolean restoresState(String userIds) {
		return super.update(USERCLASS, "user_State",0, PRIMARYKEYNAME, userIds);
	}

	@Override
	public boolean validatePhone(String phone) {
		StringBuffer whereBuffer = new StringBuffer();
		whereBuffer.append(" where user_phone = '").append(phone).append('\'');
		return super.getCount(USERCLASS, whereBuffer.toString()) > 0;
	}
	
}
