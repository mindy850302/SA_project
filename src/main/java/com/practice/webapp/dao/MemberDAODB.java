/**
 * sample program for web programming written by Ben Wu
 * reference: http://www.mkyong.com/spring/maven-spring-jdbc-example/
 */
package com.practice.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.entity.Member;

public class MemberDAODB implements MemberDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<Member> getList(){
		String sql = "SELECT * FROM Member";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<Member> getList(String sql) {
					
		List<Member> MemberList = new ArrayList<Member>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Member member = new Member();
				member.setM_id(rs.getInt("M_id"));
				member.setM_idName(rs.getString("M_idName"));
				member.setM_name(rs.getString("M_Name"));
				member.setM_phone(rs.getString("M_phone"));
				member.setM_email(rs.getString("M_email"));
				member.setM_address(rs.getString("M_address"));
				member.setM_discount(rs.getInt("M_discount"));
				member.setM_pwd(rs.getString("M_pwd"));
				member.setM_create_date(rs.getString("M_create_date"));
				member.setM_update_date(rs.getString("M_update_date"));
				MemberList.add(member);
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
		return MemberList;
	}
		  
	public void insert(Member member) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO Member (M_idName, M_name, M_phone, M_email,M_address,M_discount,M_pwd,M_create_date) VALUES(?, ?, ?, ? , ? , ? , ? , ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getM_idName());
			smt.setString(2, member.getM_name());
			smt.setString(3, member.getM_phone());
			smt.setString(4, member.getM_email());
			smt.setString(5, member.getM_address());
			smt.setInt(6, member.getM_discount());
			smt.setString(7, member.getM_pwd());
			smt.setString(8, member.getM_create_date());
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

	public Member get(int id) {
		Member member = new Member();
		String sql = "SELECT * FROM Member WHERE M_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			if(rs.next()){
				member.setM_id(rs.getInt("M_id"));
				member.setM_idName(rs.getString("M_idName"));
				member.setM_name(rs.getString("M_Name"));
				member.setM_phone(rs.getString("M_phone"));
				member.setM_email(rs.getString("M_email"));
				member.setM_address(rs.getString("M_address"));
				member.setM_discount(rs.getInt("M_discount"));
				member.setM_pwd(rs.getString("M_pwd"));
				member.setM_create_date(rs.getString("M_create_date"));
				member.setM_update_date(rs.getString("M_update_date"));
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
		return member;
	}

	public void update(Member member,int id) {
		
		String sql = "UPDATE Member SET M_idName=?, M_name=?, M_phone=?, M_email=?,M_address=?,M_discount=?,M_pwd=?,M_update_date=? "
				+ "WHERE M_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getM_idName());
			smt.setString(2, member.getM_name());
			smt.setString(3, member.getM_phone());
			smt.setString(4, member.getM_email());
			smt.setString(5, member.getM_address());
			smt.setInt(6, member.getM_discount());
			smt.setString(7, member.getM_pwd());
			smt.setString(8, member.getM_update_date());
			smt.setInt(9,id);
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
	
	public void delete(int id) {
		
		String sql = "DELETE FROM Member WHERE M_id = ?";
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

//	public int count(){
//		String sql="SELECT DATE_FORMAT(M_create_date, '%Y%m' ) as time  ,  count (*)  as count  FROM Member  GROUP BY time";
//		
//		try {
//			conn = dataSource.getConnection();
//			smt = conn.prepareStatement(sql);
//			rs = smt.executeQuery();
//			while(rs.next()){
//				String Member_idName=rs.getString("M_idName");
//				String Member_pwd=rs.getString("M_pwd");
//				if(Member_idName==M_idName&&password.equals(Member_pwd)){
//					flag=true;
//				}
//		}
//			rs.close();
//			smt.close();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
// 
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {}
//			}
//		}
//	}
	public boolean checkLoginMember(String M_idName, String password){
		boolean flag=false;
		String sql="SELECT * FROM Member";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				String Member_idName=rs.getString("M_idName");
				String Member_pwd=rs.getString("M_pwd");
				if(Member_idName==M_idName&&password.equals(Member_pwd)){
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
	

}//ProductDAOBean

