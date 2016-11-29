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

	
	public void insert(Administrator administrator) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Member (A_idName, A_name, A_phone, A_email,A_address,A_discount,A_password,A_create_date) VALUES(?, ?, ?, ? , ? , ? , ? , ?)";	
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

	
	public void delete(Administrator aAdministrator) {
		// TODO Auto-generated method stub
		
	}

	
	public void update(Administrator aAdministrator) {
		// TODO Auto-generated method stub
		
	}

	
	public void register(Administrator aAdministrator) {
		// TODO Auto-generated method stub
		
	}

	
	public void login(Administrator aAdministrator) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Administrator> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Administrator get(Administrator aAdministrator) {
		// TODO Auto-generated method stub
		return null;
	}

}
