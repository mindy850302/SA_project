package com.practice.webapp.dao;
import java.util.List; 
import com.practice.webapp.entity.DiscountDetail;

public interface DiscountDetailDAO {
	public List<DiscountDetail> getList();
	public DiscountDetail get(DiscountDetail discountDetail);
}
