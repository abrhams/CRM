package com.liuqn.dao;

import com.liuqn.pojo.MarketingOrder;

public interface MarketingOrderDao {

	public MarketingOrder queryByID(int marketingOrderID);
	public boolean updateByCustomer(MarketingOrder marketingOrder);
	public boolean deleteByID(int marketingOrderID);
	public boolean addManager(MarketingOrder marketingOrder);
}
