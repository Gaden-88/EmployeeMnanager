package com.zr.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.model.jdbc.JDBCUtil;

public class DepartmentDao {
	private static JDBCUtil jdbcUtil = JDBCUtil.getJDBC();
	
	public static int getDepartmentIdByDepartmentName(String departmentName) throws SQLException
	{
		String sql;
		ResultSet set = null;
		int departmentId = 0;
		
		sql = "select departmentId from department where departmentName='"+departmentName+"'";
		set = jdbcUtil.executeQuery(sql);
		
		while(set.next())
		{
			departmentId = set.getInt(1);
		}
		
		jdbcUtil.close();
		
		return departmentId;
	}
}
