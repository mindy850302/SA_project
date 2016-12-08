package com.practice.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.entity.OrderDetail;

public class OrderDetailDAODB implements OrderDetailDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<OrderDetail> getList(){
		String sql = "SELECT * FROM orderDetail a JOIN product b ON a.order_p_id =b.p_id";
		return getList(sql);
	}
	
	
	public List<OrderDetail> getList(String sql) {
		
		List<OrderDetail> OrderDetailList = new ArrayList<OrderDetail>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderDetail_id(rs.getInt("orderDetail_id"));
				orderDetail.setOrder_p_id(rs.getInt("order_p_id"));
				orderDetail.getProduct().setP_name(rs.getString("p_name"));
				orderDetail.getProduct().setP_price(rs.getInt("p_price"));
				orderDetail.setP_amount(rs.getInt("p_amount"));
				orderDetail.setP_total(rs.getInt("p_price")*rs.getInt("p_amount"));
				OrderDetailList.add(orderDetail);
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
		return OrderDetailList;
	}
	public void insert(OrderDetail orderDetail) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO orderDetail ( order_p_id,p_amount,p_total ) VALUES(  ? , ? , ? )";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderDetail.getOrder_p_id());
			smt.setInt(2, orderDetail.getP_amount());
			smt.setInt(3, orderDetail.getP_total());
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
	public OrderDetail get(OrderDetail orderDetail) {
		int orderDetail_id=orderDetail.getOrderDetail_id();
		List<OrderDetail> OrderDetailList = new ArrayList<OrderDetail>();
		String sql = "SELECT * FROM orderDetail WHERE orderDetail_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, orderDetail_id);
			rs = smt.executeQuery();
			if(rs.next()){
				orderDetail.setOrder_p_id(rs.getInt("order_p_id"));
				orderDetail.setP_amount(rs.getInt("p_amount"));
				orderDetail.setP_total(rs.getInt("p_total"));
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
		return orderDetail;
	}

public void update(OrderDetail orderDetail) {
		String sql = "UPDATE order SET order_p_id=?, p_amount=?,p_total=? "
				+ "WHERE orderDetail_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, orderDetail.getOrder_p_id());
			smt.setInt(2, orderDetail.getP_amount());
			smt.setInt(3, orderDetail.getP_total());
			smt.setInt(7, orderDetail.getOrderDetail_id());
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
public void delete(OrderDetail orderDetail) {
	List<OrderDetail> OrderDetailList = new ArrayList<OrderDetail>();
	String sql = "DELETE FROM orderDetail WHERE orderDetail_id = ?";
	try {
		conn = dataSource.getConnection();
		smt = conn.prepareStatement(sql);
		smt.setInt(1, orderDetail.getOrderDetail_id());
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
