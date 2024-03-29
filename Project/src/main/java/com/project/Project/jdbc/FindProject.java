package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.ResponseBean;

public class FindProject {

	
	public List<ProjectBean> findProject(String fkid) {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int findRecord = -1;
		ResponseBean responseBean = null;
		List<ProjectBean> projectBeans=new ArrayList<ProjectBean>();
		try {
			System.out.println("Finding a project is starting");
			st = con.createStatement();

			String sql = "select * from project_data where id="+fkid;
			
			rs = st.executeQuery(sql);

			
			while(rs.next()) {
				int id=rs.getInt(1);
				String p_name=rs.getString(2);
				String p_location=rs.getString(3);
				String s_date=rs.getString(4);
				String e_date=rs.getString(5);
				
				projectBeans.add(new ProjectBean(id,p_name , p_location, s_date , e_date));
				System.out.println("id="+id+",");
				System.out.println("p_name="+p_name+",");
				System.out.println("p_location="+p_location+",");
				System.out.println("s_date="+s_date+",");
				System.out.println("e_date="+e_date+",");
			
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Closed");
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				// con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return projectBeans;
		}

	}
}

		