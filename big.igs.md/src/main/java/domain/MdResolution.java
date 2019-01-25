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
public class MdResolution implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal distance;
    private BigDecimal mdDataIdentificationId;
    private String equivalentScale;

    public MdResolution() {
    }

    public MdResolution(BigDecimal id) {
        this.id = id;
    }

    public MdResolution(BigDecimal id, BigDecimal distance, BigDecimal mdDataIdentificationId, String equivalentScale) {
        this.id = id;
        this.distance = distance;
        this.mdDataIdentificationId = mdDataIdentificationId;
        this.equivalentScale = equivalentScale;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getMdDataIdentificationId() {
        return mdDataIdentificationId;
    }

    public void setMdDataIdentificationId(BigDecimal mdDataIdentificationId) {
        this.mdDataIdentificationId = mdDataIdentificationId;
    }

    public String getEquivalentScale() {
        return equivalentScale;
    }

    public void setEquivalentScale(String equivalentScale) {
        this.equivalentScale = equivalentScale;
    }
    
    
}
