/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import java.util.ArrayList;

/**
 *
 * @author Ridho
 */
public class MetadataProject {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileIdetifier() {
        return fileIdetifier;
    }

    public void setFileIdetifier(String fileIdetifier) {
        this.fileIdetifier = fileIdetifier;
    }
    String skala;

    public String getSkala() {
        return skala;
    }

    public void setSkala(String skala) {
        this.skala = skala;
    }
    String name;
    String fileIdetifier;
    ArrayList<String> tableNames;

    public ArrayList<String> getTableNames() {
        return tableNames;
    }

    public void setTableNames(ArrayList<String> tableNames) {
        this.tableNames = tableNames;
    }
}
