package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Product_category;
public interface Product_categoryDAO {
	public List<Product_category> getList();
	public void insert(Product_category product_category);
	public Product_category get(long id);
    public void update(Product_category product_category,long id);
    public void delete(long id);

	
}
