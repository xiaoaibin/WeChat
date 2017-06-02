package com.wechat.entity;

/**
 * 图片消息实体类
 * @author aibinxiao
 * @date 2017年6月2日 上午10:17:27
 */
public class ImageMessage extends BaseMessage{
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	@Override
	public String toString() {
		return "ImageMessage [Image=" + Image + "]";
	}
	
}
