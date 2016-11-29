package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.practice.webapp.entity.Member;

//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.Return;
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
	public Return get(long id){
		return ReturnList.get((int)id); 
	}
    public void update(Return areturn,int return_id){
    	ReturnList.remove(return_id);
    	ReturnList.add(return_id,areturn);
    }
    public void delete(long id){
    	ReturnList.remove((int)id);
		// loop through the ReturnList to reset id
		for (int i = 0; i< ReturnList.size(); i++){
			ReturnList.get(i).setReturn_id(i);
		}
    }
	
	
	
}
