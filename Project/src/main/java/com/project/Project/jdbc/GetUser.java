package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.RegisterBean;
import com.project.Project.bean.ResponseBean;

public class GetUser {

	public List<RegisterBean> getUser(String Uid) {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int findRecord = -1;
		ResponseBean responseBean = null;
		List<RegisterBean> registerBeans=new ArrayList<RegisterBean>();
		try {
			System.out.println("Finding a User is starting");
			st = con.createStatement();

			String sql = "select * from register_form where id="+Uid;
			
			rs = st.executeQuery(sql);

			
			while(rs.next()) {
				int id=rs.getInt(1);
				String username=rs.getString(2);
				String email=rs.getString(3);
				String password=rs.getString(4);
				String confirm_password=rs.getString(5);
				
				
				registerBeans.add(new RegisterBean(id,username ,email, password , confirm_password));
				System.out.println("id="+id+",");
				System.out.println("Username="+username+",");
				System.out.println("Email="+email+",");
				System.out.println("Password="+password+",");
				System.out.println("Confirm Password="+confirm_password+",");
				
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
			return registerBeans;
		}

	}
}
