package com.practice.webapp.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.practice.webapp.dao.A_categoryDAO;

//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.A_category;

public class A_categoryDAOImpl implements A_categoryDAO {
	private List<A_category> A_categoryList = new ArrayList<A_category>();

	@Override
	public void insert(A_category a_category) {
		// TODO Auto-generated method stub
		A_categoryList.add(a_category);

	}

	@Override
	public void delete(A_category a_category) {
		// TODO Auto-generated method stub
		for (int i = 0; i < A_categoryList.size(); i++) {
			if (A_categoryList.get(i).getC_id() == a_category.getC_id()) {
				A_categoryList.remove(i);
			}
		}
	}

	@Override
	public void update(A_category a_category) {
		// TODO Auto-generated method stub
		for (int i = 0; i < A_categoryList.size(); i++) {
			if (A_categoryList.get(i).getC_id() == a_category.getC_id()) {
				A_categoryList.remove(i);
				A_categoryList.add(i, a_category);
			}
		}

	}

	@Override
	public List<A_category> getList() {
		// TODO Auto-generated method stub
		return A_categoryList;
	}

	@Override
	public A_category get(A_category a_category) {
		// TODO Auto-generated method stub
		A_category a_category1 = new A_category();
		for (int i = 0; i < A_categoryList.size(); i++) {
			if (A_categoryList.get(i).getC_id() == a_category.getC_id()) {
				a_category1 = A_categoryList.get(i);
			}
		}
		return a_category1;

	}

}
