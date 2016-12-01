package com.practice.webapp.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


import com.practice.webapp.entity.Discount;
import com.practice.webapp.dao.DiscountDAO;

public class DiscountDAOImpl implements DiscountDAO{
	private List<Discount> DiscountList = new ArrayList<Discount>();
	@Override
	public void insert(Discount discount) {
		// TODO Auto-generated method stub
		DiscountList.add(discount);
		
	}

	@Override
	public void delete(Discount discount) {
		// TODO Auto-generated method stub
		DiscountList.remove(discount);
		
	}

	@Override
	public void update(Discount discount) {
		// TODO Auto-generated method stub
		int discount_id = discount.getDiscount_id();
		for(int i = 0;i<DiscountList.size();i++){
			if(DiscountList.get(i).getDiscount_id()==discount_id){
				DiscountList.remove(i);
				DiscountList.add(discount_id,discount);
			}
		}
		
	}

	@Override
	public List<Discount> getList() {
		// TODO Auto-generated method stub
		return DiscountList;
	}

	@Override
	public Discount get(Discount discount) {
		// TODO Auto-generated method stub
		int discount_id = discount.getDiscount_id();
		Discount discount1 = new Discount();
		for(int i = 0;i<DiscountList.size();i++){
			if(DiscountList.get(i).getDiscount_id()==discount_id){
				discount1 = DiscountList.get(i);
			}
		}
		return discount1;
	}

}
