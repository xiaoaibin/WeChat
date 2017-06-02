package com.wechat.menu;

import java.util.Arrays;

/**
 * 一级菜单实体类
 * @author aibinxiao
 * @date 2017年6月2日 上午11:35:49
 */
public class Button {
	private String type;
	private String name;
	private Button[] sub_button;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Button[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
	@Override
	public String toString() {
		return "Button [type=" + type + ", name=" + name + ", sub_button=" + Arrays.toString(sub_button) + "]";
	}
	
}
