package com.liuqn.serviceImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liuqn.dao.ManagerDao;
import com.liuqn.daoImp.ManagerDaoImp;
import com.liuqn.pojo.Manager;
import com.liuqn.service.ManagerService;

public class ManagerServiceImp implements ManagerService{
	ManagerDao managerDao = new ManagerDaoImp();
	@Override
	public boolean login(Manager manager) {
		if(manager.getUsername() != null && manager.getPassword() != null){
			Manager manager2 = null;
			try {
				manager2 = managerDao.queryByName(manager.getUsername(), manager.getPassword());
				System.out.println(manager2);
				if(manager2 != null)return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean register(Manager manager) {
		if(manager.getUsername() != null && manager.getPassword() != null && manager.getManagerName() != null){
			try {
				return managerDao.addManager(manager);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Map<String, Object> queryPageManager(int page, int limit) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			List<Manager> list = null;
			if(page == 0){
				list = managerDao.queryPageManager(0, limit);
			}else{
				list = managerDao.queryPageManager((page-1)*limit, limit);
			}
			map.put("code", 0);
			map.put("data", list);
			map.put("count",managerDao.queryCountManager());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String,Object> addManager(Manager manager) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			map.put("flag",managerDao.addManager(manager));
		} catch (SQLException e) {
			e.printStackTrace();
			map.put("flag", false);
		}
		return map;
	}

	@Override
	public Map<String,Object> updateManager(Manager manager) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			map.put("flag", managerDao.updateByManager(manager));
		} catch (SQLException e) {
			e.printStackTrace();
			map.put("flag", false);
		}
		return map;
	}

	@Override
	public Map<String,Object> deleteManager(int managerID) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			map.put("flag",managerDao.deleteByID(managerID));
		} catch (SQLException e) {
			e.printStackTrace();
			map.put("flag",false);
		}
		return map;
	}

	@Override
	public Map<String,Object> queryByIDManager(int managerID) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Manager manager = managerDao.queryByID(managerID);
			if(manager != null){
				map.put("code", 0);
			}else{
				map.put("code", 404);
			}
			List<Manager> list = new ArrayList<Manager>();
			list.add(manager);
			map.put("data", list);
			map.put("count",1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  map;
	}

}
