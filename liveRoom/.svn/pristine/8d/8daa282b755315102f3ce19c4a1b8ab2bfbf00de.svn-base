package com.liveRoom.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.liveRoom.bean.Advertisement;
import com.liveRoom.service.AdvertisementService;
import com.liveRoom.util.CommonUtil;
import com.liveRoom.util.MapAction;
import com.liveRoom.util.UtilController;

@Controller
public class AdvertisementController {
	@Autowired
	private AdvertisementService advertisementService;
	
	/**
	 * 广告列表
	 * 
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("advertisementList.do")
	@ResponseBody
	public Map<String, Object> advertisementList(int pageSize) {
		int pageNum = 1;
		if(pageSize < 1) {
			pageNum = 0;
		}
		return advertisementService.getAdvertisementList(pageNum, pageSize);
	}
	
	/**
	 * 添加广告
	 * 
	 * @author 周化益
	 * @param mapVo 添加的数据
	 * @return
	 */
	@RequestMapping("addAdvertise.do")
	@ResponseBody
	public boolean addAdvertise(MapAction mapVo,HttpServletRequest request) {
		Map<String, Object> mapData = mapVo.getMapVo();
		Long userId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
		mapData.put("images", CommonUtil.readFilePath(Advertisement.class, userId, mapData.get("images").toString()));
		
		return advertisementService.addAdvertise(mapVo.getMapVo());
	}
	
	/**
	 * 修改广告
	 * 
	 * @author 周化益
	 * @param mapVo 修改的数据
	 * @return
	 */
	@RequestMapping("updateAdvertise.do")
	@ResponseBody
	public boolean updateAdvertise(MapAction mapVo, HttpServletRequest request) {
		Map<String, Object> advertiseMap = mapVo.getMapVo();
		String photoPath = advertiseMap.remove("photoPath").toString();
		if(advertiseMap.get("images") != null) {
			Long userId = Long.parseLong(UtilController.getUserByRequest(request).get("user_id").toString());
			String path = CommonUtil.readFilePath(Advertisement.class, userId, advertiseMap.get("images").toString());
			advertiseMap.put("images",path);
			CommonUtil.clearFile(photoPath);
		}
		System.out.println(advertiseMap);
		return advertisementService.updateAdvertise(advertiseMap);
	}
	
	/**
	 * 跳转修改页面
	 * 
	 * @author 周化益
	 * @param newsId 新闻ID
	 * @param request
	 * @return
	 */
	@RequestMapping("openAdvertiseEdit.do")
	public String updateNews(int advertiseId, HttpServletRequest request) {
		request.setAttribute("advertise",advertisementService.findAdvertisement(advertiseId));
		return "advertisementEdit";
	}
	
	
	/**
	 * 删除单条广告
	 * 
	 * @author 周化益
	 * @param advertiseId 广告ID
	 * @return
	 */
	@RequestMapping("deleteAdvertise.do")
	@ResponseBody
	public boolean deleteAdvertise(long advertiseId) {
		return advertisementService.deleteAdvertise(advertiseId);
	}
	
	/**
	 * 删除多条单条广告
	 * 
	 * @author 周化益
	 * @param advertiseIds 广告ID集合
	 * @return
	 */
	@RequestMapping("deleteManyAdvertise.do")
	@ResponseBody
	public boolean deletesAdvertise(String advertiseIds) {
		return advertisementService.deletesAdvertise(advertiseIds);
	}
	
	/**
	 * 广告列表
	 * 
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("advertiseList.do")
	@ResponseBody
	public Map<String, Object> advertiseList(int pageNum,int pageSize) {
		return advertisementService.getAdvertisementList(pageNum, pageSize,null,"");
	}
	
	/**
	 * 上传广告图片
	 * 
	 * @author 周化益
	 * @param fileData 视频文件
	 * @param fileName 视频文件名
	 * @param videoId 视频ID
	 * @return
	 */
	@RequestMapping("uploadAdvertise.do")
	@ResponseBody
	public boolean uploadAdvertise(MultipartFile fileData, String fileName, int advertiseId, HttpServletRequest request) {
		try {
			CommonUtil.upLoadPath(Advertisement.class,advertiseId, fileData.getInputStream(), fileName,false);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}