package com.liveRoom.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liveRoom.bean.Video;
import com.liveRoom.util.FileLoad;

@Controller
public class DownLoad {
	/**
	 * 压缩文件下载处理
	 */
	@RequestMapping("/download.do")
	public void downloanExcel(final HttpServletResponse response) {
		FileLoad.downLoad(Video.class, 38, "38.jpg", response);
	}
	
	
	/** 
     * 下载服务器已存在的文件 
     *  
     * @param request 
     * @param response 
     * @param proposeFile 
     * @throws IOException 
     * @throws FileNotFoundException 
     */  
	@RequestMapping("/download2.do")
    private void downloadExistsFile(HttpServletRequest request, HttpServletResponse response) throws IOException,  
            FileNotFoundException {  
		String fileName = "1.jpg";
		String path = FileLoad.getPropertyByKey("upLoadPath",null) + "/" + Video.class.getSimpleName() + 
				"/" + 1 + "/" + fileName;
		
		File proposeFile = new File(path);
		
        System.out.println("下载文件路径：" + proposeFile.getPath());  
        long fSize = proposeFile.length();  
        
        // 下载  
        response.setContentType("application/x-download");  
        String isoFileName =  URLEncoder.encode(proposeFile.getName(), "UTF-8");
        response.setHeader("Accept-Ranges", "bytes");  
        response.setHeader("Content-Length", String.valueOf(fSize));  
        response.setHeader("Content-Disposition", "attachment; filename=" + isoFileName);  
        long pos = 0;  
        if (null != request.getHeader("Range")) {
            // 断点续传  
            response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);  
            try {  
                pos = Long.parseLong(request.getHeader("Range").replaceAll(  
                        "bytes=", "").replaceAll("-", ""));  
            } catch (NumberFormatException e) {  
                System.out.println(request.getHeader("Range") + " is not Number!");  
                pos = 0;
            }  
        }  
        ServletOutputStream out = response.getOutputStream();  
        BufferedOutputStream bufferOut = new BufferedOutputStream(out);  
        InputStream inputStream = new FileInputStream(proposeFile);
        
        String contentRange = new StringBuffer("bytes ").append(
        		new Long(pos).toString()).append("-").append(  
                new Long(fSize - 1).toString()).append("/").append(  
                new Long(fSize).toString()).toString();  
        response.setHeader("Content-Range", contentRange);  
        System.out.println("Content-Range:"+ contentRange);  
        inputStream.skip(pos);  
        byte[] buffer = new byte[5 * 1024];  
        int length = 0;  
        while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {  
            bufferOut.write(buffer, 0, length);  
        }  
        bufferOut.flush();  
        bufferOut.close();  
        out.close();  
        inputStream.close();  
    } 
}
