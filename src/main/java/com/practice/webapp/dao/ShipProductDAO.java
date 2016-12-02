package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.ShipProduct;

public interface ShipProductDAO {
	public List<ShipProduct> getList();
	public void insert(ShipProduct shipProduct);
	public ShipProduct get(long id);
    public void update(ShipProduct shipProduct,long id);
    public void delete(long id);
}
