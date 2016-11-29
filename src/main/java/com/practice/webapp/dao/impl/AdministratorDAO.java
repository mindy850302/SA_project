package com.practice.webapp.dao.impl;
import java.util.List;
import com.pratice.webapp.entity.Administrator;

public interface AdministratorDAO {
	public void insert(Administrator aAdministrator);
	public void delete(Administrator aAdministrator);
	public void update(Administrator aAdministrator);
	public void register(Administrator aAdministrator);
	public void login(Administrator aAdministrator);
	public List<Administrator> getList();
	public Administrator get(Administrator aAdministrator);
}
