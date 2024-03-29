package com.project.Project.jdbc;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.ContactBean;
import com.project.Project.bean.RegisterBean;

public class DisplayContact {

	public static void main(String[] args) {
		List<ContactBean> contactBeans= new DisplayContact().displayContact();
		System.out.println("contactBeans="+contactBeans.toString());
	}

	public List<ContactBean>displayContact() {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int showRecord = -1;
		List<ContactBean> contactBeans=new ArrayList<ContactBean>();

		try {
			System.out.println("Display a User is starting");
			st = con.createStatement();

			String sql =" Select * from contact_form";
			
			rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				String name=rs.getString(2);
				BigInteger phone = rs.getBigDecimal(3).toBigInteger();
				String email=rs.getString(4);
				String message=rs.getString(5);
				
				
				
				contactBeans.add(new ContactBean(id ,name ,phone , email , message ));
				System.out.println("id="+id+",");
				System.out.println("name="+name+",");
				System.out.println("phone="+phone+",");
				System.out.println("Email="+email+",");
				System.out.println("Message="+message+",");
				
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
			return contactBeans;
		}


}

	private int getInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
