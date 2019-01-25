/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import static com.esri.core.geometry.Geometry.Type.Polyline;
import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.sigma.big.utils.WktWkbUtil;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.WKTWriter;
import com.vividsolutions.jts.io.oracle.OraReader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.sql.STRUCT;

/**
 *
 * @author Ridho
 */
public class Test {

    static Connection conSumber, conTarget;
    static ArrayList<HashMap<String, Object>> dataSumbers;

    public static void main(String[] arg) {
        try {
            dataSumbers = new ArrayList<>();
            println("Mulai");
            getData();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void getData() throws SQLException, ParseException {
        setupConnectionSumber(); //, 10049346, 10049576, 10049497, 10049531, 10049350, 10049552, 10049365, 10049341
        String sql = "SELECT  OBJECTID, SHAPE FROM IGD.ADMINISTRASI c "; //1832, 1839, 1841, 
        println(sql);

        try (Statement stmt = conSumber.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                OraReader reader = new OraReader();
                Geometry geometry = reader.read((STRUCT) rs.getObject("SHAPE"));
                println("Tipe Geometry  " + geometry.getGeometryType());
                println("Jumlah geometry pembentuk  " + geometry.getNumGeometries());
                com.esri.core.geometry.Geometry esriGeometry = convertSdoGeometryToSdeGeometry(geometry);
                WktWkbUtil util = new WktWkbUtil();
                println("GEOMETRY  " + util.toWkt(esriGeometry));
            }
        }
//        insert();
    }

    public static com.esri.core.geometry.Geometry convertSdoGeometryToSdeGeometry(Geometry sdoGeometry) {
        com.esri.core.geometry.Geometry esriGeometry = null;
        if (sdoGeometry.getGeometryType().equalsIgnoreCase("Polygon") || sdoGeometry.getGeometryType().equalsIgnoreCase("Multipolygon")) {
            esriGeometry = new Polygon();
        }
        if (sdoGeometry.getGeometryType().equalsIgnoreCase("LineString") || sdoGeometry.getGeometryType().equalsIgnoreCase("MultiLineString")) {
            esriGeometry = new Polyline();
        }
        if (sdoGeometry.getGeometryType().equalsIgnoreCase("Point")) {
            esriGeometry = new Point();
        }
        if (sdoGeometry.getGeometryType().equalsIgnoreCase("MultiPoint")) {
            esriGeometry = new MultiPoint();
        }
        for (int i = 0; i < sdoGeometry.getNumGeometries(); i++) {
            int j = 0;
            for (Coordinate cord : sdoGeometry.getGeometryN(i).getCoordinates()) {
                Point point = new Point();
                point.setX(cord.x);
                point.setY(cord.y);
                point.setZ(cord.z);
                if (esriGeometry instanceof Polygon) {
                    if (j == 0) {
                        ((Polygon) esriGeometry).startPath(point);
                    } else {
                        ((Polygon) esriGeometry).lineTo(point);
                    }
                }
                if (esriGeometry instanceof Polyline) {
                    if (j == 0) {
                        ((Polyline) esriGeometry).startPath(point);
                    } else {
                        ((Polyline) esriGeometry).lineTo(point);
                    }
                }
                if (esriGeometry instanceof MultiPoint) {
                    ((MultiPoint) esriGeometry).add(point);
                }
                if (esriGeometry instanceof Point) {
                    esriGeometry = point;
                }
                j++;

            }
        }
        return esriGeometry;
    }

    private static void setupConnectionSumber() {
        println("Setup con. sumber");

        String driverName = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@" + "localhost" + ":" + "1521" + ":" + "orcl";
//        String url = "jdbc:oracle:thin:@//" + "localhost" + ":" + "1521" + "/" + "orcl.168.56.1";

        String username = "IGD";
        String password = "IGD";
        conSumber = getConnection(driverName, url, username, password);
    }

    private static void setupConnectionTarget() {
        println("Setup con. target");

        String driverName = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@//"
                + "localhost"
                + ":" + "1521"
                + "/" + "MIGRASISDE";

        String username = "PUBLIKASI";
        String password = "PUBLIKASI";
        conTarget = getConnection(driverName, url, username, password);
    }

    private static void insert() throws SQLException, ParseException {

        String sqlInsert = "DECLARE \n"
                + " xgeom clob; \n";
        sqlInsert += " SHAPE  SDE.ST_GEOMETRY;";
//                + " BEGIN \n"
//                + "INSERT INTO PUBLIKASI.PASIR_AR (OBJECTID, SHAPE) VALUES (";
//                + ""
//                + ""
//                + ""
//                + "?,SDE.ST_MULTIPOLYGON(?,300004)); \n"
//                + " END;";

        println(sqlInsert);

        int i = 0;
        for (HashMap<String, Object> next : dataSumbers) {

//            PreparedStatement pstmt = conTarget.prepareStatement(sqlInsert);
            try {
                Object dataValue = next.get("SHAPE");
                OraReader reader = new OraReader();
                Geometry geometry = reader.read((STRUCT) dataValue);
//                Blob blob = conTarget.createBlob();
//                Clob clob = conTarget.createClob();

                String wkt = new WKTWriter().write(geometry);

                com.esri.core.geometry.Geometry esriGeom = WktWkbUtil.fromWkt(wkt);
                println("Type :" + esriGeom.getType());
                println("Dim :" + esriGeom.getDimension());
//                println(wkt);
                String formattedWkt = "";
                String[] wktSplit = wkt.split(",");
                int d = 1;

                byte[] wkbString = new WKBWriter().write(geometry);

//                clob.setString(1, formattedWkt);
//
//                blob.setBytes(1, WktWkbUtil.toWkb(esriGeom));
                wkt = wkt.replace(",", "'||',");
                String objectId = (String) next.get("OBJECTID");
                println("OBJECTID " + objectId);
                sqlInsert += " BEGIN \n"
                        + " xgeom :='" + wkt + "'; \n";

//              + "INSERT INTO PUBLIKASI.ADMINISTRASI_AR (OBJECTID, FCODE,SRS_ID, SHAPE) VALUES (";
//                sqlInsert += objectId + ", '',4326,";
//                sqlInsert += " SDE.ST_GEOMETRY(xgeom,300004)); \n";
                sqlInsert += "SELECT SDE.ST_GEOMFROMTEXT(xgeom, 4326) FROM dual; \n";
                sqlInsert += "END;";
//                println(sqlInsert);
                setupConnectionTarget();
                Statement stm = conTarget.createStatement();
                ResultSet rs = stm.executeQuery(sqlInsert);
                while (rs.next()) {
                    println("Shape : " + rs.getClob("SHAPE"));
                }
//                pstmt.setString(1, objectId);
//                pstmt.setClob(2, clob);
//
//                pstmt.addBatch();
//                pstmt.executeBatch();
//                pstmt.close();
//                conTarget.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            i++;

        }

        println("Selesai");

    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
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

}
