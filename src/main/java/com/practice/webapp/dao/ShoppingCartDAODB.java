
package com.practice.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


import com.practice.webapp.entity.ShoppingCart;

public class ShoppingCartDAODB implements ShoppingCartDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<ShoppingCart> getList(){
		String sql = "SELECT * FROM ShoppingCart";
		return getList(sql);
	}
	public List<ShoppingCart> getList(String sql) {
		
		List<ShoppingCart> ShoppingCartList = new ArrayList<ShoppingCart>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setM_id(rs.getInt("M_id"));
				shoppingCart.setshoppingcart_id(rs.getInt("shoppingcart_id"));
				shoppingCart.setShoppingAmount(rs.getInt("ShoppingAmount"));
				ShoppingCartList.add(shoppingCart);
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
		return ShoppingCartList;
	}

	
	// make it a generic method for different conditions

	  public void insert(ShoppingCart shoppingcart) {


	    String sql = "INSERT INTO ShoppingCart (M_id, shoppingcart_id,shoppingAmount) VALUES(?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setInt(1, shoppingcart.getM_id());
			smt.setInt(2, shoppingcart.getshoppingcart_id());
			smt.setInt(3, shoppingcart.getShoppingAmount());
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

	public ShoppingCart get(long id) {
		ShoppingCart shoppingCart = new ShoppingCart();
		String sql = "SELECT * FROM ShoppingCart WHERE shoppingcart_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			if(rs.next()){
				shoppingCart.setM_id(rs.getInt("M_id"));
				shoppingCart.setshoppingcart_id(rs.getInt("shoppingcart_id"));
				shoppingCart.setShoppingAmount(rs.getInt("shoppingAmount"));

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
		return shoppingCart;
	}

	public void update(ShoppingCart shoppingCart,int id) {
		
		String sql = "UPDATE ShoppingCart SET M_id=?, shoppingcart_id=?, ShoppingAmount=? "
				+ "WHERE shoppingcart_id= ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, shoppingCart.getshoppingcart_id());
			smt.setInt(2, shoppingCart.getM_id());
			smt.setInt(3, shoppingCart.getShoppingAmount());
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
		
		String sql = "DELETE FROM ShoppingCart WHERE shoppingcart_id = ?";
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
//	public boolean checkLoginShoppingCart(int M_id){
//		boolean flag=false;
//		
//		String sql="SELECT * FROM ShoppingCart";
//		
//		try {
//			conn = dataSource.getConnection();
//			smt = conn.prepareStatement(sql);
//			rs = smt.executeQuery();
//			while(rs.next()){
//				
//				 M_id=rs.getInt("M_id");
//				if(M_id!= null){
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
//		return flag;
//	}
//
//		return false;
//		
//	}
//		

}//ProductDAOBean

