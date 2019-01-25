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
public class MdGeometricObjects implements java.io.Serializable{
 
     private BigDecimal id;
     private BigDecimal geometricObjectCount;
     private String geometricObjectType;
     private BigDecimal mdVectorSpatialRepresentId;

    public MdGeometricObjects() {
    }

    public MdGeometricObjects(BigDecimal id) {
        this.id = id;
    }

    public MdGeometricObjects(BigDecimal id, BigDecimal geometricObjectCount, String geometricObjectType, BigDecimal mdVectorSpatialRepresentId) {
        this.id = id;
        this.geometricObjectCount = geometricObjectCount;
        this.geometricObjectType = geometricObjectType;
        this.mdVectorSpatialRepresentId = mdVectorSpatialRepresentId;
    }
     
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getGeometricObjectCount() {
        return geometricObjectCount;
    }

    public void setGeometricObjectCount(BigDecimal geometricObjectCount) {
        this.geometricObjectCount = geometricObjectCount;
    }

    public String getGeometricObjectType() {
        return geometricObjectType;
    }

    public void setGeometricObjectType(String geometricObjectType) {
        this.geometricObjectType = geometricObjectType;
    }
    
    public BigDecimal getMdVectorSpatialRepresentId() {
        return mdVectorSpatialRepresentId;
    }

    public void setMdVectorSpatialRepresentId(BigDecimal mdVectorSpatialRepresentId) {
        this.mdVectorSpatialRepresentId = mdVectorSpatialRepresentId;
    }
     
    
}
