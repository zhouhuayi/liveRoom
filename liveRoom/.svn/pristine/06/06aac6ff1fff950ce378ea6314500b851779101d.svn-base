package com.liveRoom.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	/**
	 * 添加留言
	 * 
	 * @author 周化益
	 * @param userId 用户ID
	 * @param content 用户的内容
	 * @param request
	 * @return
	 */
	@RequestMapping("addBoard.do")
	@ResponseBody
	public Map<String, Object> addBoard(Long userId, String content, HttpServletRequest request) {
		
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		try {
			byte[] byteStr = content.getBytes("ISO8859-1");
			content = new String(byteStr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("类型是UTF-8");
		}
		
		if(address != null && !address.trim().equals("")) {
			try {
				byte[] byteStr = address.getBytes("ISO8859-1");
				address = new String(byteStr, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				System.out.println("类型是UTF-8");
			}
		}
		
		return boardService.addBard(userId, content, phone, address);
	}
	
	/**
	 * 留言列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示额数据
	 * @param search 搜索的条件
	 * @param request
	 * @return
	 */
	@RequestMapping("messageBoard.do")
	@ResponseBody
	public Map<String, Object> messageBoard(int pageNum, int pageSize) {
		return boardService.messageBoard(pageNum ,pageSize);
	}
	
	/**
	 * 留言列表
	 * 
	 * @author 周化益
	 * @param pageNum 第几页
	 * @param pageSize 每页显示额数据
	 * @param search 搜索的条件
	 * @param request
	 * @return
	 */
	@RequestMapping("searchBoardList.do")
	@ResponseBody
	public Map<String, Object> searchBoardList(int pageNum, int pageSize, String whereSql) {
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("id", "desc");
		return boardService.searchBardList(pageNum, pageSize, orderBy, whereSql);
	}
	
	
	/**
	 * 删除单个留言板
	 * 
	 * @author 周化益
	 * @param boardId 留言板ID
	 * @return
	 */
	@RequestMapping("deleteBoard.do")
	@ResponseBody
	public boolean deleteBoard(long boardId) {
		return boardService.deleteBoard(boardId);
	}
	
	/**
	 * 删除多个留言板
	 * 
	 * @author 周化益
	 * @param boardIds 留言板ID集合
	 * @return
	 */
	@RequestMapping("deleteBoards.do")
	@ResponseBody
	public boolean deleteBoards(String boardIds) {
		return boardService.deleteBoards(boardIds);
	}
	
}
