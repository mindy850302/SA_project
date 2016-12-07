
package com.practice.webapp.entity;

public class ShoppingDetail {

	private int shopping_M_id;

	private int shopping_p_id;

	private int p_amount;

	private int p_total;
	
	private Product product=new Product();
	
	private Member member=new Member();

	public int getShopping_M_id() {
		return shopping_M_id;
	}

	public void setShopping_M_id(int shopping_M_id) {
		this.shopping_M_id = shopping_M_id;
	}

	public int getShopping_p_id() {
		return shopping_p_id;
	}

	public void setShopping_p_id(int shopping_p_id) {
		this.shopping_p_id = shopping_p_id;
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

}
