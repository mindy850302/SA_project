package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import com.practice.webapp.dao.ArticleDAO;
import com.pratice.webapp.entity.Article;
import com.pratice.webapp.entity.ArticleCategory;

public class ArticleDAOImpl implements ArticleDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Article article) {
		// TODO Auto-generated method stub
		String sql = "INSERT article(articleCategoryID,articleTitle,articleContent,articleCreateDate,articleUpdateDate) "
				+ "VALUES(?,?,?,NOW(),NOW())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, article.getArticleCategory().getId());
			smt.setString(2, article.getTitle());
			smt.setString(3, article.getContent());
			smt.executeUpdate();			
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
	}

	public void delete(Article article) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM article WHERE articleID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, article.getId());
			smt.executeUpdate();			
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
	}

	public void update(Article article) {
		// TODO Auto-generated method stub
		String sql = "UPDATE article SET articleCategoryID=?, articleTitle=?, articleContent=?, articleUpdateDate=NOW() "
				+ "WHERE articleID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, article.getArticleCategory().getId());
			smt.setString(2, article.getTitle());
			smt.setString(3, article.getContent());
			smt.setInt(4, article.getId());
			smt.executeUpdate();			
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
	}

	public List<Article> getList() {
		// TODO Auto-generated method stub
		List<Article> articleList = new ArrayList<Article>();
		String sql = "SELECT * FROM article a "
				+ "JOIN article_category b ON a.articleCategoryID = b.articleCategoryID "
				+ "ORDER BY articleID DESC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Article article = new Article();
				article.getArticleCategory().setId(rs.getInt("articleCategoryID"));
				article.getArticleCategory().setName(rs.getString("articleCategoryName"));
				article.setId(rs.getInt("articleID"));
				article.setTitle(rs.getString("articleTitle"));
				article.setContent(rs.getString("articleContent"));
				article.setCreateDate(rs.getDate("articleCreateDate"));
				article.setUpdateDate(rs.getDate("articleUpdateDate"));
				articleList.add(article);
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
		return articleList;
	}

	public Article get(Article article) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM article WHERE articleID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, article.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				article.getArticleCategory().setId(rs.getInt("articleCategoryID"));
				article.setTitle(rs.getString("articleTitle"));
				article.setContent(rs.getString("articleContent"));
				article.setCreateDate(rs.getDate("articleCreateDate"));
				article.setUpdateDate(rs.getDate("articleUpdateDate"));
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
		return article;
	}


}
