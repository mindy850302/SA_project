package com.pratice.webapp.entity;
public class Member {

	private int M_id;

	private char M_idName;

	private char M_name;

	private char M_phone;

	private char M_email;

	private char M_address;

	private int M_discount;

	private char M_pwd;

	private char M_create_date;

	private char M_update_date;

	public Member(int m_id, char m_idName, char m_name, char m_phone, char m_email, char m_address, int m_discount,
			char m_pwd, char m_create_date, char m_update_date) {
		super();
		M_id = m_id;
		M_idName = m_idName;
		M_name = m_name;
		M_phone = m_phone;
		M_email = m_email;
		M_address = m_address;
		M_discount = m_discount;
		M_pwd = m_pwd;
		M_create_date = m_create_date;
		M_update_date = m_update_date;
	}

	public char getM_idName() {
		return M_idName;
	}

	public void setM_idName(char m_idName) {
		M_idName = m_idName;
	}

	public char getM_name() {
		return M_name;
	}

	public void setM_name(char m_name) {
		M_name = m_name;
	}

	public char getM_phone() {
		return M_phone;
	}

	public void setM_phone(char m_phone) {
		M_phone = m_phone;
	}

	public char getM_email() {
		return M_email;
	}

	public void setM_email(char m_email) {
		M_email = m_email;
	}

	public char getM_address() {
		return M_address;
	}

	public void setM_address(char m_address) {
		M_address = m_address;
	}

	public int getM_discount() {
		return M_discount;
	}

	public void setM_discount(int m_discount) {
		M_discount = m_discount;
	}

	public char getM_pwd() {
		return M_pwd;
	}

	public void setM_pwd(char m_pwd) {
		M_pwd = m_pwd;
	}

	public char getM_create_date() {
		return M_create_date;
	}

	public void setM_create_date(char m_create_date) {
		M_create_date = m_create_date;
	}

	public char getM_update_date() {
		return M_update_date;
	}

	public void setM_update_date(char m_update_date) {
		M_update_date = m_update_date;
	}

	public int getM_id() {
		return M_id;
	}

	
}
