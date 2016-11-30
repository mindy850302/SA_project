package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Product;

public interface ProductDAO {
	public List<Product> getList();
	public void insert(Product product);
	public Product get(int id);
    public void update(Product product,int id);
    public void delete(int id);

}
