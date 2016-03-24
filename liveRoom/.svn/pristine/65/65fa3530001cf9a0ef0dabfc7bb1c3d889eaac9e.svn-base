package com.liveRoom.util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liveRoom.bean.News;
import com.liveRoom.bean.User;

public class CommonUtil {
	
	/**
	 * 文件读取路径
	 */
	public static <T> String readFilePath(Class<T> entityClass,long entityId, String fileName) {
		String path = "upload/" + entityClass.getSimpleName()+"/"+entityId+"/"+fileName;
		return path;
	}
	
	public static void main(String[] args) {
		getVideoTime("http://192.168.10.12:8080/images/Video/122/122.avi");
	}
	
	public static long getVideoTime(String videoPath) {
		String urlAddress = uploadPath();
		File source = new File(urlAddress + videoPath);
		if(!source.exists()) {
			return 0;
		}
		long time = 0;
	    Encoder encoder = new Encoder();
	      try {
	           MultimediaInfo m = encoder.getInfo(source);
	           long ls = m.getDuration();
	           time = m.getDuration();
	           System.out.println("此视频时长为:"+ls/60000+"分"+(ls%60000)/1000+"秒！");
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	      return time;
	}
	
	/**
	 * String转List<T>
	 * 
	 * @author 周化益
	 * @param type List的类型
	 * @param str 传入的字符串
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> strToList(Class<T> type, String str) {
		List<T> list = null;
		try {
			Object[] strArray = str.split(",");
			List<Object> strList = new ArrayList<Object>();
			strList = Arrays.asList(strArray);
			list = new ArrayList<T>();
			for (Object obj : strList) {
				list.add((T)obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 清除临时文件
	 * 
	 * @author 周化益
	 * @param filePath 临时文件所属目录
	 */
	public static  void clearFile(String filePath){
		File temf = new File(uploadPath() + filePath);
		temf.delete();
	}
	
	/**
	 * 清除临时文件
	 * 
	 * @author 周化益
	 * @param filePath 临时文件所属目录
	 */
	public static  void clearTemFile(String filePath){
		File temf = new File(uploadPath() + filePath);
        File[] fs = temf.listFiles();
        for (int i = 0; i < fs.length; i++) {
			fs[i].delete();
		}
	}

	public static String uploadPath() {
		String path = CommonUtil.class.getResource("") .getPath();  
		int end = path.lastIndexOf("WEB-INF");  
		path = path.substring(1, end); 
		return path+"/";
	}
	
	/**
	 * 上传单个文件
	 *
	 * @author 周化益
	 * @param entityName 实体Class
	 * @param record_Id 文件ID
	 * @param is 文件数据
	 * @param fileName 文件名
	 * @param isVideo 是否是视频,如果是视频传入true，图片则为false
	 * @return boolean 文件是否保存成功
	 */
	public static <T> Boolean upLoadPath(Class<T> entityName,long record_Id,InputStream is,
			String fileName, boolean isVideo) {
		boolean back = false;
		File folder = new File(uploadPath()+"upload",entityName.getSimpleName()+"/"+record_Id);
		if (null != folder) {
	        String folderPath = folder.getPath();
			if (!folder.exists()){
				folder.mkdirs();//新建文件存放的文件夹
			}
			String filePath = folderPath+"\\" + fileName;
			try {
				OutputStream os = new FileOutputStream(filePath);
				back = copyFile(is,os);
				if(isVideo && back) {
					//视频图片截取
					FileLoad.capturePhotoFromVideo(entityName, record_Id, fileName);
/*					if(!fileName.contains(".avi")) {
						//视频格式转换
						FileLoad.videoToFlv(entityName, record_Id, fileName, ".avi");
					}*/
				}
				if(new File(filePath).exists() && back == true) {
					if(entityName == User.class) {
						ChangeImageSize.scaleBYWH(filePath,filePath, 50);
					} else if(entityName == News.class) {
						System.out.println("裁剪");
						//ChangeImageSize.scaleBYWH(filePath,filePath, 300);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return back;
	}
	
	/**
	 * 拷贝文件
	 *
	 * @author 周化益
	 * @param is 输入流
	 * @param os 输出流
	 * @return boolean 是否拷贝成功
	 */
	public synchronized static boolean copyFile(InputStream is,OutputStream os){
		boolean isCopySuccess = false;
		byte buffer[] = new byte[1024];
        int len = 0;
        try {
        	while ((len=is.read(buffer)) != -1) {
            	os.write(buffer, 0, len);
    		}
            os.flush();
            isCopySuccess = true;
		} catch (Exception e) {
		} finally {
			try {
				if (null!=is){
					is.close();
				}
				if (null!=os){
					os.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
        return isCopySuccess;
	}
	
	
	/**
	 * 获取多媒体文件长度
	 *
	 * @author 周化益
	 * @param filePath 文件路径
	 * @return int 文件长度
	 */
	public synchronized static int getMediaDuration(String filePath){
		int duration = 0;
		int readLen = 0;
		byte[] byteTemp = new byte[5];
		InputStream is = null;
		Process process = null;
		try {
			StringBuffer command = new StringBuffer();
			command.append("cmd /c ").append("MediaInfo.exe").append(" --Inform=General;")
			       .append("\"%Duration%\" \"").append(filePath).append("\"");
			process = Runtime.getRuntime().exec(command.toString());
			is = process.getInputStream();
			command.setLength(0);
			while((readLen = is.read(byteTemp))!=-1){
				command.append(new String(byteTemp,0,readLen));
			}
			if (command.length()>0){
				duration = Integer.parseInt(command.toString().replaceAll("\\s", ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (null!=is){
					is.close();
				}
				if (null!=process){
					process.destroy();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		return duration;
	}
}