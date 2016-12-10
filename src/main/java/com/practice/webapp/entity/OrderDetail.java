
package com.practice.webapp.entity;


public class OrderDetail {

	private int orderDetail_id;

	private int order_p_id;

	private int p_amount;

	private int p_total;
	
	private Product product = new Product();
	private Order order = new Order();

	public int getOrderDetail_id() {
		return orderDetail_id;
	}

	public void setOrderDetail_id(int orderDetail_id) {
		this.orderDetail_id = orderDetail_id;
	}

	public int getOrder_p_id() {
		return order_p_id;
	}

	public void setOrder_p_id(int order_p_id) {
		this.order_p_id = order_p_id;
	}

	public int getP_amount() {
		return p_amount;
	}

	public void setP_amount(int p_amount) {
		this.p_amount = p_amount;
	}

	public int getP_total() {
		return p_total;
	}

	public void setP_total(int p_total) {
		this.p_total = p_total;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
