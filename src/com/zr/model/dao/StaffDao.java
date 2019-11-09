package com.zr.model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.entity.Staff;
import com.zr.model.jdbc.JDBCUtil;

public class StaffDao {
	private static JDBCUtil jdbcUtil = JDBCUtil.getJDBC();
	
	public static List<Staff> getEmpPageinfo(int pageLine, int pageNo) throws SQLException
	{
		List<Staff> list = new ArrayList<Staff>();
		String sql;
//		sql = "select * "
//			 +"from(SELECT rownum rn,emp.empid,emp.empname name, emp.empsex, emp.empage,emp.birthday,emp.telephone, emp.qq,department.departmentname"
//				 +" from emp,department"
//				 +" where emp.departmentid=department.departmentid)"
//			 +" where rn>=" + ((pageNo-1)*pageLine+1) + " and  rn<=" + (pageLine*pageNo);
		
//		sql = "select emp.empid,emp.empname name, emp.empsex, emp.empage,emp.birthday,emp.telephone, emp.qq,department.departmentname from emp,department "
//				+ " where emp.departmentId = department.departmentId  limit "+ (pageNo - 1)*pageLine +","+pageLine;
		
		sql = "SELECT  emp.empid,emp.empname NAME, emp.empsex, emp.empage,emp.birthday,emp.telephone, emp.qq,department.departmentname FROM  emp,department WHERE emp.`departmentId` = department.`departmentId`"
				+ "  LIMIT "+ (pageNo - 1)*pageLine +","+pageLine;
				
		ResultSet set = jdbcUtil.executeQuery(sql);
		
		while (set.next()) {
			long empId = set.getInt(1); 
			String empName  = set.getString(2);
			String empSex  = set.getString(3);
			int empAge = set.getInt(4);
			Date birthday = set.getDate(5);
			long telephone  = set.getLong(6);
			long qq  = set.getLong(7);
			String departmentName = set.getString(8);
			list.add(new Staff(empId, empName, empSex, empAge, birthday, telephone, qq, departmentName));
		}
		
		jdbcUtil.close();
		set.close();
		
		return list;
	}

	public static int getTotalEmpNumber() throws SQLException {
		String sql;
		int num = 0;
		
		sql = "select count(*) from emp";
		ResultSet set = jdbcUtil.executeQuery(sql);
		while (set.next()) {
			num = set.getInt(1);
		}
		
		jdbcUtil.close();
		
		return num;
	}
	public static int getTotalEmpNumber(int departmentId) throws SQLException {
		String sql;
		int num=0;
		
		sql = "select count(*) from emp where departmentId="+departmentId;
		ResultSet set = jdbcUtil.executeQuery(sql);
		while (set.next()) {
			num = set.getInt(1);
		}
		
		jdbcUtil.close();
		
		return num;
	}
	
	public static int deleteStaffByID(int empId) throws SQLException {
		String sql;
		int res=0;
		
		sql = "delete from emp where empId =" +empId;
		res = jdbcUtil.executeUpdate(sql);
		
		jdbcUtil.close();
		
		return res;
	}

	public static Staff selectStaffByID(int empId) throws SQLException {
		String sql;
		Staff stu = new Staff();
		
		sql = "SELECT emp.empid,emp.empname, emp.empsex, emp.empage,emp.birthday,emp.telephone,emp.qq,department.departmentname"
			 +" FROM emp,department"
			 +" WHERE emp.departmentid=department.departmentid and emp.empid="+empId;
		ResultSet set = jdbcUtil.executeQuery(sql);
		
		while (set.next()) {
			stu.setEmpId(set.getInt(1)); 
			stu.setEmpName(set.getString(2));
			stu.setEmpSex(set.getString(3));
			stu.setEmpAge(set.getInt(4));
			stu.setBirthday(set.getDate(5));
			stu.setTelephone(set.getLong(6));
			stu.setQq(set.getLong(7));
			stu.setDepartmentName(set.getString(8));
		}
		
		jdbcUtil.close();
		set.close();
		
		return stu;
	}

	public static int UpdateStaffinfoByEmpid(Object[] data) throws SQLException {
		String sql;
		int res=0;
		
		sql = "update emp set empName='" +(String)data[1]
				+ "',empSex='" +(String)data[2]
				+ "',empAge=" +(int)data[3]
				+ ",birthday=to_date('" +(Date)data[4]+"','yyyy-mm-dd')"
				+ ",telephone=" +(long)data[5]
				+ ",qq=" +(long)data[6]
				+ ",departmentId=" +(int)data[7]
				+ " where empId="+(int)data[0];
		
		res = jdbcUtil.executeUpdate(sql);
		
		jdbcUtil.close();
		
		return res;
	}

	public static List<Staff> getStaffPageinfoByLikeName(int pageLine, int pageNo, String likeName) throws SQLException
	{
		List<Staff> list = new ArrayList<Staff>();
		String sql;
//		sql = "SELECT * FROM "
//			    		+"(SELECT ,e.empid,e.empname, e.empsex, e.empage,e.birthday,e.telephone, e.qq,d.departmentname"
//			    	    +" FROM(SELECT *  FROM emp WHERE emp.empname LIKE '%"+likeName+"%') e,department d"
//			    	    +" WHERE e.departmentid=d.departmentid)"
//			   +" WHERE rn>=" + ((pageNo-1)*pageLine+1) + " and  rn<=" + (pageLine*pageNo);
		sql = "SELECT  emp.empid,emp.empname, emp.empsex, emp.empage,emp.birthday,"
		 		+ "emp.telephone, emp.qq,d.departmentname FROM  emp ,department d "
		 		+ " WHERE  d.departmentid = emp.departmentid AND emp.empname like '%"+likeName +"%'" + 
		 		" Limit "+(pageNo-1)*pageLine +","+pageLine;
		ResultSet set = jdbcUtil.executeQuery(sql);
		
		while (set.next()) {
			long empId = set.getInt(1); 
			String empName  = set.getString(2);
			String empSex  = set.getString(3);
			int empAge = set.getInt(4);
			Date birthday = set.getDate(5);
			long telephone  = set.getLong(6);
			long qq  = set.getLong(7);
			String departmentName = set.getString(8);
			list.add(new Staff(empId, empName, empSex, empAge, birthday, telephone, qq, departmentName));
		}
		
		jdbcUtil.close();
		set.close();
		
		return list;
	}
	
	public static int getTotalSelectEmpNumberByLikename(String likeName) throws SQLException {
		String sql;
		int num=0;
		
		sql = "select count(*) from emp where emp.empname LIKE '%" +likeName+ "%'";
				
		ResultSet set = jdbcUtil.executeQuery(sql);
		while (set.next()) {
			num = set.getInt(1);
		}
		
		jdbcUtil.close();
		
		return num;
	}

	public static int addStaff(Object[] data) throws SQLException
	{
		//insert into emp values (2010001, 'ÕÅÒ»', 'ÄÐ', 23, '5_9ÔÂ_1996', '15011111111', '111111111', '2');
		String sql;
		sql = "insert into emp values (" +(int)data[0]+
				",'"+(String)data[1]+ 
				"','"+(String)data[2]+
				"',"+(int)data[3]+
				",to_date('" +(Date)data[4]+"','yyyy-mm-dd')"+
				","+(long)data[5]+
				","+(long)data[6]+
				","+(int)data[7]+")";
		
		int res = jdbcUtil.executeUpdate(sql);
		
		return res;
	}

	public static List<Staff> getgetEmpPageinfoByDepartmentId(int pageLine, int pageNo, int departmentId) throws SQLException
	{
		List<Staff> list = new ArrayList<Staff>();
		String sql;
//		sql = "select * "
//			 +"from(SELECT rownum rn,emp.empid,emp.empname name, emp.empsex, emp.empage,emp.birthday,emp.telephone, emp.qq,d.departmentname"
//				 +" from emp,department d"
//				 +" where emp.departmentid="+departmentId+"and d.departmentid="+departmentId+")"
//			 +" where rn>=" + ((pageNo-1)*pageLine+1) + " and  rn<=" + (pageLine*pageNo);
		 sql = "SELECT  emp.empid,emp.empname, emp.empsex, emp.empage,emp.birthday,"
		 		+ "emp.telephone, emp.qq,d.departmentname FROM  emp,department d "
		 		+ " WHERE emp.departmentId ="+ departmentId+" and d.departmentId="+departmentId + 
		 		" Limit "+(pageNo-1)*pageLine +","+pageLine;
		ResultSet set = jdbcUtil.executeQuery(sql);
		
		while (set.next()) {
			long empId = set.getInt(1); 
			String empName  = set.getString(2);
			String empSex  = set.getString(3);
			int empAge = set.getInt(4);
			Date birthday = set.getDate(5);
			long telephone  = set.getLong(6);
			long qq  = set.getLong(7);
			String departmentName = set.getString(8);
			list.add(new Staff(empId, empName, empSex, empAge, birthday, telephone, qq, departmentName));
		}
		
		jdbcUtil.close();
		set.close();
		
		return list;
	}
}
