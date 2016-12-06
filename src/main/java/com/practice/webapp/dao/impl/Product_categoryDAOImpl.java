package com.practice.webapp.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.Product_category;
import com.practice.webapp.dao.Product_categoryDAO;

public class Product_categoryDAOImpl implements Product_categoryDAO{
	private List<Product_category> Product_categoryList = new ArrayList<Product_category>();
	public Product_categoryDAOImpl(){
		Product_category temp=new Product_category();
	}
	public List<Product_category> getList(){
		return Product_categoryList;
	}
	public void insert(Product_category product_category){
		Product_categoryList.add(product_category);
	}
	public Product_category get(Product_category product_category){
		Product_category product_category1 = new Product_category();
		for (int i = 0; i < Product_categoryList.size(); i++) {
			if (Product_categoryList.get(i).getId() == product_category.getId()) {
				product_category1 = Product_categoryList.get(i);
			}
		}
		return product_category1;

	}
	
    public void update(Product_category product_category){
    	for (int i = 0; i < Product_categoryList.size(); i++) {
			if (Product_categoryList.get(i).getId() == product_category.getId()) {
				Product_categoryList.remove(i);
				Product_categoryList.add(i, product_category);
			}
		}
    }
    public void delete(Product_category product_category){
    	for (int i = 0; i < Product_categoryList.size(); i++) {
			if (Product_categoryList.get(i).getId() == product_category.getId()) {
				Product_categoryList.remove(i);
			}
		}
    }
//	public int count(){
//		
//	}
//	
	
	
}