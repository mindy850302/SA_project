package com.practice.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.entity.Return;

public class ReturnDAODB implements ReturnDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Return> getList(){
		String sql = "SELECT * FROM return";
		return getList(sql);
	}
	
	public List<Return> getList(String sql) {
		List<Return> ReturnList = new ArrayList<Return>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Return areturn = new Return();
				areturn.setReturn_A_id(rs.getInt("return_A_id"));
				areturn.setReturn_date(rs.getString("return_date"));
				areturn.setReturn_id(rs.getInt("return_id"));
				areturn.setReturn_M_id(rs.getInt("return_M_id"));
				areturn.setReturn_total(rs.getInt("return_total"));
				ReturnList.add(areturn);
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
		return ReturnList;
	}
	
	public void insert(Return aReturn) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO Return (return_A_id, return_date, return_id, return_M_id, return_total) VALUES(?, ?, ?, ?,?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aReturn.getReturn_A_id());
			smt.setString(2, aReturn.getReturn_date());
			smt.setInt(3, aReturn.getReturn_id());
			smt.setInt(4, aReturn.getReturn_M_id());
			smt.setInt(5, aReturn.getReturn_total());
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
		
		public Return get(long id) {
			Return areturn = new Return();
			String sql = "SELECT * FROM Return WHERE return_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setLong(1, id);
				rs = smt.executeQuery();
				if(rs.next()){
					areturn.setReturn_A_id(rs.getInt("return_A_id"));
					areturn.setReturn_date(rs.getString("return_date"));
					areturn.setReturn_id(rs.getInt("return_id"));
					areturn.setReturn_M_id(rs.getInt("return_M_id"));
					areturn.setReturn_total(rs.getInt("return_total"));
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
			return areturn;
		}
		
		public void update(Return aReturn,int id) {
			
			String sql = "UPDATE Return SET return_A_id=?, return_date=?, return_M_id=?, return_total=? "
					+ "WHERE return_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, aReturn.getReturn_A_id());
				smt.setString(2, aReturn.getReturn_date());
				smt.setInt(3, aReturn.getReturn_M_id());
				smt.setLong(4, aReturn.getReturn_total());
				smt.setInt(5, id);
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
		
		public void delete(long id) {
			String sql = "DELETE FROM Member WHERE return_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setLong(1, id);
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

