package com.liuqn.pojo;

import java.util.Date;
import java.util.List;

public class MarketingOrder {// 营销订单
	
	private int marketingOrderID;// 主键id
	private int staffID;// 职员id
	private int customerID;// 客户id
	private String customerDemand;// 客户需求内容
	private Date createDate;// 创建时间
	private int marketingClue;// 营销线索（1、客户咨询   2、黄页  3、名片  4、客户数据库  8、老客户（二次使用））
	private int occasionLevel;// 机会等级  （1级，2级，3级）
	private String occasionAnalyseContent;// 机会分析内容
	private int activityTrackingTimes;// 活动跟踪次数
	private List<Integer> marketingTrackingRecords;// 营销跟踪历史
	public int getMarketingID() {
		return marketingOrderID;
	}
	public void setMarketingID(int marketingID) {
		this.marketingOrderID = marketingID;
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
	public String getCustomerDemand() {
		return customerDemand;
	}
	public void setCustomerDemand(String customerDemand) {
		this.customerDemand = customerDemand;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getMarketingClue() {
		return marketingClue;
	}
	public void setMarketingClue(int marketingClue) {
		this.marketingClue = marketingClue;
	}
	public int getOccasionLevel() {
		return occasionLevel;
	}
	public void setOccasionLevel(int occasionLevel) {
		this.occasionLevel = occasionLevel;
	}
	public String getOccasionAnalyseContent() {
		return occasionAnalyseContent;
	}
	public void setOccasionAnalyseContent(String occasionAnalyseContent) {
		this.occasionAnalyseContent = occasionAnalyseContent;
	}
	public int getActivityTrackingTimes() {
		return activityTrackingTimes;
	}
	public void setActivityTrackingTimes(int activityTrackingTimes) {
		this.activityTrackingTimes = activityTrackingTimes;
	}
	public List<Integer> getMarketingTrackingRecords() {
		return marketingTrackingRecords;
	}
	public void setMarketingTrackingRecords(List<Integer> marketingTrackingRecords) {
		this.marketingTrackingRecords = marketingTrackingRecords;
	}
	public MarketingOrder(int marketingOrderID, int staffID, int customerID, String customerDemand, Date createDate,
			int marketingClue, int occasionLevel, String occasionAnalyseContent, int activityTrackingTimes,
			List<Integer> marketingTrackingRecords) {
		super();
		this.marketingOrderID = marketingOrderID;
		this.staffID = staffID;
		this.customerID = customerID;
		this.customerDemand = customerDemand;
		this.createDate = createDate;
		this.marketingClue = marketingClue;
		this.occasionLevel = occasionLevel;
		this.occasionAnalyseContent = occasionAnalyseContent;
		this.activityTrackingTimes = activityTrackingTimes;
		this.marketingTrackingRecords = marketingTrackingRecords;
	}
	public MarketingOrder() {
		super();
	}

	
}
