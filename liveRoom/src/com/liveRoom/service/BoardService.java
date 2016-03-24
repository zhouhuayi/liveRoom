package com.liveRoom.service;

import java.util.Map;

public interface BoardService {
	/**
	 * 添加留言板
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @param text 留言板的内容
	 * @param address 用户所在地址
	 * @return
	 */
	public Map<String, Object> addBard(Long userId, String text, String ip, String address);
	
	/**
	 * 修改留言板
	 * 
	 * @author 周化益
	 * @param mapData 修改的数据
	 * @return
	 */
	public boolean updateBard(Map<String, Object> mapData);
	
	/**
	 * 查询留言板的内容
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示的数据
	 * @param orderBy 排序规则
	 * @param whereSql 查询条件
	 * @return
	 */
	public Map<String, Object> searchBardList(int pageNum, int pageSize, 
			Map<String, Object> orderBy, String whereSql);
	
	/**
	 * 删除单个留言板
	 * 
	 * @author 周化益
	 * @param boardId 留言板ID
	 * @return
	 */
	public boolean deleteBoard(long boardId);
	
	/**
	 * 删除多个留言板
	 * 
	 * @author 周化益
	 * @param boardIds 留言板ID集合
	 * @return
	 */
	public boolean deleteBoards(String boardIds);
	
	/**
	 * 留言板
	 * 
	 * @author 周化益
	 * @param pageNUm 第几页
	 * @param pageSize 每页显示的数据
	 * @return
	 */
	public Map<String, Object> messageBoard(int pageNum, int pageSize);
}