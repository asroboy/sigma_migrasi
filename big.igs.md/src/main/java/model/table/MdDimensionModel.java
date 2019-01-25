/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;

/**
 *
 * @author wallet
 */
public class MdDimensionModel {
    
    private BigDecimal id;
    private BigDecimal resolution;
    private String dimensionName;
    private BigDecimal mdGridSpatialRepresentId;
    private String dimensionSize;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getResolution() {
        return resolution;
    }

    public void setResolution(BigDecimal resolution) {
        this.resolution = resolution;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    public BigDecimal getMdGridSpatialRepresentId() {
        return mdGridSpatialRepresentId;
    }

    public void setMdGridSpatialRepresentId(BigDecimal mdGridSpatialRepresentId) {
        this.mdGridSpatialRepresentId = mdGridSpatialRepresentId;
    }

    public String getDimensionSize() {
        return dimensionSize;
    }

    public void setDimensionSize(String dimensionSize) {
        this.dimensionSize = dimensionSize;
    }
    
}
