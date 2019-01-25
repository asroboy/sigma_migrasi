/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.utils;

/**
 *
 * @author Ridho
 */
public class FcodeReader {

    public final String POINT_2D = "01";
    public final String POLYLINE_2D = "02";
    public final String POLYGON_2D = "03";
    public final String POINT_3D = "04";
    public final String POLYLINE_3D = "05";
    public final String POLYGON_3D = "06";
    public final String MESH = "07";

    public final String M_1 = "01";
    public final String K_500 = "02";
    public final String K_250 = "03";
    public final String K_100 = "04";
    public final String K_50 = "05";
    public final String K_25 = "06";
    public final String K_10 = "07";
    public final String K_5 = "08";
    public final String K_2_5 = "09";
    public final String K_1 = "10";

    public FcodeReader(String FCODE) {
        String tipeGeomCode = FCODE.charAt(2) + "" + FCODE.charAt(3);
        String skalaCOde = FCODE.charAt(4) + "" + FCODE.charAt(5);
        calculateGeomType(tipeGeomCode);
        calculateSkala(skalaCOde);
    }

    private void calculateSkala(String skalaCOde) {
        if (skalaCOde.equals(M_1)) {
            this.skala = "1M";
        }
        if (skalaCOde.equals(K_500)) {
            this.skala = "500K";
        }
        if (skalaCOde.equals(K_250)) {
            this.skala = "250k";
        }
        if (skalaCOde.equals(K_100)) {
            this.skala = "100K";
        }
        if (skalaCOde.equals(K_50)) {
            this.skala = "50K";
        }
        if (skalaCOde.equals(K_25)) {
            this.skala = "25K";
        }
        if (skalaCOde.equals(K_10)) {
            this.skala = "10K";
        }
        if (skalaCOde.equals(K_5)) {
            this.skala = "5K";
        }
        if (skalaCOde.equals(K_2_5)) {
            this.skala = "1.5K";
        }
        if (skalaCOde.equals(K_1)) {
            this.skala = "1K";
        }
    }

    private void calculateGeomType(String tipeGeomCode) {
        if (tipeGeomCode.equals(POINT_2D)) {
            this.geomType = "POINT";
            this.dimension = 2;
        }
        if (tipeGeomCode.equals(POLYLINE_2D)) {
            this.geomType = "POLYLINE";
            this.dimension = 2;
        }
        if (tipeGeomCode.equals(POLYGON_2D)) {
            this.geomType = "POLYGON";
            this.dimension = 2;
        }
        if (tipeGeomCode.equals(POINT_3D)) {
            this.geomType = "POINT";
            this.dimension = 3;
        }
        if (tipeGeomCode.equals(POLYLINE_3D)) {
            this.geomType = "POLYLINE";
            this.dimension = 3;
        }
        if (tipeGeomCode.equals(POLYGON_3D)) {
            this.geomType = "POLYGON";
            this.dimension = 3;
        }
        if (tipeGeomCode.equals(MESH)) {
            this.geomType = "MESH";
            this.dimension = 1;
        }
    }

    String geomType;

    public String getGeomType() {
        return geomType;
    }

    public void setGeomType(String geomType) {
        this.geomType = geomType;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public String getSkala() {
        return skala;
    }

    public void setSkala(String skala) {
        this.skala = skala;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getSubKategori() {
        return subKategori;
    }

    public void setSubKategori(String subKategori) {
        this.subKategori = subKategori;
    }
    int dimension;
    String skala;
    String kategori;
    String subKategori;
}
