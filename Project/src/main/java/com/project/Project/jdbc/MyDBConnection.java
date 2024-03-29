package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDBConnection {
	private static Connection con=null;
	public static Connection getConnection(){
		
		if (con!=null) {
			return con;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","123456");
			System.out.println("Connection Successfully");
		} catch (Exception e) {
			System.out.println("Connection Error: "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		return con;
	}
}
