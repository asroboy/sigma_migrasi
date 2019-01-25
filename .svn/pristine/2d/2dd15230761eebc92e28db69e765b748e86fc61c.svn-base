/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import com.esri.core.geometry.MultiPath;
import com.esri.core.geometry.OperatorImportFromWkt;
import com.esri.core.geometry.OperatorSimplifyOGC;
import com.esri.core.geometry.ogc.OGCGeometry;
import com.esri.core.geometry.ogc.OGCPoint;
import com.sigma.migrationtool.Test;
import com.vividsolutions.jts.io.ParseException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Array;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ridho
 */
public class TestDevToProd {

    static Connection conSumber, conTarget;
    static ArrayList<HashMap<String, Object>> dataSumbers;

    public static void main(String[] arg) {
//        String wkt = "";
//        Geometry geometry = WktWkbUtil.fromWkt(wkt);

        try {
            dataSumbers = new ArrayList<>();
            println("Mulai");
            getData();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void getData() throws SQLException, ParseException {
        setupConnectionSumber();
        String sql = "SELECT * FROM (\n"
                + "SELECT ROWNUM R, SUBQ.*\n"
                + "  FROM\n"
                + "    (SELECT sde.st_geometrytype(SHAPE) as GEOMTYPE, SDE.ST_SRID(SHAPE) as SRID,  SDE.ST_ASBINARY(SHAPE) AS SHAPE, FTYPE, \n"
                + "    WADMKC, WADMKD, LOKTPN, ALIAS, FCODE, UPDATED, KOORDINAT1, ELEVASI, WIADKK, NAMOBJ, OBJECTID, NAMMAP, KLSTPN, STATUS, \n"
                + "    ASLBHS, NAMGAZ, WIADKC, WIADKD, LUAS, WADMKK, NAMSPE, REMARK, SJHNAM, KOORDX, KOORDY, KORDINTAT2, SRS_ID, LON, TIPADM, \n"
                + "    WIADPR, ARTINAM, LCODE, METADATA, NAMLOK, WADMPR, PELAKSANA, \n"
                + "    LAT FROM IGD5K.TOPONIMI_PT  WHERE METADATA = 'RBI500020161202SAMARINDA') \n"
                + "    SUBQ WHERE ROWNUM <= 10000) \n"
                + "    WHERE R > 8000\n"
                + " ";
        println(sql);
        try (Statement stmt = conSumber.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            simpleInsert(rs);
        }
//        conSumber.close();

//        insert();
    }

    private static void testSimple(String wkt) {
        com.esri.core.geometry.Geometry g = OperatorImportFromWkt.local().execute(0, com.esri.core.geometry.Geometry.Type.Unknown, wkt, null);
        System.out.println(" : " + g.getType()
                + " " + ((MultiPath) g).getPathCount() + " rings" + " " + ((MultiPath) g).getPointCount() + " vertices");
        System.out.print("Checking if simple... ");
        boolean isSimple = OperatorSimplifyOGC.local().isSimpleOGC(g, null, true, null, null);
        System.out.println(isSimple);
        System.out.print("Running simplify operation... ");
        com.esri.core.geometry.Geometry gSimple = OperatorSimplifyOGC.local().execute(g, null, true, null);
        System.out.println("Simple" + " : " + g.getType()
                + " " + ((MultiPath) gSimple).getPathCount() + " rings" + " " + ((MultiPath) gSimple).getPointCount() + " vertices");
        System.out.println("Done");
        System.out.print("Running simplify operation (should be simple now)... ");
        isSimple = OperatorSimplifyOGC.local().isSimpleOGC(gSimple, null, true, null, null);
        System.out.println(isSimple);
        ((MultiPath) gSimple).getXY(0);
    }

    private static void setupConnectionSumber() {
        println("Setup con. sumber");

        String driverName = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@"
                + "192.168.210.157"
                + ":" + "1521"
                + ":" + "dbpprt";
        String username = "IGD5K";
        String password = "IGD5K";
        conSumber = getConnection(driverName, url, username, password);
    }

    private static void setupConnectionTarget() {
        println("Setup con. target");

        String driverName = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@"
                + "192.168.210.195"
                + ":" + "1521"
                + ":" + "dbprod";

        String username = "IGD";
        String password = "IGD";
        conTarget = getConnection(driverName, url, username, password);
    }

    private static void simpleInsert(ResultSet rs) throws SQLException {
        setupConnectionTarget();
        Statement stmt = conTarget.createStatement();
        conTarget.setAutoCommit(false);
        String SRID = "";
        while (rs.next()) {
            ByteBuffer buffer = ByteBuffer.wrap((byte[]) rs.getBytes("SHAPE"));
            OGCGeometry geomOgc = OGCGeometry.fromBinary(buffer);
            SRID = String.valueOf(geomOgc.SRID());
            String sdoGtype = generateSDO_GTYPE(geomOgc.coordinateDimension(), geomOgc.geometryType());
            String geometry = null;
            if (geomOgc.geometryType().equalsIgnoreCase("point")) {
                OGCPoint point = (OGCPoint) geomOgc;
                geometry = "MDSYS.SDO_GEOMETRY(" + sdoGtype + ", " + geomOgc.SRID() + ", SDO_POINT_TYPE(" + point.X() + "," + point.Y() + "," + point.Z() + "),NULL,NULL" + ")";
            }

            println(geometry);
            println(rs.getString("OBJECTID"));
//            Blob blob = conTarget.createBlob();
            Clob clob = conTarget.createClob();
//            byte[] wkbString = new WKBWriter().write(geom);

            ByteBuffer bf = geomOgc.asBinary();
            clob.setString(1, geometry);
            String sql_ = "INSERT INTO IGD.TOPONIMI (SHAPE, \n"
                    + " FTYPE, WADMKC, WADMKD, LOKTPN, \n"
                    + " ALIAS, FCODE, UPDATED,  ELEVASI, \n"
                    + " WIADKK, NAMOBJ, OBJECTID, NAMMAP, KLSTPN, STATUS, \n"
                    + " ASLBHS, NAMGAZ, WIADKC, WIADKD, LUAS, WADMKK, NAMSPE,\n"
                    + " REMARK, SJHNAM, KOORDX, KOORDY, KORDINTAT2, SRS_ID, LON, \n"
                    + " TIPADM, WIADPR, ARTINAM, LCODE, METADATA, NAMLOK, WADMPR, \n"
                    + " PELAKSANA, LAT ) VALUES ("
                    + geometry + ","
                    + "'" + (String) rs.getString("FTYPE") + "'"
                    + ","
                    + "'" + (String) rs.getString("WADMKC") + "'"
                    + ","
                    + "'" + (String) rs.getString("WADMKD") + "'"
                    + ","
                    + "'" + (String) rs.getString("LOKTPN") + "'"
                    + ","
                    + "'" + (String) rs.getString("ALIAS") + "'"
                    + ","
                    + "'" + (String) rs.getString("FCODE") + "'"
                    + ","
                    + "'" + (String) rs.getString("UPDATED") + "'"
                    + ","
//                    + "'" + (String) rs.getString("KOORDINAT1") + "'"
//                    + ","
                    + "'" + (String) rs.getString("ELEVASI") + "'"
                    + ","
                    + "'" + (String) rs.getString("WIADKK") + "'"
                    + ","
                    + "'" + (String) rs.getString("NAMOBJ") + "'"
                    + ","
                    + "'" + (String) rs.getString("OBJECTID") + "'"
                    + ","
                    + "'" + (String) rs.getString("NAMMAP") + "'"
                    + ","
                    + "'" + (String) rs.getString("KLSTPN") + "'"
                    + ","
                    + "'" + (String) rs.getString("STATUS") + "'"
                    + ","
                    + "'" + (String) rs.getString("ASLBHS") + "'"
                    + ","
                    + "'" + (String) rs.getString("NAMGAZ") + "'"
                    + ","
                    + "'" + (String) rs.getString("WIADKC") + "'"
                    + ","
                    + "'" + (String) rs.getString("WIADKD") + "'"
                    + ","
                    + "'" + (String) rs.getString("LUAS") + "'"
                    + ","
                    + "'" + (String) rs.getString("WADMKK") + "'"
                    + ","
                    + "'" + (String) rs.getString("NAMSPE") + "'"
                    + ","
                    + "'" + (String) rs.getString("REMARK") + "'"
                    + ","
                    + "'" + (String) rs.getString("SJHNAM") + "'"
                    + ","
                    + "'" + (String) rs.getString("KOORDX") + "'"
                    + ","
                    + "'" + (String) rs.getString("KOORDY") + "'"
                    + ","
                    + "'" + (String) rs.getString("KORDINTAT2") + "'"
                    + ","
                    + "'" + (String) rs.getString("SRS_ID") + "'"
                    + ","
                    + "'" + (String) rs.getString("LON") + "'"
                    + ","
                    + "'" + (String) rs.getString("TIPADM") + "'"
                    + ","
                    + "'" + (String) rs.getString("WIADPR") + "'"
                    + ","
                    + "'" + (String) rs.getString("ARTINAM") + "'"
                    + ","
                    + "'" + (String) rs.getString("LCODE") + "'"
                    + ","
                    + "'" + (String) rs.getString("METADATA") + "'"
                    + ","
                    + "'" + (String) rs.getString("NAMLOK") + "'"
                    + ","
                    + "'" + (String) rs.getString("WADMPR") + "'"
                    + ","
                    + "'" + (String) rs.getString("PELAKSANA") + "'"
                    + ","
                    + "'" + (String) rs.getString("LAT") + "')";
            println(sql_);
            stmt.execute(sql_);

        }
        conTarget.commit();
//        String bBox = getBoundingBox(stmt);
//        updateMetadataView(stmt, bBox, SRID);
//        conTarget.commit();
//        createSpatialIndex(stmt);
//        conTarget.commit();
    }

    private static String getBoundingBox(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT MDSYS.SDO_AGGR_MBR(SHAPE) AS BOUNDING_BOX FROM IGD.spotheight");
        BigDecimal xMin = null, yMin = null, xMax = null, yMax = null, zMin = null, zMax = null;
        while (rs.next()) {
            Struct bBoxx = (Struct) rs.getObject("BOUNDING_BOX");
//            for (Object attribute : bBoxx.getAttributes()) {
//                println("attribute " + attribute);
//            }
//            Array a = ((Array) bBoxx.getAttributes()[3]);
//            BigDecimal[] x = (BigDecimal[]) a.getArray();
//            for (BigDecimal string : x) {
//                println("" + string);
//            }
            Array b = ((Array) bBoxx.getAttributes()[4]);

            BigDecimal[] xyz = (BigDecimal[]) b.getArray();

            for (int i = 0; i < xyz.length; i++) {
                xMin = xyz[0];
                yMin = xyz[1];
                xMax = xyz[2];
                yMax = xyz[3];
                if (xyz.length > 4) {
                    zMin = xyz[4];
                    zMax = xyz[5];
                }
            }
        }

        String bBox;
        if (zMin == null) {
            bBox = "SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X', " + xMin + ", " + xMax + ", 0.005), "
                    + "SDO_DIM_ELEMENT('Y', " + yMin + ", " + yMax + ", 0.005))";
        } else {
            bBox = "SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X', " + xMin + ", " + xMax + ", 0.005), "
                    + "SDO_DIM_ELEMENT('Y', " + yMin + ", " + yMax + ", 0.005),"
                    + "SDO_DIM_ELEMENT('Z', " + zMin + ", " + zMax + ", 0.005))";
        }

        return bBox;

    }

    private static void updateMetadataView(Statement stmt, String bBox, String SRID) throws SQLException {
        stmt.execute("INSERT INTO MDSYS.user_sdo_geom_metadata (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) "
                + "  VALUES ('SPOTHEIGHT','shape', " + bBox + ","
                + " " + SRID + ")");

    }

    private static void createSpatialIndex(Statement stmt) throws SQLException {
        stmt.execute("CREATE INDEX spotheight_spatial_idx ON IGD.SPOTHEIGHT(SHAPE) INDEXTYPE IS MDSYS.SPATIAL_INDEX");

    }

    private static void insert() throws SQLException, ParseException {
        setupConnectionTarget();

        String sqlInsert = "DECLARE "
                + " xgeom blob; "
                + " BEGIN "
                + "INSERT INTO IGD.DANAU (NAMOBJ, OBJECTID, FCODE, METADATA, SHAPE) VALUES (?, ?, ?, ?, ?); "
                + " END;";

        println(sqlInsert);
//        PreparedStatement pstmt = conTarget.prepareStatement(sqlInsert);
        Statement stmt = conTarget.createStatement();
        int batchSize = 1;
        int i = 0;
        for (HashMap<String, Object> next : dataSumbers) {
//            Geometry geom = (Geometry) next.get("SHAPE");
//            int geomNumber = geom.getNumGeometries();

            OGCGeometry geomOgc = (OGCGeometry) next.get("SHAPE");
            println(geomOgc.geometryType());
            println("SRID " + geomOgc.SRID());
            println("coordinateDimension " + geomOgc.coordinateDimension());
            println("ESRI SPATIAL REF " + geomOgc.getEsriSpatialReference());
            println("is Simple?  " + geomOgc.isSimple());
            println("Dimension " + geomOgc.dimension());
            println("WKT: " + geomOgc.asText());
            if (!geomOgc.geometryType().equalsIgnoreCase("point")) {
                testSimple(geomOgc.asText());
            }

            String sdoGtype = generateSDO_GTYPE(geomOgc.coordinateDimension(), geomOgc.geometryType());
            String geometry = null;
            if (geomOgc.geometryType().equalsIgnoreCase("point")) {
                OGCPoint point = (OGCPoint) geomOgc;
                geometry = "MDSYS.SDO_GEOMETRY(" + sdoGtype + ", NULL, SDO_POINT_TYPE(" + point.X() + "," + point.Y() + "," + point.Z() + "),NULL,NULL" + ")";
            }

            println(geometry);
//            Blob blob = conTarget.createBlob();
            Clob clob = conTarget.createClob();
//            byte[] wkbString = new WKBWriter().write(geom);

            ByteBuffer bf = geomOgc.asBinary();
            clob.setString(1, geometry);
            stmt.execute("INSERT INTO IGD.SPOTHEIGHT (NAMOBJ, OBJECTID, FCODE, METADATA, SHAPE) VALUES ("
                    + "'" + (String) next.get("NAMOBJ") + "'"
                    + ","
                    + "'" + (String) next.get("OBJECTID") + "'"
                    + ","
                    + "'" + (String) next.get("FCODE") + "'"
                    + ","
                    + "'" + (String) next.get("METADATA") + "'"
                    + "," + geometry + ")");
//            pstmt.setString(1, (String) next.get("NAMOBJ"));
//            pstmt.setString(2, (String) next.get("OBJECTID"));
//            pstmt.setString(3, (String) next.get("FCODE"));
//            pstmt.setString(4, (String) next.get("METADATA"));
//            pstmt.setObject(5, geometry);
//
//            pstmt.addBatch();
            i++;
//            if (i % batchSize == 0) {
//                println("Execute batch " + i);
//                pstmt.executeBatch();
//            }
//            }

        }
//        pstmt.executeBatch();
        println("Selesai");

    }

    /**
     * The SDO_GTYPE value is 4 digits in the format [dltt], where: [d]
     * identifies the number of dimensions (2, 3, or 4) [l] identifies the
     * linear referencing measure dimension for a three-dimensional linear
     * referencing system (LRS) geometry, that is, which dimension (3 or 4)
     * contains the measure value. For a non-LRS geometry, or to accept the
     * Spatial default of the last dimension as the measure for an LRS geometry,
     * specify 0. For information about the linear referencing system (LRS), see
     * Chapter 6. [tt] identifies the geometry type (00 through 07, with 08
     * through 99 reserved for future use)
     */
    private static String generateSDO_GTYPE(int dimension, String geomType) {
        int d = dimension;
        int l = 0;
        String SDO_TYPE = d + "" + l + "0" + getTT(geomType);
        return SDO_TYPE;
    }

    private static int getTT(String geomType) {
        int tt = 0;
        if (geomType.equalsIgnoreCase("point")) {
            tt = 1;
        } else if (geomType.equalsIgnoreCase("LINE") || geomType.equalsIgnoreCase("LINESTRING")) {
            tt = 2;
        } else if (geomType.equalsIgnoreCase("POLYGON")) {
            tt = 3;
        } else if (geomType.equalsIgnoreCase("COLLECTION")) {
            tt = 4;
        } else if (geomType.equalsIgnoreCase("MULTIPOINT")) {
            tt = 5;
        } else if (geomType.equalsIgnoreCase("MULTILINE") || geomType.equalsIgnoreCase("MULTILINESTRING")) {
            tt = 6;
        } else if (geomType.equalsIgnoreCase("MULTIPOLYGON")) {
            tt = 7;
        } else {
            tt = 0;
        }
        return tt;
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
