package com.practice.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import com.practice.webapp.entity.Order;

public class OrderDAODB implements OrderDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<Order> getList(){
		String sql = "SELECT * FROM `order` a JOIN Member b ON a.order_M_id=b.M_id";
		return getList(sql);
	}
	
	
	public List<Order> getList(String sql) {
		
		List<Order> OrderList = new ArrayList<Order>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setOrder_M_id(rs.getInt("order_M_id"));
				order.getMember().setM_idName(rs.getString("M_idName"));
				order.getMember().setM_name(rs.getString("M_name"));
				order.setO_date(rs.getString("O_date"));
				order.setReceiver_name(rs.getString("receiver_name"));
				order.setReceiver_phone(rs.getString("receiver_phone"));
				order.setReceiver_address(rs.getString("receiver_address"));
				order.setTotal(rs.getInt("total"));
				order.setShipping(rs.getInt("shipping"));
				order.setShipping_Date(rs.getString("shipping_Date"));
				order.setOrder_status(rs.getInt("order_status"));
				OrderList.add(order);
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
		return OrderList;
	}


	public int insert(Order order) {
		int id =0;
		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO `order` ( order_M_id,total, O_date,receiver_name,receiver_phone,receiver_address,shipping,order_status) VALUES(  ? , ? ,CURRENT_TIME() , ? , ? , ?,0,0)";	

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			smt.setInt(1, order.getOrder_M_id());
			smt.setInt(2, order.getTotal());
			//smt.setString(3, order.getO_date());
			smt.setString(3, order.getReceiver_name());
			smt.setString(4, order.getReceiver_phone());
			smt.setString(5, order.getReceiver_address());
			smt.executeUpdate();
			rs = smt.getGeneratedKeys();
			
			if (rs != null && rs.next()) {
				   id = (int)rs.getLong(1);
				}
			System.out.println(id);
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
		return id;
	}
	public Order get(Order order) {
		int order_id=order.getOrder_id();
		List<Order> OrderList = new ArrayList<Order>();
		String sql = "SELECT * FROM `order` WHERE order_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, order_id);
			rs = smt.executeQuery();
			if(rs.next()){
				order.setOrder_M_id(rs.getInt("order_M_id"));
				order.setTotal(rs.getInt("total"));
				order.setO_date(rs.getString("O_date"));
				order.setReceiver_name(rs.getString("receiver_name"));
				order.setReceiver_phone(rs.getString("receiver_phone"));
				order.setReceiver_address(rs.getString("receiver_address"));
				order.setReceiver_address(rs.getString("shipping"));
				order.setShipping_Date(rs.getString("shipping_Date"));
				order.setOrder_status(rs.getInt("order_status"));
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
		return order;
	}

public void update(Order order) {
	String sql="";
		try {
			if(order.getShipping()==0){
				 sql = "UPDATE `order` SET order_M_id=?, total=?,O_date=?, receiver_name=?,receiver_phone=?,receiver_address=?,shipping=? "
						+ "WHERE order_id = ?";
			}else{
				 sql = "UPDATE `order` SET order_M_id=?, total=?,O_date=?, receiver_name=?,receiver_phone=?,receiver_address=?,shipping=?,shipping_Date=CURRENT_TIME()  "
						+ "WHERE order_id = ?";
			}
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, order.getOrder_M_id());
			smt.setInt(2, order.getTotal());
			smt.setString(3, order.getO_date());
			smt.setString(4, order.getReceiver_name());
			smt.setString(5, order.getReceiver_phone());
			smt.setString(6, order.getReceiver_address());
			smt.setInt(7, order.getShipping());
			smt.setInt(8, order.getOrder_id());
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
public void delete(Order order) {
	List<Order> OrderList = new ArrayList<Order>();
	String sql = "DELETE FROM `order` WHERE order_id = ?";
	try {
		conn = dataSource.getConnection();
		smt = conn.prepareStatement(sql);
		smt.setLong(1, order.getOrder_id());
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
public List<Order> getOrderShippingList(){
	String sql = "select datediff(CURRENT_TIME,O_date) as Subtract,order_id,order_M_id,total,O_date,M_name,shipping from `order` a JOIN Member b on a.order_M_id=b.M_id WHERE datediff(CURRENT_TIME,O_date)>3 and shipping=0";
	List<Order> OrderList = new ArrayList<Order>();
	try {
		conn = dataSource.getConnection();
		smt = conn.prepareStatement(sql);
		rs = smt.executeQuery();
		while(rs.next()){
			Order order = new Order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setOrder_M_id(rs.getInt("order_M_id"));
			order.setO_date(rs.getString("O_date"));
			order.setTotal(rs.getInt("total"));
			order.getMember().setM_name(rs.getString("M_name"));
			order.setShipping(rs.getInt("shipping"));
			order.setOverShipping(rs.getInt("Subtract"));
			OrderList.add(order);
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
	return OrderList;
}
public void updateOrder_status(Order order) {
	String sql="UPDATE `order` SET order_status=1 " + "WHERE order_id = ?";
	try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, order.getOrder_id());
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
