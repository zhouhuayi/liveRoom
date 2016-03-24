package com.liveRoom.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;










import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.liveRoom.bean.Room;
import com.liveRoom.bean.Room_user_list;
import com.liveRoom.bean.User;
import com.liveRoom.service.RoleService;
import com.liveRoom.service.RoomService;
import com.liveRoom.service.UserService;
import com.liveRoom.service.UserlevelService;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.MapAction;
import com.liveRoom.util.UtilController;

@Controller
public class RoomControoller {
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserlevelService userlevelService;
	
	@Autowired
	private UserService userservice;

//	@Autowired
//	private RoomTypeService roomtypeservice;
	public String sql="select distinct r.* ,rt.*,u.* from room r,roomtype rt,user u ";
	public String countsql="select count(*) from room r,roomtype rt,user u";
	
	@RequestMapping("**/roleSelectList.do")
	@ResponseBody
	public List<Map<String, Object>> getRoleSelectList(HttpServletRequest request) {
		return roleService.roleObjList();
	}
	
	/**
	 * 分页查询所有房间
	 * time 2015年10月14日 15:34:26
	 * pageNum 跳转页面
	 * pageSize 每页显示条数
	 * whereSql 搜索条件
	 * orderBy 排序
	 */
	@RequestMapping("**/roomlistAction.do")
	@ResponseBody
//	public Map<String, Object> RoomSelectInformation(int pageNum,int pageSize, String whereSql,MapAction mapVo, HttpServletRequest request){
	public Map<String, Object> RoomSelectInformation(int pageNum,int pageSize,Map<String,Object> orderBy, HttpServletRequest request){
		System.out.println("==========================获取所有房间============================");
		Map<String, Object> user = UtilController.getUserByRequest(request);
//		System.out.println("当前页："+pageNum+" 每页显示条数："+pageSize+"	查询条件："+whereSql+"	排序"+orderBy);
		orderBy.put("r.room_id", "");//排序方式
		int roleId=(Integer) user.get("user_role");//用户的角色类型id
		int userid=(Integer) user.get("user_id");//用户id
		
		Map<String,Object> maprole=roleService.roleObjOne(roleId);//查询角色信息
//		System.out.println("获取所对应的角色信息："+maprole);
		String keSet=maprole.get("role_identity").toString();  
//        System.out.println("获取到的角色类型："+keSet);
		StringBuffer whereSql=new StringBuffer();
			if(keSet.equals("ZGLY")){
				whereSql.append(" where r.room_type=rt.roomtype_id and r.room_user=u.user_id");
			}else if(keSet.equals("FJGLY")){
				whereSql.append(" where u.user_id="+userid+" and u.user_id=r.room_user and r.room_type=rt.roomtype_id");
			}else if(keSet.equals("LS")){
				whereSql.append(" where u.user_id="+userid+" and u.user_id=r.room_user and r.room_type=rt.roomtype_id");
			}else if(keSet.equals("ZL")){
				whereSql.append(" where u.user_id="+userid+" and u.user_id=r.3room_user and r.room_type=rt.roomtype_id");
			}else{
				whereSql.append(" where u.user_id="+userid+" and u.user_id=r.room_user and r.room_type=rt.roomtype_id");
			}
		/**
		 * 获取用户的角色
		 * 根据角色不同来获取不同的房间信息
		 */
		Map<String,Object> map=new HashMap<String,Object>();
		map=roomService.roomPageList(sql,countsql,pageNum, pageSize, whereSql.toString(), null);
		map.put("userType", user.get("user_role"));
		return map;
	}
	
	/**
	 * 查询单个房间 
	 * time 2015年10月20日 15:58:25
	 * roomID 所要查询的房间ID
	 */
	@RequestMapping("**/roomoneAction.do")
	@ResponseBody
	public Map<String, Object> RoomSelectOneInformation(int roomID){//String whereSql){
		System.out.println("==========================获取单个房间============================");
		
		String roomOneSql="select distinct R.* ,RT.*,U.* from room R,roomtype RT,user U  where R.room_id="+roomID+" and  R.room_type=RT.roomtype_id and R.room_user=U.user_id ";
		Map<String,Object> map=roomService.roomOne(roomOneSql);
		System.out.println(map);
		return map;
	}
	/**
	 * 删除单个房间(未链表 room)
	 * @time 2015年10月21日 10:39:31
	 * roomID 所要删除的房间ID
	 * 修改房间的room_state为1
	 * 房间模式：默认为关闭 0 开启分为三种情况  1:开放   2:会员   3:密码(默认开启为1:开放)
	 */
	@RequestMapping("**/roomdeloneAction.do")
	@ResponseBody
	public Map<String,Object> roomdeloneAction(long roomId,int roomstate){
		System.out.println("==========================删除单个房间============================");
//		System.out.println("所要删除的房间ID"+roomId);
		boolean delOne = roomService.deleteRoom(roomId,roomstate);
		Map<String,Object> map=new HashMap<String,Object>();
		if(delOne){
			//删除成功
			map=roomService.roomPageList(sql,countsql,1, 10," where r.room_type=rt.roomtype_id and r.room_user=u.user_id", null);
			map.put("userType", "1");
			map.put("Result", "Success");
			System.out.println("删除成功时的数据："+map);
		}else{
			//删除失败
			map.put("Result", "Failure");
			System.out.println("删除失败时的数据："+map);
		}
		return map;
	}
	/**
	 * 删除多个房间(未链表 room)
	 * @time 2015年10月21日 10:39:31
	 * roomID 所要删除的房间ID
	 * 修改房间的room_state为1
	 */
	@RequestMapping("**/roomdellistAction.do")
	@ResponseBody
	public Map<String,Object> roomdellistAction(String roomId,int roomstate){
		System.out.println("==========================删除多个房间============================");
//		System.out.println("所要删除的房间ID"+roomId);
		boolean delOne = roomService.deleteRooms(roomId,roomstate);
		Map<String,Object> map=new HashMap<String,Object>();
		if(delOne){
			//删除成功
			map=roomService.roomPageList(sql,countsql,1, 10, " where r.room_type=rt.roomtype_id and r.room_user=u.user_id", null);
			map.put("userType", "1");
			map.put("Result", "Success");
			System.out.println("删除成功时的数据："+map);
		}else{
			//删除失败
			map.put("Result", "Failure");
			System.out.println("删除失败时的数据："+map);
		}
		return map;
	}
	
	/**
	 * 查询所有房间类型(未链表 roomtype)
	 * @return
	 */
	@RequestMapping("**/roomtypeAction.do")
	@ResponseBody
	public List<Map<String,Object>> getAllRoomtype(){
		System.out.println("=========================查询所有房间类型==========================");
		List<Map<String,Object>> mapallroom=roomService.roomObjList();
		System.out.println(mapallroom);
		return mapallroom;
	}
	/**
	 * 查询所有房管(链表user role)
	 * @return
	 */
	@RequestMapping("**/usertypeAction.do")
	@ResponseBody
	public List<Map<String,Object>> getAllUsername(String roomuser){
		System.out.println("=====================查询所有房管==================");
		String sql="select u.user_id,u.user_name from user u,role r where r.role_identity='"+roomuser+"' and r.role_id=u.user_role";
		List<Map<String,Object>> map=userservice.getAllListUser(sql);
//		System.out.println(map);
		return map;
	}
	/**
	 * 验证房间名是否存在
	 * @param roomname
	 * @return
	 */
	@RequestMapping("**/roomnameAction.do")
	@ResponseBody
	public long getVerificationRoomName(String roomname){
		System.out.println("====================验证房间名是否存在==================");
		long roomnumber=roomService.VerificationRoomName(" where room_name='"+roomname+"'");
		return roomnumber;
	}
	/**
	 * 添加最基本的房间(未链表 room)
	 * @author hj
	 * @time 2015年10月14日 15:34:26
	 * roomname 房间名字
	 * roomuser 房间所属人的ID
	 * roomtype 房间类型的ID
	 */
	@RequestMapping("**/roomInitialAction.do")
	@ResponseBody
	public Map<String,Object> RoomAddInformation(Room room,HttpServletRequest request){
		System.out.println("====================================总管理员进行添加房间=========================================");
		Map<String,Object> maplist=new HashMap<String,Object>();
		Map<String,Object> map= new HashMap<String, Object>();
		map.put("room_name", room.getRoom_name());
		map.put("room_user", room.getRoom_user());
		map.put("room_type", room.getRoom_type());
		map.put("room_createDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		map.put("path", request.getSession().getServletContext().getRealPath(""));
		boolean tf = roomService.addRoom(map);
		if(tf){
			//添加成功
			Map<String,Object> orderBy=new HashMap<String,Object>();
			orderBy.put("r.room_id", "");//排序方式
			String whereSql=" where r.room_type=rt.roomtype_id and r.room_user=u.user_id";
			maplist=roomService.roomPageList(sql,countsql,1, 10, whereSql, orderBy);
			maplist.put("userType", "1");//显示管理者的权限
			maplist.put("Result", "Success");
			System.out.println("添加成功时的数据："+map);
		}else{
			//添加失败
			maplist.put("Result", "Failure");
			System.out.println("添加失败时的数据："+map);
		}
		return maplist;
	}
	
	/**
	 * 修改房间信息
	 * @author hj
	 * @time 2015年10月21日 14:54:21
	 * 
	 */
	@RequestMapping("**/roomUpdateAction.do")
	@ResponseBody
	public boolean roomUpdateAction(MapAction mapVo,HttpServletRequest request){
		System.out.println("====================================房管对房间信息进行完善========================================");
		Map<String, Object> registerIP=mapVo.getMapVo();
		Long nowRoomId = Long.parseLong(registerIP.get("room_id").toString());
		String user_path = registerIP.remove("room_path").toString();
		if(registerIP.get("room_logo") != null) {
			String path = CommonUtil.readFilePath(Room.class, nowRoomId, registerIP.get("room_logo").toString());
			System.out.println("房间的Logo："+path);
			registerIP.put("room_logo", path);
			CommonUtil.clearFile(user_path);
		}
//		System.out.println("这是房间的简介："+registerIP.get("room_heat"));
		boolean tf = roomService.updateRoom(registerIP);
		System.out.println("修改的结果是："+tf);
		Map<String,Object> maplist=new HashMap<String,Object>();
		if(tf){
			//修改成功
			Map<String, Object> user = UtilController.getUserByRequest(request);
			int userid=(Integer) user.get("user_id");//用户id
			String whereSql=" where u.user_id="+userid+" and u.user_id=r.room_user and r.room_type=rt.roomtype_id";
			maplist=roomService.roomPageList(sql,countsql,1, 10, whereSql, null);
			maplist.put("userType", user.get("user_role"));
			System.out.println("修改成功时的数据："+maplist);
		}else{
			//修改失败
			maplist.put("Result", "Failure");
			System.out.println("修改失败时的数据："+maplist);
		}
		return tf;
	}
	/**
	 * 上传房间Logo
	 * 
	 * @author hj
	 * @param fileData 图片文件
	 * @param fileName 图片文件名
	 * @param roomId 房间ID
	 * @return
	 */
	@RequestMapping("**/uploadroomhead.do")
	@ResponseBody
	public boolean uploadRoomHead(MultipartFile fileData, String fileName, int roomId) {
		System.out.println(fileData);
		System.out.println(fileName);
		System.out.println(roomId);
		try {
			CommonUtil.upLoadPath(Room.class,roomId, fileData.getInputStream(), fileName,false);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 模糊查询（所有管理）
	 * @param room
	 * @return
	 */
	@RequestMapping("**/getroomsearch.do")
	@ResponseBody
	public Object getRoomSearch(Room room, HttpServletRequest request){
		StringBuffer whereSql=new StringBuffer();
		
		String roomname = "",roomuser = "",roomtype = "";
		//模糊查询的条件
		if(room.getRoom_name()!=""){
			roomname=" and r.room_name LIKE '%"+room.getRoom_name()+"%'";
		}
		if(room.getRoom_user()!=0){
			roomuser=" and r.room_user="+room.getRoom_user();
		}
		if(room.getRoom_type()!=0){
			roomtype=" and r.room_type="+room.getRoom_type();
		}
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> user = UtilController.getUserByRequest(request);
		int roleId=(Integer) user.get("user_role");//用户的角色类型id
		int userid=(Integer) user.get("user_id");//用户id
		Map<String,Object> maprole=roleService.roleObjOne(roleId);//查询角色信息
		String keSet=maprole.get("role_identity").toString();
		if(keSet.equals("ZGLY")){
			whereSql.append(" where r.room_type=rt.roomtype_id and r.room_user=u.user_id").append(roomname).append(roomuser).append(roomtype);
		}else if(keSet.equals("FJGLY")){
			whereSql.append(" where u.user_id="+userid).append(" and r.room_type=rt.roomtype_id and r.room_user=u.user_id").append(roomname).append(roomuser).append(roomtype);
		}else if(keSet.equals("LS")){
			whereSql.append(" where u.user_id="+userid).append(" and r.room_type=rt.roomtype_id and r.room_user=u.user_id").append(roomname).append(roomuser).append(roomtype);
		}else if(keSet.equals("ZL")){
			whereSql.append(" where u.user_id="+userid).append(" and r.room_type=rt.roomtype_id and r.room_user=u.user_id").append(roomname).append(roomuser).append(roomtype);
		}else{
			whereSql.append(" where u.user_id="+userid).append(" and r.room_type=rt.roomtype_id and r.room_user=u.user_id").append(roomname).append(roomuser).append(roomtype);
		}
		map=roomService.roomPageList(sql,countsql,1, 10, whereSql.toString(), null);
		map.put("userType", user.get("user_role"));
//		System.out.println("模糊查询的返回数据："+map);
//		System.out.println("模糊查询条件："+whereSql.toString());
		return map;
	}
	
	 /**
	  * 获取房间中的所有角色
	  */
	@RequestMapping("**/roomuserSelectList.do")
	@ResponseBody
	public List<Map<String, Object>> roomUserList(int roomId) {
		return userlevelService.selUserlevel(roomId);
	}
	
	/**
	 * 修改房间中的用户角色
	 * @param roommembers
	 * @return
	 */
	@RequestMapping("**/roomuserUpdate.do")
	@ResponseBody
	public boolean getRoommembers(Room_user_list rul){
//		System.out.println("进入准备取值："+rul);
//		
//		System.out.println("角色ID："+rul.getGrade());
//		System.out.println("房间ID："+rul.getRoom_id());
////		System.out.println("状态："+rul.getRoommembers_State());
//		System.out.println("用户ID："+rul.getUser_id());
		StringBuffer roommembersSql=new StringBuffer();
		roommembersSql.append("UPDATE room_user_list SET  grade=").append(rul.getGrade())
		.append("  WHERE user_id=").append(rul.getUser_id()).append(" and room_id=")
		.append(rul.getRoom_id());
		System.out.println("修改的结果是："+roommembersSql.toString());
		return roomService.updateRoommember(roommembersSql.toString());
	}
	
	/**
	 * 获取投资者教育所有房间
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的数量
	 * @return
	 */
	@RequestMapping("**/beforeRoomList.do")
	@ResponseBody
	public Map<String, Object> beforeRoomList() {
		return roomService.beforeRoomList(0, 0);
	}
	
	@RequestMapping("roomSelectList.do")
	@ResponseBody
	public List<Map<String, Object>> roomObjList() {
		return roomService.roomNameList();
	}
}
