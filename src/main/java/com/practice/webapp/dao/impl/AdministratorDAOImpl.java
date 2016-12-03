package com.practice.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

//import com.mysql.jdbc.Statement;

import com.practice.webapp.entity.Administrator;
import com.practice.webapp.dao.AdministratorDAO;

public class AdministratorDAOImpl implements AdministratorDAO {
	private List<Administrator> AdministratorList = new ArrayList<Administrator>();

	@Override
	public void insert(Administrator administrator) {
		// TODO Auto-generated method stub
		AdministratorList.add(administrator);

	}

	@Override
	public void delete(Administrator administrator) {
		// TODO Auto-generated method stub
		for (int i = 0; i < AdministratorList.size(); i++) {
			if (AdministratorList.get(i).getA_id() == administrator.getA_id()) {
				AdministratorList.remove(i);
			}
		}
	}

	@Override
	public void update(Administrator administrator) {
		// TODO Auto-generated method stub
		for (int i = 0; i < AdministratorList.size(); i++) {
			if (AdministratorList.get(i).getA_id() == administrator.getA_id()) {
				AdministratorList.remove(i);
				AdministratorList.add(i, administrator);
			}
		}

	}

	@Override
	public boolean checkLoginAdministrator(String A_idName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Administrator> getList() {
		// TODO Auto-generated method stub
		return AdministratorList;
	}

	@Override
	public Administrator get(Administrator administrator) {
		// TODO Auto-generated method stub
		Administrator administrator1 = new Administrator();
		for (int i = 0; i < AdministratorList.size(); i++) {
			if (AdministratorList.get(i).getA_id() == administrator.getA_id()) {
				administrator1 = AdministratorList.get(i);
			}
		}

		return administrator1;
	}

}
