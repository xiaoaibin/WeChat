package com.wechat.menu;

import java.util.Arrays;

/**
 * 
 * @author aibinxiao
 * @date 2017年6月2日 上午11:42:03
 */
public class Menu {
	private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	@Override
	public String toString() {
		return "Menu [button=" + Arrays.toString(button) + "]";
	}
	
}
