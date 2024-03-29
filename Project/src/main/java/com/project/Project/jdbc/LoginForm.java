package com.project.Project.jdbc;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import com.project.Project.bean.LoginBean;
import com.project.Project.bean.ResponseBean;




public class LoginForm {
	public ResponseBean insertLogin(LoginBean ln) { {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int insertedRecord = -1;
		ResponseBean responseLogin=null;

		try {
			System.out.println("Inserting Recording Starting in Login Form");
			st = con.createStatement();

			String sql = "insert into login_form(username,password) values('" + ln.getUsername() + "','" + ln.getPassword() + "')";

			insertedRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Inserted in Login Form: " + insertedRecord);
			responseLogin=new ResponseBean("Number of Record Inserted in Login Form: " + insertedRecord);
			
		} 
		catch (Exception e) {
			responseLogin=new ResponseBean(1, "\"Error Occurred\"+e.getMessage()");
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
			return responseLogin;
		}



	}

	}
}
