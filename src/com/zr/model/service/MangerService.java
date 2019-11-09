package com.zr.model.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.zr.model.dao.MangerDao;
import com.zr.model.entity.Manger;

public class MangerService {
	
	public static int  getRegisterInfo(int mangerID, String pwd) throws SQLException{
		
		int mangerId = MangerDao.registeByEmpidAndPwd(mangerID, pwd);
		
		return mangerId;	
	}
	
	public static int getInsertMangerInfo(Object[] data)
	{
		int res = 0;
		
		try {
			res = MangerDao.insertMnager(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public static  Manger showManageInfo (int managerID) {
		
		Manger manger = null;
		try {
			manger = MangerDao.ManageInfo(managerID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			
		return  manger;
		
	}

	public static String getMangerName(int mangerId)
	{
		String mangerName = null;
		try {
			mangerName = MangerDao.getMangerNameByMnagerId(mangerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mangerName;
	}
}
