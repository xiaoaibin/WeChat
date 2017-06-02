package com.wechat.entity;

/**
 * 消息基类
 * @author aibinxiao
 * @date 2017年6月2日 上午6:58:04
 */
public class BaseMessage {
	private String ToUserName; // 开发者微信号
	private String FromUserName; // 发送方帐号（一个OpenID）
	private Long CreateTime; // 消息创建时间 （整型）
	private String MsgType; // text
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	@Override
	public String toString() {
		return "BaseMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + "]";
	}
	
}
