package com.liveRoom.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveRoom.bean.CommentTable;
import com.liveRoom.service.CommentService;
import com.liveRoom.util.BeanConvertMap;
import com.liveRoom.util.DateStrConvert;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	/**
	 * 获取单条博客信息的所有评论
	 * 
	 * @author 周化益
	 * @param page 起始页
	 * @param rows 每页显示数量
	 * @param blogId 博客ID
	 * @return
	 */
	@RequestMapping("getAllCommentByBId.do")
	@ResponseBody
	public Map<String, Object> getAllCommentByBId(Integer pageNum, Integer pageSize, long blogId) {
		if(pageSize == null) {
			pageNum = 0;
			pageSize = 0;
		}
		return commentService.getAllCommentByBId(pageNum, pageSize, blogId);
	}
	
	/**
	 * 获取单条博客信息的所有评论
	 * 
	 * @author 周化益
	 * @param page 起始页
	 * @param rows 每页显示数量
	 * @param blogId 博客ID
	 * @return
	 */
	@RequestMapping("getUserComment.do")
	@ResponseBody
	public Map<String, Object> getAllCommentByBId(Integer pageNum, Integer pageSize, 
			long blogId, long userId, long teacherId) {
		if(pageSize == null) {
			pageNum = 0;
			pageSize = 0;
		}
		return commentService.searchCommentById(pageNum, pageSize, blogId, userId,teacherId);
	}
	
	/**
	 * 添加评论
	 * 
	 * @author 周化益
	 * @param comment 评论信息
	 * @return 评论信息的主键
	 */
	@RequestMapping("addTeacherComment.do")
	@ResponseBody
	public Map<String,Object> addComment(int userId, String content, int blogId,Integer reply) {
		CommentTable comment = new CommentTable();
		comment.setUserid(userId);
		byte[] temp;
		String newStr = "";
		try {
			temp = content.getBytes("ISO8859-1");
			newStr=new String(temp,"utf-8");//这里写转换后的编码方式
			comment.setContent(newStr);
		} catch (UnsupportedEncodingException e) {
			newStr = content;
			e.printStackTrace();
		}//这里写原编码方式
		comment.setBlogid(blogId);
		comment.setCommenttime(new Date());
		if(reply != null && reply > 0) {
			comment.setReply(reply);
		}
		commentService.insertSelective(comment);
		Map<String, Object> commentMap = BeanConvertMap.convertBean(comment);
		commentMap.put("commenttime",DateStrConvert.dateToStr((Date)commentMap.get("commenttime"), "yyyy-MM-dd HH:mm:ss"));
		return commentMap;
	}
	
	/**
	 * 删除评论
	 * 
	 * @author 周化益
	 * @param commentId 评论ID
	 * @return
	 */
	@RequestMapping("deleteComment.do")
	@ResponseBody
	public String deleteComment(Long commentId) {
		String result = "fail";
		if(commentId != null && commentId > 0) {
			if(commentService.deleteComment(commentId)) {
				result = "success";
			}
		}
		return result;
	}
}
