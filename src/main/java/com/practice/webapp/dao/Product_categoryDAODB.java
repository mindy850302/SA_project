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


import com.practice.webapp.entity.Product_category;

public class Product_categoryDAODB implements Product_categoryDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<Product_category> getList(){
		String sql = "SELECT * FROM product_category";
		return getList(sql);
	}
	public List<Product_category> getList(String sql) {
		
		List<Product_category> Product_categoryList = new ArrayList<Product_category>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Product_category product_category = new Product_category();
				product_category.setId(rs.getInt("id"));
				product_category.setName(rs.getString("name"));
				Product_categoryList.add(product_category);
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
		return Product_categoryList;
	}
	public void insert(Product_category product_category) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO product_category (id,name) VALUES(?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, product_category.getId());
			smt.setString(2, product_category.getName());
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
	public Product_category get(Product_category product_category) {
	 product_category = new Product_category();
		String sql = "SELECT * FROM product_category WHERE id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if(rs.next()){
				product_category.setId(rs.getInt("id"));
				product_category.setName(rs.getString("name"));
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
		return product_category;
	}


public void update(Product_category product_category) {
		
		String sql = "UPDATE product_category SET id=?, name=?"
				+ "WHERE id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, product_category.getId());
			smt.setString(2, product_category.getName());
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
	

public void delete(Product_category product_category) {
	
	String sql = "DELETE FROM Product_category WHERE Id = ?";
	try {
		conn = dataSource.getConnection();
		smt = conn.prepareStatement(sql);
		smt.setInt(1, product_category.getId());
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
