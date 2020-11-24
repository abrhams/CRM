package com.liuqn.service;

import java.util.Map;

import com.liuqn.pojo.Customer;

public interface CustomerService {

	public Map<String, Object> queryPageCustomer(int page,int limit);
	public Map<String, Object> addCustomer(Customer customer);
	public Map<String,Object> updateCustomer(Customer customer);
	public Map<String, Object> deleteCustomer(int customerID);
	public Map<String, Object> queryByIDCustomer(int customerID);
}
