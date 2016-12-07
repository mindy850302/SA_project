package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Product_category;
public interface Product_categoryDAO {
	public List<Product_category> getList();
	public void insert(Product_category product_category);
	public Product_category get(Product_category product_category);
    public void update(Product_category product_category);
    public void delete(Product_category product_category);

	
}
