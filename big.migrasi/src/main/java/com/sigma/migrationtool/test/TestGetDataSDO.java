/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import com.esri.core.geometry.ogc.OGCGeometry;
import com.sigma.big.utils.WktWkbUtil;
import static com.sigma.migrationtool.test.TestDevToProd.conSumber;
import static com.sigma.migrationtool.test.TestDevToProd.conTarget;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.oracle.OraReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

/**
 *
 * @author Ridho
 */
public class TestGetDataSDO {

    public static void main(String[] arg) {
        try {
            getData();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TestGetDataSDO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TestGetDataSDO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void getData() throws SQLException, ParseException, Exception {
        setupConnectionSumber();
        String sql = "SELECT SHAPE, OBJECTID, SRS_ID, METADATA, FCODE, NAMOBJ FROM IGD.ADMINISTRASI c WHERE c.SHAPE.GET_GTYPE() in (3,7) AND OBJECTID=10031470";//10031470 - 10031283
        println(sql);
        try (Statement stmt = conSumber.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            simpleInsert(rs);
        }
    }

    private static void setupConnectionSumber() {
        println("Setup con. sumber");

        String driverName = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@"
                + "localhost"
                + ":" + "1521"
                + ":" + "orcl";
        String username = "IGD";
        String password = "IGD";
        conSumber = getConnection(driverName, url, username, password);
    }

    private static void setupConnectionTarget() {
        println("Setup con. target");

        String driverName = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@"
                + "localhost    "
                + ":" + "1521"
                + ":" + "migrasisde";

        String username = "PUBLIKASI";
        String password = "PUBLIKASI";
        conTarget = getConnection(driverName, url, username, password);
    }

    private static void simpleInsert(ResultSet rs) throws SQLException, Exception {
        setupConnectionTarget();

        conTarget.setAutoCommit(false);
        String sql = "INSERT INTO PUBLIKASI.ADMINISTRASI_AR_1M (NAMOBJ, OBJECTID, FCODE, METADATA, SHAPE, SRS_ID) VALUES ("
                + "?,ADMINISTRASI_AR_1M_SEQ.NEXTVAL,?,?"
                + ", SDE.ST_GEOMFROMWKB(?, ?), ?)";
        PreparedStatement stmt = conTarget.prepareStatement(sql);

        int i = 0;
        while (rs.next()) {
            OraReader reader = new OraReader();
            STRUCT shape = (STRUCT) rs.getObject("SHAPE");
            JGeometry jGeom = JGeometry.load(shape);

            Geometry geometry = reader.read(shape);
            println("Dimension " + jGeom.getDimensions());
            println("Type " + geometry.getGeometryType());
            WKBWriter writer = new WKBWriter();
            if (geometry.getGeometryType().equalsIgnoreCase("MULTIPOLYGON")) {
                int jumlahGeometry = geometry.getNumGeometries();
                for (int j = 0; j < jumlahGeometry; j++) {
                    Geometry mPolygon = geometry.getGeometryN(j);
                    byte[] wkb = writer.write(geometry);
                    Blob clob = conTarget.createBlob();
                    clob.setBytes(1, wkb);
//           STRUCT shape = JGeometry.store(jGeom, conSumber);
                    stmt.setString(1, (String) rs.getString("NAMOBJ"));
                    println(rs.getInt("OBJECTID") + "");
//                    stmt.setInt(2, rs.getInt("OBJECTID"));
                    stmt.setString(2, rs.getString("FCODE"));
                    stmt.setString(3, rs.getString("METADATA"));
                    stmt.setBlob(4, clob);
                    stmt.setInt(5, jGeom.getSRID());
                    stmt.setInt(6, jGeom.getSRID());
                    stmt.addBatch();
                }
            } else {

                String wkt = geometry.toText();

                byte[] wkb = writer.write(geometry);
//            println("WKT " + wkt);

//            com.esri.core.geometry.Geometry esriGeom = WktWkbUtil.fromWkt(wkt);
//            OGCGeometry ogcGeometry = OGCGeometry.fromText(geometry.toText());
//            if (geometry.getGeometryType().equalsIgnoreCase("POLYGON")) {
//                Coordinate[] coords = geometry.getCoordinates();
//                if (jGeom.getDimensions() == 3) {
//                    wkt += "POLYGON Z ((";
//                } else {
//                    wkt += "POLYGON  ((";
//                }
//                int d = 0;
//                for (Coordinate coord : coords) {
//                    if (jGeom.getDimensions() == 3) {
//                        wkt += coord.x + " " + coord.y + " " + coord.z;
//                        if (d < coords.length - 1) {
//                            wkt += ", ";
//                        }
//                    } else {
//                        wkt += coord.x + " " + coord.y;
//                        if (d < coords.length - 1) {
//                            wkt += ", ";
//                        }
//                    }
//                    d++;
//                }
//
//                wkt += "))";
//            }
//
//            if (geometry.getGeometryType().equalsIgnoreCase("MULTIPOLYGON")) {
//                MultiPolygon multiPolygon = (MultiPolygon) geometry;
//                int numGeom = multiPolygon.getNumGeometries();
//                if (jGeom.getDimensions() == 3) {
//                    wkt += "MULTIPOLYGON Z ((";
//                } else {
//                    wkt += "MULTIPOLYGON ((";
//                }
//                for (int j = 0; j < numGeom; j++) {
//                    Geometry geometry_ = multiPolygon.getGeometryN(j);
//                    Coordinate[] coords = geometry_.getCoordinates();
//                    wkt += "(";
//                    int d = 0;
//                    for (Coordinate coord : coords) {
//                        if (jGeom.getDimensions() == 3) {
//                            wkt += coord.x + " " + coord.y + " " + coord.z;
//                            if (d < coords.length - 1) {
//                                wkt += ",";
//                            }
//                        } else {
//                            wkt += coord.x + " " + coord.y;
//                            if (d < coords.length - 1) {
//                                wkt += ", ";
//                            }
//                        }
//                        d++;
//                    }
//                    wkt += ")";
//                    if (j < numGeom - 1) {
//                        wkt += ", ";
//                    }
//                }
//
//                wkt += "))";
//            }
//            com.esri.core.geometry.Geometry geom = WktWkbUtil.fromWkt(wkt);
//            println(geom.toString());
                Blob clob = conTarget.createBlob();
                clob.setBytes(1, wkb);
//           STRUCT shape = JGeometry.store(jGeom, conSumber);
                stmt.setString(1, (String) rs.getString("NAMOBJ"));
                println(rs.getInt("OBJECTID") + "");
                stmt.setInt(2, rs.getInt("OBJECTID"));
                stmt.setString(3, rs.getString("FCODE"));
                stmt.setString(4, rs.getString("METADATA"));
                stmt.setBlob(5, clob);
                stmt.setInt(6, jGeom.getSRID());
                stmt.setInt(7, jGeom.getSRID());
                stmt.addBatch();

            }

            if (i % 1 == 0) {
                try {
                    println("Execute batch");
                    stmt.executeBatch();
                    stmt.clearBatch();
                } catch (SQLException ex) {
                    Logger.getLogger(TestGetDataSDO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            i++;
        }
        try {
            stmt.executeBatch();
            conTarget.commit();
        } catch (SQLException ex) {
            Logger.getLogger(TestGetDataSDO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection getConnection(String driverName, String url, String username, String password) {
        try {
//            "oracle.jdbc.driver.OracleDriver"
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return null;
        }
//        System.out.println("Oracle JDBC Driver Registered!");
        Connection connection = null;

        try {
            // url = "jdbc:oracle:thin:@localhost:1521:orcl"
            //username = "system";
            //password = "root123";
            connection = DriverManager.getConnection(
                    url, username, password
            );
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }

        return connection;
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }
}
