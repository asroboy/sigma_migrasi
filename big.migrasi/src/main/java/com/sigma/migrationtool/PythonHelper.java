/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.sigma.big.tools.LogWriter;
import com.sigma.big.tools.MigrasiShapeHelper;
import com.sigma.big.tools.MigrasiShapeHelper.CompleteListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ridho
 */
public class PythonHelper {

    LogWriter logger;
    Connection conPublikasi;
    String mapping;

    public PythonHelper(LogWriter logger, Connection conPublikasi) {
        this.logger = logger;
        this.conPublikasi = conPublikasi;
    }

    /**
     * Mengeksport data sde ke dalam shape file.
     * 
     * UPDATE : fungsi ini tidak akan digunakan lagi setelah penghapusan (fungsi eraseFeature) langsung dilakukan di dalam sde
     * @param host
     * @param sidService
     * @param skemaName
     * @param namaUnsur
     */
    private void exportGdbToShapefile(String host, String sidService, String skemaName, String namaUnsur, String mapping, CompleteListener listener) {
        String s = null;

        try {
            logger.log(LogWriter.INFO, "Mengkonvert data publikasi ke shapefile");
            Path currentRelativePath = Paths.get("");
            String rootPath = URLEncoder.encode(currentRelativePath.toAbsolutePath().toString(), "utf-8");
            System.out.println("Current relative path is: " + currentRelativePath.toAbsolutePath().toString());

            // run the Unix "ps -ef" command
            String command = "python " + rootPath + "\\python\\featureclass_to_shapefile.py " + host + " " + sidService + " " + skemaName + " " + namaUnsur;
             System.out.println("Command: " + command);
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.INFO, s);
            }

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.ERROR, s);
            }

            System.out.println(mapping);
            listener.onComplete(MigrasiShapeHelper.CODE_EXPORT_GDB_TO_SHAPEFILE);
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            listener.onFailed(MigrasiShapeHelper.CODE_EXPORT_GDB_TO_SHAPEFILE);
        }
    }

    
    /**
     * 
     * @param host
     * @param sidService
     * @param skemaName
     * @param listener 
     */
    public void buildSdeConnection(String host, String sidService, String skemaName, CompleteListener listener){
         String s = null;

        try {
            logger.log(LogWriter.INFO, "Mebuat Koneksi Ke SDE");
            Path currentRelativePath = Paths.get("");
            String rootPath = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current relative path is: " + currentRelativePath.toAbsolutePath().toString());

            // run the Unix "ps -ef" command
            String command = "python " + rootPath + "\\python\\build_sde_connection.py " + host + " " + sidService + " " + skemaName;
             System.out.println("Command: " + command);
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.INFO, s);
            }

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.ERROR, s);
            }

            System.out.println(mapping);
            listener.onComplete(MigrasiShapeHelper.CODE_CREATE_SDE_CONNECTION);
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            listener.onFailed(MigrasiShapeHelper.CODE_CREATE_SDE_CONNECTION);
        }
    }
    /**
     * fungsi ini akan menghapus fitur (secara spasial) dengan index yang telah dbuat pada fungsi calculate index
     * fungsi ini akan memanggil EraseFeatureRun.py.
     * 
     * UPDATE: script python EraseFeatureRun.py ini akan diganti menghapus data unsur di sde dengan hasil output disimpan di dalam 
     * table unsur temporary, temporary ini akan dihapus setelah proses migrasi satu unsur selesai.
     * 
     * @param namaSkema
     * @param namaUnsur
     * @param listener 
     */
    public void eraseFeature(String namaSkema, String namaUnsur, CompleteListener listener) {
        String s = null;
        try {
            logger.log(LogWriter.INFO, "Menghapus fitur pada NLP");
            Path currentRelativePath = Paths.get("");
            String rootPath = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current relative path is: " + currentRelativePath.toAbsolutePath().toString());

            // run the Unix "ps -ef" command
            String command = "python " + rootPath + "\\python\\EraseFeatureRun.py " + namaUnsur + " " + namaSkema;
            System.out.println("Command: " + command);
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.INFO, s);
            }

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.ERROR, s);
            }

            logger.log(LogWriter.INFO, "Selesai menghapus fitur pada NLP");
            listener.onComplete(MigrasiShapeHelper.CODE_ERASE_FEATURE);
//            hapusDataPublikasi(namaSkema, namaUnsur);

        } catch (IOException e) {
            listener.onFailed(MigrasiShapeHelper.CODE_ERASE_FEATURE);
            System.out.println("exception happened - here's what I know: ");
        }
    }

    /**
     * fungsi ini digunakan untuk mencari index dari data produksi, fungsi ini akan memanggil MenghitungIndexPolygon.py untuk unsur polygon
     * dan akan memanggil MenghitungIndex.py uuntuk unsur Line dan Titik(Point)
     * @param namaUnsur
     * @param skala
     * @param listener 
     */
    public void calculateIndex(String namaUnsur, String skala, CompleteListener listener) {
        String s = null;
        try {
            Path currentRelativePath = Paths.get("");
            String rootPath = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current relative path is: " + currentRelativePath.toAbsolutePath().toString());

            // run the Unix "ps -ef" command
            String pythonFile = "";
            if (namaUnsur.split("_")[1].toUpperCase().equals("AR")) {
                pythonFile = "MenghitungIndexPolygon.py";
            } else {
                pythonFile = "MenghitungIndex.py";
            }
            
            String command = "python " + rootPath + "\\python\\" + pythonFile + " " + namaUnsur + " " + skala;
            System.out.println("Command: " + command);
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.INFO, s);
            }

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.ERROR, s);
            }

            listener.onComplete(MigrasiShapeHelper.CODE_CALCULATE_INDEX);
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            listener.onFailed(MigrasiShapeHelper.CODE_CALCULATE_INDEX);
        }
    }

    /**
     * Menghapus data di db SDE publikasi, fungsi ini menggunakan operasi truncate untuk menghapus keseluruhan isi data
     * @param namaSkema
     * @param namaUnsur
     * @param mapping
     * @param listener 
     */
    public void hapusDataPublikasi(String namaSkema, String namaUnsur, String mapping, CompleteListener listener) {
        try {
            String sql = "TRUNCATE TABLE " + namaSkema + "." + namaUnsur;
            Statement stmt = conPublikasi.createStatement();
            stmt.execute(sql);
            stmt.close();
            listener.onComplete(MigrasiShapeHelper.CODE_CLEAR_PUB);
        } catch (SQLException ex) {
            Logger.getLogger(PythonHelper.class.getName()).log(Level.SEVERE, null, ex);
            listener.onFailed(MigrasiShapeHelper.CODE_CLEAR_PUB);
        }

    }
    
    /**
     * Memigrasikan SHP produksi ke dalam db SDE publikasi
     * fungsi ini hanya sebagai jembatan untuk memanggil fungsi exportShapefileToOracleGDB()
     * @param namaSkema
     * @param namaUnsur
     * @param mapping
     * @param listener 
     */
    public void exportShpProdToPub(String namaSkema, String namaUnsur, String mapping, CompleteListener listener) {
        exportShapefileToOracleGDB(namaSkema, namaUnsur, mapping, listener, "produksi", MigrasiShapeHelper.CODE_MIG_SHP_PROD_TO_PUB);
    }

    /**
     * Memigrasikan SHP hasil (sisa setalah dipotong dengan index data produksi) ke dalam db SDE publikasi
     * fungsi ini hanya sebagai jembatan untuk memanggil fungsi exportHasilShapefileToOracleGDB()
     * @param namaSkema
     * @param namaUnsur
     * @param mapping
     * @param listener 
     */
    public void exportShpHasilToPub(String namaSkema, String namaUnsur, String mapping, CompleteListener listener) {
        exportHasilShapefileToOracleGDB(namaSkema, namaUnsur, mapping, listener, "output", MigrasiShapeHelper.CODE_MIG_SHP_HASIL_TO_PUB);
    }

    public void exportShapefileToOracleGDB(String namaSkema, String namaUnsur, String mapping, CompleteListener listener, String path, int code) {
        String s = null;
        try {
            logger.log(LogWriter.INFO, "Mengeksport data ke publikasi");
            Path currentRelativePath = Paths.get("");
            String rootPath = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current relative path is: " + currentRelativePath.toAbsolutePath().toString());

            // run the Unix "ps -ef" command
            String command = "python " + rootPath + "\\python\\shapefile_to_oraclegdb.py " + namaSkema + " " + namaUnsur + " " + mapping + " " + path;
            System.out.println("Command: " + command);
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.INFO, s);
            }

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.ERROR, s);
            }

            listener.onComplete(code);
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            listener.onFailed(code);
        }
    }

    public void exportHasilShapefileToOracleGDB(String namaSkema, String namaUnsur, String mapping, CompleteListener listener, String path, int code) {
        String s = null;
        try {
            logger.log(LogWriter.INFO, "Mengeksport data ke publikasi");
            Path currentRelativePath = Paths.get("");
            String rootPath = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current relative path is: " + currentRelativePath.toAbsolutePath().toString());

            // run the Unix "ps -ef" command
            String command = "python " + rootPath + "\\python\\shapefile_to_oraclegdb_1.py " + namaSkema + " " + namaUnsur + " " + mapping + " " + path;
            System.out.println("Command: " + command);
            Process p = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.INFO, s);
            }

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                logger.log(LogWriter.ERROR, s);
            }

            listener.onComplete(code);
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            listener.onFailed(code);
        }
    }

}
