package com.zr.model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.zr.model.entity.Manger;
import com.zr.model.jdbc.JDBCUtil;

public class MangerDao {
	private static JDBCUtil jdbcUtil = JDBCUtil.getJDBC();
	
	public static int  registeByEmpidAndPwd(int mangerID, String pwd) throws SQLException{
		String sql;
		int mangerId = 0;
		sql = "select * from manger m where m.managerid=" +mangerID+ " and m.managerpwd='" +pwd+ "'";
		
		ResultSet set = jdbcUtil.executeQuery(sql);
		while(set.next())
		{
			mangerId = set.getInt(1);
		}
		jdbcUtil.close();
		
		return mangerId;
	}

	public static int insertMnager(Object[] data) throws SQLException {
		String sql;
		int res = 0;
		
		sql = "insert into manger values (" +(int)data[0]+
				",'"+(String)data[1]+ 
				"','"+(String)data[2]+
				"','"+(String)data[3]+
				"',"+(int)data[4]+
				",to_date('" +(Date)data[5]+"','yyyy-mm-dd')"+
				","+(long)data[6]+")";
		
		res = jdbcUtil.executeUpdate(sql);
		
		return res;
	}
	
	public static Manger  ManageInfo(int managerID) throws SQLException{
		String sql;
		sql="select * from manger where managerId ="+managerID;
		
		ResultSet res = jdbcUtil.executeQuery(sql);
		Manger manger = null;
		while(res.next()) {
			long managerid = res.getLong(1);
			String managername = res.getString(2);
			String managerpwd = res.getString(3);
			String manegersex = res.getString(4);
			int managerage = res.getShort(5);
			Date managerbirthday = res.getDate(6);
			long managerphone = res.getLong(7);
			
			manger = new Manger(managerid, managername, managerpwd, manegersex, managerage, managerbirthday, managerphone);
			
		}
		
		return  manger;
	}

	public static String getMangerNameByMnagerId(int mangerId) throws SQLException
	{
		String mangerName = null;
		String sql;
		sql = "select managerName  from manger where managerId="+mangerId;
		
		ResultSet set = jdbcUtil.executeQuery(sql);
		while(set.next())
		{
			mangerName = set.getString(1);
		}
		
		return mangerName;
	}
}
