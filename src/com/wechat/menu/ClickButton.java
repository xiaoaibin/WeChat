package com.wechat.menu;

/**
 * Click类型的Button实体类
 * @author aibinxiao
 * @date 2017年6月2日 上午11:39:58
 */
public class ClickButton extends Button {
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "ClickButton [key=" + key + "]";
	}
	
}
