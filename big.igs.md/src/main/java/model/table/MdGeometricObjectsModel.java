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
public class MdGeometricObjectsModel {
    
     
     private BigDecimal id;
     private BigDecimal geometricObjectCount;
     private String geometricObjectType;
     private BigDecimal mdVectorSpatialRepresentId;

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

    public BigDecimal getMdVectorSpatialRepresentId() {
        return mdVectorSpatialRepresentId;
    }

    public void setMdVectorSpatialRepresentId(BigDecimal mdVectorSpatialRepresentId) {
        this.mdVectorSpatialRepresentId = mdVectorSpatialRepresentId;
    }

    public String getGeometricObjectType() {
        return geometricObjectType;
    }

    public void setGeometricObjectType(String geometricObjectType) {
        this.geometricObjectType = geometricObjectType;
    }
    
    
     
    
}
