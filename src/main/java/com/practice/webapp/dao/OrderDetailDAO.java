package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.OrderDetail;

public interface OrderDetailDAO {
	public List<OrderDetail> getList();
	public void insert(OrderDetail orderDetail);
	public OrderDetail get(OrderDetail orderDetail);
    public void update(OrderDetail orderDetail);
    public void delete(OrderDetail orderDetail);
//	public int count();
}
