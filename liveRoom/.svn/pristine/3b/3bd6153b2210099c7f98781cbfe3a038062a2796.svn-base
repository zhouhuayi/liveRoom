package com.liveRoom.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.service.VideoCommentsService;

@Controller
public class VideoCommentsController {
	@Autowired
	private VideoCommentsService videoCommentsService;
	
	/**
	 * 获取视频的所有评论
	 * 
	 * @author 周化益
	 * @param pageNum 显示第几页
	 * @param pageSize 每页显示的数量
	 * @param videoId 视频的ID
	 * @return
	 */
	@RequestMapping("getVideoComment.do")
	@ResponseBody
	public Map<String, Object> getVideoComment(Integer pageNum, Integer pageSize, int videoId) {
		if(pageSize == null) {
			pageNum = 0;
			pageSize = 0;
		}
		return videoCommentsService.getAllCommentByBId(pageNum, pageSize, videoId);
	}
	
	/**
	 * 获取视频的所有评论
	 * 
	 * @author 周化益
	 * @param pageNum 显示第几页
	 * @param pageSize 每页显示的数量
	 * @param videoId 视频的ID
	 * @return
	 */
	@RequestMapping("getVideoUserComment.do")
	@ResponseBody
	public Map<String, Object> getVideoUserComment(Integer pageNum, Integer pageSize, int videoId, 
			Long teacherId, Long userId) {
		if(pageSize == null) {
			pageNum = 0;
			pageSize = 0;
		}
		System.out.println("cs ");
		return videoCommentsService.getVideoUserComment(pageNum, pageSize, videoId, teacherId, userId);
	}
	
	
	/**
	 * 添加视频评论
	 * 
	 * @author 周化益
	 * @param commentUser 发表评论的人
	 * @param videoId 视频ID
	 * @param content 评论的内容
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("addVideoComment.do")
	@ResponseBody
	public Map<String, Object> addVideoComment(int commentUser, int videoId, String content) {
		byte[] temp;
		String newStr = "";
		try {
			temp = content.getBytes("ISO8859-1");
			newStr=new String(temp,"utf-8");//这里写转换后的编码方式
		} catch (UnsupportedEncodingException e) {
			newStr = content;
			e.printStackTrace();
		}//这里写原编码方式
		return videoCommentsService.addVideoComment(commentUser, videoId, newStr);
	}
}
