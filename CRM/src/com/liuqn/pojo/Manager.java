package com.liuqn.pojo;

import java.util.Date;

public class Manager {// 管理员

	private int managerID;// 主键
    private String username;// 用户名
    private String password;// 密码
    private String managerName;// 管理员名称
    private Date createDate;// 创建时间
    private String createPersonnel;// 创建人员
    private int accessLevel;// 权限等级（最高级 1级，2级，3级公司人员，9级公司人员：没有操作权限）
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
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
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatePersonnel() {
		return createPersonnel;
	}
	public void setCreatePersonnel(String createPersonnel) {
		this.createPersonnel = createPersonnel;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	public Manager(int managerID, String username, String password, String managerName, Date createDate,
			String createPersonnel, int accessLevel) {
		super();
		this.managerID = managerID;
		this.username = username;
		this.password = password;
		this.managerName = managerName;
		this.createDate = createDate;
		this.createPersonnel = createPersonnel;
		this.accessLevel = accessLevel;
	}
	public Manager() {
		super();
	}
	@Override
	public String toString() {
		return "Manager [managerID=" + managerID + ", username=" + username + ", password=" + password
				+ ", managerName=" + managerName + ", createDate=" + createDate + ", createPersonnel=" + createPersonnel
				+ ", accessLevel=" + accessLevel + "]";
	}
    
    
}
