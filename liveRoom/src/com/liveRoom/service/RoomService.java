package com.liveRoom.service;

import java.util.List;
import java.util.Map;

public interface RoomService {
	/**
	 * 添加房间
	 * 
	 * @author 周化益
	 * @param roomMap 添加的数据
	 * @return
	 */
	public boolean addRoom(Map<String, Object> roomMap);
	
	/**
	 * 删除多个房间
	 * 
	 * @author 周化益
	 * @param roomIds 房间ID集合
	 * @return
	 */
	public boolean deleteRooms(String roomIds,int roomstate);
	
	/**
	 * 删除单个房间
	 * （修改房间的状态 update hj）
	 * 
	 * @author 周化益
	 * @param roomId 房间ID
	 * @param roomstate 所需修改的状态
	 * @return
	 */
	public boolean deleteRoom(long roomId,int roomstate);
	
	/**
	 * 修改房间
	 * 
	 * @author 周化益
	 * @param roomMap 修改的数据
	 * @return
	 */
	public boolean updateRoom(Map<String, Object> roomMap);
	
	/**
	 * 查询分页房间列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> roomList(int pageNum, int pageSize, String whereSql, Map<String, Object> orderBy);
	
	/**
	 * 查询所有房间ID与房间名称
	 * 
	 * @author 周化益
	 * @return
	 */
	public List<Map<String, Object>> roomObjList();
	
	/**
	 * 根据ID查询单个房间信息
	 * @author hj
	 * @return
	 */
	public Map<String ,Object> roomOne(String roomOneSql);
	/**
	 * 验证房间名是否存在
	 * @param whereSql 判断房间名的条件
	 * @return
	 */
	public long VerificationRoomName(String whereSql);
	/**
	 * 分页查询房间信息
	 * @param sql sql语句
	 * @param pageNum 当前页
	 * @param pageSize 每页显示条数
	 * @param whereSql 条件
	 * @param orderBy 排序方式
	 * @return
	 */
	public Map<String,Object> roomPageList(String sql,String countSql,int pageNum, int pageSize, String whereSql, Map<String,Object> orderBy);
	
	/**
	 * 查询所有房间ID与房间名称
	 * 
	 * @author 周化益
	 * @return
	 */
	public List<Map<String, Object>> roomNameList();
	
	/**
	 * 获取投资者教育所有房间
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的数量
	 * @return
	 */
	public Map<String, Object> beforeRoomList(int pageNum, int pageSize);
	
	/**
	 * 向房间用户表中添加信息
	 * @param sql
	 * @return
	 */
	public boolean addUserlevel(String sql);
	
	/**
	 * 修改房间中用户的信息
	 * @param sql
	 * @return
	 */
	public boolean updateRoommember(String sql);
}
