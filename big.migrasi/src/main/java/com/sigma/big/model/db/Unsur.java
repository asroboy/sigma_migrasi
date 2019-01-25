/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.model.db;

import java.util.HashMap;

/**
 *
 * @author Ridho
 */
public class Unsur {

    int id;
    String name;
    String fcode;
    Produk produk;
    HashMap<String, Attributes> attributes;

    public HashMap<String, Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, Attributes> attributes) {
        this.attributes = attributes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

}
