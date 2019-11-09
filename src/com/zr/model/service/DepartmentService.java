package com.zr.model.service;

import java.sql.SQLException;

import com.zr.model.dao.DepartmentDao;

public class DepartmentService {
	public static int getDepartmentId(String departmentName)
	{
		int departmentId = 0;
		try {
			departmentId = DepartmentDao.getDepartmentIdByDepartmentName(departmentName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return departmentId;
	}
}
