package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.Project_ImageBean;
import com.project.Project.bean.ResponseBean;

public class DeleteProject {

	
	public static void main(String[] args) {
		List<ProjectBean> projectBeans= new DeleteProject().deleteProject(null);
		System.out.println("projectBeans="+projectBeans.toString());
	}

	public List<ProjectBean>deleteProject(String id) {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int deleteRecord = -1;
		List<ProjectBean> projectBeans=new ArrayList<ProjectBean>();

		try {
			System.out.println("Delete Record Starting");
			st = con.createStatement();

			String sql = "delete from project_data where id="+id;

			deleteRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Delete Project: " + deleteRecord);
		
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
			return projectBeans;
		}


	}
}
