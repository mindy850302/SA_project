
package com.practice.webapp.entity;


public class Order {

	private int order_id;

	private int order_M_id;

	private int cart_id;

	private char O_date;

	private char receiver_name;

	private char receiver_phone;

	private char receiver_address;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_M_id() {
		return order_M_id;
	}

	public void setOrder_M_id(int order_M_id) {
		this.order_M_id = order_M_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public char getO_date() {
		return O_date;
	}

	public void setO_date(char o_date) {
		O_date = o_date;
	}

	public char getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(char receiver_name) {
		this.receiver_name = receiver_name;
	}

	public char getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(char receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public char getReceiver_address() {
		return receiver_address;
	}

	public void setReceiver_address(char receiver_address) {
		this.receiver_address = receiver_address;
	}


}
