/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;

/**
 *
 * @author wallet
 */
public class ExGeographicExtent implements java.io.Serializable{
    
    private BigDecimal id;
    private String extendsType;
    private BigDecimal extentTypeCode;
    private String measureDescription;
    private BigDecimal exExtentId;
    private BigDecimal exSpatialTemporalExtentId;

    public ExGeographicExtent() {
    }

    public ExGeographicExtent(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(String extendsType) {
        this.extendsType = extendsType;
    }

    public BigDecimal getExtentTypeCode() {
        return extentTypeCode;
    }

    public void setExtentTypeCode(BigDecimal extentTypeCode) {
        this.extentTypeCode = extentTypeCode;
    }
    
    public String getMeasureDescription() {
        return measureDescription;
    }

    public void setMeasureDescription(String measureDescription) {
        this.measureDescription = measureDescription;
    }

    public BigDecimal getExExtentId() {
        return exExtentId;
    }

    public void setExExtentId(BigDecimal exExtentId) {
        this.exExtentId = exExtentId;
    }

    public BigDecimal getExSpatialTemporalExtentId() {
        return exSpatialTemporalExtentId;
    }

    public void setExSpatialTemporalExtentId(BigDecimal exSpatialTemporalExtentId) {
        this.exSpatialTemporalExtentId = exSpatialTemporalExtentId;
    }
    
    
    
}
