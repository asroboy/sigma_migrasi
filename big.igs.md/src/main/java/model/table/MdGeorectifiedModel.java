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
public class MdGeorectifiedModel {
    
    private String centerPoint;
    private BigDecimal checkPointAvailability;
    private BigDecimal checkPointDescription;
    private String transformationDimensionDesc;
    private BigDecimal id;
    private String pointInPixel;

    public String getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(String centerPoint) {
        this.centerPoint = centerPoint;
    }

    public BigDecimal getCheckPointAvailability() {
        return checkPointAvailability;
    }

    public void setCheckPointAvailability(BigDecimal checkPointAvailability) {
        this.checkPointAvailability = checkPointAvailability;
    }

    public BigDecimal getCheckPointDescription() {
        return checkPointDescription;
    }

    public void setCheckPointDescription(BigDecimal checkPointDescription) {
        this.checkPointDescription = checkPointDescription;
    }

    public String getTransformationDimensionDesc() {
        return transformationDimensionDesc;
    }

    public void setTransformationDimensionDesc(String transformationDimensionDesc) {
        this.transformationDimensionDesc = transformationDimensionDesc;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPointInPixel() {
        return pointInPixel;
    }

    public void setPointInPixel(String pointInPixel) {
        this.pointInPixel = pointInPixel;
    }
}
