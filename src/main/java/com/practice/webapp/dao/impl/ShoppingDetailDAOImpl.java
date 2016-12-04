package com.practice.webapp.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.ShoppingDetail;
import com.practice.webapp.dao.ShoppingDetailDAO;

public class ShoppingDetailDAOImpl implements ShoppingDetailDAO{
	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private List<ShoppingDetail> ShoppingDetailList = new ArrayList<ShoppingDetail>();
	public ShoppingDetailDAOImpl(){
		ShoppingDetail temp=new ShoppingDetail();
	}
	public List<ShoppingDetail> getList(){
		return ShoppingDetailList;
	}
	public void insert(ShoppingDetail shoppingdetail){
		ShoppingDetailList.add(shoppingdetail);
	}
	public ShoppingDetail get(ShoppingDetail shoppingdetail){
		ShoppingDetail temp =new ShoppingDetail();
		int id=shoppingdetail.getShopping_cart_id();
		for (int i = 0; i< ShoppingDetailList.size(); i++){
			if(id==ShoppingDetailList.get(i).getShopping_cart_id()){
				temp=ShoppingDetailList.get(i);
			}
			
		}
		return temp;
	}
    public void update(ShoppingDetail shoppingdetail){
		int id=shoppingdetail.getShopping_cart_id();
		for (int i = 0; i< ShoppingDetailList.size(); i++){
			if(id==ShoppingDetailList.get(i).getShopping_cart_id()){
				ShoppingDetailList.get(i).setShopping_p_id(shoppingdetail.getShopping_p_id());
				ShoppingDetailList.get(i).setP_amount(shoppingdetail.getP_amount());
				ShoppingDetailList.get(i).setP_total(shoppingdetail.getP_total());
				
			}
			
		}
    }
    public void delete(ShoppingDetail shoppingdetail){
    	int id=shoppingdetail.getShopping_cart_id();
		// loop through the productList to reset id
		for (int i = 0; i< ShoppingDetailList.size(); i++){
			if(id==ShoppingDetailList.get(i).getShopping_cart_id()){
				ShoppingDetailList.remove(id);
			}
		}
    }
	@Override
	public boolean checkLoginMember(ShoppingDetail shoppingdetail) {
		// TODO Auto-generated method stub
		return false;
	}
    

//	public int count(){
//		
//	}
//	
	
	
}

