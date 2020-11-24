package com.liuqn.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.liuqn.dao.CustomerDao;
import com.liuqn.pojo.Customer;
import com.liuqn.util.C3p0Util;

public class CustomerDaoImp implements CustomerDao{

	@Override
	public Customer queryByID(int customerID) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
		Customer customer = queryRunner.query("select * from customer where customerID=?", new BeanHandler<Customer>(Customer.class), customerID);
		return customer;
	}

	@Override
	public boolean updateByCustomer(Customer customer) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
		int i = queryRunner.update("update customer set customerName=?,customerAge=?,customerPhone=?,customerGender=?,customerQQ=?,customerWX=?,staffID=?,createDate=?,marketingStatus=? where customerID=?",
				customer.getCustomerName(),customer.getCustomerAge(),customer.getCustomerPhone(),customer.getCustomerGender(),customer.getCustomerQQ(),customer.getCustomerWX(),customer.getStaffID(),
				customer.getCreateDate(),customer.getMarketingStatus(),customer.getCustomerID());
		return i>0;
	}

	@Override
	public boolean deleteByID(int customerID) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
		int i = queryRunner.update("delete from customer where customerID=?", customerID);
		return i>0;
	}

	@Override
	public boolean addCustomer(Customer customer) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
		int i = queryRunner.update("insert into customer(customerName,customerAge,customerPhone,"
				+ "customerGender,customerQQ,customerWX,staffID,createDate,marketingStatus)values"
				+ "(?,?,?,?,?,?,?,?,?)",customer.getCustomerName(),customer.getCustomerAge(),
				customer.getCustomerPhone(),customer.getCustomerGender(),customer.getCustomerQQ(),
				customer.getCustomerWX(),customer.getStaffID(),customer.getCreateDate(),
				customer.getMarketingStatus());
		return i>0;
	}

	@Override
	public List<Customer> queryPageCustomer(int page, int limit) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
		List<Customer> list = queryRunner.query("select * from customer limit ?,?",new BeanListHandler<Customer>(Customer.class),page,limit);
		return list;
	}

	@Override
	public int queryCountCustomer() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3p0Util.getDataSource());
		List<Object> list = queryRunner.query("select count(*) from customer", new ColumnListHandler<>(1));
		return list != null?Integer.parseInt(list.get(0).toString()):0;
	}

}
