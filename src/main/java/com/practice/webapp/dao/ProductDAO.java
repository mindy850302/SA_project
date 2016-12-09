package com.practice.webapp.dao;

import java.util.List;


import com.practice.webapp.entity.Product;

public interface ProductDAO {
	public List<Product> getList();
	public void insert(Product product);
	public Product get(Product product);
    public void update(Product product);
    public void delete(Product product);
    public List<Product>  search(String keyword);
    public void average(int id);
    public void addInventory(Product product);
    public int updateClick(Product product);
 

}
