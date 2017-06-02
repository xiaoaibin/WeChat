package com.wechat.entity;

/**
 * 音乐实体类
 * @author aibinxiao
 * @date 2017年6月2日 上午11:07:01
 */
public class Music {
	private String Title; // 标题
	private String Description; // 描述
	private String MusicUrl;  // 音乐链接
	private String HQMusicUrl; // 高质量音乐链接
	private String ThumbMediaId; // 缩略图id
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
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
	@Override
	public String toString() {
		return "Music [Title=" + Title + ", Description=" + Description + ", MusicUrl=" + MusicUrl + ", HQMusicUrl="
				+ HQMusicUrl + ", ThumbMediaId=" + ThumbMediaId + "]";
	}
	
}
