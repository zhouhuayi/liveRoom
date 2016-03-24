package com.liveRoom.bean;

public class Room_user_list {
	private int id;//
	private int room_id;//所属房间
	private int user_id;//用户id
	private int grade;//角色id
	private String tourist_id;//游客
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getTourist_id() {
		return tourist_id;
	}
	public void setTourist_id(String tourist_id) {
		this.tourist_id = tourist_id;
	}
}
