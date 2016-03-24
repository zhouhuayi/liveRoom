package com.liveRoom.test;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.util.Date;

public class ReadVideo {

    public static void main(String[] args){
        File source = new File("F:\\images\\Video\\1\\5-handler的使用和原理、常用的dialog、自定义dialog.avi");
        Encoder encoder = new Encoder();
        try {
             MultimediaInfo m = encoder.getInfo(source);
             long ls = m.getDuration();
             long now = new Date().getTime();
             System.out.println(new Date());
             System.out.println(ls);
             System.out.println(now);
             System.out.println(now-ls);
             System.out.println(new Date(now-ls));
             System.out.println("此视频时长为:"+ls/60000+"分"+(ls/60000)/60+"秒！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}