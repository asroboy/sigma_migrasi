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
public class ExTemporalExtent implements java.io.Serializable{
    
    private BigDecimal id;
    private String extendsType;
    private BigDecimal exExtentId;

    public ExTemporalExtent() {
    }
    
    public ExTemporalExtent(BigDecimal id, String extendsType, BigDecimal exExtentId) {
        this.id = id;
        this.extendsType = extendsType;
        this.exExtentId = exExtentId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(String extendsType) {
        this.extendsType = extendsType;
    }

    public BigDecimal getExExtentId() {
        return exExtentId;
    }

    public void setExExtentId(BigDecimal exExtentId) {
        this.exExtentId = exExtentId;
    }
    
    
    
}
