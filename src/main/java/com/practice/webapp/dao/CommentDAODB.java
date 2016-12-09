package com.practice.webapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.entity.Comment;
import com.practice.webapp.entity.Product;
public class CommentDAODB implements CommentDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void insert(Comment comment) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO Comment(comment_M_id,comment_p_id,c_comment,score,c_create_date) VALUES(?, ?, ?, ?,CURRENT_TIME())";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment.getComment_M_id());
			smt.setInt(2, comment.getComment_p_id());
			smt.setString(3, comment.getC_comment());
			smt.setInt(4, comment.getScore());
			
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
	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Comment  WHERE( comment_M_id = ? AND comment_p_id = ? )";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment.getComment_M_id());
			smt.setInt(2, comment.getComment_p_id());
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


	public void update( Comment comment) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Comment SET  c_comment=?, c_update_date=CURRENT_TIME(),score=? "
				+ "WHERE (comment_M_id = ? AND comment_p_id = ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, comment.getC_comment());
			smt.setInt(2, comment.getScore());
			smt.setInt(3, comment.getComment_M_id());
			smt.setInt(4, comment.getComment_p_id());
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
	
	@Override
	public List<Comment> getList(){
		String sql = "SELECT * FROM Comment a JOIN product b ON a.comment_p_id = b.p_id JOIN Member c ON a.comment_M_id =c.M_id";
		return getList(sql);
	}
	public List<Comment> getList(String sql) {
		// TODO Auto-generated method stub
		List<Comment> CommentList = new ArrayList<Comment>();
		try {
			conn = dataSource.getConnection();
			
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setComment_M_id(rs.getInt("comment_M_id"));
				comment.setComment_p_id(rs.getInt("comment_p_id"));
				comment.getMember().setM_idName(rs.getString("M_idName"));
				comment.getMember().setM_name(rs.getString("M_name"));
				comment.getProduct().setP_name(rs.getString("p_name"));
				comment.setC_comment(rs.getString("c_comment"));
				comment.setC_create_date(rs.getString("c_create_date"));
				comment.setC_update_date(rs.getString("c_update_date"));
				comment.setScore(rs.getInt("score"));
				CommentList.add(comment);
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
		return CommentList;
		
	}
	@Override
	public Comment get(Comment comment) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Comment WHERE (comment_M_id = ? AND comment_p_id = ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, comment.getComment_M_id());
			smt.setInt(2, comment.getComment_p_id());
			rs = smt.executeQuery();
			while(rs.next()){
				comment.setComment_M_id(rs.getInt("comment_M_id"));
				comment.setComment_p_id(rs.getInt("comment_p_id"));
				comment.setC_comment(rs.getString("c_comment"));
				comment.setC_create_date(rs.getString("c_create_date"));
				comment.setC_update_date(rs.getString("c_update_date"));
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
		return comment;
		
	}

	public List<Comment>search(String keyword) {
		List<Comment> CommentList = new ArrayList<Comment>();
		
		String sql = "SELECT * FROM Comment WHERE c_comment LIKE '%"+keyword+"%'";
		System.out.println(sql);
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			System.out.println(keyword);
			
			rs = smt.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setComment_M_id(rs.getInt("comment_M_id"));
				comment.setComment_p_id(rs.getInt("comment_p_id"));
				comment.setC_comment(rs.getString("c_comment"));
				comment.setC_create_date(rs.getString("c_create_date"));
				comment.setC_update_date(rs.getString("c_update_date"));
				comment.setScore(rs.getInt("score"));
				CommentList.add(comment);
			}
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}

			}

		}
		return CommentList;
	}
}
