package com.zr.model.entity;

import java.sql.Date;

public class Manger {
	private long managerId;
    private String managerName;
    private String managerPwd;
    private String userSex;
    private int userAge;
    private Date birthday;
    private long telephone;
    
	public Manger() {
		super();
	}

	public Manger(long managerId, String managerName, String managerPwd, String userSex, int userAge, Date birthday,
			long telephone) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerPwd = managerPwd;
		this.userSex = userSex;
		this.userAge = userAge;
		this.birthday = birthday;
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Manger [managerId=" + managerId + ", managerName=" + managerName + ", managerPwd=" + managerPwd
				+ ", userSex=" + userSex + ", userAge=" + userAge + ", birthday=" + birthday + ", telephone="
				+ telephone + "]";
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}  
}
