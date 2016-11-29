package com.practice.webapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.practice.webapp.entity.Administrator;

public class AdministratorDAODB implements AdministratorDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public void insert(Administrator administrator) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Administrator (A_idName, A_name, A_phone, A_email,A_address,A_discount,A_password,A_create_date) VALUES(?, ?, ?, ? , ? , ? , ? , ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, administrator.getA_idName());
			smt.setString(2, administrator.getA_name());
			smt.setInt(3, administrator.getA_phone());
			smt.setString(4, administrator.getA_email());
			smt.setString(5, administrator.getA_address());
			smt.setString(6, administrator.getA_password());
			smt.setString(7, administrator.getA_create_date());
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
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Administrator WHERE A_id = ?";
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


	public void update( Administrator administrator,long id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Administrator SET A_Name=?, A_idName=?, A_phone=?, A_email=?,A_address=?,A_password=?,A_create_date=?,A_update_date=? "
				+ "WHERE A_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, administrator.getA_idName());
			smt.setString(2, administrator.getA_name());
			smt.setInt(3, administrator.getA_phone());
			smt.setString(4, administrator.getA_email());
			smt.setString(5, administrator.getA_address());
			smt.setString(6, administrator.getA_password());
			smt.setString(7, administrator.getA_create_date());
			smt.setString(8, administrator.getA_update_date());
			smt.setLong(9,id);
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
	public boolean checkLoginAdministrator(String A_idName, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="SELECT * FROM Administrator";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				String Administrator_idName=rs.getString("A_idName");
				String Administrator_pwd=rs.getString("A_password");
				if(Administrator_idName==A_idName&&password.equals(Administrator_pwd)){
					flag=true;
				}
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
		return flag;
	}

	
	public List<Administrator> getList(String sql) {
		List<Administrator> AdministratorList = new ArrayList<Administrator>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Administrator administrator = new Administrator();
				administrator.setA_id(rs.getInt("A_id"));
				administrator.setA_idName(rs.getString("A_idName"));
				administrator.setA_name(rs.getString("A_Name"));
				administrator.setA_phone(rs.getInt("A_phone"));
				administrator.setA_email(rs.getString("A_email"));
				administrator.setA_address(rs.getString("A_address"));
				administrator.setA_password(rs.getString("A_password"));
				administrator.setA_create_date(rs.getString("A_create_date"));
				administrator.setA_update_date(rs.getString("A_update_date"));
				AdministratorList.add(administrator);
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
		return AdministratorList;
	}

	
	public Administrator get(Administrator administrator) {
		String sql = "SELECT * FROM Administrator WHERE A_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, administrator.getA_id());
			rs = smt.executeQuery();
			if(rs.next()){
				administrator.setA_idName(rs.getString("A_idName"));
				administrator.setA_name(rs.getString("A_name"));
				administrator.setA_create_date(rs.getString("A_create_date"));
				administrator.setA_update_date(rs.getString("A_update_date"));
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
		return administrator;
		
	}
	
	
}
