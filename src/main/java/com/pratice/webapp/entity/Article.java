package com.pratice.webapp.entity;

import java.util.Date;

public class Article {
	private int id;
	private String title;
	private String content;
	private Date createDate;
	private Date updateDate;
	private ArticleCategory articleCategory = new ArticleCategory();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}
	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}	
	
}
