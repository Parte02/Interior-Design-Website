package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.Project.bean.ContactBean;
import com.project.Project.bean.ResponseBean;

public class ContactForm {
	public ResponseBean insertContact(ContactBean cn) { 
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int insertedRecord = -1;
		ResponseBean responseBean=null;

		try {
			System.out.println("Inserting Recording Starting in Contact Form");
			st = con.createStatement();

			String sql = "insert into contact_form(name,phone,email,message) values('" + cn.getName() + "','" + cn.getPhone() + "','" + cn.getEmail() + "','" + cn.getMessage() + "')";

			insertedRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Inserted in Contact Form: " + insertedRecord);
			responseBean=new ResponseBean("Number of Record Inserted in Contact Form: " + insertedRecord);
			
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
