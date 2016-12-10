package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Member;
public interface MemberDAO {
	public List<Member> getList();
	public void insert(Member member);
	public Member get(Member member);
    public void update(Member member);
    public void delete(Member member);
    public List<Member> search(String keyword);
	public boolean checkLoginMember(Member member);

	//public boolean checkSignup(Member member);

	public boolean checkLoginAdministrator(Member member) ;
		// TODO Auto-generated method stub

	

//	public int count();
	
}
