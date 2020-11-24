package com.liuqn.dao;

import com.liuqn.pojo.SellOrder;

public interface SellOrderDao {

	public SellOrder queryByID(int sellOrderID);
	public boolean updateByCustomer(SellOrder sellOrder);
	public boolean deleteByID(int marketingOrderID);
	public boolean addManager(SellOrder marketingOrder);
}
