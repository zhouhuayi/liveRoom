package com.liveRoom.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liveRoom.dao.CommonDao;
import com.liveRoom.service.AttentionNewsTableService;
import com.liveRoom.service.CommentService;
import com.liveRoom.service.RoleService;
import com.liveRoom.service.RoomService;
import com.liveRoom.service.UserService;
import com.liveRoom.service.VideoCommentsService;
import com.liveRoom.service.VideoService;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = "classpath:com/liveRoom/config/spring-mybatis.xml")
public class testUser {
	@Resource
	private RoleService roleService;
	@Resource
	private CommonDao commonDao;
	@Resource
	private RoomService roomService;
	@Resource
	private VideoCommentsService videoCommentsService;
	@Resource
	private VideoService videoService;
	@Resource
	private AttentionNewsTableService attentionNewsTableService; 
	@Resource
	private CommentService commentService;
	@Resource
	private UserService userService;
	
	@Test
	public void test() {
//		String sql = "select v.video_id,v.video_name,v.video_describe,v.video_address,v.video_uploadtime,v.video_type,v.video_plays,v.video_thumbup,u.user_name from video v LEFT JOIN `user` u ON v.video_userid = u.user_id";
//		List<Map<String, Object>> list = commonDao.getMapListClass(sql);
//		String roleSql = "select * from role where role_id = 1";
//		Map<String, Object> roleMap = commonDao.getMapClass(roleSql);
//		System.out.println(roleMap);
//		List<Map<String, Object>> map = commonDao.getMapListClass(sql);
//		System.out.println(map);
//		System.out.println(list.toString());
//		
//		System.out.println(roleService.getRoleById(1));
//		String sql = "select room_id as ROOM_ID,room_name AS ROOM_NAME from room";
//		List<Map<String, Object>> list = roomService.roomNameList();
//		System.out.println(list);
		//videoCommentsService.addVideoComment(1, 1, "测试视频评论");
//		System.out.println(videoCommentsService.getAllCommentByBId(1, 10, 1));
//		add();
		//find();
		//update();
		//find();
//		findAll();
//		String sql = "select user_head from user where user_id = 1";
		//System.out.println(commonDao.getOneValue(sql));
		//System.out.println(videoService.courseAll(1, 10, 1));
//		String insertSql = "insert attentionnewstable(user_id,content,times) values("
//				+ "1,'测试','2015-11-10 12:17:27')";
//		commonDao.add(insertSql);
//		attentionNewsTableService.deleteAttentionNewsTable(3);
		//commentService.deleteComment(4);
//		String result = "fail";
//		Map<String, Object> userMap = new HashMap<String, Object>();
//		userMap.put("user_state", 2);
//		userMap.put("user_id", 6);
//		if(userService.updateUser(userMap)) {
//			result = "success";
//		}
//		System.out.println(result);
		
		//System.out.println(commentService.getAllCommentByBId(0, 4, 1));
//		Map<String, Object> orderBy = new HashMap<String, Object>();
//		orderBy.put("id", "desc");
//		System.out.println(attentionNewsTableService.AttentionNewsTableList(1, 10, "", orderBy));
	}
	
	/**
	 * 添加数测试方法
	 */
	public void add() {
/*		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("user_Account", "admin");
		userMap.put("user_Name", "管理员");
		userMap.put("user_Email", "weilai_zhilu@sina.com");
		userMap.put("user_Password", "123");
		userMap.put("user_RegisterDate", new Date());*/
		try {
			//boolean bool = userService.addUser(userMap);

			//User user = BeanConvertMap.convertMap(User.class, userMap);
//			Role role = new Role();
//			role.setRole_icon("test");
//			role.setRole_name("测试人员");
//			System.out.println(roleService.insert(role));
//			System.out.println(role.getRole_id());
//			role = roleService.selectByPrimaryKey(role.getRole_id());
			
//			if (bool) {
//				System.out.println("添加成功！");
//			} else {
//				System.out.println("添加失败");
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/*	*//**
	 * 查询数测试方法
	 *//*
	public void find() {
		try {
			Map<String, Object> mapData = userService.userLogin("admin", "123");
			System.out.println(mapData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	*//**
	 * 修改数测试方法
	 *//*
	public void update() {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("user_Id", 2);
		userMap.put("user_Account", "scott");
		userMap.put("user_Name", "测试人员");
		userMap.put("user_Email", "weilai_zhilu@sina.com");
		userMap.put("user_Password", "tiger");
		userMap.put("user_registerDate", DateStrConvert.dateToStr(new Date(), "yyyy-MM-dd"));
		try {
			boolean bool = userService.updateUser(userMap);

			if (bool) {
				System.out.println("修改成功！");
			} else {
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findAll() {
		try {
			Map<String, Object> mapData = userService.getAllUser(1, 10, "", null);
			System.out.println(mapData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
