package com.wechat.entity;

/**
 * 音乐消息实体类
 * @author aibinxiao
 * @date 2017年6月2日 上午11:10:01
 */
public class MusicMessage extends BaseMessage {
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

	@Override
	public String toString() {
		return "MusicMessage [Music=" + Music + "]";
	}
	
}
