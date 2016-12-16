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
	public int insert(Order order){
		int id=0;
		OrderList.add(order);
		return id;
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
    	for (int i = 0; i < OrderList.size(); i++) {
			if (OrderList.get(i).getOrder_id() == order.getOrder_id()) {
				OrderList.remove(i);
				OrderList.add(i, order);
			}
		}
    }
    public void delete(int id){
    	OrderList.remove((int)id);
		// loop through the productList to reset id
		for (int i = 0; i< OrderList.size(); i++){
			OrderList.get(i).setOrder_id(i);
		}
    }
    public List<Order> getOrderShippingList(){
    	return OrderList;
    }
    public void updateOrder_status(Order order){
    	for (int i = 0; i < OrderList.size(); i++) {
			if (OrderList.get(i).getOrder_id() == order.getOrder_id()) {
				OrderList.remove(i);
				OrderList.add(i, order);
			}
		}
    }
}
