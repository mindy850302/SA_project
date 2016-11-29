
package com.practice.webapp.entity;


public class Comment {

	private int comment_M_id;

	private int comment_p_id;

	private char c_comment;

	private char c_create_date;

	private char c_update_date;

	public int getComment_M_id() {
		return comment_M_id;
	}

	public int getComment_p_id() {
		return comment_p_id;
	}

	public char getC_comment() {
		return c_comment;
	}

	public char getC_create_date() {
		return c_create_date;
	}

	public char getC_update_date() {
		return c_update_date;
	}

	public void setComment_M_id(int comment_M_id) {
		this.comment_M_id = comment_M_id;

	}

	public void setComment_p_id(int comment_p_id) {
		this.comment_p_id = comment_p_id;

	}

	public void setC_comment(char c_comment) {
		this.c_comment = c_comment;

	}

	public void setC_create_date(char c_create_date) {
		this.c_create_date = c_create_date;

	}

	public void setC_update_date(char c_update_date) {
		this.c_update_date = c_update_date;

	}

	
}
