package com.practice.webapp.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.Product;
import com.practice.webapp.dao.ProductDAO;

public class ProductDAOImpl implements ProductDAO {
	private DataSource dataSource;

	private List<Product> ProductList = new ArrayList<Product>();

	public ProductDAOImpl() {
		Product temp = new Product();
	}

	public List<Product> getList() {
		return ProductList;
	}

	public void insert(Product product) {
		ProductList.add(product);
	}

	public Product get(Product product) {
		Product product1 = new Product();
		for (int i = 0; i < ProductList.size(); i++) {
			if (ProductList.get(i).getP_id() == product.getP_id()) {
				product1 = ProductList.get(i);
			}
		}

		return product1;
	}

	public void update(Product product) {
		for (int i = 0; i < ProductList.size(); i++) {
			if (ProductList.get(i).getP_id() == product.getP_id()) {
				ProductList.remove(i);
				ProductList.add(i, product);
			}
		}
	}

	public void delete(Product product) {
		for (int i = 0; i < ProductList.size(); i++) {
			if (ProductList.get(i).getP_id() == product.getP_id()) {
				ProductList.remove(i);
			}
		}
	}

	public List<Product> search(String keyword) {
		
		return ProductList;
	}

	public void average(int id) {

	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


    public void addInventory(Product product){
    	
    }
    

    public int updateClick(Product product){
    	int click=0;
    	for (int i = 0; i < ProductList.size(); i++) {
			if (ProductList.get(i).getP_id() == product.getP_id()) {
				click=ProductList.get(i).getClick_count();
				System.out.println("hi");
				ProductList.get(i).setClick_count(click);
			}
		}
    	return click;

    }

    public int countProduct(){
    	int count_Product=0;
    	return count_Product;
    }
    public List<Product> hotProduct(){
    	return ProductList;
    }
    public List<Product> newProduct() {
    	return ProductList;
    }


}