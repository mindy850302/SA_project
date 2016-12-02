package com.practice.webapp.dao;
import java.util.List;
import com.practice.webapp.entity.A_category;
public interface A_categoryDAO {
	public void insert(A_category a_category);
	public void delete(A_category a_category);
	public void update(A_category a_category);
	public List<A_category> getList();
	public A_category get(A_category a_category);

}
