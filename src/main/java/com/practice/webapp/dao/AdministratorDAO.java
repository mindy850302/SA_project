package com.practice.webapp.dao;
import java.util.List;
import com.practice.webapp.entity.Administrator;

public interface AdministratorDAO {
	public void insert(Administrator administrator);
	public void delete(Administrator administrator);
	public void update(Administrator administrator);
	public boolean checkLoginAdministrator(Administrator administrator);
	public List<Administrator> getList();
	public Administrator get(Administrator administrator);
}
