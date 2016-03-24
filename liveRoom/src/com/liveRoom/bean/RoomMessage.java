package com.liveRoom.bean;

import java.util.Date;

/**
 * 房间公聊信息表实体类
 * @author d
 *
 */
public class RoomMessage {
	private Integer room_message_Id;//消息id
	private Integer room_message_User;//发送人
	private Integer room_message_Room;//接收房间
	private Date room_message_Date;//发送时间
	private String room_message_Content;//发送内容
	private Integer room_message_State;//状态
	public int getRoom_message_Id() {
		return room_message_Id;
	}
	public void setRoom_message_Id(Integer room_message_Id) {
		this.room_message_Id = room_message_Id;
	}
	public Integer getRoom_message_User() {
		return room_message_User;
	}
	public void setRoom_message_User(Integer room_message_User) {
		this.room_message_User = room_message_User;
	}
	public Integer getRoom_message_Room() {
		return room_message_Room;
	}
	public void setRoom_message_Room(Integer room_message_Room) {
		this.room_message_Room = room_message_Room;
	}
	public Date getRoom_message_Date() {
		return room_message_Date;
	}
	public void setRoom_message_Date(Date room_message_Date) {
		this.room_message_Date = room_message_Date;
	}
	public String getRoom_message_Content() {
		return room_message_Content;
	}
	public void setRoom_message_Content(String room_message_Content) {
		this.room_message_Content = room_message_Content;
	}
	public Integer getRoom_message_State() {
		return room_message_State;
	}
	public void setRoom_message_State(Integer room_message_State) {
		this.room_message_State = room_message_State;
	}
}
