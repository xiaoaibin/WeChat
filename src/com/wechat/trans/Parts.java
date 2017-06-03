package com.wechat.trans;

import java.util.Arrays;

/**
 * Parts对象
 * @author aibinxiao
 * @date 2017年6月3日 下午4:40:53
 */
public class Parts {
	private String part;
	private String[] means;
	
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String[] getMeans() {
		return means;
	}
	public void setMeans(String[] means) {
		this.means = means;
	}
	
	@Override
	public String toString() {
		return "Parts [part=" + part + ", means=" + Arrays.toString(means) + "]";
	}
	
}
