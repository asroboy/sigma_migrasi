/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import com.sigma.big.model.db.Attributes;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.model.db.Mapping;
import com.sigma.bigmigrasi.db.DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ridho
 */
public class DatabaseTool {

    public static boolean isTableExists(Connection conn, String tableName) throws SQLException {
        String sql = "SELECT TABLE_NAME FROM USER_TABLES WHERE TABLE_NAME = \'" + tableName + "\'";
        Statement tmt = conn.createStatement();
        ResultSet rs = tmt.executeQuery(sql);
        boolean isExists = rs.next();

        tmt.close();
        rs.close();
        return isExists;
    }

    public static String generateSQLCheckMetadataDiTableTarget(String skemaTarget, String namaTableUnsur) {
        return "select DISTINCT metadata , fcode from " + skemaTarget + "." + namaTableUnsur;
    }

    public static String getSQLBoundingBox(String namaSkema, String namaTable, String fileIdentifier, String geomCode) {
        return "SELECT MDSYS.SDO_AGGR_MBR(SHAPE) AS AGGR_MBR FROM " + namaSkema + "." + namaTable + " b WHERE METADATA =\'" + fileIdentifier + "\' AND b.shape.get_gtype() in " + geomCode;
    }

    public static String generateSQLGetProduksi(String namaSkema, Mapping mapping, String namaUnsur) {
        HashMap<String, Attributes> attributes = mapping.getAttributes();
        String sql = "SELECT ";
        int i = 0;
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
//            String key = entry.getKey();
            Attributes value = entry.getValue();
            if (value.getDataTypeSumber().equalsIgnoreCase("GEOMETRY")) {
                sql += "SDO_UTIL.TO_WKTGEOMETRY(" + value.getNamaSumber() + ") as SHAPE";
            } else {
                sql += value.getNamaSumber();
            }
            if (i < attributes.size() - 1) {
                sql += ",";
            }
            i++;
        }

        sql += " FROM " + namaSkema + "." + namaUnsur;
        return sql;
    }

    public static String generateSQLGetGeomType(String namaSkema, String namaUnsur, String fileIdentifier) {
        return "select DISTINCT c.SHAPE.GET_GTYPE() as G_TYPE from " + namaSkema + "." + namaUnsur + " c WHERE METADATA = \'" + fileIdentifier + "\'";

    }

    public static String generateSQLGetProduksi(String namaSkema, ArrayList<String> attributes, String namaUnsur, String fileIdentifier, String geomCode) {
        String sql = "SELECT c.SHAPE.GET_GTYPE() AS G_TYPE, ";
        int i = 0;
        for (String attribute : attributes) {
//            String key = entry.getKey();

            if (attribute.equalsIgnoreCase("SHAPE")) {
                //MENGGUNAKAN TIPE WKB PADA SAAT INSERT
                sql += attribute + " ";
//                sql += "SDO_UTIL.TO_WKTGEOMETRY(" + attribute + ") as SHAPE";
            } else {
                sql += attribute;
            }
            if (i < attributes.size() - 1) {
                sql += ", ";
            }
            i++;
        }

        sql += " FROM " + namaSkema + "." + namaUnsur + " c";
        sql += " WHERE METADATA = \'" + fileIdentifier + "\'"
                + " AND c.SHAPE.GET_GTYPE() in " + geomCode;
        //FIELD WADMKD HANYA UNTUK ADMINISTRASI , BELUM BISA DIGUNAKAN UNTUK UNSUR LAIN
        //sql += " AND TRIM(WADMKD) IS NOT NULL";
        return sql;
    }

    public static String generateTruncateUnsur(Mapping mapping) {
        return "TRUNCATE TABLE " + mapping.getSkemaTarget() + "." + mapping.getTabelTarget();
    }

    public static String generateTruncateUnsur(Unsur unsur, Mapping mapping) {
//        return "TRUNCATE TABLE " + unsur.getMapping().getSkemaTarget() + "." + mapping.getTabelTarget() + "  DROP STORAGE";
        return "DELETE FROM " + mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + " ";
    }

    public static String generateSRIDUnsurPublikasi(String skemaTarget, String namaUnsurTarget) {
        return "SELECT SRID FROM SDE.ST_GEOMETRY_COLUMNS WHERE OWNER = \'" + skemaTarget + "\' AND table_name = \'" + namaUnsurTarget + "\'";
    }

    public static String generateSQLInsertPuplikasi(Mapping mapping, int SRID) {
        String sql = "INSERT INTO " + mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + " (";
        HashMap<String, Attributes> attributes = mapping.getAttributes();
        int i = 0;
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
            String key = entry.getKey();
            Attributes value = entry.getValue();
            sql += key.toUpperCase();
            if (i < attributes.size() - 1) {
                sql += ",";
            }

            i++;
        }
        sql += ") VALUES (";
        int j = 0;
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
            String key = entry.getKey();
            Attributes value = entry.getValue();
            if (value.getDataTypeTarget().equalsIgnoreCase("geometry")) {
                sql += "SDE.st_geomfromtext (?," + SRID + ")";
            } else if (value.getNamaSumber().equalsIgnoreCase("OBJECTID")) {
                sql += mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + "_SEQ.NEXTVAL ";
            } else {
                sql += "?";
            }
            if (j < attributes.size() - 1) {
                sql += ",";
            }
            j++;
        }
        sql += ")";
        return sql;
    }

    public static String generateSQLInsertPuplikasiManual(Mapping mapping, int SRID) {
        String sql = "declare \n   "
                + " wkt clob;\n"
                + "BEGIN\n";
        sql += "wkt := '';\n";
        sql += "INSERT INTO " + mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + " (";
        HashMap<String, Attributes> attributes = mapping.getAttributes();
        int i = 0;
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
            String key = entry.getKey();
            sql += key.toUpperCase();
            if (i < attributes.size() - 1) {
                sql += ", ";
            }

            i++;
        }
        sql += ") VALUES (";
        int j = 0;
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
            Attributes value = entry.getValue();
            if (value.getDataTypeTarget().equalsIgnoreCase("geometry")) {
                //MENERIMA OBJECT GEOMETRI DAN MENGUBAHNYA MENJADI ST_GEOMETRY DENGAN COVERT KE WKB TERLEBIH DAHULU
//                sql += "SDE.ST_GEOMFROMWKB(SDO_UTIL.TO_WKBGEOMETRY(?)," + SRID + ")";
                sql += "SDE.ST_GEOMFROMWKB(?," + SRID + ")";
//                sql += "SDE.ST_GEOMETRY(?," + SRID + ")";
            } else if (value.getNamaSumber().equalsIgnoreCase("OBJECTID")) {
                sql += "?";
//                sql += mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + "_SEQ.NEXTVAL ";
            } else {
                sql += "?";
            }
            if (j < attributes.size() - 1) {
                sql += ",";
            }
            j++;
        }
        sql += ");\n"
                + "END;";
        return sql;
    }
    
    
    public static String generateSQLInsertPuplikasiManualForAR(Mapping mapping, int SRID) {
        String sql = "declare \n   "
                + " wkt clob;\n"
                + "BEGIN\n";
        sql += "wkt := '';\n";
        sql += "INSERT INTO " + mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + " (";
        HashMap<String, Attributes> attributes = mapping.getAttributes();
        int i = 0;
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
            String key = entry.getKey();
            sql += key.toUpperCase();
            if (i < attributes.size() - 1) {
                sql += ", ";
            }

            i++;
        }
        sql += ") VALUES (";
        int j = 0;
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
            Attributes value = entry.getValue();
            if (value.getDataTypeTarget().equalsIgnoreCase("geometry")) {
                //MENERIMA OBJECT GEOMETRI DAN MENGUBAHNYA MENJADI ST_GEOMETRY DENGAN COVERT KE WKB TERLEBIH DAHULU
                sql += "SDE.ST_GEOMETRY(?," + SRID + ")";
//                sql += "SDE.ST_GEOMFROMWKB(?," + SRID + ")";
//                sql += "SDE.ST_GEOMETRY(?," + SRID + ")";
            } else if (value.getNamaSumber().equalsIgnoreCase("OBJECTID")) {
                sql += "?";
//                sql += mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + "_SEQ.NEXTVAL ";
            } else {
                sql += "?";
            }
            if (j < attributes.size() - 1) {
                sql += ",";
            }
            j++;
        }
        sql += ");\n"
                + "END;";
        return sql;
    }

    public static String getNumberRows(String namaSkema, String namaUnsur, String fileIdentifier, String FCODE) {
        String sql = "SELECT COUNT(*) AS CNT FROM " + namaSkema + "." + namaUnsur;
//                + " WHERE METADATA=\'" + fileIdentifier + "\' AND FCODE=" + FCODE;
        return sql;
    }

    public static String getNumberRows(String namaSkema, String namaUnsur, String fileIdentifier) {
        String sql = "SELECT COUNT(*) AS CNT FROM " + namaSkema + "." + namaUnsur + " WHERE METADATA=\'" + fileIdentifier + "\'";;
        return sql;
    }

    public static String generateSQLGetSourceWithPaging(String namaSkema, Mapping mapping, LogWriter logger, ArrayList<String> common, String fileIdentifier, String whereClause, int rowMin, int rowMax) throws IOException {
        String sql = "SELECT * FROM (\n"
                + "SELECT ROWNUM R, SUBQ.* \n"
                + "  FROM \n"
                + "    (SELECT sde.st_geometrytype(SHAPE) as GEOMTYPE, SDE.ST_SRID(SHAPE) as SRID, ";

        String skema = (namaSkema == null) ? "" : (namaSkema + ".");
        HashMap<String, Attributes> mappingColumns = mapping.getAttributes();

        if (mappingColumns == null) {
            logger.log(LogWriter.ERROR, "mappingColumns is null");
        } else {
            int i = 0;
//            logger.log(LogWriter.INFO, "mappingColumns size : " + mappingColumns.size());
            for (String string : common) {
                string = string.toUpperCase();
//                logger.log(LogWriter.INFO, mappingColumns.get(string).getNamaSumber());
//                logger.log(LogWriter.INFO, "mappingColumns i : " + i);
                if (mappingColumns.get(string) == null) {
                    logger.log(LogWriter.ERROR, "mappingColumns.get(string) is null at : " + i);
                } else {
                    boolean isGeomType = mappingColumns.get(string).getDataTypeSumber().equalsIgnoreCase("geometry");
                    if (isGeomType) {
//                        sql += " SDE.ST_ASTEXT(";
                        sql += " SDE.ST_ASBINARY(";
                    }
                    if (i == common.size() - 1) {
                        sql += mappingColumns.get(string).getNamaSumber() + (isGeomType ? ") AS " + mappingColumns.get(string).getNamaSumber() : "");
                    } else {
                        sql += mappingColumns.get(string).getNamaSumber() + (isGeomType ? ") AS " + mappingColumns.get(string).getNamaSumber() + ", " : ", ");
                    }
                }

                i++;
            }
        }

        sql += " FROM " + skema + mapping.getTabelSumber();
//        String whereClause = " WHERE METADATA = \'" + fileIdentifier + "\'";
//                mapping.getWhereClause();
        sql += " " + ((whereClause == null || whereClause.equals("")) ? "" : whereClause);
        sql += ") SUBQ WHERE ROWNUM <= " + rowMax + ") WHERE R > " + rowMin;

        return sql;
    }

    public static String generateSQLGetSource(String namaSkema, Mapping mapping, LogWriter logger, ArrayList<String> common, String fileIdentifier, String whereClause) throws IOException {
        String sql = "SELECT sde.st_geometrytype(SHAPE) as GEOMTYPE, SDE.ST_SRID(SHAPE) as SRID, ";

        String skema = (namaSkema == null) ? "" : (namaSkema + ".");
        HashMap<String, Attributes> mappingColumns = mapping.getAttributes();

        if (mappingColumns == null) {
            logger.log(LogWriter.ERROR, "mappingColumns is null");
        } else {
            int i = 0;
//            logger.log(LogWriter.INFO, "mappingColumns size : " + mappingColumns.size());
            for (String string : common) {
                string = string.toUpperCase();
//                logger.log(LogWriter.INFO, mappingColumns.get(string).getNamaSumber());
//                logger.log(LogWriter.INFO, "mappingColumns i : " + i);
                if (mappingColumns.get(string) == null) {
                    logger.log(LogWriter.ERROR, "mappingColumns.get(string) is null at : " + i);
                } else {
                    boolean isGeomType = mappingColumns.get(string).getDataTypeSumber().equalsIgnoreCase("geometry");
                    if (isGeomType) {
                        sql += " SDE.ST_ASBINARY(";
//                        sql += " SDE.ST_ASTEXT(";
                    }
                    if (i == common.size() - 1) {
                        sql += mappingColumns.get(string).getNamaSumber() + (isGeomType ? ") AS " + mappingColumns.get(string).getNamaSumber() : "");
                    } else {
                        sql += mappingColumns.get(string).getNamaSumber() + (isGeomType ? ") AS " + mappingColumns.get(string).getNamaSumber() + ", " : ", ");
                    }
                }

                i++;
            }
        }

        sql += " FROM " + skema + mapping.getTabelSumber();
//        String whereClause = " WHERE METADATA = \'" + fileIdentifier + "\'";
//                mapping.getWhereClause();
        sql += " " + ((whereClause == null || whereClause.equals("")) ? "" : whereClause);

        return sql;
    }

    public static String generateSQLCheckSRIDinSDO(int SRID) {
        return "select count(*) as COUNT from sdo_coord_ref_system where SRID="
                + SRID;
    }

    public static String generateSQLInsertTarget(Mapping mapping, ArrayList<String> common, int SRID) {
        String sql = "DECLARE \n"
                + "  xgeom SDO_GEOMETRY; \n"
                + " BEGIN \n"
                + "  xgeom:=SDO_UTIL.FROM_WKBGEOMETRY(?); \n"
                + "  xgeom.sdo_srid := " + SRID + "; \n"
                + " INSERT INTO " + mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + " "
                + "(";
        int i = 0;
        String val = "";
        HashMap<String, Attributes> mappingColumns = mapping.getAttributes();

//        for (Map.Entry<String, Attributes> entry : mappingColumns.entrySet()) {
        for (String string : common) {
//            String key = entry.getKey();
            Attributes mappingColumn = mappingColumns.get(string);

            System.out.println(mappingColumn.getNamaSumber() + " == " + mappingColumn.getNamaTarget());

            sql += mappingColumn.getNamaTarget() + (i == common.size() - 1 ? " " : ", ");
            if (mappingColumn.getDataTypeSumber().equalsIgnoreCase("geometry")) {
                val += "xgeom" + (i == common.size() - 1 ? "" : ", ");
            } else if (mappingColumn.getNamaSumber().equalsIgnoreCase("OBJECTID")) {
                val += mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + "_SEQ.NEXTVAL " + (i == common.size() - 1 ? " " : ", ");
            } else {
                val += "?" + (i == common.size() - 1 ? " " : ", ");
            }

            i++;
        }
        sql += ") VALUES (" + val + "); \n"
                + " END;";
        return sql;
    }

    public static String generateSQLInsertTarget_nat(Mapping mapping, ArrayList<String> common) {
        String sql = "DECLARE \n"
                + "  xgeom SDO_GEOMETRY; \n"
                + " BEGIN \n"
                + " INSERT INTO \"" + mapping.getSkemaTarget() + "\".\"" + mapping.getTabelTarget() + "\" "
                + "(";
        int i = 0;
        String val = "";
        HashMap<String, Attributes> mappingColumns = mapping.getAttributes();

//        for (Map.Entry<String, Attributes> entry : mappingColumns.entrySet()) {
        for (String string : common) {
//            String key = entry.getKey();
            Attributes mappingColumn = mappingColumns.get(string);

            System.out.println(mappingColumn.getNamaSumber() + " == " + mappingColumn.getNamaTarget());

            sql += mappingColumn.getNamaTarget() + (i == common.size() - 1 ? " " : ", ");
            if (mappingColumn.getDataTypeSumber().equalsIgnoreCase("geometry")) {
                val += "?" + (i == common.size() - 1 ? "" : ", ");
            } else if (mappingColumn.getNamaSumber().equalsIgnoreCase("OBJECTID")) {
                val += mapping.getSkemaTarget() + "." + mapping.getTabelTarget() + "_SEQ.NEXTVAL " + (i == common.size() - 1 ? " " : ", ");
            } else {
                val += "?" + (i == common.size() - 1 ? " " : ", ");
            }

            i++;
        }
        sql += ") VALUES (" + val + "); \n"
                + " END;";
        return sql;
    }

    public static Connection getConnection(DBConConfiguration configurationTarget, LogWriter logger) throws IOException {
        DBUtil util = new DBUtil();
//        LogWriter logger = new LogWriter();
        String driverName = "oracle.jdbc.OracleDriver";
        String url = "";
        if (configurationTarget.getServiceName().equals("")) {
            url = "jdbc:oracle:thin:@"
                    + configurationTarget.getHost()
                    + ":" + configurationTarget.getPort()
                    + ":" + configurationTarget.getSid();
        }
        if (configurationTarget.getSid().equals("")) {
            url = "jdbc:oracle:thin:@//"
                    + configurationTarget.getHost()
                    + ":"
                    + configurationTarget.getPort()
                    + "/"
                    + configurationTarget.getServiceName();
        }

        String username = configurationTarget.getUsername();
        String password = configurationTarget.getPassword();
        Connection con = util.getConnection(driverName, url, username, password);
        if (con == null) {
            logger.log(LogWriter.ERROR, "Koneksi " + configurationTarget.getName() + " gagal");
        }

        return con;
    }

    public static String generateSqlInsertIntoTempTable(String geomType, String fileIdentfier, String namSkema, String namaUnsur) {
        String sql;
        if (geomType.trim().equalsIgnoreCase("AR")) {
            sql = "insert into igd.temp_data_pt SELECT rowid, SDO_GEOM.SDO_CENTROID (shape, 0.005) shape\n"
                    + " FROM " + namSkema + "." + namaUnsur + " c"
                    + " where c.metadata = \'" + fileIdentfier + "\'"
                    + " and c.shape.get_gtype() in (3,7)";
        } else if (geomType.trim().equals("LN")) {
            sql = "insert into igd.temp_data_pt select rowid, \n"
                    + "	SDO_LRS.CONVERT_TO_STD_GEOM(SDO_LRS.LOCATE_PT(SDO_LRS.CONVERT_TO_LRS_GEOM(shape, 3), SDO_GEOM.SDO_LENGTH(shape,3)/2))\n"
                    + "from " + namSkema + "." + namaUnsur + " c where c.metadata = \'" + fileIdentfier + "\'\n"
                    + "and c.shape.get_gtype() in (2,6)";
        } else {
            sql = "select rowid, shape from " + namSkema + "." + namaUnsur + " c WHERE c.metadata = \'" + fileIdentfier + "\'\n"
                    + "  AND c.shape.get_gtype() in (1,4)";
        }
        return sql;
    }

    public String generateSQLGetDaftarUnsur() {
        String sql = "select TABLE_NAME from user_tables";
        return sql;
    }

    public String generateSQLGetFileIdentfifierWhereEquals(String fileIdentfier) {
        String sql = "SELECT FILEIDENTIFIER FROM METADATA.md_metadata WHERE FILEIDENTIFIER= \'" + fileIdentfier + "\'";
        return sql;
    }

    public String generateSQLGetFieldIsMetadata(String namaUnsur) {
        String sql = "select column_id as id, COLUMN_NAME as name, data_type as dataType, char_length as dataLength from USER_TAB_COLUMNS where TABLE_NAME= \'" + namaUnsur + "\' AND COLUMN_NAME=\'METADATA\'";
        return sql;
    }

    public String generateSQLGetMetadataCountInsideUnsur(String skema, String namaUnsur, String fileIdentifier) {
        String sql = "SELECT COUNT(METADATA) AS COUNT FROM " + skema + "." + namaUnsur + " WHERE METADATA=\'" + fileIdentifier + "\'";
        return sql;
    }

    public String generateSQLGetFileIdentifierFromMdMetadata() {
        String sql = "SELECT FILEIDENTIFIER FROM METADATA.MD_METADATA";
        return sql;
    }

    public String generateSQLGetMetadataFromUnsur(String skema, String namaUnsur) {
        String sql = "SELECT DISTINCT(METADATA) FROM " + skema + "." + namaUnsur;
        return sql;
    }

    public static String generateUrl(DBConConfiguration dBConConfiguration) {
        String url = "";
        if (dBConConfiguration.getServiceName().equals("")) {
            url = "jdbc:oracle:thin:@"
                    + dBConConfiguration.getHost()
                    + ":" + dBConConfiguration.getPort()
                    + ":" + dBConConfiguration.getSid();
        }
        if (dBConConfiguration.getSid().equals("")) {
            url = "jdbc:oracle:thin:@//"
                    + dBConConfiguration.getHost()
                    + ":"
                    + dBConConfiguration.getPort()
                    + "/"
                    + dBConConfiguration.getServiceName();
        }

        return url;
    }

    public static String getNamaProyek() {
        String sql = "select a.id,c.TITLE from METADATA.MD_METADATA a\n"
                + "JOIN metadata.md_identification b ON a.id = b.MD_METADATAID\n"
                + "JOIN METADATA.CI_CITATION c ON c.MD_IDENTIFICATIONID = b.ID\n"
                + "ORDER BY a.id";

        return sql;
    }

    public static String getFilterProd(String skala, String produk, String thnMulai, String thnAkhir) {
        String sql = "select fileidentifier, date_,  replace(replace(replace(specification,'_AR',''),'_LN',''),'_PT','') specifications\n"
                + "from\n"
                + "metadata.md_metadata a, \n"
                + "metadata.md_identification b, \n"
                + "metadata.ci_citation c, \n"
                + "metadata.ci_date d,\n"
                + "metadata.md_format e,\n"
                + "metadata.sv_serviceidentification f,\n"
                + "metadata.md_dataidentification g,\n"
                + "metadata.md_resolution h,\n"
                + "metadata.md_representativefraction i\n"
                + "where substr(a.fileidentifier,1,3)= \'" + produk + "\'  -- jenis produk\n"
                + "and i.denominator = " + skala + " -- skala\n"
                + "and date_ Between TO_DATE('" + thnMulai + "','DD-mon-YY') AND TO_DATE('" + thnAkhir + "','DD-mon-YY')\n"
                + "and a.id = b.md_metadataid\n"
                + "and b.id = c.md_identificationid\n"
                + "and c.id = d.ci_citationid\n"
                + "and b.id = e.md_identificationid\n"
                + "and b.id = f.md_identificationid\n"
                + "and f.id = g.sv_serviceidentificationid\n"
                + "and g.id = h.md_dataidentificationid\n"
                + "and h.id = i.md_resolutionid\n"
                + "order by date_ desc";

        return sql;
    }

    public String sqlGetNomorPeta(String skala) {
        return "SELECT distinct a.nomor_peta FROM metadata.KETERSEDIAAN_INDEX a WHERE a.skala = " + skala + " AND b.status=1";
    }

    public static String generateSQLDaftarUnsurBerdasarSkalaTahun(String tahunMulai, String tahunSelesai, String produk, String skala) {
        String sql = "select fileidentifier, "
                + "date_, "
                + "replace(replace(replace(e.specification,'_AR',''),'_LN',''),'_PT','') specification, "
                + "g.suplementationinformation, "
                + "e.id unsurs_id, "
                + "g.id nlps_id, "
                + "c.title  from "
                + "metadata.md_metadata a, \n"
                + "metadata.md_identification b, \n"
                + "metadata.ci_citation c, \n"
                + "metadata.ci_date d,\n"
                + "metadata.md_format e,\n"
                + "metadata.sv_serviceidentification f,\n"
                + "metadata.md_dataidentification g,\n"
                + "metadata.md_resolution h,\n"
                + "metadata.md_representativefraction i\n"
                + "where substr(a.fileidentifier,1,3)= '" + produk + "'  -- jenis produk\n"
                + "and i.denominator = " + skala + "\n"
                + "and to_number(to_char(date_,'YYYY')) between " + tahunMulai + " and " + tahunSelesai + "\n"
                + "and a.id = b.md_metadataid\n"
                + "and b.id = c.md_identificationid\n"
                + "and c.id = d.ci_citationid\n"
                + "and b.id = e.md_identificationid\n"
                + "and b.id = f.md_identificationid\n"
                + "and f.id = g.sv_serviceidentificationid\n"
                + "and g.id = h.md_dataidentificationid\n"
                + "and h.id = i.md_resolutionid\n"
                + "order by date_  desc";

        return sql;
    }

    public static String generateSQLGetNlp(Unsur unsur, String geomType, String skala) {
//        String sql1 = "SELECT c_c.nomor_peta\n"
//                + "       FROM " + unsur.getMapping().getSkemaSumber() + "." + unsur.getName() + " c_a, metadata.INDEX10K c_c \n"
//                + "       WHERE c_a.metadata = \'" + unsur.getFielIdentifier() + "\' \n"
//                + "       and SDO_GEOM.SDO_INTERSECTION(c_c.shape, c_a.shape, 0.005) is not null";
//
//        String sql3 = "SELECT nomor_peta\n"
//                + "    FROM metadata.INDEX10K a,(SELECT SDO_AGGR_CONVEXHULL(SDOAGGRTYPE(shape, 0.005)) as shape\n"
//                + "                FROM " + unsur.getMapping().getSkemaSumber() + "." + unsur.getName() + " where metadata = \'" + unsur.getFielIdentifier() + "\') b\n"
//                + "    WHERE SDO_GEOM.SDO_INTERSECTION(\n"
//                + "    a.SHAPE,\n"
//                + "    b.shape\n"
//                + "  , 0.005) IS NOT NULL";

        String sql;
//        if (geomType.equalsIgnoreCase("AR")) {
//            //AREA
//            sql = "select distinct a.nomor_peta\n"
//                    + "from METADATA.mv_index_10k a, " + unsur.getMapping().getSkemaSumber() + "." + unsur.getName() + " b   \n"
//                    + "where b.metadata = \'" + unsur.getFielIdentifier() + "\' \n"
//                    + "and SDO_RELATE(a.shape, b.shape,'mask=inside') = 'TRUE'";
//        } else {
//            //POINT DAN LINE
//            sql = "SELECT DISTINCT a.NOMOR_PETA FROM METADATA.DATAINDEX_10K a, "
//                    + unsur.getMapping().getSkemaSumber() + "." + unsur.getName()
//                    + " b WHERE b.metadata = \'" + unsur.getFielIdentifier() + "\' \n"
//                    + "AND SDO_RELATE(b.SHAPE, a.SHAPE, 'mask=inside')='TRUE'";
//        }

        sql = "SELECT distinct a.nomor_peta \n" //SELECT distinct b.sdo_rowid, a.nomor_peta
                //                + "  FROM metadata.DATA_INDEX10K a, igd.temp_data_pt b \n" //implementasi ==> DATAINDEX_10K
                + "  FROM metadata.KETERSEDIAAN_INDEX a, igd.temp_data_pt b \n" //implementasi ==> DATAINDEX_10K
                + "  WHERE a.skala = " + skala + " AND a.status = 1 AND SDO_INSIDE(b.shape, a.shape) = 'TRUE'";
//         + " AND b.shape.get_gtype() in " + GeometryTool.getGeomCodes(geomType)
        return sql;
    }

    public static String generateSQLgetPublikasiWithNLP(Mapping mapping, Unsur unsur, String geomCodes, ArrayList<String> nlps, String skala) {

        HashMap<String, Attributes> attr = mapping.getAttributes();
        String sql = "select ";
        int z = 0;
        for (Map.Entry<String, Attributes> entry : attr.entrySet()) {
            Attributes value = entry.getValue();
            if (value.getDataTypeSumber().equalsIgnoreCase("GEOMETRY")) {
                //MENGGUNAKAN TIPE WKB PADA SAAT INSERT
                sql += value.getNamaSumber() + " ";
                //sql += "SDO_UTIL.TO_WKTGEOMETRY(" + value.getNamaSumber() + ") as " + value.getNamaSumber() + " ";
            } else if (value.getNamaSumber().equalsIgnoreCase("METADATA")) {
                sql += value.getNamaSumber() + " ";
            } else {
                sql += value.getNamaSumber() + " ";
            }
            if (z < attr.size() - 1) {
                sql += ", ";
            }
            z++;
        }
        sql += "  from (\n";
        sql += "select b.nomor_peta, ";
        int i = 0;
        for (Map.Entry<String, Attributes> entry : attr.entrySet()) {
            String key = entry.getKey();
            Attributes value = entry.getValue();
            if (value.getDataTypeSumber().equalsIgnoreCase("GEOMETRY")) {
                sql += "SDO_GEOM.SDO_INTERSECTION(a." + value.getNamaSumber() + ", b." + value.getNamaSumber() + ", 0.005) " + value.getNamaSumber() + " ";
            } else if (value.getNamaSumber().equalsIgnoreCase("METADATA")) {
                sql += "a." + value.getNamaSumber() + " ";
            } else {
                sql += value.getNamaSumber() + " ";
            }
            if (i < attr.size() - 1) {
                sql += ", ";
            }
            i++;
        }

        sql += "from " + mapping.getSkemaSumber() + "." + mapping.getTabelSumber() + " a , metadata.KETERSEDIAAN_INDEX b\n";
        sql += "where a.metadata = \'" + unsur.getFielIdentifier() + "\' \n"; //-- fileidentifier
        sql += "AND  b.skala = " + skala + " AND b.status = 1 \n";
        //FIELD WADMKD HANYA UNTUK ADMINISTRASI , BELUM BISA DIGUNAKAN UNTUK UNSUR LAIN
//        sql += " AND TRIM(WADMKK) IS NOT NULL \n";

//        sql += "and b.nomor_peta in ('0816-2445','0619-6117','0619-6323','0619-6142') ";
        //KARENA MAXIMUM ARRAY DI ORACLE ADALAH 1000 MAKA KITA BAGI ARRAY NLP KE DALAM PAGING
        boolean isTest = false;
        if (!isTest) {
            int pagingSize = 500;
            if (nlps.size() > pagingSize) {
                int modNlps = nlps.size() % pagingSize;
                int pages = nlps.size() / pagingSize;
                for (int j = 0; j < pages; j++) {
                    if (j == 0) {
                        sql += "and b.nomor_peta in (";
                        for (int k = 0; k < pagingSize; k++) {
                            sql += "\'" + nlps.get(k) + "\'";
                            if (k < pagingSize - 1) {
                                sql += ",";
                            }
                        }
                        sql += ") \n";
                    } else {
                        sql += "or b.nomor_peta in (";
                        int min = j * pagingSize;
                        int max = min + pagingSize;
                        for (int k = min; k < max; k++) {
                            sql += "\'" + nlps.get(k) + "\'";
                            if (k < max - 1) {
                                sql += ",";
                            }
                        }
                        sql += ") \n";
                    }
                }

                if (modNlps > 0) {
                    if (pages > 0) {
                        sql += "or b.nomor_peta in (";
                        int min = pages * pagingSize;
                        int max = nlps.size();
                        for (int k = min; k < max; k++) {
                            sql += "\'" + nlps.get(k) + "\'";
                            if (k < max - 1) {
                                sql += ",";
                            }
                        }

                        sql += ") \n";

                    } else {
                        sql += "and b.nomor_peta in (";
                        for (int k = 0; k < nlps.size(); k++) {
                            sql += "\'" + nlps.get(k) + "\'";
                            if (k < nlps.size() - 1) {
                                sql += ",";
                            }
                        }

                        sql += ") \n";
                    }
                }

            } else {
                sql += "and b.nomor_peta in (";
                int j = 0;
                for (String nlp : nlps) {
                    sql += "\'" + nlp + "\'";
                    if (j < nlps.size() - 1) {
                        sql += ",";
                    }
                    j++;
                }

                sql += ") \n";
            }
        }

        sql += ""; //-- paging dari daftar nlp dari nomor 5
        sql += ") x where x.shape.get_gtype() in " + geomCodes; //-- lihat dokumen oracle (eri tahu)

        return sql;
    }

    public static String generateSQLCountKetersediaan(int skala) {
        String sql = "SELECT COUNT(*) as Jumlah  FROM METADATA.KETERSEDIAAN_INDEX where SKALA=" + skala;
        return sql;
    }

    public static String generateDeleteKetersediaan() {
        String sql = "DELETE FROM METADATA.KETERSEDIAAN_INDEX where SKALA = ?";
        return sql;
    }

    public static String generateSQLGetSRIDPub(String skemaTarget, String namaUnsurTarget) {
        String sql = "select SRID from SDE.st_geometry_index where owner='" + skemaTarget + "' AND table_name='" + namaUnsurTarget + "'";
        return sql;
    }

}
