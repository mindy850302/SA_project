package com.practice.webapp.dao.impl;
import java.util.List;
import com.practice.webapp.entity.Discount;
public interface DiscountDAO {
	public List<Discount> getList();
	public Discount get(Discount discount);

}
