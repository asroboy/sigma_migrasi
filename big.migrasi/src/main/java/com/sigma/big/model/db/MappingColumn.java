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
public class MappingColumn {

    int id;
    MappingMatrix mappingMatrix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MappingMatrix getMappingMatrix() {
        return mappingMatrix;
    }

    public void setMappingMatrix(MappingMatrix mappingMatrix) {
        this.mappingMatrix = mappingMatrix;
    }

    public String getColSourceName() {
        return colSourceName;
    }

    public void setColSourceName(String colSourceName) {
        this.colSourceName = colSourceName;
    }

    public String getColSourceType() {
        return colSourceType;
    }

    public void setColSourceType(String colSourceType) {
        this.colSourceType = colSourceType;
    }

    public String getColTargetName() {
        return colTargetName;
    }

    public void setColTargetName(String colTargetName) {
        this.colTargetName = colTargetName;
    }

    public String getColTargetType() {
        return colTargetType;
    }

    public void setColTargetType(String colTargetType) {
        this.colTargetType = colTargetType;
    }
    String colSourceName;
    String colSourceType;
    String colTargetName;
    String colTargetType;

}
