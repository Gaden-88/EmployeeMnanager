package com.zr.model.entity;

import java.sql.Date;

public class Staff {
	private long empId;
    private String empName;
    private String empSex;
    private int empAge;
    private Date birthday;
    private long telephone;
    private long qq;
    private String departmentName;
    
	public Staff() {
		super();
	}
	public Staff(long empId, String empName, String empSex, int empAge, Date birthday, long telephone2, long qq2,
			String departmentName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.empAge = empAge;
		this.birthday = birthday;
		this.telephone = telephone2;
		this.qq = qq2;
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		return "staff [empId=" + empId + ", empName=" + empName + ", empSex=" + empSex + ", empAge=" + empAge
				+ ", birthday=" + birthday + ", telephone=" + telephone + ", qq=" + qq + ", departmentId="
				+ departmentName + "]";
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
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
	public void setTelephone(long l) {
		this.telephone = l;
	}
	public long getQq() {
		return qq;
	}
	public void setQq(long qq) {
		this.qq = qq;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
