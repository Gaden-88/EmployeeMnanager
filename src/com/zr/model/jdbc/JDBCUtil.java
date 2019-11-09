package com.zr.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtil {
	private static JDBCUtil jdbcUtil = null;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet set;
	
	private  String driver =  "com.mysql.jdbc.Driver";
	private  String url = "jdbc:mysql://localhost:3306/mydb";
	private  String user = "test";
	private  String password = "123";
	
	//加载驱动
	private JDBCUtil()
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//初始化对象
	public static JDBCUtil getJDBC()
	{
		if(jdbcUtil != null)
		{
			return jdbcUtil;
		}else
		{
			return new JDBCUtil();
		}
	}
	//建立连接
	public Connection getConnection()
	{
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//增 删 改
	public int executeUpdate(String sql, Object... data) throws SQLException
	{
	
		int res=0;
		
		Connection conn = getConnection();
		
		ps = conn.prepareStatement(sql);
		for (int i=0; i<data.length; i++) {
			ps.setObject(i+1, data[i]);
		}
		
		res = ps.executeUpdate();
		
		return res;
	}
	//查
	public ResultSet executeQuery(String sql, Object... data) throws SQLException
	{
		Connection conn = getConnection();
		
		ps = conn.prepareStatement(sql);
		
		for (int i=0; i<data.length; i++) {
			ps.setObject(i+1, data[i]);
		}

		set = ps.executeQuery();
		
		return set;
	}
	//关闭资源
	public void close()
	{
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(set != null)
		{
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
