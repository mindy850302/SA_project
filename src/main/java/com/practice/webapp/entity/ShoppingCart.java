
package com.practice.webapp.entity;


public class ShoppingCart {

	private int cart_id;

	private int M_id;

	private int shoppingAmount;

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getM_id() {
		return M_id;
	}

	public void setM_id(int m_id) {
		M_id = m_id;
	}

	public int getShoppingAmount() {
		return shoppingAmount;
	}

	public void setShoppingAmount(int shoppingAmount) {
		this.shoppingAmount = shoppingAmount;
	}
}
