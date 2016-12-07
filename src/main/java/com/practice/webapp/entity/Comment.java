
package com.practice.webapp.entity;

public class Comment {

	private int comment_M_id;

	private int comment_p_id;

	private String c_comment;

	private String c_create_date;

	private String c_update_date;
	private int score;
	private Product producttype = new Product();
	private Member membertype = new Member();

	public int getComment_M_id() {
		return comment_M_id;
	}

	public int getComment_p_id() {
		return comment_p_id;
	}

	public String getC_comment() {
		return c_comment;
	}

	public String getC_create_date() {
		return c_create_date;
	}

	public String getC_update_date() {
		return c_update_date;
	}
	public int getScore() {
		return score;
	}

	public void setComment_M_id(int comment_M_id) {
		this.comment_M_id = comment_M_id;

	}

	public void setComment_p_id(int comment_p_id) {
		this.comment_p_id = comment_p_id;

	}

	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;

	}

	public void setC_create_date(String c_create_date) {
		this.c_create_date = c_create_date;

	}

	public void setC_update_date(String c_update_date) {
		this.c_update_date = c_update_date;
	}
	public void setScore(int score) {
		this.score = score;
	}


	public Product getProduct() {
		return producttype;
	}

	public void setProduct(Product producttype) {
		this.producttype = producttype;
	}

	public Member getMember() {
		return membertype;
	}

	public void setMember(Member membertype) {
		this.membertype = membertype;
	}

}
