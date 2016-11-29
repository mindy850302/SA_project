package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Order;

public interface OrderDAO {
	public List<Order> getList();
	public void insert(Order order);
	public Order get(int id);
    public void update(Order order,int id);
    public void delete(int id);
//	public int count();
}
