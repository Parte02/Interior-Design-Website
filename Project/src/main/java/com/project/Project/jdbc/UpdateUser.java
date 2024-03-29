package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.Project.bean.RegisterBean;
import com.project.Project.bean.ResponseBean;

public class UpdateUser {

	public ResponseBean updateUser(RegisterBean in , String id) { 
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int updateRecord = -1;
		ResponseBean responseProject=null;
		try {
			System.out.println("Update Record Starting");
			st = con.createStatement();

			String sql =  "Update register_form set username ='"+in.getUsername()+"' , email ='"+in.getEmail()+"' , password='"+in.getPassword()+"' , confirm_password='"+in.getConfirm_password()+"' where id="+id;
			updateRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Update Project: " + updateRecord);
		
		} 
		catch (Exception e) {
			
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
			return responseProject;
		}


	}

}
