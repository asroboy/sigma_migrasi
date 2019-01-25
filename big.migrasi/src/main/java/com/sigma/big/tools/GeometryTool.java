/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import com.esri.core.geometry.MultiPoint;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.io.IOException;

/**
 *
 * @author Ridho
 */
public class GeometryTool {

    public final static int GEOMETRYCOLLECTION = 1;
    public final static int MULTIPOLYGON = 2;
    public final static int MULTILINESTRING = 3;
    public final static int MULTIPOINT = 4;
    public final static int POLYGON = 5;
    public final static int LINESTRING = 6;
    public final static int POINT = 7;

    public static String getSkala(String skala) {
        String resSkala = null;
        if (skala.equalsIgnoreCase("1:5.000")) {
            resSkala = "5000";
        } else if (skala.equalsIgnoreCase("1:10.000")) {
            resSkala = "10000";
        } else if (skala.equalsIgnoreCase("1.25.000")) {
            resSkala = "25000";
        } else if (skala.equalsIgnoreCase("1:100.000")) {
            resSkala = "100000";
        } else if (skala.equalsIgnoreCase("1:250.000")) {
            resSkala = "250000";
        } else if (skala.equalsIgnoreCase("1:500.000")) {
            resSkala = "500000";
        } else {
            resSkala = "1000000";
        }

        return resSkala;

    }

    public static String getSkalaInK(String skala) {
        String resSkala = null;
        if (skala.equalsIgnoreCase("1:5.000")) {
            resSkala = "5K";
        } else if (skala.equalsIgnoreCase("1:10.000")) {
            resSkala = "10K";
        } else if (skala.equalsIgnoreCase("1.25.000")) {
            resSkala = "25K";
        } else if (skala.equalsIgnoreCase("1:100.000")) {
            resSkala = "100K";
        } else if (skala.equalsIgnoreCase("1:250.000")) {
            resSkala = "250K";
        } else if (skala.equalsIgnoreCase("1:500.000")) {
            resSkala = "500K";
        } else {
            resSkala = "1M";
        }

        return resSkala;

    }
    
    public static String getGeomTypeSDO(int code) {
        String geomType = "";
        switch (code) {
            case 1:
                geomType = "PT";
                break;
            case 2:
                geomType = "LN";
                break;
            case 3:
                geomType = "AR";
                break;
            case 4:
                geomType = "";
                break;
            case 5:
                geomType = "PT";
                break;
            case 6:
                geomType = "LN";
                break;
            case 7:
                geomType = "AR";
                break;
        }
        return geomType;
    }

    public static String getGeomCodes(String TYPE) {
        if (TYPE.equalsIgnoreCase("PT")) {
            return "(1,5)";
        } else if (TYPE.equalsIgnoreCase("LN")) {
            return "(2,6)";
        } else if (TYPE.equalsIgnoreCase("AR")) {
            return "(3,7)";
        } else {
            return "";
        }

    }

    public static int getGeomCodesSingle(String TYPE) {
        if (TYPE.equalsIgnoreCase("PT")) {
            return MULTIPOINT;
        } else if (TYPE.equalsIgnoreCase("LN")) {
            return MULTILINESTRING;
        } else if (TYPE.equalsIgnoreCase("AR")) {
            return MULTIPOLYGON;
        } else {
            return 0;
        }

    }

    public static Geometry getGeometry(String wkt, LogWriter logger) throws IOException, ParseException {
        if (wkt.length() > 100) {
            System.out.println("WKT " + wkt.substring(0, 100) + "....");
        } else {
            System.out.println("WKT " + wkt);
        }

        WKTReader reader = new WKTReader();
        if (wkt == null) {
            return null;
        } else {
            if (wkt.equals("")) {
                System.out.println("WKT IS EMPTY");
                return null;
            } else {
                if (wkt.contains("ZM")) {
                    Geometry geom = null;

                    String wkkt2 = wkt.replace("ZM", "");
                    //                    if (wkkt2.contains("1.#QNAN000")) {
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000", "");
                    //                        wkkt2 = wkkt2.replace("0.00000000,", ",");
                    //                        wkkt2 = wkkt2.replace("0.00000000)", ")");
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000)", ")");
                    //                        wkkt2 = wkkt2.replace("nan", "");
                    //                        wkkt2 = wkkt2.replace("nan)", ")");
                    ////                        System.out.println("WKT BARU " + wkkt2);
                    //                        //INSERT GEOMETRI YG DIPEROLEH KE TABLE SDO --> ADMINISTRASI_LN_25K_SDO
                    ////                        geom = reader.read(wkkt2);
                    //                    }
                    //                    if (wkkt2.contains("nan")) {
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000", "");
                    //                        wkkt2 = wkkt2.replace("0.00000000,", ",");
                    //                        wkkt2 = wkkt2.replace("0.00000000)", ")");
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000)", ")");
                    //                        wkkt2 = wkkt2.replace("nan", "");
                    //                        wkkt2 = wkkt2.replace("nan)", ")");
                    ////                      System.out.println("WKT BARU " + wkkt2);
                    //                        //INSERT GEOMETRI YG DIPEROLEH KE TABLE SDO --> ADMINISTRASI_LN_25K_SDO
                    ////                        geom = reader.read(wkkt2);
                    //
                    //                    }
                    //
                    //                    if (wkkt2.contains("NAN")) {
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000", "");
                    //                        wkkt2 = wkkt2.replace("0.00000000,", ",");
                    //                        wkkt2 = wkkt2.replace("0.00000000)", ")");
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000)", ")");
                    //                        wkkt2 = wkkt2.replace("NAN", "");
                    //                        wkkt2 = wkkt2.replace("NAN)", ")");
                    ////                      System.out.println("WKT BARU " + wkkt2);
                    //                        //INSERT GEOMETRI YG DIPEROLEH KE TABLE SDO --> ADMINISTRASI_LN_25K_SDO
                    ////                        geom = reader.read(wkkt2);
                    //
                    //                    }
                    //                    if (wkkt2.contains("0.00000000,")) {
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000", "");
                    //                        wkkt2 = wkkt2.replace("0.00000000,", ",");
                    //                        wkkt2 = wkkt2.replace("0.00000000)", ")");
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000)", ")");
                    //                        wkkt2 = wkkt2.replace("nan", "");
                    //                        wkkt2 = wkkt2.replace("nan)", ")");
                    ////                        System.out.println("WKT BARU " + wkkt2);
                    //                        //INSERT GEOMETRI YG DIPEROLEH KE TABLE SDO --> ADMINISTRASI_LN_25K_SDO
                    //
                    //                    }
                    //                    if (wkkt2.contains("0)")) {
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000", "");
                    //                        wkkt2 = wkkt2.replace("0.00000000,", ",");
                    //                        wkkt2 = wkkt2.replace("0.00000000)", ")");
                    //                        wkkt2 = wkkt2.replace("0)", ")");
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000)", ")");
                    //                        wkkt2 = wkkt2.replace("nan", "");
                    //                        wkkt2 = wkkt2.replace("nan)", ")");
                    ////                        System.out.println("WKT BARU " + wkkt2);
                    //                        //INSERT GEOMETRI YG DIPEROLEH KE TABLE SDO --> ADMINISTRASI_LN_25K_SDO
                    //                    }
                    //                    if (wkkt2.contains("NAN)")) {
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000", "");
                    //                        wkkt2 = wkkt2.replace("0.00000000,", ",");
                    //                        wkkt2 = wkkt2.replace("0.00000000)", ")");
                    //                        wkkt2 = wkkt2.replace("0)", ")");
                    //                        wkkt2 = wkkt2.replace("1.#QNAN000)", ")");
                    //                        wkkt2 = wkkt2.replace("nan", "");
                    //                        wkkt2 = wkkt2.replace("nan)", ")");
                    //                        wkkt2 = wkkt2.replace("NAN)", ")");
                    ////                        System.out.println("WKT BARU " + wkkt2);
                    //                        //INSERT GEOMETRI YG DIPEROLEH KE TABLE SDO --> ADMINISTRASI_LN_25K_SDO
                    //                    }

                    wkkt2 = wkkt2.replace(" 1.#QNAN000", "");
                    wkkt2 = wkkt2.replace(" 1.#QNAN000)", ")");
                    wkkt2 = wkkt2.replace(" 0.00000000,", ",");
                    wkkt2 = wkkt2.replace(" 0.00000000)", ")");
                    wkkt2 = wkkt2.replace(" 0)", ")");
                    wkkt2 = wkkt2.replace(" 0,", ",");
                    wkkt2 = wkkt2.replace(" nan", "");
                    wkkt2 = wkkt2.replace(" nan)", ")");
                    wkkt2 = wkkt2.replace(" NAN", "");
                    wkkt2 = wkkt2.replace(" NAN)", ")");

                    //System.out.println("WKT BARU " + wkkt2);
                    geom = reader.read(wkkt2);
                    return geom;
                } else if (wkt.contains("Z")) {
                    String wkkt2 = wkt.replace("Z", "");
                    //System.out.println("WKT BARU " + wkkt2);
                    //INSERT GEOMETRI YG DIPEROLEH KE TABLE SDO --> ADMINISTRASI_LN_25K_SDO
                    Geometry geom = reader.read(wkkt2);
                    return geom;

                } else {
                    //INSERT GEOMETRI YG DIPEROLEH KE TABLE SDO --> ADMINISTRASI_LN_25K_SDO
                    Geometry geom = reader.read(wkt);
                    return geom;

                }
            }
        }

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
//                point.setZ(cord.z);
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

    public static boolean isGeometryKnown(String wkt) {
        boolean isKNown;
        if (wkt == null) {
            isKNown = false;
        } else {
            isKNown = (wkt.contains("MULTILINESTRING") || wkt.contains("LINESTRING") || wkt.contains("POLYGON") || wkt.contains("MULTIPOLYGON") || wkt.contains("POLYLINE") || wkt.contains("MULTIPOLYLINE") || wkt.contains("POINT") || wkt.contains("MULTIPOINT"));
        }
        return isKNown;
    }

    public static String checkStringGeometryClob(String clobString, String type) {
        type = type.split("_")[1];
        if (clobString.startsWith("(((", 0)) {
            int size = clobString.split(",")[0].split(" ").length;
            switch (size) {
                case 4:
                    clobString = type + " Z " + clobString;
                    break;
                case 5:
                    clobString = type + " ZM " + clobString;
                    break;
                default:
                    clobString = type + " " + clobString;
                    break;

            }

        } else if (clobString.startsWith("((", 0)) {
            int size = clobString.split(",")[0].split(" ").length;
            switch (size) {
                case 4:
                    clobString = type + " Z " + clobString;
                    break;
                case 5:
                    clobString = type + " ZM " + clobString;
                    break;
                default:
                    clobString = type + " " + clobString;
                    break;
            }

        } else if (clobString.startsWith("(", 0)) {
            if (clobString.contains(",")) {
                int size = clobString.split(",")[0].split(" ").length;
                switch (size) {
                    case 4:
                        clobString = type + " Z " + clobString;
                        break;
                    case 5:
                        clobString = type + " ZM " + clobString;
                        break;
                    default:
                        clobString = type + " " + clobString;
                        break;
                }
            } else {
                int size = clobString.split(" ").length;
                switch (size) {
                    case 4:
                        clobString = type + " Z " + clobString;
                        break;
                    case 5:
                        clobString = type + " ZM " + clobString;
                        break;
                    default:
                        clobString = type + " " + clobString;
                        break;
                }
            }

        }

        return clobString;
    }

}