package com.practice.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.entity.ReturnDetail;

public class ReturnDetailDAODB implements ReturnDetailDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<ReturnDetail> getList(){
		String sql = "SELECT * FROM ReturnDetail";
		return getList(sql);
	}
	
	public List<ReturnDetail> getList(String sql) {
		List<ReturnDetail> ReturnDetailList = new ArrayList<ReturnDetail>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				ReturnDetail return_detail = new ReturnDetail();
				return_detail.setP_amount(rs.getInt("p_amount"));
				return_detail.setP_total(rs.getInt("p_total"));
				return_detail.setReturn_id(rs.getInt("return_id"));
				return_detail.setReturn_p_id(rs.getInt("return_p_id"));
				ReturnDetailList.add(return_detail);
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
		return ReturnDetailList;
	}
	
	public void insert(ReturnDetail return_detail) {
		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO Return (p_amount, p_total, return_id, return_p_id) VALUES(?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, return_detail.getP_amount());
			smt.setInt(2, return_detail.getP_total());
			smt.setInt(3, return_detail.getReturn_id());
			smt.setInt(4, return_detail.getReturn_p_id());
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
		
		public ReturnDetail get(ReturnDetail return_detail) {
			String sql = "SELECT * FROM ReturnDetail WHERE return_id =? AND return_p_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, return_detail.getReturn_id());
				smt.setInt(2, return_detail.getReturn_p_id());
				rs = smt.executeQuery();
				if(rs.next()){
					return_detail.setP_amount(rs.getInt("p_amount"));
					return_detail.setP_total(rs.getInt("return_date"));
					return_detail.setReturn_id(rs.getInt("return_id"));
					return_detail.setReturn_p_id(rs.getInt("return_p_id"));
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
			return return_detail;
		}
		
		public void update(ReturnDetail return_detail) {
			String sql = "UPDATE ReturnDetail SET p_amount=?, p_total=? "
					+ "WHERE return_id = ? AND return_p_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, return_detail.getP_amount());
				smt.setInt(2, return_detail.getP_total());
				smt.setInt(3, return_detail.getReturn_id());
				smt.setInt(4, return_detail.getReturn_p_id());
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
		public void delete(ReturnDetail return_detail) {
			String sql = "DELETE FROM Member WHERE return_id = ? AND return_p_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, return_detail.getReturn_id());
				smt.setInt(2, return_detail.getReturn_p_id());
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
		
	}