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
	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

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
	public Member get(Member member){
		Member temp =new Member();
		int id=member.getM_id();
		for (int i = 0; i< MemberList.size(); i++){
			if(id==MemberList.get(i).getM_id()){
				temp=MemberList.get(i);
			}
			
		}
		return temp;
	}
    public void update(Member member){
		int id=member.getM_id();
		for (int i = 0; i< MemberList.size(); i++){
			if(id==MemberList.get(i).getM_id()){
				MemberList.get(i).setM_name(member.getM_name());
				MemberList.get(i).setM_idName(member.getM_idName());
				MemberList.get(i).setM_phone(member.getM_phone());
				MemberList.get(i).setM_email(member.getM_email());
				MemberList.get(i).setM_address(member.getM_address());
			}
			
		}
    }
    public void delete(Member member){
    	int id=member.getM_id();
		// loop through the productList to reset id
		for (int i = 0; i< MemberList.size(); i++){
			if(id==MemberList.get(i).getM_id()){
				MemberList.remove(id);
			}
		}
    }
    public List<Member> search(String keyword){
    	return MemberList;
    }
    
	public boolean checkLoginMember(Member member){
		String M_idName=member.getM_idName();
		String password=member.getM_pwd();
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
	
	public boolean checkLoginAdministrator(Member member){
		String A_idName=member.getM_idName();
		String password=member.getM_pwd();
		boolean log=false;
		for (int i = 0; i< MemberList.size(); i++){
			String idName=MemberList.get(i).getM_idName();
			String pwd=MemberList.get(i).getM_pwd();
			if(idName.equals(A_idName)&&pwd.equals(password)){
				log=true;
				break;
			}
		}
		return log;
	}

	public int countMember() {
		int count=0;
		return count;
	}

	
}

