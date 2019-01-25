/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.controller;

import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.bigmigrasi.db.ConnectionConfiguration;
import com.sigma.bigmigrasi.db.DBUtil;
import com.sigma.bigmigrasi.db.PropertyAccess;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ridho
 */
public class DBConConfigurationController {

    DBUtil dBUtil;

    public DBConConfigurationController(DBUtil dBUtil) {
        this.dBUtil = dBUtil;
    }

    public void save(DBConConfiguration dBConConfiguration) throws SQLException, IOException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dBUtil.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());
        String sql = "INSERT INTO DBCONFIGURATION ("
                + "ID, "
                + " CONNECTION_NAME,"
                + " HOST,"
                + " PORT,"
                + " SID,"
                + " SERVICE_NAME,"
                + " USERNAME,"
                + " PASSWORD) VALUES ("
                + "SEQ_DBCONFIGURATION.NEXTVAL,"
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?,"
                + "?,"
                + "?)";
        //SEQ_DBCONFIGURATION.NEXTVAL
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, dBConConfiguration.getName());
        preparedStmt.setString(2, dBConConfiguration.getHost());
        preparedStmt.setInt(3, dBConConfiguration.getPort());
        preparedStmt.setString(4, dBConConfiguration.getSid());
        preparedStmt.setString(5, dBConConfiguration.getServiceName());
        preparedStmt.setString(6, dBConConfiguration.getUsername());
        preparedStmt.setString(7, dBConConfiguration.getPassword());
        // execute the preparedstatement
        preparedStmt.execute();
        conn.close();

    }

    public ArrayList<DBConConfiguration> getConnectionConfigurations() throws SQLException, IOException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dBUtil.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());

        String sql = "SELECT * FROM DBCONFIGURATION";
        System.out.println(sql);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<DBConConfiguration> conns = new ArrayList<DBConConfiguration>();
        while (rs.next()) {
            DBConConfiguration con = new DBConConfiguration();
            int id = rs.getInt("ID");
            String name = rs.getString("CONNECTION_NAME");
            String host = rs.getString("HOST");
            int port = rs.getInt("PORT");
            String sid = rs.getString("SID");
            String serviceName = rs.getString("SERVICE_NAME");
            String username = rs.getString("USERNAME");
            String password = rs.getString("PASSWORD");
            System.out.println("Connection name " + name);

            con.setId(String.valueOf(id));
            con.setHost(host);
            con.setName(name);
            con.setPassword(password);
            con.setUsername(username);
            con.setSid(sid);
            con.setServiceName(serviceName);
            con.setPort(port);

            conns.add(con);
        }
        conn.close();
        return conns;
    }

    public void update(DBConConfiguration dBConConfiguration) throws IOException, SQLException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dBUtil.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());
        String sql = "UPDATE DBCONFIGURATION SET "
                + " CONNECTION_NAME = ?,"
                + " HOST = ?,"
                + " PORT = ?,"
                + " SID = ?,"
                + " SERVICE_NAME = ? ,"
                + " USERNAME = ?,"
                + " PASSWORD = ? WHERE ID = ? ";
        //SEQ_DBCONFIGURATION.NEXTVAL
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, dBConConfiguration.getName());
        preparedStmt.setString(2, dBConConfiguration.getHost());
        preparedStmt.setInt(3, dBConConfiguration.getPort());
        preparedStmt.setString(4, dBConConfiguration.getSid());
        preparedStmt.setString(5, dBConConfiguration.getServiceName());
        preparedStmt.setString(6, dBConConfiguration.getUsername());
        preparedStmt.setString(7, dBConConfiguration.getPassword());
        preparedStmt.setInt(8, Integer.parseInt(dBConConfiguration.getId()));
        // execute the preparedstatement
        preparedStmt.execute();
        conn.close();
    }

    public void delete(DBConConfiguration dBConConfiguration) throws SQLException, IOException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dBUtil.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());
        String sql = "DELETE FROM DBCONFIGURATION WHERE ID = ?";
        System.out.println("SQL : " + sql);
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, Integer.parseInt(dBConConfiguration.getId()));
        st.executeUpdate();

        conn.close();
    }

    public ArrayList<DBConConfiguration> findByConnectionName(String searchKey) throws SQLException, IOException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dBUtil.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());
        String sql = "SELECT * FROM DBCONFIGURATION WHERE CONNECTION_NAME LIKE ?";
        System.out.println("SQL : " + sql);
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, "%" + searchKey + "%");
        ResultSet rs = st.executeQuery();
        ArrayList<DBConConfiguration> conns = new ArrayList<DBConConfiguration>();
        while (rs.next()) {
            DBConConfiguration con = new DBConConfiguration();
            int id = rs.getInt("ID");
            String name = rs.getString("CONNECTION_NAME");
            String host = rs.getString("HOST");
            int port = rs.getInt("PORT");
            String sid = rs.getString("SID");
            String serviceName = rs.getString("SERVICE_NAME");
            String username = rs.getString("USERNAME");
            String password = rs.getString("PASSWORD");
            System.out.println("Connection name " + name);

            con.setId(String.valueOf(id));
            con.setHost(host);
            con.setName(name);
            con.setPassword(password);
            con.setUsername(username);
            con.setSid(sid);
            con.setServiceName(serviceName);
            con.setPort(port);

            conns.add(con);
        }
        conn.close();

        return conns;
    }
    
    
}
