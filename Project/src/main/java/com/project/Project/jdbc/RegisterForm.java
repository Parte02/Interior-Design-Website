package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.Project.bean.RegisterBean;
import com.project.Project.bean.ResponseBean;


public class RegisterForm {
	public ResponseBean insertRegister(RegisterBean rn) { {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int insertedRecord = -1;
		ResponseBean responseBean=null;

		try {
			System.out.println("Inserting Recording Starting in Register Form");
			st = con.createStatement();

			String sql = "insert into register_form(username,email,password,confirm_password) values('" + rn.getUsername() + "','" + rn.getEmail() + "','" + rn.getPassword() + "','" + rn.getConfirm_password() + "')";

			insertedRecord = st.executeUpdate(sql);
			System.out.println("Number of Record in Register Form Inserted: " + insertedRecord);
			responseBean=new ResponseBean("Number of Record in Register Form Inserted: " + insertedRecord);
			
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
}
