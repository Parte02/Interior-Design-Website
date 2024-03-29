package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import com.project.Project.bean.ImageBean;
import com.project.Project.bean.ResponseBean;

public class InsertImage {

	public ResponseBean insertImage(ImageBean ib) { 
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		int insertedRecord = -1;
		ResponseBean responseBean=null;

		try {
			System.out.println("Inserting Recording Starting in Image");
			st = con.createStatement();

			String sql = "insert into image(img_name,fkid) values('" + ib.getImg_name() + "','" + ib.getFkid() + "')";

			insertedRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Inserted in Image: " + insertedRecord);
			responseBean=new ResponseBean("Number of Record Inserted in Image: " + insertedRecord);
			
		} 
		catch (Exception e) {
			responseBean=new ResponseBean(1, "\"Error Occurred\"+e.getMessage()");
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
			return responseBean;
		}



	}
}
