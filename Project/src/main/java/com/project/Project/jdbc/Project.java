package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.ResponseBean;

public class Project {
	public ResponseBean insertProject(ProjectBean in) { 
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int insertedRecord = -1;
		ResponseBean responseProject=null;

		try {
			System.out.println("Inserting Recording Starting");
			st = con.createStatement();

			String sql = "insert into project_data(p_name,p_location,s_date,e_date) values('" + in.getName() + "','" + in.getLocation() +"','" + in.getStart_date() + "','" + in.getEnd_date() + "')";

			insertedRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Inserted in Image: " + insertedRecord);
			responseProject=new ResponseBean("Number of Record Inserted in Create Project : " + insertedRecord);
			
		} 
		catch (Exception e) {
			responseProject=new ResponseBean(1, "\"Error Occurred\"+e.getMessage()");
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

