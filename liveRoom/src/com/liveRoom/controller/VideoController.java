package com.liveRoom.controller;

import java.io.IOException;
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

import com.liveRoom.bean.Video;
import com.liveRoom.service.CommentService;
import com.liveRoom.service.VideoService;
import com.liveRoom.util.BeanConvertMap;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.FileLoad;
import com.liveRoom.util.MapAction;
import com.liveRoom.util.UtilController;

@Controller
public class VideoController {
	@Autowired
	private VideoService videoService;
	@Autowired
	private CommentService commentService;
	
	/**
	 * 通过分页获取所有视频信息
	 * 
	 * @author 周化益
	 * @param pageNum 显示第几页
	 * @param pageSize 每页显示的数量
	 * @param whereSql 查询的条件
	 * @param mapVo 分页的参数
	 * @param request
	 * @return
	 */
	@RequestMapping("getAllVideo.do")
	@ResponseBody
	public Map<String, Object> videoList(int pageNum, int pageSize,
			String whereSql, MapAction mapVo, HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> orderBy = new HashMap<String, Object>();
		orderBy.put("video_id", "desc");
		params.put("user_id", UtilController.getUserByRequest(request).get("user_id").toString());
		if(whereSql != null && !whereSql.equals("")) {
			params.put("search", whereSql);
		}
		return videoService.videoList(pageNum, pageSize, params, orderBy);
	}
	
	/**
	 * 视频数据添加
	 * 
	 * @author 周化益
	 * @param mapVo 视频数据
	 * @param request
	 * @return
	 */
	@RequestMapping("addVideo.do")
	@ResponseBody
	public String addVideo(MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> videoMap = mapVo.getMapVo();
		Long userId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
		videoMap.put("video_Userid", userId);
		String imagesPath = CommonUtil.readFilePath(Video.class, userId, videoMap.get("video_images").toString());
		/*int suffex =videoPath.lastIndexOf(".");
		videoPath = videoPath.substring(0,suffex) + ".avi";*/
		videoMap.put("video_images",imagesPath);

		videoMap.put("video_playTime", new Date());
		Video video = BeanConvertMap.convertMap(Video.class, videoMap);
		videoService.insertSelective(video);
		return videoMap.get("video_Address").toString();
	}
	
	/**
	 * 视频数据修改
	 * 
	 * @author 周化益
	 * @param mapVo 视频数据
	 * @param request
	 * @return
	 */
	@RequestMapping("editVideo.do")
	@ResponseBody
	public boolean editVideo(MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> videoMap = mapVo.getMapVo();
		Long userId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
		videoMap.put("video_Userid", userId);
		if(videoMap.get("video_images") != null) {
			String videoPath = CommonUtil.readFilePath(Video.class, userId, 
					videoMap.get("video_images").toString());
			/*int suffex =videoPath.lastIndexOf(".");
			videoPath = videoPath.substring(0,suffex) + ".avi";*/
			videoMap.put("video_images",videoPath);
			String video_path = videoMap.remove("video_path").toString();
			CommonUtil.clearFile(video_path);
		}

		return videoService.updateVideo(videoMap);
	}
	
	/**
	 * 跳转修改页面
	 * 
	 * @author 周化益
	 * @param videoId 角色ID
	 * @param request
	 * @return
	 */
	@RequestMapping("openVideoEdit.do")
	public String updateVideo(int videoId, HttpServletRequest request) {
		request.setAttribute("video",videoService.getVideoById(videoId));
		return "editVideo";
	}
	
	/**
	 * 上传视频
	 * 
	 * @author 周化益
	 * @param fileData 视频文件
	 * @param fileName 视频文件名
	 * @param videoId 视频ID
	 * @return
	 */
	@RequestMapping("uploadVideo.do")
	@ResponseBody
	public boolean uploadVideo(MultipartFile fileData, String fileName, int videoId,HttpServletRequest request) {
		try {
			CommonUtil.upLoadPath(Video.class,videoId, fileData.getInputStream(), fileName,true);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除单个视频
	 * 
	 * @param videoId 视频ID集合
	 * @return
	 */
	@RequestMapping("deleteVideo.do")
	@ResponseBody
	public boolean deleteVideo(long videoId) {
		return videoService.deleteVideo(videoId);
	}
	
	/**
	 * 删除多个视频
	 * 
	 * @param videoIds 视频集合
	 * @return
	 */
	@RequestMapping("deleteManyVideo.do")
	@ResponseBody
	public boolean deleteManyVideo(String videoIds) {
		boolean bool = videoService.deleteVideos(videoIds);
		if(bool) {
			bool = FileLoad.deleteFile(Video.class, videoIds);
		}
		return bool;
	}
	
	
	/*================================安卓接口方法================================*/
	
	/**
	 * 视频推荐
	 * 
	 * @param pageSize 显示的条数
	 * @return
	 */
	@RequestMapping("courseCommend.do")
	@ResponseBody
	public Map<String,Object> courseCommend(int pageSize) {
		return videoService.courseCommend(pageSize);
	}
	
	/**
	 * 视频推荐
	 * 
	 * @param pageSize 显示的条数
	 * @return
	 */
	@RequestMapping("indexCourse.do")
	@ResponseBody
	public List<Map<String,Object>> indexCourse() {
		return videoService.indexCourse();
	}
	
	
	/**
	 * 课程与直播视频
	 * 
	 * @param pageSize 显示的条数
	 * @param pageNum 第几页的数据
	 * @param type 播放类型
	 * @return
	 */
	@RequestMapping("courseAll.do")
	@ResponseBody
	public Map<String,Object> courseAll(Integer pageNum, Integer pageSize, int type) {
		if(pageSize == null) {
			pageNum = 0;
			pageSize = 0;
		}
		return videoService.courseAll(pageNum, pageSize, type);
	}
	
	/**
	 * 课程与直播视频
	 * 
	 * @param pageSize 显示的条数
	 * @param pageNum 第几页的数据
	 * @param type 播放类型
	 * @return
	 */
	@RequestMapping("courseAll1.do")
	@ResponseBody
	public Map<String,Object> courseAll1(Integer pageNum, Integer pageSize, int type) {
		if(pageSize == null) {
			pageNum = 0;
			pageSize = 0;
		}
		return videoService.courseAll1(pageNum, pageSize, type);
	}
	
	/**
	 * 更新播放与点赞数量
	 * 
	 * @author 周化益
	 * @param video_plays 播放数量
	 * @return
	 */
	@RequestMapping("updateNumber.do")
	@ResponseBody
	public boolean updateNumber(int video_plays, int video_thumbup, int video_Id) {
		boolean bool = true;
		try {
			videoService.updateNumber(video_plays, video_thumbup, video_Id);
		} catch (Exception e) {
			bool = false;
			e.printStackTrace();
		}
		return bool;
	}
	
	/**
	 * 查看视频详情
	 * 
	 * @author 周化益
	 * @param video_Id 视频ID
	 * @return
	 */
	@RequestMapping("findVideoInfo.do")
	@ResponseBody
	public Map<String, Object> findVideoInfo(int video_Id) {
		return videoService.getVideoById(video_Id);
	}
	
	/**
	 * 播放量修改
	 * 
	 * @author 周化益
	 * @param videoId 视频ID
	 * @return
	 */
	@RequestMapping("updatePlays.do")
	@ResponseBody
	public boolean updatePlays(int videoId) {
		return videoService.updatePlays(videoId);
	}
	
	/**
	 * 点赞量修改
	 * 
	 * @author 周化益
	 * @param videoId 视频ID
	 * @return
	 */
	@RequestMapping("updateThumbup.do")
	@ResponseBody
	public boolean updateThumbup(int videoId) {
		return videoService.updateThumbup(videoId);
	}
	
	/**
	 * 获取老师第一条直播视频
	 * 
	 * @author 周化益
	 * @param teacherId 老师ID
	 * @return
	 */
	@RequestMapping("getVideoByUid.do")
	@ResponseBody
	public Map<String, Object> getVideoByUid(int teacherId) {
		return videoService.getVideoByUid(teacherId);
	}
}
