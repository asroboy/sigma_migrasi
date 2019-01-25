/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.model;

import com.vividsolutions.jts.geom.Geometry;

/**
 *
 * @author Ridho
 */
public class KeterseidaanIndex {

    String nomorPeta;
    String namaPeta;
    String region;
    int skala;
    int status;
    Geometry shape;

    public String getNomorPeta() {
        return nomorPeta;
    }

    public void setNomorPeta(String nomorPeta) {
        this.nomorPeta = nomorPeta;
    }

    public String getNamaPeta() {
        return namaPeta;
    }

    public void setNamaPeta(String namaPeta) {
        this.namaPeta = namaPeta;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getSkala() {
        return skala;
    }

    public void setSkala(int skala) {
        this.skala = skala;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Geometry getShape() {
        return shape;
    }

    public void setShape(Geometry shape) {
        this.shape = shape;
    }

}
