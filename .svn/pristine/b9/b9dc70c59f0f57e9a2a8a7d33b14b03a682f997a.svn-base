/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import com.esri.core.geometry.ogc.OGCGeometry;
import com.esri.core.geometry.ogc.OGCLineString;
import com.esri.core.geometry.ogc.OGCMultiLineString;
import com.esri.core.geometry.ogc.OGCMultiPolygon;
import com.esri.core.geometry.ogc.OGCPoint;
import com.esri.core.geometry.ogc.OGCPolygon;
import com.sigma.big.utils.ConverterUtil;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.oracle.OraWriter;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleConnection;
import oracle.spatial.geometry.JGeometry;
import org.apache.commons.lang3.ArrayUtils;
//import oracle.sdoapi.OraSpatialManager;

/**
 *
 * @author Ridho
 */
public class TestDevToProdLn {

    static String namaUnsur = "ADMINISTRASI";
    static String namaSkemaSumber = "IGD1000K";
    static String TIPE_UNSUR = "AR";
    static Connection conSumber, conTarget;
    static ArrayList<HashMap<String, Object>> dataSumbers;

    public static void main(String[] arg) {
        try {
            dataSumbers = new ArrayList<>();
            println("Mulai");
            getData();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(com.sigma.migrationtool.Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void getData() throws SQLException, ParseException {
        setupConnectionSumber();
        String sql = "SELECT  SDE.ST_ASBINARY(SHAPE) as SHAPE, OBJECTID, SRS_ID, METADATA, FCODE, NAMOBJ FROM " + namaSkemaSumber + "." + namaUnsur + "_" + TIPE_UNSUR + " WHERE OBJECTID = 308"; //
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
                + ":" + "migrasisde";
        String username = namaSkemaSumber;
        String password = namaSkemaSumber;
        conSumber = getConnection(driverName, url, username, password);
    }

    private static void setupConnectionTarget() {
        println("Setup con. target");

        String driverName = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@"
                + "localhost"
                + ":" + "1521"
                + ":" + "orcl";

        String username = "IGD";
        String password = "IGD";
        conTarget = getConnection(driverName, url, username, password);
    }

    private static void simpleInsert(ResultSet rs) throws SQLException {
        setupConnectionTarget();

        String sql = "INSERT INTO IGD." + namaUnsur + " (NAMOBJ, OBJECTID, FCODE, METADATA, SHAPE) VALUES ("
                + "?,?,?,?,?)";
        Statement stmt = conTarget.createStatement();
        PreparedStatement pstm = conTarget.prepareStatement(sql);
        conTarget.setAutoCommit(false);
        String SRID = "";

        int c = 0;
        while (rs.next()) {
            ByteBuffer buffer = ByteBuffer.wrap((byte[]) rs.getBytes("SHAPE"));
            OGCGeometry geomOgc = OGCGeometry.fromBinary(buffer);
            SRID = String.valueOf(geomOgc.SRID());
            String sdoGtype = generateSDO_GTYPE(geomOgc.coordinateDimension(), geomOgc.geometryType());
//            String geometry = null;
            println("Number : " + c);
            println("TYPE: " + geomOgc.geometryType());
            println("Dimension : " + geomOgc.coordinateDimension());
            if (geomOgc.geometryType().equalsIgnoreCase("POINT")) {
                OGCPoint point = (OGCPoint) geomOgc;
                int dim = point.coordinateDimension();
                if (dim == 4) {
                    dim = dim - 1;
                }
                double[] doubles = new double[dim];

                doubles[0] = point.X();
                doubles[1] = point.Y();
                if (dim > 2) {
                    doubles[2] = point.Z();
                }
                JGeometry jGeom = JGeometry.createPoint(doubles, dim, point.SRID());
                pstm.setString(1, rs.getString("NAMOBJ"));
                pstm.setInt(2, rs.getInt("OBJECTID"));
                pstm.setString(3, rs.getString("FCODE"));
                pstm.setString(4, rs.getString("METADATA"));
                pstm.setObject(5, JGeometry.store(jGeom, conTarget));

                pstm.addBatch();
//                geometry = "MDSYS.SDO_GEOMETRY(" + sdoGtype + ", " + geomOgc.SRID() + ", SDO_POINT_TYPE(" + point.X() + "," + point.Y() + "," + point.Z() + "),NULL,NULL" + ")";
            } //            else if (geomOgc.geometryType().equalsIgnoreCase("MULTIPOINT")) {
            //                OGCMulti point = (OGCPoint) geomOgc;
            //                int dim = point.coordinateDimension();
            //                if (dim == 4) {
            //                    dim = dim - 1;
            //                }
            //                double[] doubles = new double[]{dim};
            //
            //                doubles[0] = point.X();
            //                doubles[1] = point.Y();
            //                if (dim > 2) {
            //                    doubles[2] = point.Z();
            //                }
            //                JGeometry jGeom = JGeometry.createPoint(doubles, dim, point.SRID());
            //                pstm.setString(1, rs.getString("NAMOBJ"));
            //                pstm.setInt(2, rs.getInt("OBJECTID"));
            //                pstm.setString(3, rs.getString("FCODE"));
            //                pstm.setString(4, rs.getString("METADATA"));
            //                pstm.setObject(5, JGeometry.store(jGeom, conTarget));
            //
            //                pstm.addBatch();
            //                
            //            } 
            else if (geomOgc.geometryType().equalsIgnoreCase("LINESTRING")) {
                OGCLineString lineString = (OGCLineString) geomOgc;
                int numPoints = lineString.numPoints();
                println("numPoints : " + numPoints);
                int dim = lineString.coordinateDimension();
//                if (dim > 3) {
//                    dim = dim - 1;
//                }

                dim = 2;
                int limit = 1048576 / dim;
                if (numPoints > limit) {
                    int size = numPoints / limit;
                    int mod = numPoints % limit;
                    int arraySize = (mod > 0) ? (size + 1) : size;
                    Object[] coords = new Object[arraySize];
                    for (int j = 0; j < size; j++) {
                        ArrayList<Double> d = new ArrayList<>();
                        int start = j * limit;
                        int end = start + limit - 1;
                        println("start : " + start + " end : " + end);
                        for (int i = start; i < end; i++) {
                            OGCPoint pointInLine = lineString.pointN(i);
//                            if (i < limit) {
                            d.add(pointInLine.X());
                            d.add(pointInLine.Y());
                            if (dim > 2) {
                                d.add(pointInLine.Z());
                            }
//                            }
                        }
                        Double[] doubles_ = d.toArray(new Double[d.size()]);
                        double[] doubles = ArrayUtils.toPrimitive(doubles_);
                        println("doubles.length : " + doubles.length);
                        coords[j] = doubles;
                    }

                    if (mod > 0) {
                        ArrayList<Double> d = new ArrayList<>();
                        int start = size * limit;
                        int end = start + mod - 1;
                        println("start : " + start + " end : " + end);
                        for (int i = start; i < end; i++) {
                            OGCPoint pointInLine = lineString.pointN(i);
                            d.add(pointInLine.X());
                            d.add(pointInLine.Y());
                            if (dim > 2) {
                                d.add(pointInLine.Z());
                            }

                        }
                        Double[] doubles_ = d.toArray(new Double[d.size()]);
                        double[] doubles = ArrayUtils.toPrimitive(doubles_);
                        println("doubles.length : " + doubles.length);
                        coords[size] = doubles;
                    }

                    JGeometry jGeom = JGeometry.createLinearMultiLineString(coords, dim, lineString.SRID());
                    pstm.setString(1, rs.getString("NAMOBJ"));
                    int objectId = rs.getInt("OBJECTID");
                    println("objectId " + objectId);
                    pstm.setInt(2, objectId);
                    pstm.setString(3, rs.getString("FCODE"));
                    pstm.setString(4, rs.getString("METADATA"));
                    pstm.setObject(5, JGeometry.store(jGeom, conTarget));

                    pstm.addBatch();

                } else {
                    ArrayList<Double> d = new ArrayList<>();
                    for (int i = 0; i < numPoints; i++) {
                        OGCPoint pointInLine = lineString.pointN(i);
                        d.add(pointInLine.X());
                        d.add(pointInLine.Y());
                        if (pointInLine.coordinateDimension() > 2) {
                            d.add(pointInLine.Z());
                        }
                    }
                    Double[] doubles_ = d.toArray(new Double[d.size()]);
                    double[] doubles = ArrayUtils.toPrimitive(doubles_);
                    println("numPoints " + numPoints);
                    JGeometry jGeom = JGeometry.createLinearLineString(doubles, dim, lineString.SRID());
                    pstm.setString(1, rs.getString("NAMOBJ"));
                    int objectId = rs.getInt("OBJECTID");
                    println("objectId " + objectId);
                    pstm.setInt(2, objectId);
                    pstm.setString(3, rs.getString("FCODE"));
                    pstm.setString(4, rs.getString("METADATA"));
                    pstm.setObject(5, JGeometry.store(jGeom, conTarget));

                    pstm.addBatch();
                }

            } else if (geomOgc.geometryType().equalsIgnoreCase("MULTILINESTRING")) {
                OGCMultiLineString multiLineString = (OGCMultiLineString) geomOgc;
                int jumlahLine = multiLineString.numGeometries();
                ArrayList<Double> d = new ArrayList<>();

                Object[] coords = new Object[jumlahLine];

                for (int i = 0; i < jumlahLine; i++) {
                    OGCLineString lineStringInMultiLine = (OGCLineString) multiLineString.geometryN(i);
                    int jumlahPoint = lineStringInMultiLine.numPoints();
                    for (int z = 0; z < jumlahPoint; z++) {
                        OGCPoint pointInLine = lineStringInMultiLine.pointN(z);
                        d.add(pointInLine.X());
                        d.add(pointInLine.Y());
                        if (pointInLine.is3D()) {
                            d.add(pointInLine.Z());
                        }
                    }

                    Double[] doubles_ = d.toArray(new Double[d.size()]);
                    double[] doubles = ArrayUtils.toPrimitive(doubles_);
                    coords[i] = doubles;
                }

                int dim = multiLineString.coordinateDimension();
                if (dim == 4) {
                    dim = dim - 1;
                }
                JGeometry jGeom = JGeometry.createLinearMultiLineString(coords, dim, multiLineString.SRID());
                pstm.setString(1, rs.getString("NAMOBJ"));
                pstm.setInt(2, rs.getInt("OBJECTID"));
                pstm.setString(3, rs.getString("FCODE"));
                pstm.setString(4, rs.getString("METADATA"));
                pstm.setObject(5, JGeometry.store(jGeom, conTarget));
                pstm.addBatch();
            } else if (geomOgc.geometryType().equalsIgnoreCase("POLYGON")) {
                OGCPolygon polygon = (OGCPolygon) geomOgc;
                OGCLineString exterior = polygon.exteriorRing();
//                double[] coords = new double[polygon.numInteriorRing() + 1];

                int jumlahPoint = exterior.numPoints();
                ArrayList<Double> d = new ArrayList<>();
                for (int z = 0; z < jumlahPoint; z++) {
                    OGCPoint pointInLine = exterior.pointN(z);
                    d.add(pointInLine.X());
                    d.add(pointInLine.Y());
                    if (pointInLine.is3D()) {
                        d.add(pointInLine.Z());
                    }
                }
                Double[] doubles_ = d.toArray(new Double[d.size()]);
                double[] coords = ArrayUtils.toPrimitive(doubles_);
//                coords[0] = doubles;
//                if (polygon.numInteriorRing() > 0) {
//                    for (int j = 0; j < polygon.numInteriorRing(); j++) {
//                        OGCLineString interior = polygon.interiorRingN(j);
//                        int jumlahPoint_ = interior.numPoints();
//                        ArrayList<Double> d_ = new ArrayList<>();
//                        for (int z = 0; z < jumlahPoint_; z++) {
//                            OGCPoint pointInLine = interior.pointN(z);
//                            d_.add(pointInLine.X());
//                            d_.add(pointInLine.Y());
//                            if (pointInLine.coordinateDimension() == 3) {
//                                d_.add(pointInLine.Z());
//                            }
//                        }
//                        Double[] doubles_x = d_.toArray(new Double[d_.size()]);
//                        double[] doubles_s = ArrayUtils.toPrimitive(doubles_x);
//
//                        coords[j + 1] = doubles_s;
//                    }
//                }
                int dim = polygon.coordinateDimension();
                JGeometry jGeom;
                if (dim == 4) {
                    jGeom = JGeometry.createLinearPolygon(coords, polygon.coordinateDimension() - 1, polygon.SRID());
                } else {
                    jGeom = JGeometry.createLinearPolygon(coords, polygon.coordinateDimension(), polygon.SRID());
                }

                pstm.setString(1, rs.getString("NAMOBJ"));
                pstm.setInt(2, rs.getInt("OBJECTID"));
                pstm.setString(3, rs.getString("FCODE"));
                pstm.setString(4, rs.getString("METADATA"));
                pstm.setObject(5, JGeometry.store(jGeom, conTarget));
                pstm.addBatch();

            } else if (geomOgc.geometryType().equalsIgnoreCase("MULTIPOLYGON")) {
                ConverterUtil converter = new ConverterUtil();
                MultiPolygon multipolygon = converter.esrOgcMultiPolygonToPolygon((OGCMultiPolygon) geomOgc);
                OraWriter writer = new OraWriter();
                pstm.setString(1, rs.getString("NAMOBJ"));
                pstm.setInt(2, rs.getInt("OBJECTID"));
                pstm.setString(3, rs.getString("FCODE"));
                pstm.setString(4, rs.getString("METADATA"));
                Geometry g = multipolygon.getFactory().createGeometry(multipolygon);
                println("SRID " + SRID);
                g.setSRID(multipolygon.getSRID());
                pstm.setObject(5, writer.write(g, (OracleConnection) conTarget));
                pstm.addBatch();

            }
            c++;
        }

        pstm.executeBatch();
        conTarget.commit();
        String bBox = getBoundingBox(stmt);
        updateMetadataView(stmt, bBox, SRID);
        conTarget.commit();
        createSpatialIndex(stmt);
        conTarget.commit();
    }

    private static String getBoundingBox(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT MDSYS.SDO_AGGR_MBR(SHAPE) AS BOUNDING_BOX FROM IGD." + namaUnsur + "");
        BigDecimal xMin = null, yMin = null, xMax = null, yMax = null, zMin = null, zMax = null;
        while (rs.next()) {
            Struct bBoxx = (Struct) rs.getObject("BOUNDING_BOX");
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
                + "  VALUES ('" + namaUnsur + "','shape', " + bBox + ","
                + " " + SRID + ")");

    }

    private static void createSpatialIndex(Statement stmt) throws SQLException {
        stmt.execute("CREATE INDEX " + namaUnsur + "_spatial_idx ON IGD." + namaUnsur + "(SHAPE) INDEXTYPE IS MDSYS.SPATIAL_INDEX");

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
        if (geomType.equalsIgnoreCase("POINT")) {
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
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return null;
        }

        Connection connection = null;
        try {
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
