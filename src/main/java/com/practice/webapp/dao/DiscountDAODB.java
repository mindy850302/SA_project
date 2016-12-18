package com.practice.webapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import com.practice.webapp.entity.Comment;
import com.practice.webapp.entity.Discount;

public class DiscountDAODB implements DiscountDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int insert(Discount discount) {
		// TODO Auto-generated method stub
		int id =0;

		String sql = "INSERT INTO discount (discount_id,discount_order_id,discount_date,discount_total,discount_A_id) VALUES(?, ?, CURRENT_TIME(), ?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			System.out.println(discount.getDiscount_A_id());
			smt.setInt(1, discount.getDiscount_id());
			smt.setInt(2, discount.getDiscount_order_id());
			smt.setInt(3, discount.getDiscount_total());
			smt.setInt(4, discount.getDiscount_A_id());
			smt.executeUpdate();
			rs = smt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				   id = (int)rs.getLong(1);
				}

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
		return id;

	}

	@Override
	public void delete(Discount discount) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM discount WHERE discount_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, discount.getDiscount_id());
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

	@Override
	public void update(Discount discount) {
		// TODO Auto-generated method stub
		String sql = "UPDATE discount SET  discount_order_id=?,discount_date=?,discount_total=?,discount_A_id=? "
				+ "WHERE discount_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, discount.getDiscount_order_id());
			smt.setString(2, discount.getDiscount_date());
			smt.setInt(3, discount.getDiscount_total());
			smt.setInt(4, discount.getDiscount_A_id());
			smt.setInt(5, discount.getDiscount_id());
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

	public List<Discount> getList() {
		String sql = "SELECT * FROM discount a JOIN `order` b ON a.discount_order_id=b.order_id JOIN Administrator c ON a.discount_A_id=c.A_id Join Member d ON b.order_M_id=d.M_id";
		return getList(sql);
		// TODO Auto-generated method stub
	}

	public List<Discount> getList(String sql) {

		List<Discount> DiscountList = new ArrayList<Discount>();

		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Discount discount = new Discount();
				discount.setDiscount_id(rs.getInt("discount_id"));
				discount.setDiscount_order_id(rs.getInt("discount_order_id"));
				discount.setDiscount_date(rs.getString("discount_date"));
				discount.setDiscount_total(rs.getInt("discount_total"));
				discount.setDiscount_A_id(rs.getInt("discount_A_id"));
				discount.getMember().setM_name(rs.getString("M_name"));
				discount.getAdministrator().setM_name(rs.getString("A_name"));
				DiscountList.add(discount);

			}
			rs.close();
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
			if (rs.next()) {
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
				} catch (SQLException e) {
				}
			}
		}
		return discount;
	}

	@Override
	public List<Discount> search(String keyword) {
List<Discount> DiscountList = new ArrayList<Discount>();
		
		String sql = "SELECT * FROM discount WHERE discount_order_id LIKE '%"+keyword+"%'";
		System.out.println(sql);
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			System.out.println(keyword);
			
			rs = smt.executeQuery();
			while (rs.next()) {
				Discount discount = new Discount();
				discount.setDiscount_id(rs.getInt("	discount_id"));
				discount.setDiscount_order_id(rs.getInt("discount_order_id"));
				discount.setDiscount_date(rs.getString("discount_date"));
				discount.setDiscount_total(rs.getInt("discount_total"));
				discount.setDiscount_A_id(rs.getInt("discount_A_id"));
				DiscountList.add(discount);
			}
			rs.close();
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
		return DiscountList;
	}

}
