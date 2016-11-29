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

public class ProductDAOImpl implements ProductDAO{
	private List<Product> ProductList = new ArrayList<Product>();
	public ProductDAOImpl(){
		Product temp=new Product();
	}
	public List<Product> getList(){
		return ProductList;
	}
	public void insert(Product product){
		ProductList.add(product);
	}
	public Product get(int id){
		return ProductList.get(id); 
	}
    public void update(Product product,int id){
    	id = (int)product.getP_id();
    	ProductList.set((int) id, product);
    }
    public void delete(int id){
    	ProductList.remove((int)id);
		// loop through the productList to reset id
		for (int i = 0; i< ProductList.size(); i++){
			ProductList.get(i).setP_id(i);
		}
    }
}