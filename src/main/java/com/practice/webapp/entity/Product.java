
package com.practice.webapp.entity;


public class Product {

	private int p_id;

	private int p_category;

	private char p_name;

	private char p_describe;

	private int p_price;

	private int p_inventory;

	private char p_onsale_date;

	private char p_remove_date;

	private char p_update_date;

	private int click_count;

	private char p_image;

	private boolean sale;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getP_category() {
		return p_category;
	}

	public void setP_category(int p_category) {
		this.p_category = p_category;
	}

	public char getP_name() {
		return p_name;
	}

	public void setP_name(char p_name) {
		this.p_name = p_name;
	}

	public char getP_describe() {
		return p_describe;
	}

	public void setP_describe(char p_describe) {
		this.p_describe = p_describe;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_inventory() {
		return p_inventory;
	}

	public void setP_inventory(int p_inventory) {
		this.p_inventory = p_inventory;
	}

	public char getP_onsale_date() {
		return p_onsale_date;
	}

	public void setP_onsale_date(char p_onsale_date) {
		this.p_onsale_date = p_onsale_date;
	}

	public char getP_remove_date() {
		return p_remove_date;
	}

	public void setP_remove_date(char p_remove_date) {
		this.p_remove_date = p_remove_date;
	}

	public char getP_update_date() {
		return p_update_date;
	}

	public void setP_update_date(char p_update_date) {
		this.p_update_date = p_update_date;
	}

	public int getClick_count() {
		return click_count;
	}

	public void setClick_count(int click_count) {
		this.click_count = click_count;
	}

	public char getP_image() {
		return p_image;
	}

	public void setP_image(char p_image) {
		this.p_image = p_image;
	}

	public boolean isSale() {
		return sale;
	}

	public void setSale(boolean sale) {
		this.sale = sale;
	}

	
}
