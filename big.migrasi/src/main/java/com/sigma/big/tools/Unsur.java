/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import com.sigma.big.model.db.Mapping;
import java.util.HashMap;

/**
 *
 * @author Ridho
 */
public class Unsur {

    String namaSkema;
    boolean selected;
    boolean valid;
    String fielIdentifier;
    Mapping mapping;
    String status;
    String name;
    boolean isDataBesar;
    int tahun;
    HashMap<String, Mapping> productionMappings;

    public HashMap<String, Mapping> getProductionMappings() {
        return productionMappings;
    }

    public void setProductionMappings(HashMap<String, Mapping> productionMappings) {
        this.productionMappings = productionMappings;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public boolean isIsDataBesar() {
        return isDataBesar;
    }

    public void setIsDataBesar(boolean isDataBesar) {
        this.isDataBesar = isDataBesar;
    }

    public String getNamaSkema() {
        return namaSkema;
    }

    public void setNamaSkema(String namaSkema) {
        this.namaSkema = namaSkema;
    }

    public String getFielIdentifier() {
        return fielIdentifier;
    }

    public void setFielIdentifier(String fielIdentifier) {
        this.fielIdentifier = fielIdentifier;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Mapping getMapping() {
        return mapping;
    }

    public void setMapping(Mapping mapping) {
        this.mapping = mapping;
    }

}
