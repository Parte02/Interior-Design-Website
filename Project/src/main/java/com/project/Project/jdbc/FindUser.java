package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import com.project.Project.bean.ResponseBean;
import com.project.Project.auth.UserSessionsInfo;
import com.project.Project.bean.AuthBean;
import com.project.Project.bean.LoginBean;
import com.project.Project.bean.RegisterBean;


public class FindUser {
    @Value("${admin123.username}")
    private String adminUsername;

    @Value("${admin123.password}")
    private String adminPassword;
    
    public boolean isAdmin(RegisterBean rn) {
        return rn.getUsername().equals(adminUsername) && rn.getPassword().equals(adminPassword);
    }

    public ResponseBean findUser( RegisterBean rn) {
        Connection con = MyDBConnection.getConnection();
        Statement st = null;
        ResultSet rs = null;
        ResponseBean responseBean = null;

        try {
            System.out.println("Finding data in the starting");
            st = con.createStatement();

            if (isAdmin(rn)) {
                // Handle admin login
                responseBean = new ResponseBean("Admin Login Successful");
                responseBean.setAdmin(true);
            } else {
                // Handle regular user login
                
                String sql = "select * from register_form where username='" + rn.getUsername() + "' and password='"
                        + rn.getPassword() + "'";
                
                rs = st.executeQuery(sql);

                if (rs.next()) {
                    responseBean = new ResponseBean("User Login Successful");
                    int pkUserId = rs.getInt(1);
                    AuthBean authBean = new AuthBean(UUID.randomUUID().toString(), pkUserId);
                    UserSessionsInfo.getUserSessionInfo().put(authBean.getAuth_token(), authBean);
                    responseBean.setToken(authBean.getAuth_token());
                } 
            
                else {
                    throw new RuntimeException("Incorrect User Credentials");
                }
            }
        }
         catch (Exception e) {
            responseBean = new ResponseBean(401, "Error While Authenticating the User");
            e.printStackTrace();
            System.out.println("Connection Closed");
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                // con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return responseBean;
        }
        }
    }
