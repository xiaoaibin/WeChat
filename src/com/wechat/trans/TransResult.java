package com.wechat.trans;

/**
 * 百度翻译数据对象
 * @author aibinxiao
 * @date 2017年6月3日 下午4:36:57
 */
public class TransResult {
	private String form;
	private String to;
	private String errno;
	private Data data;
	
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getErrno() {
		return errno;
	}
	public void setErrno(String errno) {
		this.errno = errno;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "TransResult [form=" + form + ", to=" + to + ", errno=" + errno + ", data=" + data + "]";
	}
	
}
