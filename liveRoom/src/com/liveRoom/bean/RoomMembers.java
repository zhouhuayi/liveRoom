package com.liveRoom.bean;
/**
 * 房间成员实体类
 * @author d
 *
 */
public class RoomMembers {
	private int roommembers_Userid;//用户id
	private int roommembers_Roomid;//所属房间
	private int roommembers_Roleid;//角色id
	private String roommembers_State;//状态
	public int getRoommembers_Userid() {
		return roommembers_Userid;
	}
	public void setRoommembers_Userid(int roommembers_Userid) {
		this.roommembers_Userid = roommembers_Userid;
	}
	public int getRoommembers_Roomid() {
		return roommembers_Roomid;
	}
	public void setRoommembers_Roomid(int roommembers_Roomid) {
		this.roommembers_Roomid = roommembers_Roomid;
	}
	public int getRoommembers_Roleid() {
		return roommembers_Roleid;
	}
	public void setRoommembers_Roleid(int roommembers_Roleid) {
		this.roommembers_Roleid = roommembers_Roleid;
	}
	public String getRoommembers_State() {
		return roommembers_State;
	}
	public void setRoommembers_State(String roommembers_State) {
		this.roommembers_State = roommembers_State;
	}
}
