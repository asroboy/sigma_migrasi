/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.bkp;

import com.sigma.big.model.db.Project;
import com.sigma.big.tools.DatabaseTool;
import com.sigma.big.tools.GeometryTool;
import com.sigma.big.tools.ProjectedTable;
import com.sigma.big.tools.Unsur;
import com.sigma.migrationtool.MigrasiSdoToSde;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ridho
 */
public class SDOkeSDE {

    private int getSRIDPublikasi(String skemaTarget, String tableName, Connection conTarget) throws SQLException {
        int SRID = 0;
        String sql = DatabaseTool.generateSRIDUnsurPublikasi(skemaTarget, tableName);
        System.out.println(sql);
        Statement stmt = conTarget.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            SRID = rs.getInt("SRID");
        }
        rs.close();
        stmt.close();
        return SRID;
    }

    private void getNamaProyek() {
        try {

//            comboBoxProduk.setEnabled(false);
//            comboBoxSkala.setEnabled(false);
//            buttonMigrasi.setEnabled(false);
//            buttonBrowse.setEnabled(false);
//            buttonJalankanFilter.setEnabled(false);
//            // create the map
//
//            String sql = DatabaseTool.getNamaProyek();
//            System.out.println(sql);
//            conSumber = DatabaseTool.getConnection(configurationSumber, logger);
//            Statement stmt = conSumber.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            HashMap<String, Project> prj = new HashMap<>();
//            ArrayList<String> proyeks = new ArrayList<>();
//            while (rs.next()) {
////                int id = rs.getInt("ID");
//                String namaProduk = rs.getString("TITLE");
//                proyeks.add(namaProduk);
//            }
//            Collections.sort(proyeks);
//            for (String string : proyeks) {
//                Project prj1 = new Project();
//                prj1.setNamaProject(string);
//                prj1.setIsSelected(false);
//                prj.put(string, prj1);
//            }
//            TreeMap<String, Project> sorted = new TreeMap<>(prj);
//            Set<Map.Entry<String, Project>> projTables = sorted.entrySet();
//            setTableProyek(projTables);
        } catch (Exception e) {
            System.out.println("Nama Proyek :" + e);

        }
    }

    private Unsur projectedTableToUnsur(ProjectedTable value) {
//        System.out.println("Value " + value.getName());
        Unsur unsur = new Unsur();
        unsur.setSelected(value.isIsSelected());
        unsur.setValid(value.isIsValid());
        unsur.setMapping(value.getMapping());
        unsur.setStatus(value.getStatus());
        unsur.setIsDataBesar(value.isIsDataBesar());
        unsur.setNamaSkema(value.getNamaSkema());
        unsur.setName(value.getName());
        unsur.setFielIdentifier(value.getFileIdetifier());
        return unsur;
    }
    //GET GEOMETRY TYPE

    Connection conSumber;

    private ArrayList<String> getGeomTypeInUnsur(Unsur unsur) throws SQLException {
        ArrayList<String> geomType = new ArrayList<>();
        try (Statement stmt = conSumber.createStatement()) {
            String sql = DatabaseTool.generateSQLGetGeomType(unsur.getMapping().getSkemaSumber(), unsur.getName(), unsur.getFielIdentifier());
//            print(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String gType = GeometryTool.getGeomTypeSDO(rs.getInt("KEY_GTYPE"));
                if (!geomType.contains(gType)) {
                    geomType.add(gType);
                }
            }
            rs.close();
        }
        return geomType;
    }

    private void getDataProd() throws IOException {
//        String skala = comboBoxSkala.getSelectedItem().toString();
//        String vProduk = comboBoxProduk.getSelectedItem().toString();
//        String vSkala = GeometryTool.getSkala(skala);
//        String vThnMl = spinnerTahunMulai.getValue().toString();
//        String vThnSls = spinnerTahunSampai.getValue().toString();
//        String sql = DatabaseTool.getFilterProd(vSkala, vProduk, vThnMl, vThnSls);
//
//        try {
//            conSumber = DatabaseTool.getConnection(configurationSumber, logger);
//            Statement stmt = conSumber.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String fileidentifier = rs.getString("fileidentifier");
//                String namaUnsur = rs.getString("specifications");
//                namaUnsur = namaUnsur.replaceAll(";", "\n");
//                System.out.println(namaUnsur);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MigrasiSdoToSde.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }

    }

    //    public void setXTableValue(Set<Map.Entry<String, ProjectedTable>> projectedTable) {
//        Thread t = new Thread(() -> {
//            unsurs = new ArrayList<>();
//            for (Map.Entry<String, ProjectedTable> entry : projectedTable) {
//                String key = entry.getKey();
////                System.out.println("Key " + key);
//
//                ProjectedTable value = entry.getValue();
//                unsurs.add(projectedTableToUnsur(value));
//            }
//            updateTableProject(projectedTable.size());
//            updateViewsCon1(true);
//        });
//
//        t.start();
//    }
}
