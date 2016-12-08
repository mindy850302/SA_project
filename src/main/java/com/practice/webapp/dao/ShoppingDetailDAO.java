package com.practice.webapp.dao;

import java.util.List;


import com.practice.webapp.entity.ShoppingDetail;
public interface ShoppingDetailDAO {
	
	public List<ShoppingDetail> getList();
	public void insert(ShoppingDetail shoppingdetail);
	public ShoppingDetail get(ShoppingDetail shoppingdetail);
    public void update(ShoppingDetail shoppingdetail);
    public void delete(ShoppingDetail shoppingdetail);
	public boolean checkLoginMember(ShoppingDetail shoppingdetail);
	public int getTotal(int M_id);
//	public int count();
	
}
