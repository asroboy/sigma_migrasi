/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import com.sigma.big.tools.GeometryTool;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.feature.simple.SimpleFeatureType;

/**
 *
 * @author Ridho
 */
public class FeatureTypeHelper {

    //HashMap<String, Attributes> attrHashMap
    public SimpleFeatureType createFeatureType(String[] columNames, String[] dataTypes, String name, int geomType) {
        SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
        builder.setName(name);
//        builder.setCRS(DefaultGeographicCRS.WGS84);
//        builder.srid(4326);

        if (geomType == GeometryTool.POLYGON) {
            builder.add("the_geom", Polygon.class);
        }
        if (geomType == GeometryTool.LINESTRING) {
            builder.add("the_geom", LineString.class);
        }
        if (geomType == GeometryTool.POINT) {
            builder.add("the_geom", Point.class);
        }
        if (geomType == GeometryTool.MULTILINESTRING) {
            builder.add("the_geom", MultiLineString.class);
        }
        if (geomType == GeometryTool.MULTIPOLYGON) {
            builder.add("the_geom", MultiPolygon.class);
        }
        if (geomType == GeometryTool.MULTIPOINT) {
            builder.add("the_geom", Point.class);
        }
        System.out.println("DEFAULT GEOMETRY " + builder.getDefaultGeometry());
        for (int i = 0; i < columNames.length; i++) {

            if (!columNames[i].equalsIgnoreCase("SHAPE")) {
                System.out.println("KEY : " + columNames[i] + " - " + getClassName(dataTypes[i]).getSimpleName());
                builder.add(columNames[i], getClassName(dataTypes[i]));
            }

        }

        // build the type
        final SimpleFeatureType LOCATION = builder.buildFeatureType();
        return LOCATION;
    }

    public Class<? extends Object> getClassName(String className) {
        if (className.equalsIgnoreCase("STRING")
                || className.equalsIgnoreCase("varchar2")
                || className.equalsIgnoreCase("varchar")) {
            return String.class;
        } else if (className.equalsIgnoreCase("INTEGER")
                || className.equalsIgnoreCase("NUMBER")
                || className.equalsIgnoreCase("INT")) {
            return Integer.class;
        } else if (className.equalsIgnoreCase("BOOLEAN")) {
            return Boolean.class;
        } else if (className.equalsIgnoreCase("float")) {
            return Double.class;
        } else if (className.equalsIgnoreCase("DATE")) {
            return Date.class;
        } else {
            return String.class;
        }
    }

    public File getNewShapeFile(String path, String name) throws IOException {
        String tmpPath = "C:\\migrasi\\tmp";
        File tmpdir = new File(tmpPath);
        if (!tmpdir.exists()) {
            tmpdir.mkdir();
        }
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String newPath = path + name + ".shp";
        File newFile = new File(newPath);
        return newFile;
    }

    public SimpleFeatureType createFeatureTypeKeterSediaanIndex() {

        SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
        builder.setName("KetersediaanIndex");
//        builder.setCRS(DefaultGeographicCRS.WGS84);
//        builder.srid(4326);

        // add attributes in order
        builder.add("the_geom", MultiPolygon.class); // nama the_geom tidak bisa dirubah
        builder.length(50).add("nama_peta", String.class);
        builder.add("nomor_peta", String.class);
        builder.add("region", String.class);
        builder.add("skala", Integer.class);
        builder.add("status", Integer.class);

        // build the type
        final SimpleFeatureType LOCATION = builder.buildFeatureType();
        return LOCATION;
    }
}
