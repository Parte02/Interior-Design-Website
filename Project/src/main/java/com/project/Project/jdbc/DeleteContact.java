package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.ContactBean;
import com.project.Project.bean.RegisterBean;

public class DeleteContact {

	public static void main(String[] args) {
		List<ContactBean> contactBeans= new DeleteContact().deleteContact(null);
		System.out.println("contactBeans="+contactBeans.toString());
	}

	public List<ContactBean>deleteContact(String id) {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int deleteRecord = -1;
		List<ContactBean> contactBeans=new ArrayList<ContactBean>();

		try {
			System.out.println("Delete Record Starting");
			st = con.createStatement();

			String sql = "delete from contact_form where id="+id;

			deleteRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Delete Contact: " + deleteRecord);
		
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
			return contactBeans;
		}


	}

}
