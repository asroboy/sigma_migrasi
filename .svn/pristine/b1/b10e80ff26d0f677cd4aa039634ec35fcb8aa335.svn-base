/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.geotools.data.shapefile.files.ShpFiles;

/**
 *
 * @author Ridho
 */
public class TestDelete {

    public static void main(String[] arg) {
        try {
            File file = new File("C:\\migrasi\\tmp\\ketersdiaan_index\\AGRIKEBUN_AR.shp");
            ShpFiles shp = new ShpFiles(file);
            shp.delete();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
