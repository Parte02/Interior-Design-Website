package com.project.Project.jdbc;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.BookBean;
import com.project.Project.bean.ContactBean;
import com.project.Project.bean.RegisterBean;

public class DisplayBook {

	public static void main(String[] args) {
		List<BookBean> bookBeans= new DisplayBook().displayBook();
		System.out.println("bookBeans="+bookBeans.toString());
	}

	public List<BookBean>displayBook() {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int showRecord = -1;
		List<BookBean> bookBeans=new ArrayList<BookBean>();

		try {
			System.out.println("Display Record Starting");
			st = con.createStatement();

			String sql = "select*from book_form";

			rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				String name=rs.getString(2);
				BigInteger phone = rs.getBigDecimal(3).toBigInteger();
				String email=rs.getString(4);
				String date=rs.getString(5);
				String time=rs.getString(6);
				String address = rs.getString(7);
				
				
				
				bookBeans.add(new BookBean(id ,name ,phone , email , date , time, address ));
				System.out.println("id="+id+",");
				System.out.println("name="+name+",");
				System.out.println("phone="+phone+",");
				System.out.println("Email="+email+",");
				System.out.println("Date="+date+",");
				System.out.println("Time="+time+",");
				System.out.println("Address="+address+",");
				
				
			}
		
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
			return bookBeans;
		}
	}
}

		
		

