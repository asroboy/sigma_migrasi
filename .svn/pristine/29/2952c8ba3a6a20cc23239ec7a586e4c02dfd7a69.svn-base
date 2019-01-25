/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import com.sigma.big.tools.LogWriter;
import com.sigma.big.utils.ConverterUtil;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;
import java.io.IOException;
import java.sql.SQLException;
import oracle.spatial.geometry.JGeometry;

/**
 *
 * @author Ridho
 */
public class GeometryHelper {

    /**
     * 
     * @param rowid
     * @param geometry
     * @param logger
     * @return
     * @throws IOException
     * @throws SQLException 
     */
    public JGeometry changeDimension(String rowid, JGeometry geometry, LogWriter logger) throws IOException, SQLException {

        logger.log(LogWriter.INFO, "ROWID : " + rowid
                + ", DIMENSI SEBELUM UPDATE : " + geometry.getDimensions() + ", GEOM TYPE : " + geometry.getType());

        if (geometry.getType() == JGeometry.GTYPE_POLYGON) {
            Polygon polygon = (Polygon) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < polygon.getNumGeometries(); i++) {
                for (Coordinate coord : polygon.getGeometryN(i).getCoordinates()) {
                    coord.setCoordinate(new Coordinate(coord.x, coord.y));
                }
            }
            geometry = ConverterUtil.toJGeometry(polygon, 4326);
        }
        if (geometry.getType() == JGeometry.GTYPE_MULTIPOLYGON) {
            MultiPolygon multiPolygon = (MultiPolygon) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < multiPolygon.getNumGeometries(); i++) {
                for (Coordinate coord : multiPolygon.getGeometryN(i).getCoordinates()) {
                    coord.setCoordinate(new Coordinate(coord.x, coord.y));
                }
            }
            geometry = ConverterUtil.toJGeometry(multiPolygon, 4326);
        }

        if (geometry.getType() == JGeometry.GTYPE_CURVE) { //LINE
            LineString lineString = (LineString) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < lineString.getNumGeometries(); i++) {
                for (Coordinate coord : lineString.getGeometryN(i).getCoordinates()) {
                    coord.setCoordinate(new Coordinate(coord.x, coord.y));
                }
            }
            geometry = ConverterUtil.toJGeometry(lineString, 4326);
        }
        if (geometry.getType() == JGeometry.GTYPE_MULTICURVE) { //LINE
            MultiLineString lineString = (MultiLineString) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < lineString.getNumGeometries(); i++) {
                for (Coordinate coord : lineString.getGeometryN(i).getCoordinates()) {
                    coord.setCoordinate(new Coordinate(coord.x, coord.y));
                }
            }
            geometry = ConverterUtil.toJGeometry(lineString, 4326);
        }

        if (geometry.getType() == JGeometry.GTYPE_POINT) { //POINT
            System.out.println("========= POINT =======");
            double[] point = geometry.getPoint();
            JGeometry newGeometry = new JGeometry(point[0], point[1], 4326);
            geometry = newGeometry;
        }
        if (geometry.getType() == JGeometry.GTYPE_MULTIPOINT) { //MILTIPOINT
            logger.log(LogWriter.WARNING, "TIPE GEOMETRY MULTIPOINT, Dimensi akhir belum diuji cobakan");
            MultiPoint points = (MultiPoint) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < points.getNumGeometries(); i++) {
                for (Coordinate coord : points.getGeometryN(i).getCoordinates()) {
                    coord.setCoordinate(new Coordinate(coord.x, coord.y));
                }
            }
            geometry = ConverterUtil.toJGeometry(points, 4326);
        }
        logger.log(LogWriter.INFO, "GEOMETRY SETELAH UDPATE " + geometry.getDimensions());
        return geometry;
    }
}
