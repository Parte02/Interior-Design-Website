package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Project.bean.ProjectBean;
import com.project.Project.bean.Project_ImageBean;


public class ShowImage {
	public static void main(String[] args) {
		List<Project_ImageBean> projectImageBeans= new ShowImage().showImage();
		System.out.println("projectImageBeans="+projectImageBeans.toString());
	}

	public List<Project_ImageBean> showImage() {
		Connection con = MyDBConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int showRecord = -1;
		List<Project_ImageBean> projectImageBeans=new ArrayList<Project_ImageBean>();

		try {
			System.out.println("Display a Image in starting");
			st = con.createStatement();

			String sql = " Select * from project_data p,image i Where p.id=i.fkId";
			
			rs = st.executeQuery(sql);
List <Integer> idProcessed=new ArrayList<>();

			while(rs.next()) {
				int id=rs.getInt(1);
				
				if(idProcessed.contains(id)) {
					continue;
				}
				idProcessed.add(id);
				String p_name=rs.getString(2);
				String p_location=rs.getString(3);
				String s_date=rs.getString(4);
				String e_date=rs.getString(5);
				int pkid = rs.getInt(6);
				String img_name=rs.getString(7);
				int fkid=rs.getInt(8);
				
				projectImageBeans.add(new Project_ImageBean(id,p_name , p_location, s_date , e_date, pkid, img_name, fkid));
				System.out.println("id="+id+",");
				System.out.println("p_name="+p_name+",");
				System.out.println("p_location="+p_location+",");
				System.out.println("s_date="+s_date+",");
				System.out.println("e_date="+e_date+",");
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
			return projectImageBeans;
		}


}

}
