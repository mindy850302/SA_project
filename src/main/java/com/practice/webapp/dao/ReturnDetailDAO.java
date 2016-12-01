package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.ReturnDetail;

public interface ReturnDetailDAO {
	public List<ReturnDetail> getList();
	public void insert(ReturnDetail return_detail);
	public ReturnDetail get(ReturnDetail return_detail);
    public void update(ReturnDetail return_detail);
    public void delete(ReturnDetail return_detail);
}
