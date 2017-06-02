package com.wechat.entity;

/**
 * AccessToken实体类
 * @author aibinxiao
 * @date 2017年6月2日 上午9:13:02
 */
public class AccessToken {
	private String token; // 获取到的凭证
	private int expiresIn; // 凭证有效时间，单位：秒
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	@Override
	public String toString() {
		return "AccessToken [token=" + token + ", expiresIn=" + expiresIn + "]";
	}
}
