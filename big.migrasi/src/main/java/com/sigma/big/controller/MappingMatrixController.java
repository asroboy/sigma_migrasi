/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.controller;

import com.sigma.big.model.db.DBConConfiguration;
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
public class MappingMatrixController {

    DBUtil dbu;

    public MappingMatrixController(DBUtil dbu) {
        this.dbu = dbu;
    }

    public String save(MappingMatrix o) throws IOException {
        try {

            MappingMatrix mappingMatrix = (MappingMatrix) o;
            ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
            Connection conn = dbu.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());
            String sql = "INSERT INTO MAPPING_MATRIX ("
                    + "ID, NAME, "
                    + " TABLE_SOURCE,"
                    + " TABLE_TARGET,"
                    + " CREATED_DATE,"
                    + " CREATED_BY, "
                    + " WHERE_CLAUSE, "
                    + " ID_CONF_SUMBER, "
                    + " ID_CONF_TARGET "
                    + ") VALUES ("
                    + "SEQ_MAPPING_COLUMN.NEXTVAL,"
                    + "?,"
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?)";
            //SEQ_DBCONFIGURATION.NEXTVAL
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, mappingMatrix.getName());
            preparedStmt.setString(2, mappingMatrix.getTableSource());
            preparedStmt.setString(3, mappingMatrix.getTableTarget());
            preparedStmt.setDate(4, mappingMatrix.getCreatedDate());
            preparedStmt.setString(5, mappingMatrix.getCreatedBy());
            preparedStmt.setString(6, mappingMatrix.getWhereClause());
            System.out.println("Conn id sumber" + mappingMatrix.getConnSumber().getId());
            System.out.println("Conn id target" + mappingMatrix.getConnTarget().getId());
            preparedStmt.setInt(7, Integer.parseInt(mappingMatrix.getConnSumber().getId()));
            preparedStmt.setInt(8, Integer.parseInt(mappingMatrix.getConnTarget().getId()));
            preparedStmt.execute();
            conn.close();

            return "OK";

        } catch (SQLException ex) {
            Logger.getLogger(MappingMatrixController.class.getName()).log(Level.SEVERE, null, ex);
            return "FAILED";
        }
    }

    public MappingMatrix getLastInserted() throws SQLException, IOException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dbu.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());

        String sql = "select * "
                + "  from MAPPING_MATRIX "
                + " where id = ( select max(id) from MAPPING_MATRIX )";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        MappingMatrix mappingMatrix = null;
        while (rs.next()) {
            mappingMatrix = new MappingMatrix();
            mappingMatrix.setId(rs.getInt("ID"));
            mappingMatrix.setName(rs.getString("NAME"));
            mappingMatrix.setTableSource(rs.getString("TABLE_SOURCE"));
            mappingMatrix.setTableTarget(rs.getString("TABLE_TARGET"));
            mappingMatrix.setCreatedBy(rs.getString("CREATED_BY"));
            mappingMatrix.setWhereClause(rs.getString("WHERE_CLAUSE"));
//            mappingMatrix.setCreatedDate(Date.valueOf(rs.getString("CREATED_DATE")));
        }
        conn.close();
        return mappingMatrix;
    }

    public ArrayList<MappingMatrix> getAllMappingMatrix() throws SQLException, IOException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dbu.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());

        String sql = "select * from MAPPING_MATRIX";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<MappingMatrix> mappingMatrixs = new ArrayList<>();
        while (rs.next()) {
            MappingMatrix mappingMatrix = new MappingMatrix();
            mappingMatrix.setId(rs.getInt("ID"));
            mappingMatrix.setName(rs.getString("NAME"));
            mappingMatrix.setTableSource(rs.getString("TABLE_SOURCE"));
            mappingMatrix.setTableTarget(rs.getString("TABLE_TARGET"));
            mappingMatrix.setCreatedBy(rs.getString("CREATED_BY"));
            mappingMatrix.setWhereClause(rs.getString("WHERE_CLAUSE"));
//            mappingMatrix.setCreatedDate(Date.valueOf(rs.getString("CREATED_DATE")));

            mappingMatrixs.add(mappingMatrix);
        }

        conn.close();
        return mappingMatrixs;
    }

    public ArrayList<MappingMatrix> getAllMappingColumnsAllRelations() throws SQLException, IOException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dbu.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());

        String sql = "SELECT MM.ID, MM.NAME, MM.TABLE_SOURCE, MM.TABLE_TARGET, MM.WHERE_CLAUSE, "
                //                + "MC.ID AS ID_MAPPING_COL,"
                //                + "MC.COL_SOURCE_NAME, MC.COL_SOURCE_DT_TYPE, MC.COL_TARGET_NAME, MC.COL_TARGET_DT_TYPE, "
                + "DBC1.CONNECTION_NAME AS CONF_NAME_SUMBER,"
                + "DBC1.ID AS CONF_ID_SUMBER,"
                + "DBC1.HOST AS CONF_HOST_SUMBER,"
                + "DBC1.PORT AS CONF_PORT_SUMBER,"
                + "DBC1.SID AS CONF_SID_SUMBER,"
                + "DBC1.SERVICE_NAME AS CONF_SERVICE_NAME_SUMBER,"
                + "DBC1.USERNAME AS CONF_USERNAME_SUMBER,"
                + "DBC1.PASSWORD AS CONF_PASSWORD_SUMBER,"
                + "DBC2.CONNECTION_NAME AS CONF_NAME_TARGET,"
                + "DBC2.ID AS CONF_ID_TARGET,"
                + "DBC2.HOST AS CONF_HOST_TARGET,"
                + "DBC2.PORT AS CONF_PORT_TARGET,"
                + "DBC2.SID AS CONF_SID_TARGET,"
                + "DBC2.SERVICE_NAME AS CONF_SERVICE_NAME_TARGET,"
                + "DBC2.USERNAME AS CONF_USERNAME_TARGET,"
                + "DBC2.PASSWORD AS CONF_PASSWORD_TARGET "
                + "FROM MAPPING_MATRIX  MM "
                //                + "LEFT JOIN MAPPING_COLUMN MC ON MC.ID_MAPPING = MM.ID "
                + "LEFT JOIN DBCONFIGURATION DBC1 ON MM.ID_CONF_SUMBER = DBC1.ID "
                + "LEFT JOIN DBCONFIGURATION DBC2 ON MM.ID_CONF_TARGET = DBC2.ID ";

        System.out.println(sql);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<MappingMatrix> mappingMatrixs = new ArrayList<>();
        while (rs.next()) {
            DBConConfiguration dBConConfigurationSource = new DBConConfiguration();
            dBConConfigurationSource.setName(rs.getString("CONF_NAME_SUMBER"));
            dBConConfigurationSource.setHost(rs.getString("CONF_HOST_SUMBER"));
            dBConConfigurationSource.setId(rs.getString("CONF_ID_SUMBER"));
            dBConConfigurationSource.setPort(rs.getInt("CONF_PORT_SUMBER"));
            dBConConfigurationSource.setSid(rs.getString("CONF_SID_SUMBER"));
            dBConConfigurationSource.setServiceName(rs.getString("CONF_SERVICE_NAME_SUMBER"));
            dBConConfigurationSource.setUsername(rs.getString("CONF_USERNAME_SUMBER"));
            dBConConfigurationSource.setPassword(rs.getString("CONF_PASSWORD_SUMBER"));

            DBConConfiguration dBConConfigurationTarget = new DBConConfiguration();
            dBConConfigurationTarget.setName(rs.getString("CONF_NAME_TARGET"));
            dBConConfigurationTarget.setHost(rs.getString("CONF_HOST_TARGET"));
            dBConConfigurationTarget.setId(rs.getString("CONF_ID_TARGET"));
            dBConConfigurationTarget.setPort(rs.getInt("CONF_PORT_TARGET"));
            dBConConfigurationTarget.setSid(rs.getString("CONF_SID_TARGET"));
            dBConConfigurationTarget.setServiceName(rs.getString("CONF_SERVICE_NAME_TARGET"));
            dBConConfigurationTarget.setUsername(rs.getString("CONF_USERNAME_TARGET"));
            dBConConfigurationTarget.setPassword(rs.getString("CONF_PASSWORD_TARGET"));

            MappingMatrix mappingMatrix = new MappingMatrix();
            mappingMatrix.setId(rs.getInt("ID"));
            mappingMatrix.setName(rs.getString("NAME"));
            mappingMatrix.setTableSource(rs.getString("TABLE_SOURCE"));
            mappingMatrix.setTableTarget(rs.getString("TABLE_TARGET"));
            mappingMatrix.setWhereClause(rs.getString("WHERE_CLAUSE"));
//            mappingMatrix.setCreatedBy(rs.getString("CREATED_BY"));
            mappingMatrix.setConnSumber(dBConConfigurationSource);
            mappingMatrix.setConnTarget(dBConConfigurationTarget);

//            MappingColumn mappingColumn = new MappingColumn();
//            mappingColumn.setId(rs.getInt("ID_MAPPING_COL"));
//            mappingColumn.setColSourceName(rs.getString("COL_SOURCE_NAME"));
//            mappingColumn.setColSourceType(rs.getString("COL_SOURCE_DT_TYPE"));
//            mappingColumn.setColTargetName(rs.getString("COL_TARGET_NAME"));
//            mappingColumn.setColTargetType(rs.getString("COL_TARGET_DT_TYPE"));
//            mappingColumn.setMappingMatrix(mappingMatrix);
            mappingMatrixs.add(mappingMatrix);

        }

        conn.close();
        return mappingMatrixs;
    }

    public void read(Object[] oParams) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    public void delete(Object o) throws IOException, SQLException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        Connection conn = dbu.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword());

        String deleteMatrixColumn = "DELETE FROM MAPPING_COLUMN WHERE ID_MAPPING = " + (int) o;
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM MAPPING_MATRIX WHERE ID = " + (int) o;
      
        
        stmt.executeUpdate(deleteMatrixColumn);
        stmt.executeUpdate(sql);
        
        conn.close();

    }

}
