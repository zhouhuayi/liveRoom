package com.liveRoom.bean;

import java.util.Date;

public class Room {
	private Integer room_id;	//ID
	
	private String room_name;	//房间名
	
	private Integer room_state;	//房间模式
	
	private String room_pwd;	//房间密码
	
	private Integer room_type;	//房间类型
	
	private Integer room_user;	//房间创始人
	
	private String room_heat;	//热度
	
	private Date room_createDate;	//创办日期
	
	private String room_videoUrl;	//视频地址
	
	private String room_logo;	//房间的logo
	
	private String room_phone;	//放假客服号码
	

	public String getRoom_phone() {
		return room_phone;
	}

	public void setRoom_phone(String room_phone) {
		this.room_phone = room_phone;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public Integer getRoom_state() {
		return room_state;
	}

	public void setRoom_state(Integer room_state) {
		this.room_state = room_state;
	}

	public String getRoom_pwd() {
		return room_pwd;
	}

	public void setRoom_pwd(String room_pwd) {
		this.room_pwd = room_pwd;
	}

	public Integer getRoom_type() {
		return room_type;
	}

	public void setRoom_type(Integer room_type) {
		this.room_type = room_type;
	}

	public Integer getRoom_user() {
		return room_user;
	}

	public void setRoom_user(Integer room_user) {
		this.room_user = room_user;
	}

	public String getRoom_heat() {
		return room_heat;
	}

	public void setRoom_heat(String room_heat) {
		this.room_heat = room_heat;
	}

	public Date getRoom_createDate() {
		return room_createDate;
	}

	public void setRoom_createDate(Date room_createDate) {
		this.room_createDate = room_createDate;
	}

	public String getRoom_videoUrl() {
		return room_videoUrl;
	}

	public void setRoom_videoUrl(String room_videoUrl) {
		this.room_videoUrl = room_videoUrl;
	}

	public String getRoom_logo() {
		return room_logo;
	}

	public void setRoom_logo(String room_logo) {
		this.room_logo = room_logo;
	}
	
}
