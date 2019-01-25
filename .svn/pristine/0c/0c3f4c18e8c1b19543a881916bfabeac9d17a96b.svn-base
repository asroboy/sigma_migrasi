/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.controller;

import com.sigma.bigmigrasi.db.FieldOfTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ridho
 */
public class DatabaseController {

    public ArrayList<String> getTables(Connection conn) throws SQLException {
        ArrayList<String> tables = new ArrayList<>();
        String sql = "select TABLE_NAME from user_tables";
        System.out.println(sql);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            tables.add(tableName);
        }
        conn.close();
        return tables;
    }

    public ArrayList<FieldOfTable> getFields(Connection conn, String tableName) throws SQLException {
        ArrayList<FieldOfTable> fields = new ArrayList<>();
        String sql = "select column_id as id, COLUMN_NAME as name, data_type as dataType, char_length as dataLength from USER_TAB_COLUMNS where TABLE_NAME= \'" + tableName + "\'";
        System.out.println(sql);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            FieldOfTable fot = new FieldOfTable();
            fot.setId(Long.parseLong(rs.getString("id")));
            fot.setName(rs.getString("name"));
            fot.setDataType(rs.getString("dataType"));
            fot.setDataLength(rs.getString("dataLength"));
            fields.add(fot);
        }
        stmt.close();
        return fields;
    }
    
    public HashMap<String, FieldOfTable> getFieldsWithKey(Connection conn, String tableName) throws SQLException {
        HashMap<String, FieldOfTable> fields = new HashMap<>();
        String sql = "select column_id as id, COLUMN_NAME as name, data_type as dataType, char_length as dataLength from USER_TAB_COLUMNS where TABLE_NAME= \'" + tableName + "\'";
        System.out.println(sql);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            FieldOfTable fot = new FieldOfTable();
            fot.setId(Long.parseLong(rs.getString("id")));
            fot.setName(rs.getString("name"));
            fot.setDataType(rs.getString("dataType"));
            fot.setDataLength(rs.getString("dataLength"));
            fields.put(fot.getName().toUpperCase(), fot);
        }
        stmt.close();
        return fields;
    }

}
