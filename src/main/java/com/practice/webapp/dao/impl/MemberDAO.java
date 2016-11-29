package com.practice.webapp.dao.impl;

import java.util.List;
import com.pratice.webapp.entity.Member;
public interface MemberDAO {
	public List<Member> getList();
	public void insert(Member member);
	public void update(Member member);
	public void delete(Member member);
	public void register(Member member);
	public void login(Member member);
	public Member get(Member member);
}
