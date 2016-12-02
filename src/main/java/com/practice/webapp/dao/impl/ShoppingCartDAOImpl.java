package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



//import com.mysql.jdbc.Statement;


import com.practice.webapp.entity.ShoppingCart;
import com.practice.webapp.dao.ShoppingCartDAO;

public class ShoppingCartDAOImpl implements ShoppingCartDAO{
	private List<ShoppingCart> ShoppingCartList = new ArrayList<ShoppingCart>();
	public ShoppingCartDAOImpl(){
		ShoppingCart temp=new ShoppingCart();
	}
	public List<ShoppingCart> getList(){
		return ShoppingCartList;
	}
	public void insert(ShoppingCart areturn){
		ShoppingCartList.add(areturn);
	}
	public ShoppingCart get(long id){
		return ShoppingCartList.get((int)id); 
	}
    public void update(ShoppingCart areturn,int return_id){
    	ShoppingCartList.remove(return_id);
    	ShoppingCartList.add(return_id,areturn);
    }
    public void delete(long id){
    	ShoppingCartList.remove((int)id);
		// loop through the ReturnList to reset id
		for (int i = 0; i< ShoppingCartList.size(); i++){
			ShoppingCartList.get(i).setM_id(i);
		}
    }
}
	