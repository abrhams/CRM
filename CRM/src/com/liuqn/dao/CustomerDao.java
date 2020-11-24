package com.liuqn.dao;

import java.sql.SQLException;
import java.util.List;

import com.liuqn.pojo.Customer;

public interface CustomerDao {

	public Customer queryByID(int customerID) throws SQLException;
	public boolean updateByCustomer(Customer customer) throws SQLException;
	public boolean deleteByID(int customerID) throws SQLException;
	public boolean addCustomer(Customer customer) throws SQLException;
	public List<Customer> queryPageCustomer(int page, int limit) throws SQLException;
    public int queryCountCustomer() throws SQLException;	
}
