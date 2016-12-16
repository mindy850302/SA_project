package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.Return;
import com.practice.webapp.entity.Order;
import com.practice.webapp.dao.ReturnDAO;
import com.practice.webapp.dao.OrderDAO;

public class ReturnDAOImpl implements ReturnDAO{
	private List<Return> ReturnList = new ArrayList<Return>();
	private List<Order> OrderList = new ArrayList<Order>();
	public ReturnDAOImpl(){
		Return temp=new Return();
	}
	public List<Return> getList(){
		return ReturnList;
	}
	public int insert(Return areturn){
		int id=areturn.getReturn_id();
		return id;
	}
	public Return get(Return areturn){
		Return bReturn = new Return();
		for (int i = 0; i< ReturnList.size(); i++){
			if(ReturnList.get(i).getReturn_id() == areturn.getReturn_id()){
				bReturn = ReturnList.get(i);
			}
		}
		return bReturn; 
	}
    public void update(Return areturn){
		for (int i = 0; i< ReturnList.size(); i++){
			if(ReturnList.get(i).getReturn_id() == areturn.getReturn_id()){
				ReturnList.remove(i);
				ReturnList.add(i,areturn);
			}
    	}
    }
    public void delete(Return areturn){
		for (int i = 0; i< ReturnList.size(); i++){
			if(ReturnList.get(i).getReturn_id() == areturn.getReturn_id()){
				ReturnList.remove(i);
			}
    	}
		// loop through the ReturnList to reset id
//		for (int i = 0; i< ReturnList.size(); i++){
//			ReturnList.get(i).setReturn_id(i);
//		}
    }
//    public void isReturn(Return areturn){
//    	for (int i = 0; i< OrderList.size(); i++){
//    		if(OrderList.get(i).getOrder_id()==areturn.getReturn_order_id()){
//    			OrderList.get(i).setOrder_status(1);
//    		}
//    		
//    	}
//    }
	
	
}
