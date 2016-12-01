package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Order;

public interface OrderDAO {
	public List<Order> getList();
	public void insert(Order order);
	public Order get(Order order);
    public void update(Order order);
    public void delete(Order order);
//	public int count();
}
