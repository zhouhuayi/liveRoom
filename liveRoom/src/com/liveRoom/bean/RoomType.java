package com.liveRoom.bean;
/**
 * 房间类型实体类
 * @author d
 *
 */
public class RoomType {
	private int roomtype_Id;//类型id
	private String roomtype_Name;//类型名称
	private String roomtype_Icon;//图标
	public int getRoomtype_Id() {
		return roomtype_Id;
	}
	public void setRoomtype_Id(int roomtype_Id) {
		this.roomtype_Id = roomtype_Id;
	}
	public String getRoomtype_Name() {
		return roomtype_Name;
	}
	public void setRoomtype_Name(String roomtype_Name) {
		this.roomtype_Name = roomtype_Name;
	}
	public String getRoomtype_Icon() {
		return roomtype_Icon;
	}
	public void setRoomtype_Icon(String roomtype_Icon) {
		this.roomtype_Icon = roomtype_Icon;
	}
}
