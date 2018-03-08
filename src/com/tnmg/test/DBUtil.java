package com.tnmg.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static final String DB_URL = "jdbc:mysql://localhost:3306/MyFirstDB";
	static final String USER = "root";
	static final String PASS = "Liu2580";
	static Connection conn = null;
	public static Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeDb(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs !=null){
				rs.close();
			}
			if(stmt !=null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	

}
