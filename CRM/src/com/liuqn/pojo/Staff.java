package com.liuqn.pojo;

import java.util.Date;

public class Staff {// 公司职员
	
	private int staffID;// 职员id
	private String username;// 用户名
	private String password;// 密码
	private String staffName;// 职员姓名
	private String staffPhone;// 职员电话
	private int staffAge;// 职员年龄
	private char staffGender;// 职员性别
	private String staffQQ;// 职员qq
	private String staffWX;// 职员微信
	private int marketingLevel;// 营销级别
	private Date CompanyDate;// 创建日期
	private int DepID;// 部门id
	private int superiorID;// 直系领导id
	private String staffPosition;// 职位名称
	private int staffLevel;// 职位级别
	private double staffSalary;// 工资待遇
	private double commissionRate;// 提出比例
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	public int getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(int staffAge) {
		this.staffAge = staffAge;
	}
	public char getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(char staffGender) {
		this.staffGender = staffGender;
	}
	public String getStaffQQ() {
		return staffQQ;
	}
	public void setStaffQQ(String staffQQ) {
		this.staffQQ = staffQQ;
	}
	public String getStaffWX() {
		return staffWX;
	}
	public void setStaffWX(String staffWX) {
		this.staffWX = staffWX;
	}
	public int getMarketingLevel() {
		return marketingLevel;
	}
	public void setMarketingLevel(int marketingLevel) {
		this.marketingLevel = marketingLevel;
	}
	public Date getCompanyDate() {
		return CompanyDate;
	}
	public void setCompanyDate(Date companyDate) {
		CompanyDate = companyDate;
	}
	public int getDepID() {
		return DepID;
	}
	public void setDepID(int depID) {
		DepID = depID;
	}
	public int getSuperiorID() {
		return superiorID;
	}
	public void setSuperiorID(int superiorID) {
		this.superiorID = superiorID;
	}
	public String getStaffPosition() {
		return staffPosition;
	}
	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}
	public int getStaffLevel() {
		return staffLevel;
	}
	public void setStaffLevel(int staffLevel) {
		this.staffLevel = staffLevel;
	}
	public double getStaffSalary() {
		return staffSalary;
	}
	public void setStaffSalary(double staffSalary) {
		this.staffSalary = staffSalary;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	public Staff(int staffID, String username, String password, String staffName, String staffPhone, int staffAge,
			char staffGender, String staffQQ, String staffWX, int marketingLevel, Date companyDate, int depID,
			int superiorID, String staffPosition, int staffLevel, double staffSalary, double commissionRate) {
		super();
		this.staffID = staffID;
		this.username = username;
		this.password = password;
		this.staffName = staffName;
		this.staffPhone = staffPhone;
		this.staffAge = staffAge;
		this.staffGender = staffGender;
		this.staffQQ = staffQQ;
		this.staffWX = staffWX;
		this.marketingLevel = marketingLevel;
		CompanyDate = companyDate;
		DepID = depID;
		this.superiorID = superiorID;
		this.staffPosition = staffPosition;
		this.staffLevel = staffLevel;
		this.staffSalary = staffSalary;
		this.commissionRate = commissionRate;
	}
	public Staff() {
		super();
	}
	

}
