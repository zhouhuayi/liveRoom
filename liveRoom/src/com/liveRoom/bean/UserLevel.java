package com.liveRoom.bean;
/**
 * 用户等级实体类
 * @author d
 *
 */
public class UserLevel {
	private int level_id;//用户等级id
	private String level_Name;//等级名称
	private String level_Icon;//图标
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public String getLevel_Name() {
		return level_Name;
	}
	public void setLevel_Name(String level_Name) {
		this.level_Name = level_Name;
	}
	public String getLevel_Icon() {
		return level_Icon;
	}
	public void setLevel_Icon(String level_Icon) {
		this.level_Icon = level_Icon;
	}
}
