package com.practice.webapp.dao;

import java.util.List;

import com.pratice.webapp.entity.Article;


public interface ArticleDAO {	
	
	public void insert(Article article);
	public void delete(Article article);
	public void update(Article article);
	public List<Article> getList();
	public Article get(Article article);
	

}
