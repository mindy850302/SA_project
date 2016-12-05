package com.practice.webapp.dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.practice.webapp.entity.A_category;

public class A_categoryDAODB implements A_categoryDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(A_category a_category){
		String sql = "INSERT INTO A_category (c_id,c_name) VALUES(?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, a_category.getC_id());
			smt.setString(2, a_category.getC_name());
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
	public void delete(A_category a_category){
		String sql = "DELETE FROM A_category WHERE c_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, a_category.getC_id());
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
	public void update(A_category a_category){
			// TODO Auto-generated method stub
			String sql = "UPDATE A_category SET c_id =?, c_name=? "+ "WHERE c_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, a_category.getC_id());
				smt.setString(2, a_category.getC_name());
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
	public List<A_category> getList() {
		String sql = "SELECT * FROM A_category";
		return getList(sql);
		// TODO Auto-generated method stub
	}
	public List<A_category> getList(String sql) {
		
		List<A_category> A_categoryList = new ArrayList<A_category>();
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				A_category a_category = new A_category();
				a_category.setC_id(rs.getInt("id"));
				a_category.setC_name(rs.getString("c_name"));
				A_categoryList.add(a_category);
			
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
		return A_categoryList;
	 }
	
    public A_category get(A_category a_category) {
		// TODO Auto-generated method stub
    	a_category = new A_category();
		String sql = "SELECT * FROM A_category WHERE id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if(rs.next()){
				a_category.setC_id(rs.getInt("C_id"));
				a_category.setC_name(rs.getString("C_name"));
				
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
		return a_category;
	}

}
