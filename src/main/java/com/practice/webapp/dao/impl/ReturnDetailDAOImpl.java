package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.ReturnDetail;
import com.practice.webapp.dao.ReturnDetailDAO;

public class ReturnDetailDAOImpl implements ReturnDetailDAO{
	private List<ReturnDetail> ReturnDetailList = new ArrayList<ReturnDetail>();
	public ReturnDetailDAOImpl(){
		ReturnDetail temp=new ReturnDetail();
	}
	public List<ReturnDetail> getList(){
		return ReturnDetailList;
	}
	public void insert(ReturnDetail return_detail){
		ReturnDetailList.add(return_detail);
	}
	public ReturnDetail get(ReturnDetail return_detail){
		int return_id = return_detail.getReturn_id();
		int return_p_id = return_detail.getReturn_p_id();
		ReturnDetail returnDetail = new ReturnDetail();
		for (int i = 0; i< ReturnDetailList.size(); i++){
			if(ReturnDetailList.get(i).getReturn_id() == return_id && ReturnDetailList.get(i).getReturn_p_id() == return_p_id){
				returnDetail = ReturnDetailList.get(i);
			}
		}
		return returnDetail; 
	}
    public void update(ReturnDetail return_detail){
    	for (int i = 0; i< ReturnDetailList.size(); i++){
			if(ReturnDetailList.get(i).getReturn_id() == return_detail.getReturn_id()){
				ReturnDetailList.remove(i);
				ReturnDetailList.add(i,return_detail);
			}
    	}
    }
    public void delete(ReturnDetail return_detail){
    	int return_id = return_detail.getReturn_id();
		int return_p_id = return_detail.getReturn_p_id();
		for (int i = 0; i< ReturnDetailList.size(); i++){
			if(ReturnDetailList.get(i).getReturn_id() == return_id && ReturnDetailList.get(i).getReturn_p_id() == return_p_id){
				ReturnDetailList.remove(i);
			}
    	}
		// loop through the ReturnList to reset id
//		for (int i = 0; i< ReturnList.size(); i++){
//			ReturnList.get(i).setReturn_id(i);
//		}
    }
}