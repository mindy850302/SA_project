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
import com.practice.webapp.entity.ReturnDetail;
import com.practice.webapp.dao.ReturnDAO;

public class ReturnDAOImpl implements ReturnDAO{
	private List<Return> ReturnList = new ArrayList<Return>();
	public ReturnDAOImpl(){
		Return temp=new Return();
	}
	public List<Return> getList(){
		return ReturnList;
	}
	public void insert(Return areturn){
		ReturnList.add(areturn);
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
	
	
	
}