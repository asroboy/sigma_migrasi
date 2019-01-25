/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.controller;

import com.sigma.big.model.db.MappingColumn;
import com.sigma.big.model.db.MappingMatrix;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ridho
 */
public class MappingColumnController {

    DBUtil dbu;

    public MappingColumnController(DBUtil dbu) {
        this.dbu = dbu;
    }

    public String save(MappingColumn mappingColumn) throws IOException {
        try {
            ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
            Connection conn = dbu.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());
            String sql = "INSERT INTO MAPPING_COLUMN ("
                    + "ID, "
                    + "ID_MAPPING, "
                    + " COL_SOURCE_NAME,"
                    + " COL_SOURCE_DT_TYPE,"
                    + " COL_TARGET_NAME,"
                    + " COL_TARGET_DT_TYPE) VALUES ("
                    + "SEQ_MAPPING_COLUMN.NEXTVAL,"
                    + "?,"
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?)";
            //SEQ_DBCONFIGURATION.NEXTVAL
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, mappingColumn.getMappingMatrix().getId());
            preparedStmt.setString(2, mappingColumn.getColSourceName());
            preparedStmt.setString(3, mappingColumn.getColSourceType());
            preparedStmt.setString(4, mappingColumn.getColTargetName());
            preparedStmt.setString(5, mappingColumn.getColTargetType());
            preparedStmt.execute();
            conn.close();

            return "OK";

        } catch (SQLException ex) {
            Logger.getLogger(MappingMatrixController.class.getName()).log(Level.SEVERE, null, ex);
            return "FAILED";
        }
    }

    public String saveMultipleMappingColumn(ArrayList<MappingColumn> mappingColumns) throws IOException {
        try {
            ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
            Connection conn = dbu.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());
            String sql = "INSERT INTO MAPPING_COLUMN ("
                    + "ID, "
                    + "ID_MAPPING, "
                    + " COL_SOURCE_NAME,"
                    + " COL_SOURCE_DT_TYPE,"
                    + " COL_TARGET_NAME,"
                    + " COL_TARGET_DT_TYPE) VALUES ("
                    + "SEQ_MAPPING_COLUMN.NEXTVAL,"
                    + "?,"
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?)";
            //SEQ_DBCONFIGURATION.NEXTVAL

            System.out.println(sql);
            for (MappingColumn mappingColumn : mappingColumns) {
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1, mappingColumn.getMappingMatrix().getId());
                preparedStmt.setString(2, mappingColumn.getColSourceName());
                preparedStmt.setString(3, mappingColumn.getColSourceType());
                preparedStmt.setString(4, mappingColumn.getColTargetName());
                preparedStmt.setString(5, mappingColumn.getColTargetType());
                preparedStmt.execute();
            }

            conn.close();

            return "OK";

        } catch (SQLException ex) {
            Logger.getLogger(MappingMatrixController.class.getName()).log(Level.SEVERE, null, ex);
            return "FAILED";
        }
    }

    public ArrayList<MappingColumn> getAllMappingColumnByMappingMatrix(MappingMatrix mappingMatrix) throws SQLException, IOException {

        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dbu.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());

        String sql = "select * from MAPPING_COLUMN WHERE ID_MAPPING = " + mappingMatrix.getId();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<MappingColumn> mappingColumns = new ArrayList<>();
        while (rs.next()) {
            MappingColumn mappingColumn = new MappingColumn();
            mappingColumn.setId(rs.getInt("ID"));
            mappingColumn.setColSourceName(rs.getString("COL_SOURCE_NAME"));
            mappingColumn.setColSourceType(rs.getString("COL_SOURCE_DT_TYPE"));
            mappingColumn.setColTargetName(rs.getString("COL_TARGET_NAME"));
            mappingColumn.setColTargetType(rs.getString("COL_TARGET_DT_TYPE"));
            mappingColumn.setMappingMatrix(mappingMatrix);
//            mappingMatrix.setCreatedDate(Date.valueOf(rs.getString("CREATED_DATE")));

            mappingColumns.add(mappingColumn);
        }

        conn.close();
        return mappingColumns;

    }

}
