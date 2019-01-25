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
public class ExTemporalExtentModel {
    
    private String extendsType;
    private BigDecimal id;
    private BigDecimal exExtendId;

    public String getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(String extendsType) {
        this.extendsType = extendsType;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getExExtendId() {
        return exExtendId;
    }

    public void setExExtendId(BigDecimal exExtendId) {
        this.exExtendId = exExtendId;
    }
        
    
}
