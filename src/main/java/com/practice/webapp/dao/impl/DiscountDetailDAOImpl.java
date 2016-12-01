package com.practice.webapp.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.practice.webapp.entity.DiscountDetail;
import com.practice.webapp.dao.DiscountDetailDAO;
public class DiscountDetailDAOImpl implements DiscountDetailDAO {
	private List<DiscountDetail> DiscountDetailList = new ArrayList<DiscountDetail>();

	@Override
	public void insert(DiscountDetail discountDetail) {
		// TODO Auto-generated method stub
		DiscountDetailList.add(discountDetail);
	}

	@Override
	public void delete(DiscountDetail discountDetail) {
		// TODO Auto-generated method stub
		DiscountDetailList.remove(discountDetail);
		
	}

	@Override
	public void update(DiscountDetail discountDetail) {
		// TODO Auto-generated method stub
		int discount_id = discountDetail.getDiscount_id();
		for(int i = 0;i<DiscountDetailList.size();i++){
			if(DiscountDetailList.get(i).getDiscount_id()==discount_id){
				DiscountDetailList.remove(i);
				DiscountDetailList.add(discount_id,discountDetail);
			}
		}
		
	}

	@Override
	public List<DiscountDetail> getList() {
		// TODO Auto-generated method stub
		return DiscountDetailList;
	}

	@Override
	public DiscountDetail get(DiscountDetail discountDetail) {
		// TODO Auto-generated method stub
		int discount_id = discountDetail.getDiscount_id();
		DiscountDetail discountDetail1 = new DiscountDetail();
		for(int i = 0;i<DiscountDetailList.size();i++){
			if(DiscountDetailList.get(i).getDiscount_id()==discount_id){
				discountDetail1 = DiscountDetailList.get(i);
				
			}
		}
		return discountDetail1;
	}

}
