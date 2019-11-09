package com.zr.model.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.zr.model.dao.StaffDao;
import com.zr.model.entity.Staff;


public class StaffService {
	
	public static String listToJson(int pageLine, int pageNo,int pageTotal)
	{
		ArrayList<Staff> list = null;
		try {
			list = (ArrayList<Staff>) StaffDao.getEmpPageinfo(pageLine, pageNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//data = {"data":[{"stuid":id, "stuname":name, "stuage":age, "birthday":"year-month-day"}, {}, {}, {}]}
		Calendar cal = Calendar.getInstance();
		int isEmpty = 1;
		String str = "{'isEmpty':"  +isEmpty+ ",'pageTotal':"  +pageTotal+ ",'data':[";
		for(int i=0 ; i<list.size() ; i++)
		{
			Staff emp = list.get(i);
			long empId = emp.getEmpId(); 
			String empName  = emp.getEmpName();
			String empSex  = emp.getEmpSex();
			int empAge = emp.getEmpAge();
			Date birth = emp.getBirthday();
			long telephone  = emp.getTelephone();
			long qq  = emp.getQq();
			String departmentName = emp.getDepartmentName();
			
			cal.setTime(birth);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DATE);
			
			str += "{'empId':" +empId+ 
					",'empName':'" +empName+ 
					"','empSex':'" +empSex+ 
					"','empAge':" +empAge+ 
					",'birthday':'" +year+ "-" +month+ "-" +day+ 
					"','telephone':" +telephone+ 
					",'qq':" +qq+
					",'departmentName':'" +departmentName+
					"'}";
			if(i != list.size()-1)
			{
				str += ",";
			}
		}
		str += "]}";
		
		return str;
	}

	public static int getTotalPage(int pageLine) {
		int total=0;
		
		try {
			int num = StaffDao.getTotalEmpNumber();
			total = (num-1) / pageLine + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	public static int getTotalPage(int pageLine,int departmentId) {
		int total=0;
		
		try {
			int num = StaffDao.getTotalEmpNumber(departmentId);
			total = (num-1) / pageLine + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	public static int deleStaff(int empId) {
		int res = 0;
		try {
			res= StaffDao.deleteStaffByID(empId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public static String getStaffinfoByIDToJson(int empID)
	{
		String str = null;
		Staff emp = null;
		Calendar cal = Calendar.getInstance();
		
		try {
			emp = StaffDao.selectStaffByID(empID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		long empId = emp.getEmpId(); 
		String empName  = emp.getEmpName();
		String empSex  = emp.getEmpSex();
		int empAge = emp.getEmpAge();
		Date birth = emp.getBirthday();
		long telephone  = emp.getTelephone();
		long qq  = emp.getQq();
		String departmentName = emp.getDepartmentName();
		
		cal.setTime(birth);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		
		str = "{'empId':" +empId+ 
				",'empName':'" +empName+ 
				"','empSex':'" +empSex+ 
				"','empAge':" +empAge+ 
				",'birthday':'" +year+ "-" +month+ "-" +day+ 
				"','telephone':" +telephone+ 
				",'qq':" +qq+
				",'departmentName':'" +departmentName+
				"'}";
		
		return str;
	}

	public static int updateEmpinfoByEmpid(Object[] data)
	{
		int res = 0;
		try {
			res = StaffDao.UpdateStaffinfoByEmpid(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static int getSelectTotalPage(int pageLine, String likeName) {
		int total=0;
		String likename = likeName;
		try {
			int num = StaffDao.getTotalSelectEmpNumberByLikename(likename);
			total = (num-1) / pageLine + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	public static String listToJson(int pageLine, int pageNo,int pageTotal, String likename)
	{
		ArrayList<Staff> list = null;
		try {
			list = (ArrayList<Staff>) StaffDao.getStaffPageinfoByLikeName(pageLine, pageNo, likename);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//data = {"data":[{"stuid":id, "stuname":name, "stuage":age, "birthday":"year-month-day"}, {}, {}, {}]}
		Calendar cal = Calendar.getInstance();
		int isEmpty = 2;
		String str = "{'isEmpty':"  +isEmpty+ ",'pageTotal':"  +pageTotal+ ",'data':[";
		for(int i=0 ; i<list.size() ; i++)
		{
			Staff emp = list.get(i);
			long empId = emp.getEmpId(); 
			String empName  = emp.getEmpName();
			String empSex  = emp.getEmpSex();
			int empAge = emp.getEmpAge();
			Date birth = emp.getBirthday();
			long telephone  = emp.getTelephone();
			long qq  = emp.getQq();
			String departmentName = emp.getDepartmentName();
			
			cal.setTime(birth);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DATE);
			
			str += "{'empId':" +empId+ 
					",'empName':'" +empName+ 
					"','empSex':'" +empSex+ 
					"','empAge':" +empAge+ 
					",'birthday':'" +year+ "-" +month+ "-" +day+ 
					"','telephone':" +telephone+ 
					",'qq':" +qq+
					",'departmentName':'" +departmentName+
					"'}";
			if(i != list.size()-1)
			{
				str += ",";
			}
		}
		str += "]}";
		
		return str;
	}

	public static int addStaff(Object[] data) 
	{
		int res = 0;
		try {
			res = StaffDao.addStaff(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static String listToJson(int pageLine, int pageNo,int pageTotal,int departmentId)
	{
		ArrayList<Staff> list = null;
		try {
			list = (ArrayList<Staff>) StaffDao.getgetEmpPageinfoByDepartmentId(pageLine, pageNo, departmentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//data = {"data":[{"stuid":id, "stuname":name, "stuage":age, "birthday":"year-month-day"}, {}, {}, {}]}
		Calendar cal = Calendar.getInstance();
		int isEmpty = 1;
		String str = "{'isEmpty':"  +isEmpty+ ",'pageTotal':"  +pageTotal+ ",'data':[";
		for(int i=0 ; i<list.size() ; i++)
		{
			Staff emp = list.get(i);
			long empId = emp.getEmpId(); 
			String empName  = emp.getEmpName();
			String empSex  = emp.getEmpSex();
			int empAge = emp.getEmpAge();
			Date birth = emp.getBirthday();
			long telephone  = emp.getTelephone();
			long qq  = emp.getQq();
			String departmentName = emp.getDepartmentName();
			
			cal.setTime(birth);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DATE);
			
			str += "{'empId':" +empId+ 
					",'empName':'" +empName+ 
					"','empSex':'" +empSex+ 
					"','empAge':" +empAge+ 
					",'birthday':'" +year+ "-" +month+ "-" +day+ 
					"','telephone':" +telephone+ 
					",'qq':" +qq+
					",'departmentName':'" +departmentName+
					"'}";
			if(i != list.size()-1)
			{
				str += ",";
			}
		}
		str += "]}";
		
		return str;
	}
}
