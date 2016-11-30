package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.Member;
import com.practice.webapp.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO{
	private List<Member> MemberList = new ArrayList<Member>();
	public MemberDAOImpl(){
		Member temp=new Member();
	}
	public List<Member> getList(){
		return MemberList;
	}
	public void insert(Member member){
		MemberList.add(member);
	}
	public Member get(long id){
		return MemberList.get((int)id); 
	}
    public void update(Member member,int M_id){
    	MemberList.remove(M_id);
    	MemberList.add(M_id,member);
    }
    public void delete(long id){
    	MemberList.remove((int)id);
		// loop through the productList to reset id
		for (int i = 0; i< MemberList.size(); i++){
			MemberList.get(i).setM_id(i);
		}
    }
    
	public boolean checkLoginMember(String M_idName, String password){
		boolean log=false;
		for (int i = 0; i< MemberList.size(); i++){
			String idName=MemberList.get(i).getM_idName();
			String pwd=MemberList.get(i).getM_pwd();
			if(idName.equals(M_idName)&&pwd.equals(password)){
				log=true;
				break;
			}
		}
		return log;
	}
//	public int count(){
//		
//	}
//	
	
	
}

