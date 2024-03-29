package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.Project.bean.BookBean;
import com.project.Project.bean.ResponseBean;

public class BookForm {
	public ResponseBean insertBook(BookBean bn) { 
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int insertedRecord = -1;
		ResponseBean responseBean=null;

		try {
			System.out.println("Inserting Recording Starting in Booking Form");
			st = con.createStatement();

			String sql = "insert into "
					+ "(name,phone,email,date,time,address) values('" + bn.getName() + "','" + bn.getPhone() + "','" + bn.getEmail() + "','" + bn.getDate() + "','" + bn.getTime() + "','" + bn.getAddress() + "')";

			insertedRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Inserted in Booking Form: " + insertedRecord);
			responseBean=new ResponseBean("Number of Record Inserted in Booking Form: " + insertedRecord);
			
		} 
		catch (Exception e) {
			responseBean=new ResponseBean(1, "\"Error Occurred\"+e.getMessage()");
			System.out.println("Connection Closed");
		} 
		finally {
			try {
				if (st != null) {
					st.close();
				}
				//con.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return responseBean;
		}



	}

}
