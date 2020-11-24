package com.liuqn.pojo;

import java.util.Date;

public class SellOrder {// 销售订单

	private int sellID;// 销售ID
	private int staffID;// 营销ID
	private int customerID;// 客户ID
	private Date sellDate;// 销售时间
	private double sellPrice;// 销售价格
	private int payStatus;// 支付情况（1 支付  0 未支付）
	private String payType;// 支付类型
	private Date payTime;// 支付时间
	public int getSellID() {
		return sellID;
	}
	public void setSellID(int sellID) {
		this.sellID = sellID;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public SellOrder(int sellID, int staffID, int customerID, Date sellDate, double sellPrice, int payStatus,
			String payType, Date payTime) {
		super();
		this.sellID = sellID;
		this.staffID = staffID;
		this.customerID = customerID;
		this.sellDate = sellDate;
		this.sellPrice = sellPrice;
		this.payStatus = payStatus;
		this.payType = payType;
		this.payTime = payTime;
	}
	public SellOrder() {
		super();
	}
	@Override
	public String toString() {
		return "SellOrder [sellID=" + sellID + ", staffID=" + staffID + ", customerID=" + customerID + ", sellDate="
				+ sellDate + ", sellPrice=" + sellPrice + ", payStatus=" + payStatus + ", payType=" + payType
				+ ", payTime=" + payTime + "]";
	}
	
}
