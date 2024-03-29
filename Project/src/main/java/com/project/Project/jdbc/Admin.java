package com.project.Project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.project.Project.auth.UserSessionsInfo;
import com.project.Project.bean.AuthBean;
import com.project.Project.bean.LoginBean;
import com.project.Project.bean.RegisterBean;
import com.project.Project.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Admin {

    @Value("${admin123.username}")
    private String adminUsername;

    @Value("${admin123.password}")
    private String adminPassword;

    public ResponseBean admin(RegisterBean registerBean) {
        Connection con = MyDBConnection.getConnection();
        Statement st = null;
        ResultSet rs = null;
        ResponseBean responseBean = null;

        try {
            System.out.println("Admin data in starting");
            st = con.createStatement();

            String sql = "select * from login_form where username='" + registerBean.getUsername() + "' and password='"
                    + registerBean.getPassword() + "'";

            rs = st.executeQuery(sql);

            if (rs.next()) {
                responseBean = new ResponseBean("Find UserData: ");
                int pkUserId = rs.getInt(1);
                AuthBean authBean = new AuthBean(UUID.randomUUID().toString(), pkUserId);
                UserSessionsInfo.getUserSessionInfo().put(authBean.getAuth_token(), authBean);
                responseBean.setToken(authBean.getAuth_token());

                // Check if the logged-in user is the admin
                if (registerBean.getUsername().equals(adminUsername) && registerBean.getPassword().equals(adminPassword)) {
                    responseBean.setAdmin(true);
                }
            } else {
                throw new RuntimeException("Incorrect User Credentials");
            }
        } catch (Exception e) {
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
