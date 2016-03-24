package com.liveRoom.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class mainTest {

	/**
	 * freemarker生成静态html
	 * 
	 * @author lpz
	 * 
	 */
	private static Configuration config = null;

	/**
	 * 如果目录不存在，则自动创建
	 * 
	 * @param path
	 * @return boolean 是否成功
	 */
	private static boolean creatDirs(String path) {
		File aFile = new File(path);
		if (!aFile.exists()) {
			return aFile.mkdirs();
		} else {
			return true;
		}
	}

	/**
	 * 模板生成静态html的方法
	 * 
	 * @param templateFileName
	 *            (模板文件名)
	 * @param templateFilePath
	 *            (指定模板目录)
	 * @param contextMap
	 *            (用于处理模板的属性Object映射)
	 * @param htmlFilePath
	 *            (指定生成静态html的目录)
	 * @param htmlFileName
	 *            (生成的静态文件名)
	 */
	public static void geneHtmlFile(String templateFileName,
			String templateFilePath, Map<String, Object> contextMap,
			String htmlFilePath, String htmlFileName) {

		try {
			Template t = getFreeMarkerCFG(templateFilePath).getTemplate(
					templateFileName);
			// 如果根路径存在,则递归创建子目录
			creatDirs(htmlFilePath);
			t.setEncoding("utf-8");
			File afile = new File(htmlFilePath + "/" + htmlFileName);
			OutputStreamWriter outWrite = new OutputStreamWriter(
					new FileOutputStream(afile), "utf-8");
			Writer out = new BufferedWriter(outWrite);
			t.process(contextMap, out);
			out.flush();
			out.close();
		} catch (TemplateException e) {
			System.out.print(e.getMessage());
		} catch (IOException e) {
			System.out.print(e.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/**
	 * 
	 * 获取freemarker的配置，freemarker本身支持classpath,目录或从ServletContext获取.
	 * 
	 * @param templateFilePath
	 *            获取模板路径
	 * @return Configuration 返回freemaker的配置属性
	 * @throws Exception
	 */
	private static Configuration getFreeMarkerCFG(String templateFilePath)
			throws Exception {
		if (null == config) {

			config = new Configuration();
			try {
				config.setDirectoryForTemplateLoading(new File(templateFilePath));
			} catch (Exception ex) {
				throw ex;
			}
		}
		return config;
	}

	public static void main(String[] args) {
		/*
		 * File file = new File(""); String fromPath = file.getAbsolutePath() +
		 * "\\" + "WebRoot\\room"; Map<String, Object> roomMap = new
		 * HashMap<String, Object>(); roomMap.put("id", 1); roomMap.put("name",
		 * "房间一号"); roomMap.put("type", "会员房间"); roomMap.put("phone",
		 * "13003221671"); geneHtmlFile("index.html", fromPath, roomMap,
		 * fromPath, roomMap.get("id") + ".html");
		 */
//		System.out.println(new Date().getTime());
//		StringBuffer sb = new StringBuffer();
//		sb.append("12345\r\n");
//		sb.append("abcde\r\n");
//		sb.append("123.abc");
//		writeFile(sb.toString(), "f:/test.txt");
//		String readFile = readTxtFile("f:/test.txt");
//		byte[] data = readFile.getBytes();//这里获取到的字节数组不存在编码格式的问题吧？
//		//那么如何获取str2的编码格式呢？
//		String bianma;
//		try {
//			bianma = new String(data,"UTF-8");
//			System.out.println(bianma);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		mainTest a = new mainTest();
		System.out.println(a.rootPath());
	}

	public String rootPath() {
		File f = new File(this.getClass().getResource("/").getPath());System.out.println(f);
		System.out.println(f.getPath());
		System.out.println(System.getProperty("user.dir")+"com/liveRoom/resources/");
		String rootPath=this.getClass().getResource("/").getPath();  
		return rootPath;
	}
	
	/**
	 * 将字符串存入一个文件中
	 * 
	 * @param str
	 * @param filename
	 */
	public static void writeFile(String str, String filePath) {
		BufferedWriter bwriter;
		try {
			bwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"utf-8"));
			bwriter.write(str);
			bwriter.flush();
			bwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
					if(lineTxt.equals("")) {
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
