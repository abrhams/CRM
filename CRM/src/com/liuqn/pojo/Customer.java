package com.liuqn.pojo;

import java.util.Date;

public class Customer {// 客户表

	private int customerID;// 客户id
	private String customerName;// 客户名字
	private int customerAge;// 客户年龄
	private String customerPhone;// 客户电话号码
	private String customerGender;// 客户性别
	private String customerQQ;// 客户qq
	private String customerWX;// 客户微信
	private int staffID;// 营销人员id
	private Date createDate;// 创建时间
	private int marketingStatus;// 营销机会
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerQQ() {
		return customerQQ;
	}
	public void setCustomerQQ(String customerQQ) {
		this.customerQQ = customerQQ;
	}
	public String getCustomerWX() {
		return customerWX;
	}
	public void setCustomerWX(String customerWX) {
		this.customerWX = customerWX;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getMarketingStatus() {
		return marketingStatus;
	}
	public void setMarketingStatus(int marketingStatus) {
		this.marketingStatus = marketingStatus;
	}
	public Customer(int customerID, String customerName, int customerAge, String customerPhone, String customerGender,
			String customerQQ, String customerWX, int staffID, Date createDate, int marketingStatus) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerPhone = customerPhone;
		this.customerGender = customerGender;
		this.customerQQ = customerQQ;
		this.customerWX = customerWX;
		this.staffID = staffID;
		this.createDate = createDate;
		this.marketingStatus = marketingStatus;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerAge=" + customerAge
				+ ", customerPhone=" + customerPhone + ", customerGender=" + customerGender + ", customerQQ="
				+ customerQQ + ", customerWX=" + customerWX + ", staffID=" + staffID + ", createDate=" + createDate
				+ ", marketingStatus=" + marketingStatus + "]";
	}
	
}
