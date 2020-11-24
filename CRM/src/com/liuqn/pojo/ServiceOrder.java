package com.liuqn.pojo;

import java.util.Date;

public class ServiceOrder {// 服务订单

	private int serviceID;// 服务id
	private int customerID;// 客户id
	private int staffID;// 职员id
	private Date createDate;// 创建时间
	private int serviceType;// 服务类型（1、客户关怀 2、投诉 3、维修）
	private String serviceContent;// 服务内容
	private String serviceFeeback;// 服务反馈
	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	public String getServiceContent() {
		return serviceContent;
	}
	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}
	public String getServiceFeeback() {
		return serviceFeeback;
	}
	public void setServiceFeeback(String serviceFeeback) {
		this.serviceFeeback = serviceFeeback;
	}
	public ServiceOrder(int serviceID, int customerID, int staffID, Date createDate, int serviceType,
			String serviceContent, String serviceFeeback) {
		super();
		this.serviceID = serviceID;
		this.customerID = customerID;
		this.staffID = staffID;
		this.createDate = createDate;
		this.serviceType = serviceType;
		this.serviceContent = serviceContent;
		this.serviceFeeback = serviceFeeback;
	}
	public ServiceOrder() {
		super();
	}
	@Override
	public String toString() {
		return "ServiceOrder [serviceID=" + serviceID + ", customerID=" + customerID + ", staffID=" + staffID
				+ ", createDate=" + createDate + ", serviceType=" + serviceType + ", serviceContent=" + serviceContent
				+ ", serviceFeeback=" + serviceFeeback + "]";
	}
}
