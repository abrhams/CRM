package com.liuqn.service;

import java.util.Map;

import com.liuqn.pojo.Manager;

public interface ManagerService {

	public boolean login(Manager manager);
	public boolean register(Manager manager);
	public Map<String, Object> queryPageManager(int page,int limit);
	public Map<String, Object> addManager(Manager manager);
	public Map<String,Object> updateManager(Manager manager);
	public Map<String, Object> deleteManager(int managerID);
	public Map<String, Object> queryByIDManager(int managerID);
}
