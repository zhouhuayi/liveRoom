package com.liveRoom.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DisableControoller {
	@RequestMapping("disableword.do")
	@ResponseBody
	public boolean disableWord(
			@RequestParam(value = "disable", required = true) String disable,
			HttpServletRequest request) {
		boolean bool = true;
		try {
			writeFile(disable, request.getSession().getServletContext()
					.getRealPath("\\stop.txt"));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return bool;
	}

	/**
	 * 将字符串存入一个文件中
	 * 
	 * @param str
	 * @param filename
	 */
	public static void writeFile(String disable, String filePath) {
		BufferedWriter bwriter;
		try {
			bwriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filePath),"utf-8"));
			bwriter.write(disable);
			bwriter.flush();
			bwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("disablewords.do")
	public String disableWords(HttpServletRequest request) throws UnsupportedEncodingException {
		String str;
		try {
			str=readTxtFile(request.getSession().getServletContext()
					.getRealPath("\\stop.txt"));
			System.out.println(str);
			request.setAttribute("disable", str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "stop";
		
	}

	/**
	 * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 */
	public static String readTxtFile(String filePath) {
		StringBuffer content = new StringBuffer();
		try {
			String encoding = "utf-8";
			File file = new File(filePath);

			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (lineTxt.equals("")) {
						continue;
					}
					content.append(lineTxt).append("\n");
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return content.toString();
	}

}
