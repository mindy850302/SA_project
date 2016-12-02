package com.practice.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.practice.webapp.entity.Return;
import com.practice.webapp.entity.ShipProduct;
public class ShipProductDAODB implements ShipProductDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<ShipProduct> getList(){
		String sql = "SELECT * FROM return";
		return getList(sql);
	}
	
	public List<ShipProduct> getList(String sql) {
		List<ShipProduct> ShipProductList = new ArrayList<ShipProduct>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				ShipProduct shipProduct = new ShipProduct();
				
				(shipProduct).setShipProduct_id(rs.getInt("ShipProduct_id"));
				shipProduct.setShipProduct_Date(rs.getString("ShipProduct_date"));
				
				shipProduct.setShipProduct_price(rs.getInt("ShipProduct_price"));
				ShipProductList.add(shipProduct);
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
		return ShipProductList;
	}
	
	public void insert(ShipProduct shipproduct) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO Return (ShipProduct_id,ShipProduct_date,ShipProduct_price) VALUES(?, ?, ?, ?,?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, shipproduct.getShipProduct_id());
			smt.setString(2, shipproduct.getShipProduct_Date());
			
			smt.setInt(3, shipproduct.getShipProduct_price());
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
		
		public ShipProduct get(long id) {
			ShipProduct shipproduct = new ShipProduct();
			String sql = "SELECT * FROM ShipProduct WHERE shipproduct_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setLong(1, id);
				rs = smt.executeQuery();
				if(rs.next()){
					shipproduct.setShipProduct_id(rs.getInt("ShipProduct_id"));
					shipproduct.setShipProduct_Date(rs.getString("ShipProduct_date"));
					
					shipproduct.setShipProduct_price(rs.getInt("ShipProduct_price"));
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
			return shipproduct;
		}
		
		@Autowired
		public void update(ShipProduct shipproduct,long id) {
			
			String sql = "UPDATE ShipProduct SET ShipProduct_id=?, ShipProduct_Date=?, ShipProduct_price=?,  "
					+ "WHERE ShipProduct_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, shipproduct.getShipProduct_id());
				smt.setString(2, shipproduct.getShipProduct_Date());
				smt.setInt(3, shipproduct.getShipProduct_id());
				smt.setLong(4, shipproduct.getShipProduct_price());
				smt.setLong(5, id);
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

