package com.liveRoom.bean;

import java.util.Date;

/**
 * 好友私聊表实体类
 * @author d
 *
 */
public class FriendPrivateChat {
	private int id;//消息id
	private int sendid;//发送人
	private int pickid;//接收人
	private Date createtime;//发送时间
	private String content;//发送内容
	private int state;//状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	public int getPickid() {
		return pickid;
	}
	public void setPickid(int pickid) {
		this.pickid = pickid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

}
