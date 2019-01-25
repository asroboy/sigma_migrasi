/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import com.sigma.big.model.KeterseidaanIndex;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.bigmigrasi.db.ConnectionConfiguration;
import com.sigma.migrationtool.PythonHelper;
import com.sigma.migrationtool.test.FeatureTypeHelper;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.oracle.OraReader;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import oracle.sql.STRUCT;
import org.geotools.data.DefaultTransaction;
import org.geotools.data.Transaction;
import org.geotools.data.collection.ListFeatureCollection;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.shapefile.files.ShpFiles;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

/**
 *
 * @author Ridho
 */
public class MigrasiShapeHelper {

    LogWriter logger;
    PythonHelper pythonHelper;
    DBConConfiguration conftarget;
    String skemaName;
    String unsurName;
    String skala;
    String mapping = "";
    String path_produksi = "C:\\migrasi\\tmp\\produksi\\";
    String path_index = "C:\\migrasi\\tmp\\ketersediaan_index\\";

    public static final int CODE_CONVERT_SDO_TO_SHAPEFILE = 0;
    public static final int CODE_CALCULATE_INDEX = 1;
    public static final int CODE_EXPORT_GDB_TO_SHAPEFILE = 2;
    public static final int CODE_ERASE_FEATURE = 3;
    public static final int CODE_MIG_SHP_PROD_TO_PUB = 4;
    public static final int CODE_MIG_SHP_HASIL_TO_PUB = 5;
    public static final int CODE_CLEAR_PUB = 6;
    public static final int CODE_CREATE_SDE_CONNECTION = 7;

    public CompleteListener listener = new CompleteListener() {
        @Override
        public void onComplete(int code) {
            try {
                if (code == MigrasiShapeHelper.CODE_CONVERT_SDO_TO_SHAPEFILE) {
                    logger.log(LogWriter.INFO, "== CALCULATE INDEX ==");
                    String path_c = "C:\\migrasi\\tmp\\ketersediaan_index\\" + unsurName + "_CENTEROID.shp";
                    File f_c = new File(path_c);
                    if (f_c.exists() && !f_c.isDirectory()) {
                        deleteShapefile(path_c);
                    }

                    String path_ki = "C:\\migrasi\\tmp\\ketersediaan_index\\ketersediaan_index.shp";
                    File f_ki = new File(path_ki);
                    if (f_ki.exists() && !f_ki.isDirectory()) {
                        deleteShapefile(path_ki);
                    }
                    
                    String path_intersect = "C:\\migrasi\\tmp\\ketersediaan_index\\"+unsurName+"_INTERSECT.shp";
                    File f_intersect = new File(path_intersect);
                    if (f_intersect.exists() && !f_intersect.isDirectory()) {
                        deleteShapefile(path_intersect);
                    }
                     String path_intersect_point = "C:\\migrasi\\tmp\\ketersediaan_index\\"+unsurName+"_INTERSECT_POINT.shp";
                    File f_intersect_p = new File(path_intersect_point);
                    if (f_intersect_p.exists() && !f_intersect_p.isDirectory()) {
                        deleteShapefile(path_intersect_point);
                    }
                    pythonHelper.calculateIndex(unsurName, skala, listener);
                }
                
                if(code == MigrasiShapeHelper.CODE_CALCULATE_INDEX){
                    pythonHelper.buildSdeConnection(conftarget.getHost(), conftarget.getSid(), skemaName, listener);
                }
                if (code == MigrasiShapeHelper.CODE_CREATE_SDE_CONNECTION) {
                    
                    logger.log(LogWriter.INFO, "== REMOVE DATA PUBLIKASI PADA KETERSEDIAAN INDEX ==");
                    pythonHelper.eraseFeature(skemaName, unsurName, listener);
//                    logger.log(LogWriter.INFO, "== CONVERT PUB TO SHP ==");
//                    String path = "C:\\migrasi\\tmp\\publikasi\\" + unsurName + ".shp";
//                    File f = new File(path);
//                    if (f.exists() && !f.isDirectory()) {
//                        deleteShapefile(path);
//                    }
//                    pythonHelper.exportGdbToShapefile(conftarget.getHost(), conftarget.getSid(), skemaName, unsurName, mapping, listener);
                }
                if (code == MigrasiShapeHelper.CODE_EXPORT_GDB_TO_SHAPEFILE) {
                    logger.log(LogWriter.INFO, "== REMOVE DATA PUBLIKASI PADA KETERSEDIAAN INDEX ==");
                    String path = "C:\\migrasi\\tmp\\output\\" + unsurName + ".shp";
                    File f = new File(path);
                    if (f.exists() && !f.isDirectory()) {
                        deleteShapefile(path);
                    }

                    pythonHelper.eraseFeature(skemaName, unsurName, listener);
                }
                if (code == MigrasiShapeHelper.CODE_ERASE_FEATURE) {
                    logger.log(LogWriter.INFO, "== CLEAR DATA PUBLIKASI ==");
                    pythonHelper.hapusDataPublikasi(skemaName, unsurName, mapping, listener);
                }
                if (code == MigrasiShapeHelper.CODE_CLEAR_PUB) {
                    logger.log(LogWriter.INFO, "== MIGRASI DATA PROD KE PUBLIKASI ==");
                    pythonHelper.exportShpProdToPub(skemaName, unsurName, mapping, listener);
                }

                if (code == MigrasiShapeHelper.CODE_MIG_SHP_PROD_TO_PUB) {
                    logger.log(LogWriter.INFO, "== MIGRASI DATA OUT OF INDEX KE PUBLIKASI ==");
                    pythonHelper.exportShpHasilToPub(skemaName, unsurName, mapping, listener);
                }
                if (code == MigrasiShapeHelper.CODE_MIG_SHP_HASIL_TO_PUB) {

//                    deleteShapefile("C:\\migrasi\\tmp\\produksi\\" + unsurName + ".shp");
//                    deleteShapefile("C:\\migrasi\\tmp\\output\\" + unsurName + ".shp");
//                    deleteShapefile("C:\\migrasi\\tmp\\ketersediaan_index\\" + unsurName + "_CENTEROID.shp");
//                    deleteShapefile("C:\\migrasi\\tmp\\ketersediaan_index\\ketersediaan_index.shp");

                    logger.log(LogWriter.INFO, "Selesai");

                }
            } catch (IOException ex) {
                Logger.getLogger(MigrasiShapeHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void onFailed(int code) {
        }
    };

    
    /**
     * Menghapus shapefile pada path tertentu
     * @param path 
     */
    public void deleteShapefile(String path) {
        try {
            File file = new File(path);
            ShpFiles shp = new ShpFiles(file);
            shp.delete();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MigrasiShapeHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MigrasiShapeHelper(LogWriter logger, DBConConfiguration conftarget, String skemaName, String unsurName, String skala) {
        try {
            this.logger = logger;
            pythonHelper = new PythonHelper(logger, DatabaseTool.getConnection(conftarget, logger));
            this.conftarget = conftarget;
            this.skemaName = skemaName;
            this.skala = skala;
            this.unsurName = unsurName;
        } catch (IOException ex) {
            Logger.getLogger(MigrasiShapeHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * Mengkonversi data produksi di db SDO menjadi SHP (shapefile)
     * @param fileIdentifierBaruRelease
     * @param columNames
     * @param dataTypes
     * @param namaUnsur
     * @param rs
     * @param geomType
     * @param listener
     * @throws IOException
     * @throws SQLException 
     */
    //ArrayList<KeterseidaanIndex> nomorPetas    
    public void convertSdoToShapefile(String fileIdentifierBaruRelease, String[] columNames, String[] dataTypes, String namaUnsur, ResultSet rs, int geomType, CompleteListener listener) throws IOException, SQLException {

        logger.log(LogWriter.INFO, "Mengkonversi data produksi " + namaUnsur + " ke shapefile");
        FeatureTypeHelper helper = new FeatureTypeHelper();
        OraReader reader = new OraReader();
        SimpleFeatureType TYPE = helper.createFeatureType(columNames, dataTypes, namaUnsur, geomType);
        System.out.println("TYPE:" + TYPE);
//        logger.log(LogWriter.INFO, "TYPE:" + TYPE);
        List<SimpleFeature> features = new ArrayList<>();
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
        SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(TYPE);

        mapping = getMappingFormat(columNames);
        while (rs.next()) {
            Geometry geom = reader.read((STRUCT) rs.getObject("SHAPE"));
            System.out.println("=======> GEOM TYPE: " + geomType);
            Geometry ge = geometryFactory.createGeometry(geom);
            geom.setSRID(4326);
            featureBuilder.add(ge);
//            if (geomType == GeometryTool.POLYGON) {
//                Polygon polygon = geometryFactory.createPolygon(geom.getCoordinates());
//                polygon.setSRID(4326);
//                featureBuilder.add(polygon);
//            }
//            if (geomType == GeometryTool.LINESTRING) {
//                LineString linestring = geometryFactory.createLineString(geom.getCoordinates());
//                linestring.setSRID(4326);
//                featureBuilder.add(linestring);
//            }
//            if (geomType == GeometryTool.POINT) {
//                Point point = geometryFactory.createPoint(geom.getCoordinate());
//                point.setSRID(4326);
//                featureBuilder.add(point);
//            }

            for (int i = 0; i < columNames.length; i++) {

                String key = columNames[i];
                if (!key.equalsIgnoreCase("SHAPE")) {
                    String className = dataTypes[i];
                    if (key.equalsIgnoreCase("METADATA")) {
                        String data = rs.getString(key);
                        System.out.println(key + ": " + fileIdentifierBaruRelease);
                        featureBuilder.add(fileIdentifierBaruRelease);

                    } else {
                        if (className.equalsIgnoreCase("STRING")
                                || className.equalsIgnoreCase("varchar2")
                                || className.equalsIgnoreCase("varchar")) {
                            String data = rs.getString(key);
                            System.out.println(key + ": " + data);
                            featureBuilder.add(data);
                        } else if (className.equalsIgnoreCase("INTEGER")
                                || className.equalsIgnoreCase("NUMBER")
                                || className.equalsIgnoreCase("INT")) {
                            int dataInt = rs.getInt(key);
                            System.out.println(key + ": " + dataInt);
                            featureBuilder.add(dataInt);
                        } else if (className.equalsIgnoreCase("BOOLEAN")) {
                            boolean data = rs.getBoolean(key);
                            System.out.println(key + ": " + data);
                            featureBuilder.add(data);
                        } else if (className.equalsIgnoreCase("float")) {
                            Double data = rs.getDouble(key);
                            System.out.println(key + ": " + data);
                            featureBuilder.add(data);
                        } else if (className.equalsIgnoreCase("DATE")) {
                            Date data = rs.getDate(key);
                            System.out.println(key + ": " + data);
                            featureBuilder.add(data);
                        } else {
                            String data = rs.getString(key);
                            System.out.println(key + ": " + data);
                            featureBuilder.add(data);
                        }
                    }

                }
            }
            SimpleFeature feature = featureBuilder.buildFeature(null);
            features.add(feature);
        }

        File newFile = helper.getNewShapeFile(path_produksi, namaUnsur);
        ShapefileDataStoreFactory dataStoreFactory = new ShapefileDataStoreFactory();
        Map<String, Serializable> params = new HashMap<>();
        params.put("url", newFile.toURI().toURL());
        params.put("create spatial index", Boolean.TRUE);
        ShapefileDataStore newDataStore
                = (ShapefileDataStore) dataStoreFactory.createNewDataStore(params);

        newDataStore.createSchema(TYPE);
        Transaction transaction = new DefaultTransaction("create");
        String typeName = newDataStore.getTypeNames()[0];
        SimpleFeatureSource featureSource = newDataStore.getFeatureSource(typeName);
        if (featureSource instanceof SimpleFeatureStore) {
            SimpleFeatureStore featureStore = (SimpleFeatureStore) featureSource;
            SimpleFeatureCollection collection = new ListFeatureCollection(TYPE, features);
            featureStore.setTransaction(transaction);
            try {
                featureStore.addFeatures(collection);
                transaction.commit();
                logger.log(LogWriter.INFO, "Shapefile berhasil dibuat");
//                convertNomorPetaToShp(nomorPetas);
                listener.onComplete(CODE_CONVERT_SDO_TO_SHAPEFILE);
            } catch (IOException problem) {
                problem.printStackTrace();
                transaction.rollback();
            } finally {
                transaction.close();
                System.out.println("Done creating shapefile of data");
            }
        } else {
            System.out.println(typeName + " does not support read/write access");
            listener.onFailed(CODE_CONVERT_SDO_TO_SHAPEFILE);
        }

    }

    /**
     * Generate struktur mapping shapefile
     * @param columNames
     * @return 
     */
    public String getMappingFormat(String[] columNames) {
        String mapping = "";
        for (int i = 0; i < columNames.length; i++) {
            String key = columNames[i];
            if (!key.equalsIgnoreCase("SHAPE")) {
                mapping += key;
                if (i < columNames.length - 1) {
                    mapping += ";";
                }
            }
        }
        return mapping;
    }

    /**
     * Mengkonversi index(NLP ke dalam shapefile (shp)
     * @param nomorPetas 
     */
    public void convertNomorPetaToShp(ArrayList<KeterseidaanIndex> nomorPetas) {
        try {
            // Set cross-platform look & feel for compatability
            logger.log(LogWriter.INFO, "Mengkonversi data NLP ke shapefile");
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            FeatureTypeHelper helper = new FeatureTypeHelper();
            final SimpleFeatureType TYPE = helper.createFeatureTypeKeterSediaanIndex();
            System.out.println("TYPE:" + TYPE);

            List<SimpleFeature> features = new ArrayList<>();

            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

            SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(TYPE);
            for (KeterseidaanIndex ki : nomorPetas) {
                System.out.println("Geom type " + ki.getShape().getGeometryType());
                if (ki.getShape().getGeometryType().equalsIgnoreCase("MultiPolygon")) {
                    Polygon[] polygons = new Polygon[ki.getShape().getNumGeometries()];
                    for (int i = 0; i < ki.getShape().getNumGeometries(); i++) {
                        Polygon polygon = geometryFactory.createPolygon(ki.getShape().getGeometryN(i).getCoordinates());
                        polygon.setSRID(4326);
                        polygons[i] = polygon;
                    }
                    MultiPolygon multipolygon = geometryFactory.createMultiPolygon(polygons);
                    multipolygon.setSRID(4326);
                    featureBuilder.add(multipolygon);
                    featureBuilder.add(ki.getNamaPeta());
                    featureBuilder.add(ki.getNomorPeta());
                    featureBuilder.add(ki.getRegion());
                    featureBuilder.add(ki.getSkala());
                    featureBuilder.add(ki.getStatus());
                    SimpleFeature feature = featureBuilder.buildFeature(null);
                    features.add(feature);
                }

            }

            /*
             * Get an output file name and create the new shapefile
             */
            File newFile = helper.getNewShapeFile(path_index, "ketersediaan_index");

            ShapefileDataStoreFactory dataStoreFactory = new ShapefileDataStoreFactory();

            Map<String, Serializable> params = new HashMap<>();
            params.put("url", newFile.toURI().toURL());
            params.put("create spatial index", Boolean.TRUE);

            ShapefileDataStore newDataStore
                    = (ShapefileDataStore) dataStoreFactory.createNewDataStore(params);
            /*
             * TYPE is used as a template to describe the file contents
             */
            newDataStore.createSchema(TYPE);
            Transaction transaction = new DefaultTransaction("create");

            String typeName = newDataStore.getTypeNames()[0];
            SimpleFeatureSource featureSource = newDataStore.getFeatureSource(typeName);
//            SimpleFeatureType SHAPE_TYPE = featureSource.getSchema();
//            System.out.println("SHAPE:" + SHAPE_TYPE);

            if (featureSource instanceof SimpleFeatureStore) {
                SimpleFeatureStore featureStore = (SimpleFeatureStore) featureSource;
                SimpleFeatureCollection collection = new ListFeatureCollection(TYPE, features);
                featureStore.setTransaction(transaction);
                try {
                    featureStore.addFeatures(collection);
                    transaction.commit();
                } catch (IOException problem) {
                    transaction.rollback();
                } finally {
                    logger.log(LogWriter.INFO, "Selesai mengkonversi data NLP ke shapefile");
                    transaction.close();
                }

//                pythonHelper.exportGdbToShapefile(conftarget.getHost(), conftarget.getSid(), skemaName, unsurName, mapping);
            } else {
                logger.log(LogWriter.WARNING, typeName + " does not support read/write access");
                System.out.println(typeName + " does not support read/write access");
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public interface CompleteListener {

        public void onComplete(int code);

        public void onFailed(int code);
    }

}
