
package com.practice.webapp.entity;

import java.util.ArrayList;
import java.util.List;

import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.entity.Product;
public class ReturnDetail {

	private int return_id;

	private int return_p_id;

	private int p_amount;

	private int p_total;

	public int getReturn_id() {
		return return_id;
	}

	public void setReturn_id(int return_id) {
		this.return_id = return_id;
	}

	public int getReturn_p_id() {
		return return_p_id;
	}
	public String getReturn_p_name() {
		List<Product> ProductList =new ArrayList<Product>();
		String name="";
		for(int i=0;i<ProductList.size();i++){
			if(return_p_id==ProductList.get(i).getP_id()){
				name=ProductList.get(i).getP_name();
			}
		}
		return name;
	}
	public void setReturn_p_id(int return_p_id) {
		this.return_p_id = return_p_id;
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
