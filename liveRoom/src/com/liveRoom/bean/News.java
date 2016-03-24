package com.liveRoom.bean;

import java.util.Date;
/**
 * 新闻实体类
 * @author d
 *
 */
public class News {
	private Integer news_Id;//新闻id
	private String news_Title;//新闻标题
	private String news_Describe;//新闻描述
	private String news_Address;//地址
	private String news_Content;//内容
	private Date news_Uploadtime;//发布时间
	private Integer news_Userid;//发布人
	private Integer news_Type;//新闻类型
	private Long news_Thumbup;//点赞
	private String news_photo;
	
	public String getNews_photo() {
		return news_photo;
	}
	public void setNews_photo(String new_photo) {
		this.news_photo = new_photo;
	}
	public Integer getNews_Id() {
		return news_Id;
	}
	public void setNews_Id(Integer news_Id) {
		this.news_Id = news_Id;
	}
	public String getNews_Title() {
		return news_Title;
	}
	public void setNews_Title(String news_Title) {
		this.news_Title = news_Title;
	}
	public String getNews_Describe() {
		return news_Describe;
	}
	public void setNews_Describe(String news_Describe) {
		this.news_Describe = news_Describe;
	}
	public String getNews_Address() {
		return news_Address;
	}
	public void setNews_Address(String news_Address) {
		this.news_Address = news_Address;
	}
	public String getNews_Content() {
		return news_Content;
	}
	public void setNews_Content(String news_Content) {
		this.news_Content = news_Content;
	}
	public Date getNews_Uploadtime() {
		return news_Uploadtime;
	}
	public void setNews_Uploadtime(Date news_Uploadtime) {
		this.news_Uploadtime = news_Uploadtime;
	}
	public Integer getNews_Userid() {
		return news_Userid;
	}
	public void setNews_Userid(Integer news_Userid) {
		this.news_Userid = news_Userid;
	}
	public Integer getNews_Type() {
		return news_Type;
	}
	public void setNews_Type(Integer news_Type) {
		this.news_Type = news_Type;
	}
	public Long getNews_Thumbup() {
		return news_Thumbup;
	}
	public void setNews_Thumbup(Long news_Thumbup) {
		this.news_Thumbup = news_Thumbup;
	}

}
