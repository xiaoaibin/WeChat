package com.wechat.entity;

/**
 * 图片对象
 * @author aibinxiao
 * @date 2017年6月2日 上午10:16:14
 */
public class Image {
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@Override
	public String toString() {
		return "Image [MediaId=" + MediaId + "]";
	}
	
}
