package com.liveRoom.bean;

public class Power {
	private Integer power_id;	//权限ID
	
	private String power_name;	//权限名称
	
	private String power_url;	//权限跳转的地址
	
	private Integer power_parentId;	//关联父类

	public Integer getPower_id() {
		return power_id;
	}

	public void setPower_id(Integer power_id) {
		this.power_id = power_id;
	}

	public String getPower_name() {
		return power_name;
	}

	public void setPower_name(String power_name) {
		this.power_name = power_name;
	}

	public String getPower_url() {
		return power_url;
	}

	public void setPower_url(String power_url) {
		this.power_url = power_url;
	}

	public Integer getPower_parentId() {
		return power_parentId;
	}

	public void setPower_parentId(Integer power_parentId) {
		this.power_parentId = power_parentId;
	}
	
}
