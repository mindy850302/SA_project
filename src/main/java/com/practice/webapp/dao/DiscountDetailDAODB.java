package com.practice.webapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


import com.practice.webapp.entity.DiscountDetail;

public class DiscountDetailDAODB implements DiscountDetailDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<DiscountDetail> getList() {
		String sql = "SELECT * FROM DiscountDetail";
		return getList(sql);
		// TODO Auto-generated method stub
	}
	public List<DiscountDetail> getList(String sql) {
		
		List<DiscountDetail> DiscountDetailList = new ArrayList<DiscountDetail>();
		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				DiscountDetail discountDetail = new DiscountDetail();
				discountDetail.setDiscount_id(rs.getInt("discount_id"));
				discountDetail.setDiscount_p_id(rs.getInt("discount_p_id"));
				discountDetail.setP_amount(rs.getInt("p_amount"));
				discountDetail.setP_total(rs.getInt("p_total"));
		
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
		return DiscountDetailList;
	 }
	
    public DiscountDetail get(DiscountDetail discountDetail) {
		// TODO Auto-generated method stub
    	discountDetail = new DiscountDetail();
		String sql = "SELECT * FROM DiscountDetail WHERE discount_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			if(rs.next()){
				discountDetail.setP_amount(rs.getInt("p_amount"));
				discountDetail.setP_total(rs.getInt("p_total"));
				
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
		return discountDetail;
	}

}


