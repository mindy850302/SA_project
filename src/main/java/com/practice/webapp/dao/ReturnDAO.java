package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Return;
public interface ReturnDAO {
	public List<Return> getList();
	public int insert(Return areturn);
	public Return get(Return areturn);
    public void update(Return areturn);
    public void delete(Return areturn);
}
