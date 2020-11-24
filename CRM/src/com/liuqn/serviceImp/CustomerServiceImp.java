package com.liuqn.serviceImp;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liuqn.dao.CustomerDao;
import com.liuqn.daoImp.CustomerDaoImp;
import com.liuqn.pojo.Customer;
import com.liuqn.service.CustomerService;

public class CustomerServiceImp implements CustomerService{
	CustomerDao customerDao = new CustomerDaoImp();

	@Override
	public Map<String, Object> queryPageCustomer(int page, int limit) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			List<Customer> list = null;
			if(page == 0){
				list = customerDao.queryPageCustomer(0, limit);
			}else{
				list = customerDao.queryPageCustomer((page-1)*limit, limit);
			}
			map.put("code", 0);
			map.put("data", list);
			map.put("count", customerDao.queryCountCustomer());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> addCustomer(Customer customer) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map.put("flag", customerDao.addCustomer(customer));
		} catch (SQLException e) {
			e.printStackTrace();
			map.put("flag", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> updateCustomer(Customer customer) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map.put("flag", customerDao.updateByCustomer(customer));
		} catch (SQLException e) {
			e.printStackTrace();
			map.put("flag", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteCustomer(int customerID) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map.put("flag", customerDao.deleteByID(customerID));
		} catch (SQLException e) {
			e.printStackTrace();
			map.put("flag", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> queryByIDCustomer(int customerID) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map.put("flag", customerDao.queryByID(customerID));
		} catch (SQLException e) {
			e.printStackTrace();
			map.put("flag", false);
		}
		return map;
	}

}
