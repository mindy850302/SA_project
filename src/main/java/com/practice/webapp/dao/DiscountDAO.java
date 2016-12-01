package com.practice.webapp.dao;
import java.util.List;
import com.practice.webapp.entity.Discount;
public interface DiscountDAO {
	public void insert(Discount discount);
	public void delete(Discount discount);
	public void update(Discount discount);
	public List<Discount> getList();
	public Discount get(Discount discount);

}
