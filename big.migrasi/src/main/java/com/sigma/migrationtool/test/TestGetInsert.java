/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.tools.ClobTool;
import com.sigma.big.tools.DatabaseTool;
import java.io.IOException;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.sql.CLOB;

/**
 *
 * @author Ridho
 */
public class TestGetInsert {

    static String SQL_GET = "SELECT c.SHAPE.GET_GTYPE() AS G_TYPE, WADMKC, KDBBPS, WADMKD, KDEPUM, UUPP, KDCPUM, STSBTS, FCODE, UPDATED, WIADKK, NAMOBJ, OBJECTID, KDPBPS, WIADKC, WIADKD, WADMKK, REMARK, KLBADM, KDCBPS, KDEBPS, KDBPUM, SRS_ID, KDPPUM, TIPADM, WIADPR, LUASWH, SHAPE, LCODE, METADATA, WADMPR, PELAKSANA FROM IGD.ADMINISTRASI c WHERE METADATA = 'RBI1000020171025BOPUNJUR_64' AND c.SHAPE.GET_GTYPE() in (3,7) AND TRIM(WADMKD) IS NOT NULL"
            + "-- AND OBJECTID = 20761";
    static String SQL_DELETE = "DELETE FROM PUBLIKASI.ADMINISTRASI_AR";
    static String SQL_INSERT = "declare \n"
            + "    wkt clob;\n"
            + "BEGIN\n"
            + "wkt := '';\n"
            + "INSERT INTO PUBLIKASI.ADMINISTRASI_AR "
            + "(WADMKC, KDBBPS, WADMKD, KDEPUM, UUPP, KDCPUM, STSBTS, FCODE, UPDATED, WIADKK, NAMOBJ, OBJECTID, KDPBPS, WIADKC, WIADKD, WADMKK, REMARK, KLBADM, KDCBPS, KDEBPS, KDBPUM, SRS_ID, KDPPUM, TIPADM, WIADPR, LUASWH, SHAPE, LCODE, METADATA, WADMPR, PELAKSANA) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,PUBLIKASI.ADMINISTRASI_AR_SEQ.NEXTVAL ,?,?,?,?,?,?,?,?,?,?,?,?,?,?, SDE.ST_GEOMFROMWKB(SDO_UTIL.TO_WKBGEOMETRY(?), 4326),?,?,?,?);\n"
            + "END;";
//SDE.ST_GEOMETRY(?,4326)
    static String[] fields = {"WADMKC", "KDBBPS", "WADMKD", "KDEPUM", "UUPP", "KDCPUM", "STSBTS", "FCODE", "UPDATED", "WIADKK", "NAMOBJ", "KDPBPS", "WIADKC", "WIADKD",
        "WADMKK", "REMARK", "KLBADM", "KDCBPS", "KDEBPS", "KDBPUM", "SRS_ID", "KDPPUM", "TIPADM", "WIADPR", "LUASWH", "SHAPE", "LCODE", "METADATA", "WADMPR", "PELAKSANA"};

    public static void main(String[] ar) {
        try {
            DBConConfiguration configurationSumber = new DBConConfiguration();
            configurationSumber.setHost("192.168.210.195");
            configurationSumber.setPort(1521);
            configurationSumber.setSid("dbprod");
            configurationSumber.setServiceName("");
            configurationSumber.setUsername("system");
            configurationSumber.setPassword("oracle");
            Connection conSumber = DatabaseTool.getConnection(configurationSumber, null);
            ArrayList<HashMap<String, Object>> kumpulanDataSumber = get(conSumber);

            Connection conTarget = getConnectionTarget();
            delete(conTarget);
            insert(conTarget, kumpulanDataSumber);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(TestGetInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection getConnectionTarget() throws IOException {
        DBConConfiguration configurationTarget = new DBConConfiguration();
        configurationTarget.setHost("localhost");
        configurationTarget.setPort(1521);
        configurationTarget.setSid("migrasisde");
        configurationTarget.setServiceName("");
        configurationTarget.setUsername("RBI10K");
        configurationTarget.setPassword("RBI10K");
        Connection conTarget = DatabaseTool.getConnection(configurationTarget, null);
        return conTarget;
    }
    static ArrayList<String> objectIds = new ArrayList<>();

    public static ArrayList<HashMap<String, Object>> get(Connection con) throws SQLException, IOException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(SQL_GET);
        ArrayList<HashMap<String, Object>> kumpulanDataSumber = new ArrayList<>();
        System.out.println("Execute");
        int i = 0;
        while (rs.next()) {
            System.out.println("OBJECTID " + rs.getString("OBJECTID"));
            objectIds.add(rs.getString("OBJECTID"));
            HashMap<String, Object> dataSumber = new HashMap<>();
            for (String field : fields) {
                Object o = rs.getObject(field);
                if (field.equals("SHAPE")) {
//                    String wkt = ClobTool.toString((Clob) o);
//                    System.out.println("WKT " + wkt);
                    dataSumber.put(field, o);
                } else {
                    dataSumber.put(field, o);
                }
            }
            kumpulanDataSumber.add(dataSumber);
//            if (i == 30) {
//                break;
//            }
            i++;
        }

        rs.close();
        st.close();
        con.close();
        return kumpulanDataSumber;
    }

    public static void insert(Connection con, ArrayList<HashMap<String, Object>> kumpulanDataSumber) throws SQLException, IOException {
        int batchSize = 1;
        con.setAutoCommit(false);
        System.out.println(SQL_INSERT);
        System.out.println(fields.length);
        int j = 0;
        PreparedStatement ps = con.prepareStatement(SQL_INSERT);
        for (HashMap<String, Object> data : kumpulanDataSumber) {
            if (con.isClosed()) {
                con = getConnectionTarget();
                con.setAutoCommit(false);
            }
            if (ps.isClosed()) {
                ps = con.prepareStatement(SQL_INSERT);
            }
            int i = 1;
            try {
                for (String field : fields) {
                    if (field.equals("SHAPE")) {
//                        String wkt = ((String) data.get(field));
//                        Clob clob = con.createClob();    
//                        clob.setString(1, wkt);
                        ps.setObject(i, data.get(field));
                    } else {
                        ps.setString(i, ((String) data.get(field)));
                    }
                    i++;
                }
                System.out.println("Add batch ..." + objectIds.get(j));
                ps.addBatch();
                j++;

                if (j % batchSize == 0) {
                    System.out.println("Execute batch ...");
                    ps.executeBatch();
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

//        System.out.println("Execute batch ...");
//        ps.executeBatch();
        con.commit();
        con.close();
    }

    public static CLOB getCLOB(String innStr, Connection conn) throws SQLException,
            IOException {
        CLOB tempClob = null;
        // If the temporary CLOB has not yet been created, create new
        tempClob = CLOB.createTemporary(conn, true, CLOB.DURATION_SESSION);

        // Open the temporary CLOB in readwrite mode to enable writing
        tempClob.open(CLOB.MODE_READWRITE);
        // Get the output stream to write
        Writer tempClobWriter = tempClob.getCharacterOutputStream();
        // Write the data into the temporary CLOB
        tempClobWriter.write(innStr);

        // Flush and close the stream
        tempClobWriter.flush();
        tempClobWriter.close();

        // Close the temporary CLOB
        tempClob.close();
        return tempClob;
    }

    public static void delete(Connection con) throws SQLException {
        Statement ps = con.createStatement();
        System.out.println("Clear data ...");
        ps.execute(SQL_DELETE);
    }
}
