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
public class MdGridSpatialRepresent implements java.io.Serializable{
    
    private BigDecimal numberOfDimensions;
    private BigDecimal transformationParamAvail;
    private BigDecimal id;
    private String cellGeometry;

    public MdGridSpatialRepresent() {
    }

    public MdGridSpatialRepresent(BigDecimal id) {
        this.id = id;
    }

    public MdGridSpatialRepresent(BigDecimal numberOfDimensions, BigDecimal transformationParamAvail, BigDecimal id, String cellGeometry) {
        this.numberOfDimensions = numberOfDimensions;
        this.transformationParamAvail = transformationParamAvail;
        this.id = id;
        this.cellGeometry = cellGeometry;
    }

    public BigDecimal getNumberOfDimensions() {
        return numberOfDimensions;
    }

    public void setNumberOfDimensions(BigDecimal numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    public BigDecimal getTransformationParamAvail() {
        return transformationParamAvail;
    }

    public void setTransformationParamAvail(BigDecimal transformationParamAvail) {
        this.transformationParamAvail = transformationParamAvail;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCellGeometry() {
        return cellGeometry;
    }

    public void setCellGeometry(String cellGeometry) {
        this.cellGeometry = cellGeometry;
    }
    
    
}
