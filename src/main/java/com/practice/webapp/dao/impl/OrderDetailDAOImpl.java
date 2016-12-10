package com.practice.webapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.practice.webapp.entity.OrderDetail;

public class OrderDetailDAOImpl {
	private List<OrderDetail> OrderDetailList = new ArrayList<OrderDetail>();
	public OrderDetailDAOImpl(){
		OrderDetail temp=new OrderDetail();
	}

	public List<OrderDetail> getList(){
		return OrderDetailList;
	}
	public void insert(OrderDetail orderDetail){
		OrderDetailList.add(orderDetail);
	}
	public OrderDetail get(OrderDetail orderDetail){
		OrderDetail getOrderDetail=new OrderDetail();
		for(int i=0;i<OrderDetailList.size();i++){
			if(orderDetail.getOrderDetail_id()==OrderDetailList.get(i).getOrderDetail_id()){
				getOrderDetail=OrderDetailList.get(i);
			}
		}
		return getOrderDetail;
	}
    public void update(OrderDetail orderDetail){
    	for (int i = 0; i < OrderDetailList.size(); i++) {
			if (OrderDetailList.get(i).getOrderDetail_id() == orderDetail.getOrderDetail_id()) {
				OrderDetailList.remove(i);
				OrderDetailList.add(i, orderDetail);
			}
		}
    }
    public void delete(int id){
    	OrderDetailList.remove((int)id);
		// loop through the productList to reset id
		for (int i = 0; i< OrderDetailList.size(); i++){
			OrderDetailList.get(i).setOrderDetail_id(i);
		}
    }
}
