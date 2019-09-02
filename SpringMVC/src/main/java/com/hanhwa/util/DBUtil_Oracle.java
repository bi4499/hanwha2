package com.hanhwa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil_Oracle {
	
	
	//connection
	/*
	 * public static Connection getConnect() { try {
	 * Class.forName("oracle.jdbc.driver.OracleDriver"); } catch
	 * (ClassNotFoundException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } Connection conn = null; String url =
	 * "jdbc:oracle:thin:@localhost:1521:HWORACLE"; String id = "hr"; String
	 * password = "hr";
	 * 
	 * try { conn = DriverManager.getConnection(url, id, password); } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return conn; }
	 */
	
	
	
	public static void dbClose(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
