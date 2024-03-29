package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.ImageBean;
import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.ResponseBean;

public class DeleteImage {
	
	public static void main(String[] args) {
		List<ImageBean> imageBeans= new DeleteImage().deleteImage(null);
		System.out.println("imageBeans="+imageBeans.toString());
	}

	public List<ImageBean> deleteImage(String id) {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int deleteRecord = -1;
		ResponseBean responseBean = null;
		List<ImageBean> imageBeans=new ArrayList<ImageBean>();
		try {
			System.out.println("Delete a Image is starting");
			st = con.createStatement();

			String sql = "delete from image where pkid="+id;
			
			deleteRecord = st.executeUpdate(sql);
			System.out.println("Number of Record Delete Project: " + deleteRecord);
		

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
			return imageBeans;
		}
	}

}

