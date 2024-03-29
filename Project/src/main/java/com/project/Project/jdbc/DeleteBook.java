package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.BookBean;


public class DeleteBook {

	public static void main(String[] args) {
		List<BookBean> bookBeans= new DeleteBook().deleteBook(null);
		System.out.println("bookBeans="+bookBeans.toString());
	}

	public List<BookBean>deleteBook(String id) {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int deleteRecord = -1;
		List<BookBean> bookBeans=new ArrayList<BookBean>();

		try {
			System.out.println("Delete Record Starting");
			st = con.createStatement();

			String sql = "delete from book_form where id="+id;

			deleteRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Delete Book: " + deleteRecord);
		
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
