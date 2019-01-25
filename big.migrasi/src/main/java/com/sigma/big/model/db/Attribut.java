/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.model.db;

/**
 *
 * @author Ridho
 */
public class Attribut {
    
    int id;
    Unsur unsur;
    String datType;
    int dataSize;
    boolean nullable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unsur getUnsur() {
        return unsur;
    }

    public void setUnsur(Unsur unsur) {
        this.unsur = unsur;
    }

    public String getDatType() {
        return datType;
    }

    public void setDatType(String datType) {
        this.datType = datType;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
    
    
    
}
