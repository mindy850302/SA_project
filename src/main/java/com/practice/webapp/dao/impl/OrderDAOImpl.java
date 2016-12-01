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
	public Order get(Order order){
		Order getOrder=new Order();
		for(int i=0;i<OrderList.size();i++){
			if(order.getOrder_id()==OrderList.get(i).getOrder_id()){
				getOrder=OrderList.get(i);
			}
		}
		return getOrder;
	}
    public void update(Order order){
    	for(int i=0;i<OrderList.size();i++){
    		
    	}
    }
    public void delete(int id){
    	OrderList.remove((int)id);
		// loop through the productList to reset id
		for (int i = 0; i< OrderList.size(); i++){
			OrderList.get(i).setOrder_id(i);
		}
    }
}
