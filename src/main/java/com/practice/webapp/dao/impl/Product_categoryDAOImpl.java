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
	public Product_category get(long id){
		return Product_categoryList.get((int)id); 
	}
    public void update(Product_category product_category,long id){
    	 id = (int)product_category.getId();
    	Product_categoryList.set((int) id, product_category);
    }
    public void delete(long id){
    	Product_categoryList.remove((int)id);
		// loop through the productList to reset id
		for (int i = 0; i< Product_categoryList.size(); i++){
			Product_categoryList.get(i).setId(i);
		}
    }
//	public int count(){
//		
//	}
//	
	
	
}