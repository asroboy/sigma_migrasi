/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.controller;

import com.sigma.big.model.User;
import com.sigma.bigmigrasi.db.ConnectionConfiguration;
import com.sigma.bigmigrasi.db.DBUtil;
import com.sigma.bigmigrasi.db.PropertyAccess;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ridho
 */
public class LoginCntroller {

    public User login(String username, String password) throws SQLException, IOException {
        User user = new User();

        String sql = "select a.username, a.id, b.role_id, c.name as role_name from m_user a "
                + "left join userrole b ON b.id_user = a.id "
                + "left join role c ON b.role_id = c.id "
                + "WHERE a.username = \'" + username + "\' AND a.password = \'" + password + "\'";

        DBUtil util = new DBUtil();
        ConnectionConfiguration conf = new PropertyAccess().readPropertiesByName("default");
        Connection con = util.getConnection(conf.getDriverName(), conf.getUrl(), conf.getUsername(), conf.getPassword());

        System.out.println(sql);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String lastName = rs.getString("username");
            String id = rs.getString("id");
            String roleName = rs.getString("role_name");

            user.setId(Integer.parseInt(id));
            user.setUsername(username);
            user.setRole(roleName);
        }
        con.close();
        return user;
    }

}
