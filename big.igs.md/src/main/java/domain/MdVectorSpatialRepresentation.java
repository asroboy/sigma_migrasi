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
public class MdVectorSpatialRepresentation implements java.io.Serializable{
 
    private BigDecimal id;
    private String topologyLevel;

    public MdVectorSpatialRepresentation() {
    }

    public MdVectorSpatialRepresentation(BigDecimal id) {
        this.id = id;
    }

    public MdVectorSpatialRepresentation(BigDecimal id, String topologyLevel) {
        this.id = id;
        this.topologyLevel = topologyLevel;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTopologyLevel() {
        return topologyLevel;
    }

    public void setTopologyLevel(String topologyLevel) {
        this.topologyLevel = topologyLevel;
    }
    
    
}
