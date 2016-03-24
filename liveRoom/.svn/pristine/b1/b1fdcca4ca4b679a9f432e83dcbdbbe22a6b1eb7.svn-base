package com.liveRoom.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.liveRoom.bean.User;
import com.liveRoom.service.RoomService;
import com.liveRoom.service.UserService;
import com.liveRoom.util.BeanConvertMap;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.MD5Util;
import com.liveRoom.util.MapAction;
import com.liveRoom.util.UtilController;

@Controller
public class UserController {
	@Resource
	private UserService userService;

	@Resource
	private RoomService roomservice;
	
	public static Map<String,Object> phoneMap = new HashMap<String, Object>();
	 
	/**
	 * 用户登录
	 * 
	 * @author 周化益
	 * @param account 账户
	 * @param password 密码
	 * @return
	 */
	@RequestMapping("**/login")
	@ResponseBody
	public int userLogin(String account,String password, HttpServletRequest request) {
		boolean bool = userService.validateAccount(account);
		if(!bool) {
			return 1;
		} else {
			Map<String, Object> userMap = userService.userLogin(account, password,
					UtilController.getIpAddress(request));
			if(userMap != null && userMap.size() > 0) {
				request.getSession().setAttribute("user", userMap);
				return 2;
			} else {
				return 3;
			}
		}
	}
	
	/**
	 * 用户注销
	 * 
	 * @author 周化益
	 * @return
	 */
	@RequestMapping("**/logout")
	@ResponseBody
	public void logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
	}
	
	/**
	 * 用户注册
	 * 
	 * @author 周化益
	 * @param userMap 添加信息
	 * @return
	 */
	@RequestMapping("addUser.do")
	@ResponseBody
	//MultipartFile fileData,String fileName,
	public long addUser(MapAction mapVo,HttpServletRequest request) {
		long userId = 0;
		Map<String, Object> registerIP=mapVo.getMapVo();
		registerIP.put("user_registerIP", UtilController.getIpAddress(request));
		registerIP.put("user_loginIP", UtilController.getIpAddress(request));
		registerIP.put("user_pwd", MD5Util.string2MD5(registerIP.get("user_pwd").toString()));
		Long nowUserId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
		if(registerIP.get("user_head") == null || registerIP.get("user_head").equals("")) {
			registerIP.put("user_head","image/head.jpg");
		} else {
			registerIP.put("user_head", 
					CommonUtil.readFilePath(User.class, nowUserId, registerIP.get("user_head").toString()));
		}
		if(registerIP.get("user_role") != null && registerIP.get("user_role").equals("")) {
           registerIP.remove("user_role").toString();
		}
		User user = null;
		user = BeanConvertMap.convertMap(User.class, registerIP);
		user.setUser_registerDate(new Date());
		user.setUser_lastTime(new Date());
		user.setUser_source("后台");
		userService.insertSelective(user);
		userId = user.getUser_id();
		return userId;
	}
	/**
	 * 修改信息
	 * 
	 * @author 周化益
	 * @param userMap 修改的信息
	 * @return
	 */
	@RequestMapping("updateUser.do")
	@ResponseBody
	public boolean updateUser(MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> registerIP=mapVo.getMapVo();
		Long nowUserId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
		if(registerIP.get("user_head") != null) {
			String path = CommonUtil.readFilePath(User.class, nowUserId, registerIP.get("user_head").toString());
			registerIP.put("user_head", path);
			String user_path = registerIP.remove("user_path").toString();
			CommonUtil.clearFile(user_path);
		}
		return userService.updateUser(registerIP);
	}
	
	/**
	 * 验证账户是否被注册
	 * 
	 * @author 周化益
	 * @param account 账户
	 * @return
	 */
	@RequestMapping("validateAccount.do")
	@ResponseBody
	public boolean validateAccount(String account) {
		byte[] temp;
		String newStr = "";
		try {
			temp = account.getBytes("ISO8859-1");//这里写原编码方式
			newStr=new String(temp,"utf-8");//这里写转换后的编码方式
		} catch (UnsupportedEncodingException e) {
			newStr = account;
			e.printStackTrace();
		}
		return userService.validateAccount(newStr);
	}
	
	/**
	 * 修改个人信息
	 * 
	 * @author 周化益
	 * @param user 用户信息
	 * @return
	 */
	@RequestMapping("updateOneself.do")
	@ResponseBody
	public boolean updateOneself(MapAction mapVo, HttpServletRequest request) {
		boolean bool = false;
		Map<String, Object> userMap = mapVo.getMapVo();
		Map<String, Object> user = UtilController.getUserByRequest(request);
		bool = userService.updateUser(userMap);
		if(bool) {
			Iterator<String> it = userMap.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				user.put(key.toUpperCase(), userMap.get(key));
			}
			request.getSession().setAttribute("user", user);
		}
		return bool;
	}
	

	/**
	 * 跳转修改页面
	 * 
	 * @author 李琼雅
	 * @param userId 用户ID
	 * @param request
	 * @return
	 */
	@RequestMapping("openUserEdit.do")
	public String updateUsers(int userId, HttpServletRequest request) {
		request.setAttribute("user",userService.getUserById(userId));
		return "userEdit";
	}
	
	/**
	 * 跳转修改页面
	 * 
	 * @author 李琼雅
	 * @param userId 用户ID
	 * @param request
	 * @return
	 */
	@RequestMapping("openUserEdit1.do")
	public String updateUsers1(int userId, HttpServletRequest request) {
		request.setAttribute("user",userService.getUserById(userId));
		return "userEdit1";
	}
	
	/**
	 * 修改密码
	 * 
	 * @author 周化益
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @return
	 */
	@RequestMapping("updatePwd.do")
	@ResponseBody
	public int updatePwd(String oldPwd,String newPwd, HttpServletRequest request) {
		boolean bool = false;
		int result = 0;
		Map<String,Object> userMap = UtilController.getUserByRequest(request);
		bool = MD5Util.string2MD5(oldPwd).equals(userMap.get("user_pwd").toString());
		if(bool) {
			result = 1;
			if(userService.updatePwd(Integer.parseInt(userMap.get("user_id").toString()), 
					MD5Util.string2MD5(newPwd))) {
				result = 2;
			};
		} 
		return result;
	}
	
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
	@RequestMapping("getAllUser.do")
	@ResponseBody
	public Map<String, Object> getAllUser(int pageNum, int pageSize,int roles,int state,int user_teacher,
			Integer teacher, String whereSql, MapAction mapVo,HttpServletRequest request) {
		System.out.println(roles);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_teacher", user_teacher);
		params.put("teacher", teacher);
		if(whereSql != null && !whereSql.equals("")) {
			params.put("search",whereSql);
		}
		if(roles>0) {
			params.put("roles",roles);
		}
		if(state<6)
		{
			params.put("state", state);
		}
		return userService.getAllUser(pageNum,pageSize,params,mapVo.getMapVo(),whereSql);
	}
	
	/**
	 * 跳转详情页面
	 * 
	 * @author 李琼雅
	 * @param userId 用户ID
	 * @param request
	 * @return
	 */
	@RequestMapping("openUserDetails.do")
	public String getAllUsers(int userId,HttpServletRequest request) {
		request.setAttribute("user",userService.getAllUsers(userId));
		return "userDetails";
	}
	
	/**
	 * 单条删除
	 * @author 周化益
	 * @param userId 用户ID
	 * @return
	 */
	public boolean deleteUser(long userId) {
		return userService.deleteUser(userId);
	}
	
	/**
	 * 多条删除
	 * 
	 * @author 周化益
	 * @param userIds 用户ID集合
	 * @return
	 */
	public boolean deletesUser(String userIds) {
		return userService.deletesUser(userIds);
	}
	
	/**
	 * 修改单条状态
	 * 
	 * @author 李琼雅
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping("deleteUser.do")
	@ResponseBody
	public boolean updateState(long userId) {
		return userService.updateState(userId);
	}
	
	/**
	 * 修改多条状态
	 * 
	 * @author 李琼雅
	 * @param userIds 用户ID集合
	 * @return
	 */
	@RequestMapping("deletesUser.do")
	@ResponseBody
	public boolean updatesState(String userIds) {
		return userService.updatesState(userIds);
	}
	
	/**
	 * 还原单个用户
	 * 
	 * @author 李琼雅
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping("restoreUser.do")
	@ResponseBody
	public boolean restoreState(long userId) {
		return userService.restoreState(userId);
	}
	
	/**
	 * 还原多个用户
	 * 
	 * @author 李琼雅
	 * @param userIds 用户ID集合
	 * @return
	 */
	@RequestMapping("restoresUser.do")
	@ResponseBody
	public boolean restoresState(String userIds) {
		return userService.restoresState(userIds);
	}
	
	/**
	 * 上传头像
	 * 
	 * @author 李琼雅
	 * @param fileData 图片文件
	 * @param fileName 图片文件名
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping("**/uploaduserhead.do")
	@ResponseBody
	public boolean uploadUserHead(MultipartFile fileData, String fileName, int userId,HttpServletRequest request) {
		try {
			CommonUtil.upLoadPath(User.class,userId, fileData.getInputStream(), fileName,false);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false; 
		}
	}
	
	
	/**
	 * 条件查询用户信息（链表）
	 * @author hj
	 * whereSql 所要查询的条件
	 */
	@RequestMapping("getAllListUser.do")
	@ResponseBody
	public List<Map<String,Object>> getAllListUser(String whereSql){
		List<Map<String,Object>> mapuser=userService.getAllListUser(whereSql);
		return mapuser;
	}
	/**
	 * 获取房间中所有的用户
	 * @param roomID 房间ID
	 * @author hj
	 * @return
	 */
	@RequestMapping("**/getRoomUserList.do")
	@ResponseBody
	public Map<String,Object> getRoomUserList(int roomID,int pageNum,int pageSize){
//		String sql="select * from roommembers rm,room r,user u,room_user_grade rug where r.room_id="+roomID+" and rm.roommembers_roomid=r.room_id and rm.roommembers_userid=u.user_id and rm.roommembers_roleid=rug.id";
//		String sqlcount="select count(*) from roommembers rm where rm.roommembers_roomid="+roomID;
		
		String sql="select * from room_user_list rm,room r,user u,room_user_grade rug where r.room_id="+roomID+" and rm.room_id=r.room_id and rm.user_id=u.user_id and rm.grade=rug.id";
		String sqlcount="select count(*) from room_user_list rm where rm.room_id="+roomID;
		Map<String,Object> map=roomservice.roomPageList(sql, sqlcount, pageNum, pageSize, "", null);
		System.out.println("获取房间信息的："+map);
		return map;
	}
	/**
	 * 获取单条用户信息
	 * @param userId
	 * @param roomId
	 * @author hj
	 * @return
	 */
	@RequestMapping("**/getUserOne.do")
	@ResponseBody
	public Map<String,Object> getUserOne(int userId,int roomId){
		System.out.println("用户ID："+userId+" 所属房间ID："+roomId);
		StringBuffer sql = new StringBuffer();
		sql.append("select * from room_user_list rm,room r,user u,room_user_grade rug where r.room_id=").append(roomId)
		.append(" and u.user_id=").append(userId)
		.append(" and rm.room_id=r.room_id and rm.user_id=u.user_id and rm.grade=rug.id");
		Map<String,Object> map=userService.getUserById(sql.toString());
		System.out.println("单条用户信息："+map);
		return map;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("getAllTeacher.do")
	@ResponseBody
	public Map<String, Object> getAllTeacher(int page, int rows, String params) {
		return userService.getAllTeacher(page, rows, params, null);
	}
	
	/*================================接口处================================*/
	/**
	 * 获取所有讲师
	 * 
	 * @author 周化益
	 * @param userId 当前登陆用户ID
	 * @return
	 */
	@RequestMapping("getTeachers.do")
	@ResponseBody
	public Map<String, Object> getTeacher(Integer pageNum, Integer pageSize, int teacherId) {
		if(pageSize == null) {
			pageNum = 0;
			pageSize = 0;
		}
		return userService.getTeachers(pageNum, pageSize,teacherId);
	}
	
	/**
	 * 获取讲师详情
	 * 
	 * @author 周化益
	 * @return
	 */
	@RequestMapping("findTeacherInfo.do")
	@ResponseBody
	public Map<String, Object> findTeacherInfo(int teacherId, int userId) {
		return userService.findTeacherInfo(teacherId,userId);
	}
	
	/**
	 * 获取用户详情
	 * 
	 * @author 周化益
	 * @return
	 */
	@RequestMapping("findUserInfo.do")
	@ResponseBody
	public Map<String, Object> findUserInfo(int userId) {
		return userService.findUserInfo(userId);
	}
	
	/**
	 * 查询个人关注
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping("myAttention.do")
	@ResponseBody
	public Map<String, Object> myAttention(int userId) {
		return userService.myAttention(userId, 0, 0);
	}
	
	/**
	 * 移动端注册
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("befoerRegister.do")
	@ResponseBody
	public Map<String,Object> beforeRegister(String phone, String pwd, String code,
			String enterpassword, HttpServletRequest request) {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("type", "failure");
		if(!phoneMap.get(phone).toString().equals(code.toString())){
			message.put("message", "验证码错误");
		} else {
			if(!pwd.equals(enterpassword)) {
				message.put("message", "注册两次密码不一致");
			} else {
				if(userService.validatePhone(phone)) {
					message.put("message", "手机号已被注册");
				} else {
					User user = new User();
					user.setUser_phone(phone);
					user.setUser_account(phone);
					user.setUser_pwd(MD5Util.string2MD5(pwd));
					user.setUser_registerDate(new Date());
					user.setUser_registerIP(UtilController.getIpAddress(request));
					user.setUser_lastTime(new Date());
					user.setUser_source("手机端");
					user.setUser_head("image/head.jpg");
					int state = userService.beforeRegister(user);
					if(state > 0) {
						Map<String, Object> map = new HashMap<String,Object>();
						map = BeanConvertMap.convertBean(user);
						message.put("user", map);
						message.put("type", "success");
						message.put("message", "注册成功");
					} else {
						message.put("message", "注册失败");
					}
				}
			}
		}
		return message;
	}
	
	/**
	 * 手机端密码修改
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @param oldPwd 用户旧密码
	 * @param newPwd 用户新密码
	 * @return
	 */
	@RequestMapping("beforeEditPWD.do")
	@ResponseBody
	public int beforeEditPWD(int userId, String oldPwd, String newPwd, String enterpassword,HttpServletRequest request) {
		if(!newPwd.equals(enterpassword)) {
			return 1;
		} else if (userService.beforeEditPWD(userId, oldPwd, newPwd)) {
			return 3;
		} else {
			return 2;
		}
	}
	
	/**
	 * 前台忘了密码
	 * 
	 * @author 周化益
	 * @param phone 用户手机号码
	 * @param pwd 新密码
	 * @return
	 */
	@RequestMapping("beforeForgotPWD.do")
	@ResponseBody
	public Map<String, Object> beforeForgotPWD(String phone,String pwd, String code,
			String enterpassword,HttpServletRequest request) {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("type", "failure");
		
		if(!phoneMap.get(phone).toString().equals(code.toString())){
			message.put("message", "验证码错误");
		} else if(!pwd.equals(enterpassword)) {
			message.put("message", "两次密码不一致");
		} else if ( userService.beforeForgotPWD(phone, pwd)) {
			message.put("type", "success");
			message.put("message", "找回成功");
		} else {
			message.put("message", "改手机号未注册");
		}
		return message;
	}
	
	/**
	 * 添加关注信息
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @param teacherId 老师ID
	 * @return
	 */
	@RequestMapping("addAttention.do")
	@ResponseBody
	public boolean addAttention(int userId, int teacherId) {
		return userService.addAttention(userId, teacherId);
	}
	
	/**
	 * 取消关注
	 * 
	 * @author 周化益
	 * @param attentionId 关注ID
	 * @return
	 */
	@RequestMapping("removeAttention.do")
	@ResponseBody
	public boolean removeAttention(Integer teacherId, Integer userId) {
		return userService.removeAttention(teacherId, userId);
	}
	
	/**
	 * 查看是否已关注该老师了
	 * 
	 * @author 周化益
	 * @param teacherId 讲师ID
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping("validateAttention.do")
	@ResponseBody
	public int validateAttention(int teacherId,int userId) {
		return userService.validateAttention(teacherId, userId) ? 1 : 0;
	}
	
	/**
	 * 手机端修改个人信息
	 * 
	 * @author 周化益
	 * @param userId
	 * @param userName
	 * @param realName
	 * @param phone
	 * @param oldHead
	 * @param sex
	 * @param address
	 * @param suffex
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("editInfo.do")
	@ResponseBody
	public boolean editInfo(Integer userId,String userName,String realName,String phone,
			String introduction,Integer sex,String address, HttpServletRequest request) {
		Map<String, Object> userMap = new HashMap<String,Object>();
		byte[] temp;
		String newStr = "";
		
		if(userName != null && !userName.equals("")) {
			try {
				temp = userName.getBytes("ISO8859-1");//这里写原编码方式
				newStr=new String(temp,"utf-8");//这里写转换后的编码方式
			} catch (UnsupportedEncodingException e) {
				newStr = userName;
				e.printStackTrace();
			}
			userMap.put("user_Name", newStr);
		} 
		if(realName != null && !realName.equals("")) {
			try {
				temp = realName.getBytes("ISO8859-1");//这里写原编码方式
				newStr=new String(temp,"utf-8");//这里写转换后的编码方式
			} catch (UnsupportedEncodingException e) {
				newStr = realName;
				e.printStackTrace();
			}
			userMap.put("user_realName", newStr);
		} 
		
		if(introduction != null && !introduction.equals("")) {
			try {
				temp = introduction.getBytes("ISO8859-1");//这里写原编码方式
				newStr=new String(temp,"utf-8");//这里写转换后的编码方式
			} catch (UnsupportedEncodingException e) {
				newStr = introduction;
				e.printStackTrace();
			}
			userMap.put("user_introduction", newStr);
		} 
		
 		if(phone != null && !phone.equals("")) {
			userMap.put("user_phone", phone);
		} 
 		if(sex != null) {
			userMap.put("user_sex", sex);
		} 
 		if(address != null && !address.equals("")) {
			try {
				temp = address.getBytes("ISO8859-1");//这里写原编码方式
				newStr=new String(temp,"utf-8");//这里写转换后的编码方式
			} catch (UnsupportedEncodingException e) {
				newStr = address;
				e.printStackTrace();
			}
			userMap.put("user_address", newStr);
		} 
 		if(userId != null && !userId.equals("")) {
			userMap.put("user_id", userId);
		} 
		return userService.updateUser(userMap);
	}
	
	@RequestMapping("uploadHead.do")
	@ResponseBody
	public boolean uploadHead(MultipartFile file, String suffex, int userId,String oldHead, HttpServletRequest request) {
		if(suffex != null && !suffex.equals("")) {
			Date date = new Date();
			try {
				System.out.println("上传头像");
				Map<String, Object> userMap = new HashMap<String, Object>();
				CommonUtil.upLoadPath(User.class, userId, file.getInputStream(), date.getTime()+suffex, false);
				userMap.put("user_head", CommonUtil.readFilePath(User.class, userId, date.getTime()+suffex));
				userMap.put("user_id", userId);
				userService.updateUser(userMap);
				if(oldHead != null && !oldHead.equals("")) {
		 			CommonUtil.clearFile(CommonUtil.readFilePath(User.class, userId, oldHead));
		 		}
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	
	/**
	 * 查封用户
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping("stopUser.do")
	@ResponseBody
	public String stopUser(Long userId) {
		String result = "fail";
		if(userId != null && userId > 0) {
			Map<String, Object> userMap = new HashMap<String, Object>();
			userMap.put("user_state", 2);
			userMap.put("user_id", userId);
			if(userService.updateUser(userMap)) {
				result = "success";
			}
		}
		return result;
	}
}
