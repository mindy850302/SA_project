package com.practice.webapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.entity.Product;

public class ProductDAODB implements ProductDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private ResultSet rs1 = null;
	private PreparedStatement smt = null;
	private PreparedStatement smt1 = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Product> getList() {

		String sql = "SELECT * FROM product";
		return getList(sql);
	}

	public List<Product> getList(String sql) {

		List<Product> ProductList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setP_id(rs.getInt("p_id"));
				product.setP_category(rs.getInt("p_category"));
				product.setClick_count(rs.getInt("click_count"));
				product.setP_describe(rs.getString("p_describe"));
				product.setP_image(rs.getString("p_image"));
				product.setP_inventory(rs.getInt("p_inventory"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setAverage(rs.getInt("average"));
				product.setP_onsale_date(rs.getString("p_onsale_date"));
				product.setP_remove_date(rs.getString("p_remove_date"));
				product.setP_update_date(rs.getString("p_update_date"));
				product.setSale(rs.getInt("sale"));
				ProductList.add(product);
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
		return ProductList;
	}

	public void insert(Product product) {

		// remove first parameter when Id is auto-increment
		String sql = "INSERT INTO product ( p_category,click_count, p_describe,p_image,p_inventory,p_name,p_price,p_onsale_date,sale) VALUES( ?, ?, ? , ? , ? , ? , ? , ? ,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, product.getP_category());
			smt.setInt(2, product.getClick_count());
			smt.setString(3, product.getP_describe());
			smt.setString(4, product.getP_image());
			smt.setInt(5, product.getP_inventory());
			smt.setString(6, product.getP_name());
			smt.setInt(7, product.getP_price());
			smt.setString(8, product.getP_onsale_date());
			smt.setInt(9,product.isSale());

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

	public Product get(Product product) {
		List<Product> ProductList = new ArrayList<Product>();

		String sql = "SELECT * FROM product WHERE p_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, product.getP_id());
			rs = smt.executeQuery();
			while (rs.next()) {
				product.setP_id(rs.getInt("p_id"));
				product.setP_category(rs.getInt("p_category"));
				product.setClick_count(rs.getInt("click_count"));
				product.setP_describe(rs.getString("p_describe"));
				product.setP_image(rs.getString("p_image"));
				product.setP_inventory(rs.getInt("p_inventory"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setAverage(rs.getInt("average"));
				product.setSale(rs.getInt("sale"));
				product.setP_onsale_date(rs.getString("p_onsale_date"));
				product.setP_remove_date(rs.getString("p_remove_date"));
				product.setP_update_date(rs.getString("p_update_date"));
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
		return product;
	}

	public void update(Product product) {
		String sql = "UPDATE product SET click_count=?, p_describe=?,p_image=?, p_inventory=?,sale=?,p_name=?,p_price=?,p_update_date=CURRENT_TIME() "
				+ "WHERE p_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, product.getClick_count());
			smt.setString(2, product.getP_describe());
			smt.setString(3, product.getP_image());
			smt.setInt(4, product.getP_inventory());
			smt.setInt(5, product.isSale());
			smt.setString(6, product.getP_name());
			smt.setInt(7, product.getP_price());
			
			smt.setInt(8, product.getP_id());
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

	public void delete(Product product) {
		String sql = "DELETE FROM product WHERE p_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, product.getP_id());
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
	public List<Product> search(String keyword) {
		List<Product> ProductList = new ArrayList<Product>();
		
		String sql = "SELECT * FROM product WHERE p_name LIKE '%"+keyword+"%'";
		System.out.println(sql);
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			System.out.println(keyword);
			
			rs = smt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setP_id(rs.getInt("p_id"));
				product.setP_category(rs.getInt("p_category"));
				product.setClick_count(rs.getInt("click_count"));
				product.setP_describe(rs.getString("p_describe"));
				product.setP_image(rs.getString("p_image"));
				product.setP_inventory(rs.getInt("p_inventory"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_onsale_date(rs.getString("p_onsale_date"));
				product.setP_remove_date(rs.getString("p_remove_date"));
				product.setP_update_date(rs.getString("p_update_date"));
				product.setSale(rs.getInt("sale"));
				
				ProductList.add(product);
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
		return ProductList;
	}

	public void average(int id) {
		System.out.println("in average function");
		

			String sql = "Select AVG(score) as p_average FROM Comment WHERE comment_p_id = ?";
			String sql1 = "Update product SET average =? " + "WHERE p_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, id);
				rs = smt.executeQuery();
				int average=0;
				while(rs.next()){
					average = (int)rs.getDouble("p_average");
				}
				
				System.out.println("average:"+average);
				System.out.println("id:"+id);
				
				System.out.println("sql1"+sql1);
				smt1 = conn.prepareStatement(sql1);
				smt1.setInt(1, average);
				smt1.setInt(2, id);
				
				smt1.executeUpdate();
				smt.close();
				smt1.close();
				
				rs.close();
				
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
	
	public int  updateClick(Product product){
		List<Product> ProductList = new ArrayList<Product>();
		int click=0;
		try {
			
			String sql = "SELECT click_count  FROM product WHERE p_id = ?";
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, product.getP_id());
			rs = smt.executeQuery();
			
			while (rs.next()) {
				product.setClick_count(rs.getInt("click_count"));
				click=rs.getInt("click_count");
				click++;
				break;
			}
			rs.close();
			smt.close();
			
			 sql = "UPDATE product SET click_count=? "+ "WHERE p_id = ?";
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, click);
//			smt.setString(2, product.getP_describe());
//			smt.setString(3, product.getP_image());
//			smt.setInt(4, product.getP_inventory());
//			smt.setString(5, product.getP_name());
//			smt.setInt(6, product.getP_price());
//			smt.setString(7, product.getP_update_date());
			smt.setInt(2, product.getP_id());
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
    	return click;
    }

	public void addInventory(Product product) {
		

			String sql= "UPDATE product SET p_inventory= ? "
				+ "WHERE p_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, product.getP_inventory());
				
				smt.setInt(2, product.getP_id());
				
				smt.executeUpdate();
				System.out.println("database"+product.getP_id());
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




}
