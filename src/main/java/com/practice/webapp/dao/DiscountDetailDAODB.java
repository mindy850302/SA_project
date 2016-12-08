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
	public void insert(DiscountDetail discountDetail){
		String sql = "INSERT INTO discountDetail (discount_id,discount_p_id,p_amount,p_total) VALUES(?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, discountDetail.getDiscount_id());
			smt.setInt(2, discountDetail.getDiscount_p_id());
			smt.setInt(3, discountDetail.getP_amount());
			smt.setInt(4, discountDetail.getP_total());
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
	public void delete(DiscountDetail discountDetail){
		String sql = "DELETE FROM discountDetail WHERE discount_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, discountDetail.getDiscount_id());
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
	public void update(DiscountDetail discountDetail){
		String sql = "UPDATE discountDetail SET discount_p_id=?,p_amount=?,p_total=? "
				+ "WHERE discount_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, discountDetail.getDiscount_p_id());
			smt.setInt(2, discountDetail.getP_amount());
			smt.setInt(3, discountDetail.getP_total());
			smt.setInt(4, discountDetail.getDiscount_id());
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
	public List<DiscountDetail> getList() {
		String sql = "SELECT * FROM discountDetail a JOIN product b ON a.discount_p_id = b.p_id";
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
				discountDetail.getProduct().setP_name(rs.getString("p_name"));
				discountDetail.getProduct().setP_price(rs.getInt("p_price"));
				discountDetail.setP_amount(rs.getInt("p_amount"));
				discountDetail.setP_total(rs.getInt("p_total"));
				DiscountDetailList.add(discountDetail);
		
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
		String sql = "SELECT * FROM discountDetail WHERE discount_id = ?";
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


