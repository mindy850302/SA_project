
package com.practice.webapp.entity;


public class Return {

	private int return_id;

	private int return_M_id;

	private String return_date;

	private int return_total;

	private int return_A_id;
	
	private Member member=new Member();
	
	private Administrator administrato=new Administrator();
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Administrator getAdministrato() {
		return administrato;
	}

	public void setAdministrato(Administrator administrato) {
		this.administrato = administrato;
	}

	public int getReturn_id() {
		return return_id;
	}

	public int getReturn_M_id() {
		return return_M_id;
	}

	public String getReturn_date() {
		return return_date;
	}

	public int getReturn_total() {
		return return_total;
	}

	public int getReturn_A_id() {
		return return_A_id;
	}

	public void setReturn_id(int return_id) {
		this.return_id = return_id;
	}


	public void setReturn_M_id(int return_M_id) {
		this.return_M_id = return_M_id;
	}


	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public void setReturn_total(int return_total) {
		this.return_total = return_total;
	}

	public void setReturn_A_id(int return_A_id) {
		this.return_A_id = return_A_id;
	}

	

}
