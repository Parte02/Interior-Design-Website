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

public class FindImage {

	public List<ImageBean> findImage(String id) {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int findRecord = -1;
		ResponseBean responseBean = null;
		List<ImageBean> imageBeans=new ArrayList<ImageBean>();
		try {
			System.out.println("Finding a Image is starting");
			st = con.createStatement();

			String sql = "select*from image where fkid="+id;
			
			rs = st.executeQuery(sql);

			
			while(rs.next()) {
				int pkid=rs.getInt(1);
				String img_name=rs.getString(2);
				int fkid=rs.getInt(3);
				

				imageBeans.add(new ImageBean(pkid, img_name , fkid));
				System.out.println("pkid="+pkid);
				System.out.println("img_name="+img_name);
				System.out.println("fkid="+fkid);
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
			return imageBeans;
		}
	}

}
