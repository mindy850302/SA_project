
package com.practice.webapp.entity;


public class Discount {

	private int discount_id;

	private int discount_order_id;

	private String discount_date;

	private int discount_total;

	private int discount_A_id;
    
	private Member member=new Member();
	
	private Administrator administrator=new Administrator();

	public int getDiscount_id() {
		return discount_id;
	}

	public int getDiscount_order_id() {
		return discount_order_id;
	}


	public String getDiscount_date() {
		return discount_date;
	}

	public int getDiscount_total() {
		return discount_total;
	}

	public int getDiscount_A_id() {
		return discount_A_id;
	}

	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;

	}

	public void setDiscount_order_id(int discount_M_id) {
		this.discount_order_id = discount_M_id;

	}

	public void setDiscount_date(String discount_date) {
		this.discount_date = discount_date;

	}

	public void setDiscount_total(int discount_total) {
		this.discount_total = discount_total;

	}

	public void setDiscount_A_id(int discount_A_id) {
		this.discount_A_id = discount_A_id;

	}
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrato(Administrator administrator) {
		this.administrator = administrator;
	}
	

}
