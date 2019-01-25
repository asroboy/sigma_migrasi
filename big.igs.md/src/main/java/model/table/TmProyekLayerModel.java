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
public class TmProyekLayerModel {
    
     private BigDecimal id;
     private BigDecimal idLayer;
     private BigDecimal idProyek;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getIdLayer() {
        return idLayer;
    }

    public void setIdLayer(BigDecimal idLayer) {
        this.idLayer = idLayer;
    }

    public BigDecimal getIdProyek() {
        return idProyek;
    }

    public void setIdProyek(BigDecimal idProyek) {
        this.idProyek = idProyek;
    }
     
     
}
