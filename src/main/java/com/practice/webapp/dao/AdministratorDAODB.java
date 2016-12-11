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
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Administrator administrator) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Administrator (A_idName, A_name, A_phone, A_email,A_address,A_password,A_create_date,A_category) VALUES(?, ?, ?, ?, ?, ?, CURRENT_TIME(),  ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, administrator.getM_idName());
			smt.setString(2, administrator.getM_name());
			smt.setString(3, administrator.getM_phone());
			smt.setString(4, administrator.getM_email());
			smt.setString(5, administrator.getM_address());
			smt.setString(6, administrator.getM_pwd());
			smt.setInt(7, administrator.getA_category());
			smt.executeUpdate();
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

	}

	public void delete(Administrator administrator) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Administrator WHERE A_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, administrator.getA_id());
			smt.executeUpdate();
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

	}

	public void update(Administrator administrator) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Administrator SET A_name=?, A_idName=?, A_phone=?, A_email=?,A_address=?,A_password=?,A_update_date=CURRENT_TIME(),A_category=? "
				+ "WHERE A_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, administrator.getM_name());
			smt.setString(2, administrator.getM_idName());
			smt.setString(3, administrator.getM_phone());
			smt.setString(4, administrator.getM_email());
			smt.setString(5, administrator.getM_address());
			smt.setString(6, administrator.getM_pwd());
			smt.setInt(7, administrator.getA_category());
			smt.setInt(8, administrator.getA_id());
			smt.executeUpdate();
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

	}

	public boolean checkLoginAdministrator(Administrator administrator){
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "SELECT * FROM Administrator";

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				String Administrator_idName = rs.getString("A_idName");
				String Administrator_pwd = rs.getString("A_password");
				if (Administrator_idName.equals(administrator.getM_idName()) && Administrator_pwd.equals(administrator.getM_pwd())) {
					flag = true;
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
				} catch (SQLException e) {
				}
			}
		}
		return flag;
	}

	public List<Administrator> getList() {
		String sql = "SELECT * FROM Administrator a JOIN A_category b ON a.A_category = b.id";
		return getList(sql);
	}

	public List<Administrator> getList(String sql) {
		List<Administrator> AdministratorList = new ArrayList<Administrator>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Administrator administrator = new Administrator();
				administrator.setA_id(rs.getInt("A_id"));
				administrator.setM_idName(rs.getString("A_idName"));
				administrator.setM_name(rs.getString("A_name"));
				administrator.setM_phone(rs.getString("A_phone"));
				administrator.setM_email(rs.getString("A_email"));
				administrator.setM_address(rs.getString("A_address"));
				administrator.setM_pwd(rs.getString("A_password"));
				administrator.setM_create_date(rs.getString("A_create_date"));
				administrator.setM_update_date(rs.getString("A_update_date"));
				administrator.setA_category(rs.getInt("A_category"));
				administrator.getA_category1().setC_name(rs.getString("c_name"));
//				administrator.getA_category1().setC_id(rs.getInt("id"));
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
				} catch (SQLException e) {
				}
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
			if (rs.next()) {
				administrator.setM_idName(rs.getString("A_idName"));
				administrator.setM_name(rs.getString("A_name"));
				administrator.setM_phone(rs.getString("A_phone"));
				administrator.setM_email(rs.getString("A_email"));
				administrator.setM_address(rs.getString("A_address"));
				administrator.setM_pwd(rs.getString("A_password"));
				administrator.setM_create_date(rs.getString("A_create_date"));
				administrator.setM_update_date(rs.getString("A_update_date"));
				administrator.setA_category(rs.getInt("A_category"));
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
		return administrator;

	}

}
