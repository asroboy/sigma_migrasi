/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import com.sigma.big.model.KeterseidaanIndex;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.tools.DatabaseTool;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.oracle.OraReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

/**
 *
 * @author Ridho
 */
public class MetodeBaruSDOtoSDE {

    static String path_produksi = "C:\\migrasi\\tmp\\produksi\\";
    static String path_index = "C:\\migrasi\\tmp\\ketersediaan_index\\";

    static DBConConfiguration DB_CONF_PROD = new DBConConfiguration();
    static Connection connectionSumber;
    static String SQL_GET_DATA = "SELECT * FROM IGD.ADMINISTRASI c WHERE METADATA = 'RBI1000020111102SUMATERA' AND  c.SHAPE.GET_GTYPE()=3";
    static String SQL_DELETE = "delete from IGD.TEMP_DATA_PT";
    static ArrayList<Administrasi> administrasies;
    static OraReader reader;
    static FeatureTypeHelper helper;
    static String[] fields = new String[]{"SHAPE", "ADMIN1", "ADMIN2", "FCODE", "KARKTR", "KDBBPS", "KDBPUM", "KDCBPS", "KDCPUM", "KDEBPS", "KDEPUM", "KDPBPS", "KDPKAB", "KDPPUM", "KELAS", "KLBADM", "LCODE", "LOKASI", "LUASWH", "METADATA", "NAMOBJ", "OBJECTID", "PELAKSANA", "PJGBTS", "REMARK", "SHAPE_AREA", "SHAPE_LENG", "SRS_ID", "STSBTS", "TIPADM", "TIPLOK", "TIPTBT", "UPDATED", "UUPP", "WADKC2", "WADMKC", "WADMKD", "WADMKK", "WADMPR", "WAKBK1", "WAKBK2", "WAKLD1", "WAKLD2", "WAPRO1", "WAPRO2", "WIADKC", "WIADKD", "WIADKK", "WIADPR"};
    static Class<?>[] classss = new Class<?>[]{Polygon.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, Double.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Double.class, Double.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};

    public static void main(String[] argv) {
        try {
            System.out.println("Mulai");
            reader = new OraReader();
            helper = new FeatureTypeHelper();
//            setupConnectionProd();
            convertNomorPetaToShp();

            getDataSumber();
            convertToShape();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(MetodeBaruSDOtoSDE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void insertIntoTempTable() throws SQLException {
//        connectionSumber.setAutoCommit(false);
        String sql = DatabaseTool.generateSqlInsertIntoTempTable("AR", "RBI1000020111102SUMATERA", "IGD", "ADMINISTRASI");
        System.out.println(sql);
        try (Statement stmt = connectionSumber.createStatement()) {
            stmt.execute(sql);
            stmt.close();
        }
    }

    static void deleteTempTable() throws SQLException {
        try (Statement stmt = connectionSumber.createStatement()) {
            stmt.execute(SQL_DELETE);
            stmt.close();
        }
    }

    //Mneghapus nomor peta nasional yang tidak dipakai
    static ArrayList<String> getNlpOfUnsur() throws SQLException, IOException {
        insertIntoTempTable();

        Statement stmt = connectionSumber.createStatement();
        String sql = "SELECT *  FROM metadata.KETERSEDIAAN_INDEX a, igd.temp_data_pt b   WHERE a.skala = 10000 AND a.status = 1 AND SDO_INSIDE(b.shape, a.shape) = 'TRUE'";
//         + " AND b.shape.get_gtype() in " + GeometryTool.getGeomCodes(geomType)

        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<String> nlps = new ArrayList<>();
        while (rs.next()) {
            String nl = rs.getString("NOMOR_PETA");
//            System.out.println("NOMOR PETA " + nl);
            nlps.add(nl);

        }
        rs.close();
        stmt.close();
        deleteTempTable();
        return nlps;
    }

    static void convertToShape() throws IOException {
        final SimpleFeatureType TYPE = null;
//        = helper.createFeatureType(fields, classss, "ADMINISTRASI_AR", 1);
        System.out.println("TYPE:" + TYPE);
        List<SimpleFeature> features = new ArrayList<>();
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
        SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(TYPE);
        for (Administrasi ki : administrasies) {
            /* Longitude (= x coord) first ! */
            System.out.println("Geom type " + ki.getSHAPE().getGeometryType());
            Polygon polygon = geometryFactory.createPolygon(ki.getSHAPE().getCoordinates());
            polygon.setSRID(4326);
            featureBuilder.add(polygon);
//            featureBuilder.add(polygon);
            featureBuilder.add(ki.getADMIN1());
            featureBuilder.add(ki.getADMIN2());
            featureBuilder.add(ki.getFCODE());
            featureBuilder.add(ki.getKARKTR());
            featureBuilder.add(ki.getKDBBPS());
            featureBuilder.add(ki.getKDBPUM());
            featureBuilder.add(ki.getKDCBPS());
            featureBuilder.add(ki.getKDCPUM());
            featureBuilder.add(ki.getKDEBPS());
            featureBuilder.add(ki.getKDEPUM());
            featureBuilder.add(ki.getKDPBPS());
            featureBuilder.add(ki.getKDPKAB());
            featureBuilder.add(ki.getKDPPUM());
            featureBuilder.add(ki.getKELAS());
            featureBuilder.add(ki.getKLBADM());
            featureBuilder.add(ki.getLCODE());
            featureBuilder.add(ki.getLOKASI());
            featureBuilder.add(ki.getLUASWH());
            featureBuilder.add(ki.getMETADATA());
            featureBuilder.add(ki.getNAMOBJ());
            int objectId = ki.getOBJECTID();
            System.out.println("object id " + objectId);
            featureBuilder.add(objectId);
            featureBuilder.add(ki.getPELAKSANA());
            featureBuilder.add(ki.getPJGBTS());
            featureBuilder.add(ki.getREMARK());
            featureBuilder.add(ki.getSHAPE_AREA());
            featureBuilder.add(ki.getSHAPE_LENGTH());
            featureBuilder.add(ki.getSRS_ID());
            featureBuilder.add(ki.getSTSBTS());
            featureBuilder.add(ki.getTIPADM());
            featureBuilder.add(ki.getTIPLOK());
            featureBuilder.add(ki.getTIPTBT());
            featureBuilder.add(ki.getUPDATED());
            featureBuilder.add(ki.getUUPP());
            featureBuilder.add(ki.getWADKC2());
            featureBuilder.add(ki.getWADMKC());
            featureBuilder.add(ki.getWADMKD());
            featureBuilder.add(ki.getWADMKK());
            featureBuilder.add(ki.getWADMPR());
            featureBuilder.add(ki.getWAKBK1());
            featureBuilder.add(ki.getWAKBK2());
            featureBuilder.add(ki.getWAKLD1());
            featureBuilder.add(ki.getWAKLD2());
            featureBuilder.add(ki.getWAPRO1());
            featureBuilder.add(ki.getWAPRO2());
            featureBuilder.add(ki.getWIADKC());
            featureBuilder.add(ki.getWIADKD());
            featureBuilder.add(ki.getWIADKK());
            featureBuilder.add(ki.getWIADPR());

            SimpleFeature feature = featureBuilder.buildFeature(null);
            features.add(feature);
        }

        File newFile = helper.getNewShapeFile(path_produksi, "ADMINISTRASI_AR");
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
//            SimpleFeatureType SHAPE_TYPE = featureSource.getSchema();
//            System.out.println("SHAPE:" + SHAPE_TYPE);
        if (featureSource instanceof SimpleFeatureStore) {
            SimpleFeatureStore featureStore = (SimpleFeatureStore) featureSource;
            SimpleFeatureCollection collection = new ListFeatureCollection(TYPE, features);
            featureStore.setTransaction(transaction);
            try {
                featureStore.addFeatures(collection);
                transaction.commit();
            } catch (Exception problem) {
                problem.printStackTrace();
                transaction.rollback();
            } finally {
                transaction.close();
            }
//            System.exit(0); // success!
        } else {
            System.out.println(typeName + " does not support read/write access");
//            System.exit(1);
        }

    }

    public static void getDataSumber() throws SQLException {
        administrasies = new ArrayList<>();
        Statement stmt = connectionSumber.createStatement();
        ResultSet rs = stmt.executeQuery(SQL_GET_DATA);
        while (rs.next()) {
            Administrasi adm = new Administrasi();
            adm.setADMIN1(rs.getString("ADMIN1"));
            adm.setADMIN2(rs.getString("ADMIN2"));
            adm.setFCODE(rs.getString("FCODE"));
            adm.setKARKTR(rs.getInt("KARKTR"));
            adm.setKDBBPS(rs.getString("KDBBPS"));
            adm.setKDBPUM(rs.getString("KDBPUM"));
            adm.setKDCBPS(rs.getString("KDCBPS"));
            adm.setKDCPUM(rs.getString("KDCPUM"));
            adm.setKDEBPS(rs.getString("KDEBPS"));
            adm.setKDPKAB(rs.getString("KDPKAB"));
            adm.setKDPPUM(rs.getString("KDPPUM"));
            adm.setKELAS(rs.getInt("KELAS"));
            adm.setKLBADM(rs.getInt("KLBADM"));
            adm.setLCODE(rs.getString("LCODE"));
            adm.setLOKASI(rs.getInt("LOKASI"));
            adm.setLUASWH(rs.getDouble("LUASWH"));
            adm.setMETADATA(rs.getString("METADATA"));
            adm.setNAMOBJ(rs.getString("NAMOBJ"));
            adm.setOBJECTID(rs.getInt("OBJECTID"));
            adm.setPELAKSANA(rs.getString("PELAKSANA"));
            adm.setPJGBTS(rs.getString("PJGBTS"));
            adm.setREMARK(rs.getString("REMARK"));
            Geometry geometry = reader.read((STRUCT) rs.getObject("SHAPE"));
            adm.setSHAPE(geometry);
            adm.setSHAPE_AREA(rs.getDouble("SHAPE_AREA"));
            adm.setSHAPE_LENGTH(rs.getDouble("SHAPE_LENGTH"));
            adm.setSRS_ID(rs.getString("SRS_ID"));
            adm.setSTSBTS(rs.getInt("STSBTS"));
            adm.setTIPADM(rs.getInt("TIPADM"));
            adm.setTIPLOK(rs.getInt("TIPLOK"));
            adm.setTIPTBT(rs.getInt("TIPTBT"));
            adm.setUPDATED(rs.getString("UPDATED"));
            adm.setUUPP(rs.getString("UUPP"));
//            adm.setWADKC1(rs.getString("WADKC1"));
            adm.setWADKC2(rs.getString("WADKC2"));
            adm.setWADMKC(rs.getString("WADMKC"));
            adm.setWADMKD(rs.getString("WADMKD"));
            adm.setWADMKK(rs.getString("WADMKK"));
            adm.setWADMPR(rs.getString("WADMPR"));
            adm.setWAKBK1(rs.getString("WAKBK1"));
            adm.setWAKBK2(rs.getString("WAKBK2"));
            adm.setWAKLD1(rs.getString("WAKLD1"));
            adm.setWAKLD2(rs.getString("WAKLD2"));
            adm.setWAPRO1(rs.getString("WAPRO1"));
            adm.setWAPRO2(rs.getString("WAPRO2"));
            adm.setWIADKC(rs.getString("WIADKC"));
            adm.setWIADKD(rs.getString("WIADKD"));
            adm.setWIADKK(rs.getString("WIADKK"));
            adm.setWIADPR(rs.getString("WIADPR"));

            administrasies.add(adm);
        }
        rs.close();
        stmt.close();
    }

    public static void setupConnectionProd() throws IOException {
        DB_CONF_PROD.setHost("192.168.3.105");
        DB_CONF_PROD.setPort(1521);
        DB_CONF_PROD.setSid("dbpprt");
        DB_CONF_PROD.setServiceName("");
        DB_CONF_PROD.setUsername("IGD");
        DB_CONF_PROD.setPassword("IGD");
        connectionSumber = DatabaseTool.getConnection(DB_CONF_PROD, null);
    }

    public static ArrayList<KeterseidaanIndex> getNomorPetas() throws IOException, SQLException {
        ArrayList<KeterseidaanIndex> keterseidaanIndexs = new ArrayList<>();
        String nlps = "";
        int i = 0;
        ArrayList<String> dataNlp = getNlpOfUnsur();
        for (String nlp : dataNlp) {
            if (i < dataNlp.size() - 1) {
                nlps += "'" + nlp + "'" + ",";
            } else {
                nlps += "'" + nlp + "'";
            }
            i++;
        }
        if (connectionSumber != null) {
            String sql = "SELECT * FROM METADATA.KETERSEDIAAN_INDEX WHERE SKALA = 5000";
            System.out.println(sql);
            Statement stmt = connectionSumber.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                KeterseidaanIndex ki = new KeterseidaanIndex();
                String namaPeta = rs.getString("NAMA_PETA");
                ki.setNamaPeta(namaPeta);
                ki.setNomorPeta(rs.getString("NOMOR_PETA"));
                ki.setRegion(rs.getString("REGION"));
                ki.setSkala(Integer.parseInt(rs.getString("SKALA")));
                ki.setStatus(Integer.parseInt(rs.getString("STATUS")));
                System.out.println(namaPeta);

                Geometry geometry = reader.read((STRUCT) rs.getObject("SHAPE"));
                ki.setShape(geometry);
                keterseidaanIndexs.add(ki);
            }
        } else {
            System.out.println("Koneksi null");
        }

        return keterseidaanIndexs;
    }

    public static void convertNomorPetaToShp() {
        try {
            // Set cross-platform look & feel for compatability
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            final SimpleFeatureType TYPE = createFeatureTypeKeterSediaanIndex();
            System.out.println("TYPE:" + TYPE);

            List<SimpleFeature> features = new ArrayList<>();

            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

            SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(TYPE);
            try {
                for (KeterseidaanIndex ki : getNomorPetas()) {

                    /* Longitude (= x coord) first ! */
                    System.out.println("Geom type " + ki.getShape().getGeometryType());
                    if (ki.getShape().getGeometryType().equalsIgnoreCase("MultiPolygon")) {
                        Polygon[] polygons = new Polygon[ki.getShape().getNumGeometries()];
                        for (int i = 0; i < ki.getShape().getNumGeometries(); i++) {
                            Polygon polygon = geometryFactory.createPolygon(ki.getShape().getGeometryN(i).getCoordinates());
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

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (SQLException ex) {
                System.out.println(ex);
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

            //============================
            /*
             * Write the features to the shapefile
             */
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
                } catch (Exception problem) {
                    problem.printStackTrace();
                    transaction.rollback();
                } finally {
                    transaction.close();
                }
//                System.exit(0); // success!
            } else {
                System.out.println(typeName + " does not support read/write access");
//                System.exit(1);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static SimpleFeatureType createFeatureTypeKeterSediaanIndex() {

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
