package com.im.carsale;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	static Connection con ;
	
	static String url  = "jdbc:mysql://localhost:3306/dbcarsale";
	static String driver = "com.mysql.jdbc.Driver";
	
	
	public static Connection getCon() throws Exception{
		if(con==null) {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root","0147");
		}
		return con;
	}
	
}
