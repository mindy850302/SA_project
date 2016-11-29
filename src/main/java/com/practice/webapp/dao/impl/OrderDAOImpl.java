package com.practice.webapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.practice.webapp.entity.Order;

public class OrderDAOImpl {
	private List<Order> OrderList = new ArrayList<Order>();
	public OrderDAOImpl(){
		Order temp=new Order();
	}

	public List<Order> getList(){
		return OrderList;
	}
	public void insert(Order order){
		OrderList.add(order);
	}
	public Order get(int id){
		return OrderList.get(id);
	}
    public void update(Order order,int id){
    	id = (int)order.getOrder_id();
    	OrderList.set((int) id, order);
    }
    public void delete(int id){
    	OrderList.remove((int)id);
		// loop through the productList to reset id
		for (int i = 0; i< OrderList.size(); i++){
			OrderList.get(i).setOrder_id(i);
		}
    }
}
