package com.liuqn.dao;

import com.liuqn.pojo.ServiceOrder;

public interface ServiceOrderDao {

	public ServiceOrder queryByID(int serviceOrderID);
	public boolean updateByCustomer(ServiceOrder serviceOrder);
	public boolean deleteByID(int serviceOrderID);
	public boolean addManager(ServiceOrder serviceOrder);
}
