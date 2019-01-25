/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.publikasi;

import com.sigma.big.tools.LogWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ridho
 */
public class PythonExecutor {

    public static String PATH_SCRIPT_ERASE_FEATURE = "C:\\migrasi\\EraseFeature\\EraseFeatureRun.py";
    public static String PATH_SCRIPT_DB_TO_SHAPEFILE = "C:\\migrasi\\EraseFeature\\featureclass_to_shapefile.py";
    public static final int ERASE_FEATURE = 1;
    public static final int DB_TO_SHP = 2;

    LogWriter logger;

    private PythonExecutor(LogWriter logger) {
        this.logger = logger;
    }

    public static PythonExecutor init(LogWriter logger) {
        return new PythonExecutor(logger);
    }

    public void execute(int code) throws IOException {
        String path = "";
        String s = null;
        boolean isError = false;
        try {
            // run the Unix "ps -ef" command
            Process p = Runtime.getRuntime().exec("python " + getPath(code));

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String message = null;
            // read the output from the command
            logger.log(LogWriter.INFO, "Menjalankan script ...");
            while ((s = stdInput.readLine()) != null) {
                isError = false;
                message += s;
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                isError = true;
                message += s;
            }

            if (isError) {
                logger.log(LogWriter.ERROR, "Result : " + message);
            } else {
                logger.log(LogWriter.INFO, "Result : " + message);
            }

            logger.log(LogWriter.INFO, "Selsai");
        } catch (IOException e) {
            logger.log(LogWriter.ERROR, "exception happened - here's what I know: ");
            logger.log(LogWriter.ERROR, e.getMessage());

        }
    }

    public String getPath(int code) {
        String path = "";
        if (code == DB_TO_SHP) {
            path = PATH_SCRIPT_DB_TO_SHAPEFILE;
        }

        if (code == ERASE_FEATURE) {
            path = PATH_SCRIPT_ERASE_FEATURE;
        }

        return path;
    }
}
