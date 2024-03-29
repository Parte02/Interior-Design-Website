package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.BookBean;
import com.project.Project.bean.RegisterBean;

public class DeleteUser {

	public static void main(String[] args) {
		List<RegisterBean> registerBeans= new DeleteUser().deleteUser(null);
		System.out.println("registerBeans="+registerBeans.toString());
	}

	public List<RegisterBean> deleteUser(String id) {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int deleteRecord = -1;
		List<RegisterBean> registerBeans=new ArrayList<RegisterBean>();

		try {
			System.out.println("Delete Record Starting");
			st = con.createStatement();

			String sql = "delete from register_form where id="+id;

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
			return registerBeans;
		}


	}

	}



