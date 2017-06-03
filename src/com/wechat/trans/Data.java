package com.wechat.trans;

import java.util.Arrays;

/**
 * Data对象
 * @author aibinxiao
 * @date 2017年6月3日 下午4:38:24
 */
public class Data {
	private String word_name;
	private Symbols[] symbols;
	
	public String getWord_name() {
		return word_name;
	}
	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
	public Symbols[] getSymbols() {
		return symbols;
	}
	public void setSymbols(Symbols[] symbols) {
		this.symbols = symbols;
	}
	
	@Override
	public String toString() {
		return "Data [word_name=" + word_name + ", symbols=" + Arrays.toString(symbols) + "]";
	}
	
}
