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
import com.practice.webapp.entity.ShoppingDetail;

public class ShoppingDetailDAODB implements ShoppingDetailDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<ShoppingDetail> getList(){
		String sql = "SELECT * FROM shoppingDetail a JOIN product b on a.shopping_p_id=b.p_id JOIN Member c on a.shopping_M_id=c.M_id";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<ShoppingDetail> getList(String sql) {
					
		List<ShoppingDetail> ShoppingDetailList = new ArrayList<ShoppingDetail>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Member member=new Member();
				Product product=new Product();
				ShoppingDetail shoppingdetail = new ShoppingDetail();
				shoppingdetail.setShopping_M_id(rs.getInt("shopping_M_id"));
				shoppingdetail.setShopping_p_id(rs.getInt("Shopping_p_id"));
				shoppingdetail.setP_amount(rs.getInt("p_amount"));
				shoppingdetail.setP_total(rs.getInt("p_total"));
				shoppingdetail.getMember().setM_idName(rs.getString("M_idName"));
				shoppingdetail.getMember().setM_id(rs.getInt("M_id"));
				shoppingdetail.getMember().setM_name(rs.getString("M_name"));
				shoppingdetail.getProduct().setP_name(rs.getString("p_name"));
				shoppingdetail.getProduct().setP_price(rs.getInt("p_price"));
				shoppingdetail.getProduct().setP_image(rs.getString("p_image"));
				ShoppingDetailList.add(shoppingdetail);
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
		return ShoppingDetailList;
	}
		  
	public void insert(ShoppingDetail shoppingdetail) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO shoppingDetail (shopping_p_id, p_amount, p_total, shopping_M_id) VALUES(? , ? , ? , ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, shoppingdetail.getShopping_p_id());
			smt.setInt(2, shoppingdetail.getP_amount());
			smt.setInt(3, shoppingdetail.getP_total());
			smt.setInt(4, shoppingdetail.getShopping_M_id());
			
			
		
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

	public ShoppingDetail get(ShoppingDetail shoppingdetail) {
		
		String sql = "SELECT * FROM shoppingDetail WHERE shopping_M_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, shoppingdetail.getShopping_M_id());
			rs = smt.executeQuery();
			if(rs.next()){
				
				shoppingdetail.getMember().setM_idName(rs.getString("M_idName"));
				shoppingdetail.getMember().setM_name(rs.getString("M_Name"));
				shoppingdetail.getProduct().setP_name(rs.getString("p_name"));
				shoppingdetail.getProduct().setP_price(rs.getInt("p_price"));
				shoppingdetail.setShopping_M_id(rs.getInt("M_id"));
				shoppingdetail.setShopping_p_id(rs.getInt("p_id"));
				shoppingdetail.setP_amount(rs.getInt("p_amount"));
				shoppingdetail.setP_total(rs.getInt("p_total"));
				shoppingdetail.getProduct().setP_image(rs.getString("p_image"));
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
		return shoppingdetail;
	}

	public void update(ShoppingDetail shoppingdetail) {
		
		String sql = "UPDATE shoppingDetail SET p_amount=? ,p_total=? "
				+ "WHERE shopping_M_id = ? AND shopping_p_id=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, shoppingdetail.getP_amount());
			smt.setInt(2, shoppingdetail.getP_total());
			smt.setInt(3, shoppingdetail.getShopping_M_id());
			smt.setInt(4, shoppingdetail.getShopping_p_id());
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
	
	public void delete(ShoppingDetail shoppingdetail) {
		
		String sql = "DELETE FROM shoppingDetail WHERE shopping_M_id = ? AND shopping_p_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, shoppingdetail.getShopping_M_id());
			smt.setLong(2, shoppingdetail.getShopping_p_id());
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
	public boolean checkLoginMember(ShoppingDetail shoppingdetail) {
		// TODO Auto-generated method stub
		return false;
	}
	public int getTotal(int M_id){
		String sql = "SELECT SUM(p_total) as AllTotal FROM shoppingDetail WHERE shopping_M_id = ?";
		int total=0;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, M_id);
			rs = smt.executeQuery();
			if(rs.next()){
				total=rs.getInt("AllTotal");
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
		return total;
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
	
			
	

}//ProductDAOBean

