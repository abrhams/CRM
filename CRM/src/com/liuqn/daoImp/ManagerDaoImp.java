package com.liuqn.daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liuqn.dao.ManagerDao;
import com.liuqn.pojo.Manager;
import com.liuqn.util.JDBCUtil;

public class ManagerDaoImp implements ManagerDao{

	@Override
	public Manager queryByID(int managerID) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		String sql = "select * from manager where managerID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, managerID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			int managerID2 = rs.getInt(1);
			String usernamed = rs.getString(2);
			String passworded = rs.getString(3);
			String managerName = rs.getString(4);
			Date date = rs.getDate(5);
			String createPersonnel = rs.getString(6);
			int accessLevel = rs.getInt(1);
			Manager manager = new Manager(managerID2,usernamed,passworded,managerName,date,createPersonnel,accessLevel);
			return manager;
		}
		return null;
	}

	@Override
	public boolean updateByManager(Manager manager) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		String sql = "update manager set username=?,password=?,managerName=?,createDate=?,createPersonnel=?,accessLevel=? where managerID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, manager.getUsername());
		ps.setString(2, manager.getPassword());
		ps.setString(3, manager.getManagerName());
		ps.setDate(4, new java.sql.Date(manager.getCreateDate().getTime()));
		ps.setString(5, manager.getCreatePersonnel());
		ps.setInt(6, manager.getAccessLevel());
		ps.setInt(7, manager.getManagerID());
		int b = ps.executeUpdate();
		return b>0;
	}

	@Override
	public boolean deleteByID(int managerID) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		String sql = "delete from manager where managerID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, managerID);
		int b = ps.executeUpdate();
		return b>0;
	}

	@Override
	public boolean addManager(Manager manager) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into manager(username,password,managerName,createDate,createPersonnel,accessLevel) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, manager.getUsername());
		ps.setString(2, manager.getPassword());
		ps.setString(3, manager.getManagerName());
		ps.setDate(4, new java.sql.Date(manager.getCreateDate().getTime()));
		ps.setString(5, manager.getCreatePersonnel());
		ps.setInt(6, manager.getAccessLevel());
		int b = ps.executeUpdate();
		return b>0;
	}

	@Override
	public Manager queryByName(String username, String password) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		String sql = "select * from manager where username = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			int managerID = rs.getInt(1);
			String usernamed = rs.getString(2);
			String passworded = rs.getString(3);
			String managerName = rs.getString(4);
			Date date = rs.getDate(5);
			String createPersonnel = rs.getString(6);
			int accessLevel = rs.getInt(1);
			Manager manager = new Manager(managerID,usernamed,passworded,managerName,date,createPersonnel,accessLevel);
			return manager;
		}
		return null;
	}

	@Override
	public List<Manager> queryPageManager(int page, int limit) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from manager limit ?,?");
		ps.setInt(1, page);
		ps.setInt(2, limit);
		ResultSet rs = ps.executeQuery();
		List<Manager> list = new ArrayList<Manager>();
		while(rs.next()){
			int managerID = rs.getInt(1);
			String usernamed = rs.getString(2);
			String passworded = rs.getString(3);
			String managerName = rs.getString(4);
			Date date = rs.getDate(5);
			String createPersonnel = rs.getString(6);
			int accessLevel = rs.getInt(7);
			Manager manager = new Manager(managerID,usernamed,passworded,managerName,date,createPersonnel,accessLevel);
			list.add(manager);
		}
		return list;
	}

	@Override
	public int queryCountManager() throws SQLException {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select count(*) from manager");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}

	
}
