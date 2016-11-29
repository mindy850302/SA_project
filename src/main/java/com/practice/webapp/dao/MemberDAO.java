package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Member;
public interface MemberDAO {
	public List<Member> getList();
	public void insert(Member member);
	public Member get(long id);
    public void update(Member member,int M_id);
    public void delete(long id);
	public boolean checkLoginMember(String M_idName, String password);
//	public int count();
	
}
