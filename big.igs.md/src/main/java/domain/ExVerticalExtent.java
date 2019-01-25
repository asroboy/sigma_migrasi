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
public class ExVerticalExtent implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal maximumValue;
    private BigDecimal minimumValue;
    private String verticalCrs;
    private BigDecimal exExtentId;

    public ExVerticalExtent() {
    }

    public ExVerticalExtent(BigDecimal id, BigDecimal maximumValue, BigDecimal minimumValue, String verticalCrs, BigDecimal exExtentId) {
        this.id = id;
        this.maximumValue = maximumValue;
        this.minimumValue = minimumValue;
        this.verticalCrs = verticalCrs;
        this.exExtentId = exExtentId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(BigDecimal maximumValue) {
        this.maximumValue = maximumValue;
    }

    public BigDecimal getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(BigDecimal minimumValue) {
        this.minimumValue = minimumValue;
    }

    public String getVerticalCrs() {
        return verticalCrs;
    }

    public void setVerticalCrs(String verticalCrs) {
        this.verticalCrs = verticalCrs;
    }

    public BigDecimal getExExtentId() {
        return exExtentId;
    }

    public void setExExtentId(BigDecimal exExtentId) {
        this.exExtentId = exExtentId;
    }
   
    
}
