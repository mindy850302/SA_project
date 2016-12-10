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
import com.practice.webapp.entity.Product;

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
				System.out.println("phone in dao"+rs.getString("M_phone"));
				member.setM_email(rs.getString("M_email"));
				member.setM_address(rs.getString("M_address"));
				member.setM_discount(rs.getInt("M_discount"));
				member.setM_pwd(rs.getString("M_password"));
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
	    String sql = "INSERT INTO Member (M_idName, M_name, M_phone, M_email,M_address,M_discount,M_password,M_create_date) VALUES(?, ?, ?, ? , ? , ? , ? , CURRENT_TIME())";	
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

	public Member get(Member member) {
		
		String sql = "SELECT * FROM Member WHERE M_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, member.getM_id());
			rs = smt.executeQuery();
			if(rs.next()){
				member.setM_id(rs.getInt("M_id"));
				member.setM_idName(rs.getString("M_idName"));
				member.setM_name(rs.getString("M_Name"));
				member.setM_phone(rs.getString("M_phone"));
				member.setM_email(rs.getString("M_email"));
				member.setM_address(rs.getString("M_address"));
				member.setM_discount(rs.getInt("M_discount"));
				member.setM_pwd(rs.getString("M_password"));
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

	public void update(Member member) {
		
		String sql = "UPDATE Member SET M_idName=?, M_name=?, M_phone=?, M_email=?,M_address=?,M_discount=?,M_password=?,M_update_date=CURRENT_TIME() "
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
			
			smt.setInt(8,member.getM_id());
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
	
	public void delete(Member member) {
		
		String sql = "DELETE FROM Member WHERE M_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, member.getM_id());
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
	public List<Member> search(String keyword) {
		List<Member> MemberList = new ArrayList<Member>();
		
		String sql = "SELECT * FROM Member WHERE M_name LIKE '%"+keyword+"%'";
		System.out.println(sql);
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			System.out.println(keyword);
			
			rs = smt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setM_id(rs.getInt("M_id"));
				member.setM_email(rs.getString("M_email"));
				member.setM_address(rs.getString("M_address"));
				member.setM_discount(rs.getInt("M_discount"));
				member.setM_pwd(rs.getString("M_password"));
				member.setM_create_date(rs.getString("M_create_date"));
				member.setM_update_date(rs.getString("M_update_date"));
				member.setM_name(rs.getString("M_name"));
				member.setM_phone(rs.getString("M_phone"));
				member.setM_idName(rs.getString("M_idName"));
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
				} catch (SQLException e) {
				}

			}

		}
		return MemberList;
	}
	public int countMember() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(M_create_date) as Count_member FROM `Member` WHERE month(M_create_date)=month(CURRENT_TIME)";
		int count=0;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				count=rs.getInt("Count_member");
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
		return count;
		
	}
	public boolean checkLoginMember(Member member){
		boolean flag=false;
		String sql="SELECT * FROM Member where binary M_idName=?";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			System.out.println("id:"+member.getM_idName());
			smt.setString(1, member.getM_idName());
			rs = smt.executeQuery();
			if(rs.next()){
				String Member_idName=rs.getString("M_idName");
				String Member_pwd=rs.getString("M_password");
				System.out.println("id2:"+Member_idName);
				System.out.println("password:"+Member_pwd);
				
				
				if(Member_pwd.equals(member.getM_pwd())){
					flag=true;//登入成功
				}
				else{
					flag=false;//密碼錯誤，到signup頁面
					
				}
				
			}
			
			rs.close();
			smt.close();
		} 
			catch (SQLException e) {
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
	
	public boolean checkLoginAdministrator(Member member){
		boolean flag=false;
		String sql="SELECT * FROM Administrator where binary A_idName=?";
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			System.out.println("id:"+member.getM_idName());
			smt.setString(1, member.getM_idName());
			rs = smt.executeQuery();
			if(rs.next()){
				String A_idName=rs.getString("A_idName");
				String A_pwd=rs.getString("A_password");
				System.out.println("id2:"+A_idName);
				System.out.println("password:"+A_pwd);
				
				
				if(A_pwd.equals(member.getM_pwd())){
					flag=true;//登入成功
				}
				else{
					flag=false;//密碼錯誤，到signup頁面
					
				}
				
			}
			
			rs.close();
			smt.close();
		} 
			catch (SQLException e) {
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

