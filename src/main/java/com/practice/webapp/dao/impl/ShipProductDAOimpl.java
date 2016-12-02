package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.dao.ShipProductDAO;
import com.practice.webapp.entity.Product;
import com.practice.webapp.entity.ShipProduct;

public class ShipProductDAOimpl {

	public class ShipProductDAOImpl implements ShipProductDAO{
		
		private List<ShipProduct> ShipProductList = new ArrayList<ShipProduct>();
	
		public ShipProductDAOImpl(){
			ShipProduct temp=new ShipProduct();
		}
		public List<ShipProduct> getList(){
			return ShipProductList;
		}
		public void insert(ShipProduct shipProduct){
			ShipProductList.add(shipProduct);
		}
		public ShipProduct get(long id){
			return ShipProductList.get((int)id); 
		}
	    public void update(ShipProduct shipProduct,long ShipProduct_id){
	    	ShipProductList.remove(ShipProduct_id);
	    	ShipProductList.add(shipProduct);
	    }
	    public void delete(long id){
	    	ShipProductList.remove((int)id);
			// loop through the ReturnList to reset id
			for (int i = 0; i< ShipProductList.size(); i++){
				ShipProductList.get(i).setShipProduct_id(i);
			}
}
}
}