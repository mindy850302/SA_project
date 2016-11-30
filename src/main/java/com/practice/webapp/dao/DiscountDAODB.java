package com.practice.webapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.practice.webapp.entity.Discount;

public class DiscountDAODB implements DiscountDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<Discount> getList() {
		String sql = "SELECT * FROM Discount";
		return getList(sql);
		// TODO Auto-generated method stub
	}
	public List<Discount> getList(String sql) {
		
		List<Discount> DiscountList = new ArrayList<Discount>();
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Discount discount= new Discount();
				discount.setDiscount_id(rs.getInt("discount_id"));
				discount.setDiscount_M_id(rs.getInt("discount_M_id"));
				discount.setDiscount_date(rs.getString("discount_date"));
				discount.setDiscount_total(rs.getInt("discount_total"));
				discount.setDiscount_A_id(rs.getInt("discount_A_id"));
			
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
		return DiscountList;
	 }
	
    public Discount get(Discount discount) {
		// TODO Auto-generated method stub
    	discount = new Discount();
		String sql = "SELECT * FROM Discount WHERE discount_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if(rs.next()){
				discount.setDiscount_date(rs.getString("discount_date"));
				discount.setDiscount_total(rs.getInt("discount_total"));
				
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
		return discount;
	}


}
