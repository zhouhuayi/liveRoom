package com.liveRoom.service;

import java.util.List;
import java.util.Map;

import com.liveRoom.bean.User;


public interface UserService {
	
	User selectByPrimaryKey(Integer userId);
	
	int insertSelective(User record);
	
	/**
	 * 用户登录
	 * 
	 * @author 周化益
	 * @param account 账户
	 * @param password 密码
	 * @param loginIp 登录者的IP地址
	 * @return
	 */
	public Map<String, Object> userLogin(String account,String password, String loginIp);
	
	/**
	 * 用户注册
	 * 
	 * @author 周化益
	 * @param userMap 添加信息
	 * @return
	 */
	public boolean addUser(Map<String, Object> userMap);
	
	/**
	 * 修改密码
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @param pwd 用户的密码
	 * @return
	 */
	public boolean updatePwd(long userId, String pwd);
	
	/**
	 * 修改信息
	 * 
	 * @author 李琼雅
	 * @param userMap 修改的信息
	 * @return
	 */
	public boolean updateUser(Map<String,Object> userMap);
	
	/**
     * 根据ID查询单条用户信息
     * 
     * @author 李琼雅
     * @param userId 新闻ID
     * @return
     */
    public Map<String, Object> getUserById(int userId);

    /**
     * 根据ID查询单条房间用户信息
     * 
     * @author 李琼雅
     * @param userId 新闻ID
     * @return
     */
    public Map<String, Object> getUserById(String sql);
	
	/**
	 * 验证账户是否被注册
	 * 
	 * @author 周化益
	 * @param account 账户
	 * @return
	 */
	public boolean validateAccount(String account);
	
	/**
	 * 查询所有用户信息
	 * 
	 * @author 周化益
	 * @param page 第几页
	 * @param rows 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> getAllUser(int page, int rows,
			Map<String, Object> params, Map<String, Object> orderBy,String whereSql);
	
	/**
	 * 单条删除
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @return
	 */
	public boolean deleteUser(long userId);
	
	/**
	 * 多条删除
	 * 
	 * @author 周化益
	 * @param userIds 用户ID集合
	 * @return
	 */
	public boolean deletesUser(String userIds);
	
	/**
	 * 修改单条状态
	 * 
	 * @author 李琼雅
	 * @param userId 用户ID
	 * @return
	 */
	public boolean updateState(long userId);
	
	/**
	 * 修改多条状态
	 * 
	 * @author 李琼雅
	 * @param userIds 用户ID集合
	 * @return
	 */
	public boolean updatesState(String userIds);
	
	/**
	 * 还原单个用户
	 * 
	 * @author 李琼雅
	 * @param userId 用户ID
	 * @return
	 */
	public boolean restoreState(long userId);
	
	/**
	 * 还原多个用户
	 * 
	 * @author 李琼雅
	 * @param userIds 用户ID集合
	 * @return
	 */
	public boolean restoresState(String userIds);
	
	/**
	 * 条件查询所有
	 * @author hj
	 * @param wheresql
	 * wheresql 查询的条件
	 * @return
	 */
	public List<Map<String,Object>> getAllListUser(String wheresql);
	
	/**
	 * 根据角色查询用户
	 * 
	 * @author 周化益
	 * @param roleId 角色ID
	 * @return
	 */
	public int searUserByRoleId(int roleId);
	
	/**
	 * 根据角色查询用户
	 * 
	 * @author 周化益
	 * @param roleIds 角色ID集合
	 * @return
	 */
	public long searcountByRoleIds(String roleIds);
	
	/**
	 * 查询所有用户信息
	 * 
	 * @author 周化益
	 * @param page 第几页
	 * @param rows 每页显示的条数
	 * @param params 查询的参数
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> getAllTeacher(int page, int rows,String params, Map<String, Object> orderBy);
	
	/**
	 * 关联角色表根据id查询用户信息
	 * 
	 * @author李琼雅
	 * @param whereSql 查询的条件
	 * @return
	 */
	public Map<String, Object> getAllUsers(int userId);
	
	/**
	 * 查询所有房间老师
	 * 
	 * @author 周化益
	 * @param userId 当前登陆用户ID
	 * @return
	 */
	public Map<String, Object> getTeachers(Integer pageNum, Integer pageSize, int userId);
	
	/**
	 * 查询讲师详情
	 * 
	 * @author 周化益
	 * @param userId 讲师ID
	 * @return
	 */
	public Map<String, Object> findTeacherInfo(int teacherId, int userId);
	
	/**
	 * 查询用户个人资料
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @return
	 */
	public Map<String, Object> findUserInfo(int userId);
	
	/**
	 * 查询个人关注
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @return
	 */
	public Map<String, Object> myAttention(int userId,int pageNum,int pageSize);
	
	/**
	 * 前台注册
	 * 
	 * @author 周化益
	 * @param user 用户信息
	 * @return
	 */
	public int beforeRegister(User user);
	
	/**
	 * 前台密码修改
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @return
	 */
	public boolean beforeEditPWD(int userId,String oldPwd,String newPwd);
	
	/**
	 * 前台忘了密码
	 * 
	 * @author 周化益
	 * @param userPhone 用户手机号码
	 * @param newPwd 新密码
	 * @return
	 */
	public boolean beforeForgotPWD(String userPhone,String newPwd);
	
	/**
	 * 添加关注信息
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @param teacherId 老师ID
	 * @return
	 */
	public boolean addAttention(int userId, int teacherId);
	
	/**
	 * 取消关注
	 * 
	 * @author 周化益
	 * @param attentionId 关注ID
	 * @return
	 */
	public boolean removeAttention(int teacherId, int userId);
	
	/**
	 * 查看是否已关注该老师了
	 * 
	 * @author 周化益
	 * @param teacherId 讲师ID
	 * @param userId 用户ID
	 * @return
	 */
	public boolean validateAttention(int teacherId,int userId);
	
	/**
	 * 验证手机号是否已存在
	 * 
	 * @author 周化益
	 * @param phone 手机号码
	 * @return
	 */
	public boolean validatePhone(String phone);
}
