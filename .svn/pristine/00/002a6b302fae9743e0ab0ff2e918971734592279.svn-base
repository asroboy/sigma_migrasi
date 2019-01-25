/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import com.vividsolutions.jts.geom.MultiPolygon;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.geotools.data.DataUtilities;
import org.geotools.data.memory.MemoryDataStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

/**
 *
 * @author Ridho
 */
public class MetodeBaruSDOtoSDEHelper {

    public void print(String message) {
        System.out.println("Message : " + message);
    }

    

    public void transformToShapeFile() {
        HashMap ketersiaans = new HashMap<>();
        try {
            File f = new File("c:/migrasi/tmp/keteresediaan_index.shp");
            ShapefileDataStore shapefile = new ShapefileDataStore(f.toURI().toURL());
            SimpleFeatureIterator features = shapefile.getFeatureSource().getFeatures().features();
            SimpleFeature shp;
            while (features.hasNext()) {
                shp = features.next();
                String id = (String) shp.getAttribute("NOMOR_PETA");
                String name = (String) shp.getAttribute("NAMA_PETA");
                String region = (String) shp.getAttribute("REGION");
                int skala = Integer.parseInt((String) shp.getAttribute("SKALA"));
                int status = Integer.parseInt((String) shp.getAttribute("STATUS"));
                MultiPolygon boundary = (MultiPolygon) shp.getDefaultGeometry();
//            CommunityArea ca = new CommunityArea(id, name, boundary);
//            communities.put(id, ca);
            }
            features.close();
            shapefile.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
 
}
