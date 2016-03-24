package com.liveRoom.bean;

import java.util.Date;

public class User {
	private Integer user_id;	//ID
	
	private String user_name;	//昵称
	
	private String user_phone;	//手机号
	
	private String user_email;	//邮箱
	
	private String user_registerIP;	//注册IP地址
	
	private String user_realName;	//真实姓名
	
	private Integer user_integral;	//积分
	   
	private Date user_age;	//年龄
	
	private String user_address;	//用户地址
	
	private Date user_registerDate;	//注册日期
	
	private Integer user_state;	//用户状态
	
	private Date user_lastTime;	//最后登录时间
	
	private String user_loginIP;	//登录的IP地址
	
	private String user_qq;	//QQ账号
	
	private String user_pwd;	//用户密码
	
	private Integer user_level;	//用户等级
	
	private String user_introduction;	//个人简介
	
	private String user_head;	//头像
	
	private Integer user_role;	//用户角色  
	
	private String user_account;	//用户账号
	
	private Integer user_sex;//性别
	
	private String user_source;//判断前台还是后台用户

	private Integer	user_teacher;//0不是老师，1是老师
	
	private String advantage;//擅长领域
	
	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public Integer getUser_teacher() {
		return user_teacher;
	}

	public void setUser_teacher(Integer user_teacher) {
		this.user_teacher = user_teacher;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(Integer user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_registerIP() {
		return user_registerIP;
	}

	public void setUser_registerIP(String user_registerIP) {
		this.user_registerIP = user_registerIP;
	}

	public String getUser_realName() {
		return user_realName;
	}

	public void setUser_realName(String user_realName) {
		this.user_realName = user_realName;
	}

	public Date getUser_age() {
		return user_age;
	}

	public void setUser_age(Date user_age) {
		this.user_age = user_age;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public Date getUser_registerDate() {
		return user_registerDate;
	}

	public void setUser_registerDate(Date user_registerDate) {
		this.user_registerDate = user_registerDate;
	}

	public Integer getUser_state() {
		return user_state;
	}

	public void setUser_state(Integer  user_state) {
		this.user_state = user_state;
	}

	public Date getUser_lastTime() {
		return user_lastTime;
	}

	public void setUser_lastTime(Date user_lastTime) {
		this.user_lastTime = user_lastTime;
	}

	public String getUser_loginIP() {
		return user_loginIP;
	}

	public void setUser_loginIP(String user_loginIP) {
		this.user_loginIP = user_loginIP;
	}

	public String getUser_qq() {
		return user_qq;
	}

	public void setUser_qq(String user_qq) {
		this.user_qq = user_qq;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public Integer getUser_level() {
		return user_level;
	}

	public void setUser_level(Integer user_level) {
		this.user_level = user_level;
	}
	public String getUser_head() {
		return user_head;
	}

	public void setUser_head(String user_head) {
		this.user_head = user_head;
	}

	public Integer getUser_role() {
		return user_role;
	}

	public void setUser_role(Integer user_role) {
		this.user_role = user_role;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public Integer getUser_integral() {
		return user_integral;
	}

	public void setUser_integral(Integer user_integral) {
		this.user_integral = user_integral;
	}

	public String getUser_introduction() {
		return user_introduction;
	}

	public void setUser_introduction(String user_introduction) {
		this.user_introduction = user_introduction;
	}

	public String getUser_source() {
		return user_source;
	}

	public void setUser_source(String user_source) {
		this.user_source = user_source;
	}
	
}
