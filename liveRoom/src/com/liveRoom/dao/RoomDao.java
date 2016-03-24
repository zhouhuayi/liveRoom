package com.liveRoom.dao;

import java.util.List;
import java.util.Map;

import com.liveRoom.bean.Room;

public interface RoomDao {
	/**
	 * 添加视频数据
	 * 
	 * @author 周化益
	 * @param video
	 * @return
	 */
	public int insertSelective(Room video);
	
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
	 * 查询所有房间ID于房间名称
	 * 
	 * @author 周化益
	 * @return
	 */
	public List<Map<String, Object>> roomObjList();
	
	/**
	 * 根据ID查询所有房间信息
	 * @author hj
	 * @return
	 */
	public Map<String,Object> selectOne(String roomOneSql);
	/**
	 * 验证房间名是否存在
	 * @param wheresql
	 * @author hj
	 * @return
	 */
	public long VerificationRoomName(String wheresql);
	
	/**
	 * 分页查询房间信息
	 * @param sql sql语句
	 * @param pageNum 当前页
	 * @param pageSize 每页显示条数
	 * @param whereSql 条件
	 * @param orderBy 排序方式
	 * @return
	 */
	public Map<String,Object> roomPageList(String sql, String countSql,int pageNum, int pageSize, String whereSql, Map<String,Object> orderBy);
	/**
	 * 添加房间成员
	 * @param sql 添加的语句
	 * @return
	 */
	public boolean addUserlevel(String sql);
	
	/**
	 * 修改房间成员信息
	 * @param sql
	 * @return
	 */
	public boolean updateRoommember(String sql);
}
