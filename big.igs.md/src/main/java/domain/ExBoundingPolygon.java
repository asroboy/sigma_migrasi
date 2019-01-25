/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.sql.Clob;

/**
 *
 * @author wallet
 */
public class ExBoundingPolygon implements java.io.Serializable{
    
    private BigDecimal exGeographicExtentId;

    public ExBoundingPolygon() {
    }

    public ExBoundingPolygon(BigDecimal exGeographicExtentId) {
        this.exGeographicExtentId = exGeographicExtentId;
    }

    public BigDecimal getExGeographicExtentId() {
        return exGeographicExtentId;
    }

    public void setExGeographicExtentId(BigDecimal exGeographicExtentId) {
        this.exGeographicExtentId = exGeographicExtentId;
    }
    
}
