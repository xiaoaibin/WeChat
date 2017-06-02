package com.wechat.entity;

/**
 * 图文消息最里层的单条图文
 * @author aibinxiao
 * @date 2017年6月2日 上午6:54:47
 */
public class News {
	private String Title; // 图文标题
	private String Description; // 图文描述
	private String PicUrl; // 图片URL 
	private String Url; // 该图文URL
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	
}
