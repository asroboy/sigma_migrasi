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
public class ExGeographicBoundingBox implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal eastBoundLongitude;
    private BigDecimal southBoundLongitude;
    private BigDecimal northBoundLongitude;
    private BigDecimal westBoundLongitude;
    private BigDecimal exGeographicExtentId;

    public ExGeographicBoundingBox() {
    }

    public ExGeographicBoundingBox(BigDecimal id) {
        this.id = id;
    }

    public ExGeographicBoundingBox(BigDecimal id, BigDecimal eastBoundLongitude, BigDecimal southBoundLongitude, BigDecimal northBoundLongitude, BigDecimal westBoundLongitude,BigDecimal exGeographicExtentId) {
        this.id = id;
        this.eastBoundLongitude = eastBoundLongitude;
        this.southBoundLongitude = southBoundLongitude;
        this.northBoundLongitude = northBoundLongitude;
        this.westBoundLongitude = westBoundLongitude;
        this.exGeographicExtentId = exGeographicExtentId;
    }
    
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getEastBoundLongitude() {
        return eastBoundLongitude;
    }

    public void setEastBoundLongitude(BigDecimal eastBoundLongitude) {
        this.eastBoundLongitude = eastBoundLongitude;
    }

    public BigDecimal getSouthBoundLongitude() {
        return southBoundLongitude;
    }

    public void setSouthBoundLongitude(BigDecimal southBoundLongitude) {
        this.southBoundLongitude = southBoundLongitude;
    }

    public BigDecimal getNorthBoundLongitude() {
        return northBoundLongitude;
    }

    public void setNorthBoundLongitude(BigDecimal northBoundLongitude) {
        this.northBoundLongitude = northBoundLongitude;
    }
    
    public BigDecimal getWestBoundLongitude() {
        return westBoundLongitude;
    }

    public void setWestBoundLongitude(BigDecimal westBoundLongitude) {
        this.westBoundLongitude = westBoundLongitude;
    }

    public BigDecimal getExGeographicExtentId() {
        return exGeographicExtentId;
    }

    public void setExGeographicExtentId(BigDecimal exGeographicExtentId) {
        this.exGeographicExtentId = exGeographicExtentId;
    }
    
    
    
}
