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
    	int id = (int)member.getM_id();
    	MemberList.set(id, member);
    }
    public void delete(long id){
    	MemberList.remove((int)id);
		// loop through the productList to reset id
		for (int i = 0; i< MemberList.size(); i++){
			MemberList.get(i).setM_id(i);
		}
    }
//	public int count(){
//		
//	}
//	
	
	
}

