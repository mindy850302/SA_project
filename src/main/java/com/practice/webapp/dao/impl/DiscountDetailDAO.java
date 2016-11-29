package com.practice.webapp.dao.impl;
import java.util.List; 
import com.practice.webapp.entity.DiscountDetail;

public interface DiscountDetailDAO {
	public List<DiscountDetail> getList();
	public List<DiscountDetail> getp_amountList();
	public List<DiscountDetail> getp_totalList();
	public DiscountDetail get(DiscountDetail discountDetail);
}
