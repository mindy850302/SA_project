package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.ArticleCategoryDAO;
import com.pratice.webapp.entity.ArticleCategory;

public class ArticleCategoryDAOImpl implements ArticleCategoryDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<ArticleCategory> getList() {
		// TODO Auto-generated method stub
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		String sql = "SELECT * FROM article_category";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				ArticleCategory articleCategory = new ArticleCategory();
				articleCategory.setId(rs.getInt("articleCategoryID"));
				articleCategory.setName(rs.getString("articleCategoryName"));
				articleCategoryList.add(articleCategory);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return articleCategoryList;
	}
	
}
