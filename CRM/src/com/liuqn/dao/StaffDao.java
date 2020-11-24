package com.liuqn.dao;

import com.liuqn.pojo.Staff;

public interface StaffDao {

	public Staff queryByID(int staffID);
	public boolean updateByCustomer(Staff staff);
	public boolean deleteByID(int staffID);
	public boolean addManager(Staff staff);
}
