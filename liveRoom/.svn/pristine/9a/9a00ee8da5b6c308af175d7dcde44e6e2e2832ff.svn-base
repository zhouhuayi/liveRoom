package com.liveRoom.service;
import java.util.Map;

public interface RoomMessageService {
	/**
	 * 查询房间公聊信息分页列表
	 * 
	 * @author 李琼雅
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的条数
	 * @param whereSql 查询的条件
	 * @param orderBy 排序的方式
	 * @return
	 */
	public Map<String, Object> roomMessageList(int pageNum, int pageSize,Map<String, Object> params,String whereSql, Map<String, Object> orderBy);

	/**
	 * 修改单条状态
	 * 
	 * @author 李琼雅
	 * @param roomMessageId 聊天记录ID
	 * @return
	 */
	public boolean updateState(long roomMessageId);
	
	/**
	 * 修改多条状态
	 * 
	 * @author 李琼雅
	 * @param roomMessageIds 聊天记录ID集合
	 * @return
	 */
	public boolean updatesState(String roomMessageIds);
}
