package com.practice.webapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
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
		String sql = "SELECT * FROM `return` a JOIN Member b ON a.return_M_id=b.M_id JOIN Administrator c ON a.return_A_id=c.A_id";
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
				areturn.getMember().setM_name(rs.getString("M_name"));
				areturn.getAdministrato().setM_name(rs.getString("M_name"));
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
	
	public int insert(Return areturn) {
		int id =0;
		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO `return`(`return_M_id`,`return_date`,`return_total`,`return_A_id`) VALUES(?,?,?,?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			System.out.println(id);

			smt.setInt(1, areturn.getReturn_M_id());
			smt.setString(2, areturn.getReturn_date());
			smt.setInt(3, areturn.getReturn_total());
			smt.setInt(4, areturn.getReturn_A_id());
			smt.executeUpdate();	
			rs = smt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				   id = (int)rs.getLong(1);
				}
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
		return id;
	}
		
		public Return get(Return areturn) {
			String sql = "SELECT * FROM `return` WHERE `return_id` = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, areturn.getReturn_id());
				rs = smt.executeQuery();
				if(rs.next()){
					areturn.setReturn_A_id(rs.getInt("return_A_id"));
					areturn.setReturn_date(rs.getString("return_date"));
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
		
		public void update(Return areturn) {
			
			String sql = "UPDATE `return` SET `return_A_id`=?, `return_date`=?, `return_M_id`=?, `return_total`=? "
					+ "WHERE `return_id` =?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, areturn.getReturn_A_id());
				smt.setString(2, areturn.getReturn_date());
				smt.setInt(3, areturn.getReturn_M_id());
				smt.setInt(4, areturn.getReturn_total());
				smt.setInt(5, areturn.getReturn_id());
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
		
		public void delete(Return areturn) {
			String sql = "DELETE FROM `return` WHERE `return_id` = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, areturn.getReturn_id());
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

