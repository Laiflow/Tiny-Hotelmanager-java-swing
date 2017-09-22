package com.htdao;
import java.awt.*;
import java.sql.*;

import com.htutil.Operater;
import com.htdao.Dao;

public class Dao {
	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/test3";
	protected static String dbUser = "root";
	protected static String dbPwd = "624077096a";
	protected static String second = null;
	private static Connection conn = null;
	Statement stat = null;
	 PreparedStatement ps;
	 Connection ct = null;
	 ResultSet rs = null;
	  
	private Dao() {
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
			else
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}
	private static ResultSet executeQuery(String sql) {
		try {
			if(conn==null)
			new Dao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}
	private static int executeUpdate(String sql) {
		
		try {
			if(conn==null)
				new Dao();
			return conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
				
			return -1;
		} finally {
		}
	}
	
	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
	public static Operater check(String name, String password) {
		int i = 0;
		Operater operater=new Operater();
		String sql = "select *  from tb_operator where name='" + name
				+ "' and password='" + password + "'and admin=1";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				String names = rs.getString(1);
				operater.setId(rs.getString("id"));
				operater.setName(rs.getString("name"));
				operater.setGrade(rs.getString("admin"));
				operater.setPassword(rs.getString("password"));
				if (names != null) {
					i = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return operater;
		
	}
}
