package com.wechat.entity;

import java.util.List;

/**
 * 图文消息实体类
 * @author aibinxiao
 * @date 2017年6月2日 上午6:59:24
 */
public class NewsMessage extends BaseMessage{
	private int ArticleCount; // 图文数量
	private List<News> Articles; // 图文集合
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<News> getArticles() {
		return Articles;
	}
	public void setArticles(List<News> articles) {
		Articles = articles;
	}
	
	@Override
	public String toString() {
		return "NewsMessage [ArticleCount=" + ArticleCount + ", Articles=" + Articles + "]";
	}
	
}
