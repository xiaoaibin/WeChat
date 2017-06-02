package com.wechat.menu;

/**
 * View类型的Button实体类
 * @author aibinxiao
 * @date 2017年6月2日 上午11:40:53
 */
public class ViewButton extends Button{
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ViewButton [url=" + url + "]";
	}
	
}
