package com.pratice.webapp.entity;
public class DiscountDetail {

	private int discount_id;

	private int discount_p_id;

	private int p_amount;

	private int p_total;

	public int getDiscount_id() {
		return discount_id;
	}

	public int getDiscount_p_id() {
		return discount_p_id;
	}

	public int getP_amount() {
		return p_amount;
	}

	public int getP_total() {
		return p_total;
	}

	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;

	}

	public void setDiscount_p_id(int discount_p_id) {
		this.discount_p_id = discount_p_id;

	}

	public void setP_amount(int p_amount) {
		this.p_amount = p_amount;

	}

	public void setP_total(int p_total) {
		this.p_total = p_total;

	}

}
