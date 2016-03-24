package com.liveRoom.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Date;

public class uploadTest extends Thread implements Serializable {
	private static int fileLength = 0;
	private static File file = null;
	private static File outFile = null;
	private static int startPort = 0;
	private static int endPort = 0;
	public static void main(String[] args) {
		file = new File("f://images/Video/3/1.3.启动手机模拟器.swf");
		outFile = new File("f://temp/temp1.swf");
		fileLength = (int)file.length();
		int len = fileLength/5;
		
//		uploadTest up = new uploadTest(0,len);
//		up.start();
//		
//		uploadTest up1 = new uploadTest(len*1,len*2);
//		up1.start();
//		
//		uploadTest up2 = new uploadTest(len*2,len*3);
//		up2.start();
//		
//		uploadTest up3 = new uploadTest(len*3,len*4);
//		up3.start();
//		
//		uploadTest up4 = new uploadTest(len*4,len*5);
//		up4.start();
//		
		uploadTest up5 = new uploadTest(len*5,fileLength);
		up5.start();
	}
	
	public uploadTest(int start, int end) {
		startPort = start;
		endPort = end;
	}
	
	
	public void run() {
		long startTime = new Date().getTime();
		upload(startPort, endPort);
		System.out.println(endPort);
		long endTime = new Date().getTime();
		System.out.println("所用时间：" + (endTime - startTime) + "毫秒");
	}
	
	public static void upload(int startPort, int endPort) {
		InputStream its = null;
		RandomAccessFile ots = null;
		try {
			its = new FileInputStream(file);
			ots = new RandomAccessFile(outFile, "rw");
			ots.seek(startPort);
			int start = 0;
			int end = 0;
			int count = 0;
			byte[] buffer = new byte[1024];
			while ((end=its.read(buffer)) != -1 && startPort < endPort) {
            	ots.write(buffer, start, end);
            	startPort += end;
            	count++;
    		}
			System.out.println("循环次数：" + count);
            ots.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("下载完成！");
	}

	public int getFileLength() {
		return fileLength;
	}

	public void setFileLength(int fileLength) {
		uploadTest.fileLength = fileLength;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		uploadTest.file = file;
	}

	public File getOutFile() {
		return outFile;
	}

	public void setOutFile(File outFile) {
		uploadTest.outFile = outFile;
	}

	public int getStartPort() {
		return startPort;
	}

	public void setStartPort(int startPort) {
		uploadTest.startPort = startPort;
	}

	public int getEndPort() {
		return endPort;
	}

	public void setEndPort(int endPort) {
		uploadTest.endPort = endPort;
	}
}
