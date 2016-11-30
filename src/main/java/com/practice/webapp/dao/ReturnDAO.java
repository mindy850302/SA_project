package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Return;
public interface ReturnDAO {
	public List<Return> getList();
	public void insert(Return areturn);
	public Return get(long id);
    public void update(Return areturn,int id);
    public void delete(long id);
}
