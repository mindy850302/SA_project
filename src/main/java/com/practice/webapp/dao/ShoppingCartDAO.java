package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.ShoppingCart;

public interface ShoppingCartDAO {
	public List<ShoppingCart> getList();
	public void insert(ShoppingCart shoppingcart);
	public ShoppingCart get(long id);
    public void update(ShoppingCart shoppingcart,int id);
    public void delete(long id);
	//public boolean checkLoginShoppingCart(String shoppingcart_id, String password);

}
