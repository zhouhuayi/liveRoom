package com.liveRoom.test;

import org.springframework.beans.factory.annotation.Value;

import com.liveRoom.bean.Video;
import com.liveRoom.util.FileLoad;

/**
 * 读取Properties文件的例子 File: TestProperties.java User: leizhimin Date: 2008-2-15
 * 18:38:40
 */
public final class TestProperties {
	private static String param1;
	private static String param2;
	@Value("#{propertyConfigurer['file.upLoadPath']}")  
	private static String upLoadPath;


	/**
	 * 私有构造方法，不需要创建对象
	 */
	private TestProperties() {
	}

	public static String getParam1() {
		return param1;
	}

	public static String getParam2() {
		return param2;
	}

	public static void main(String args[]) {
		//FileLoad.videoToFlv(Video.class, 1, "1.avi");
	}
}