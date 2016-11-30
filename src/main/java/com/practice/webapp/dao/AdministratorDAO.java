package com.practice.webapp.dao;
import java.util.List;
import com.practice.webapp.entity.Administrator;

public interface AdministratorDAO {
	public void insert(Administrator aAdministrator);
	public void delete(long id);
	public void update(Administrator administrator ,long id);
	public boolean checkLoginAdministrator(String A_idName, String password);
	public List<Administrator> getList(String sql);
	public Administrator get(Administrator aAdministrator);
}
