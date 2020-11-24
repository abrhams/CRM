package com.liuqn.dao;

import java.sql.SQLException;
import java.util.List;

import com.liuqn.pojo.Manager;

public interface ManagerDao {

	public Manager queryByID(int managerID) throws SQLException;
	public boolean updateByManager(Manager manager) throws SQLException;
	public boolean deleteByID(int managerID) throws SQLException;
	public boolean addManager(Manager manager) throws SQLException;
	public Manager queryByName(String username, String password) throws SQLException;
	public List<Manager> queryPageManager(int page, int limit) throws SQLException;
    public int queryCountManager() throws SQLException;	

}
