package com.practice.webapp.dao.impl;
import java.util.List;
import com.pratice.webapp.entity.A_category;
public interface A_categoryDAO {
	public List<A_category> getList();
	public A_category get(A_category a_category);

}
