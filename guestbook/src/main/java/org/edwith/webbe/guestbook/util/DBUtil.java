package org.edwith.webbe.guestbook.util;

import java.sql.*;

public class DBUtil {
	
	private static String dburl = "jdbc:mysql://127.0.0.1:3306/connectdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String dbUser = "root";
	private static String dbpassword = "1234";
	
	private static Connection conn = null;
	
	static {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	private DBUtil() {}
	
	public static Connection getConn() {
		return conn;
	}
	
	public static void closeConn() {
		try {
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
