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
		String sql = "SELECT * FROM Product_category";
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
				product_category.setId(rs.getInt("Id"));
				product_category.setName(rs.getString("Name"));
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
	    String sql = "INSERT INTO Product_category (Id,Name) VALUES(?, ?)";	
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
	public Product_category get(long id) {
		Product_category product_category = new Product_category();
		String sql = "SELECT * FROM Product_category WHERE Id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			if(rs.next()){
				product_category.setId(rs.getInt("Id"));
				product_category.setName(rs.getString("Name"));
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


public void update(Product_category product_category,long id) {
		
		String sql = "UPDATE Product_category SET Id=?, Name=?"
				+ "WHERE Id = ?";
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
	

public void delete(long id) {
	
	String sql = "DELETE FROM Product_category WHERE Id = ?";
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
