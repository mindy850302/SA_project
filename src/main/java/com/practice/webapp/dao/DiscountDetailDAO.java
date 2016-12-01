package com.practice.webapp.dao;
import java.util.List;


import com.practice.webapp.entity.DiscountDetail;

public interface DiscountDetailDAO {
	public void insert(DiscountDetail discountDetail);
	public void delete(DiscountDetail discountDetail);
	public void update(DiscountDetail discountDetail);
	public List<DiscountDetail> getList();
	public DiscountDetail get(DiscountDetail discountDetail);
}
