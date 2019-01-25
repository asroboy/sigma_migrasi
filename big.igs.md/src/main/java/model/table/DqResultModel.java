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
public class DqResultModel {
    
    private String extendsType;
    private BigDecimal id;
    private BigDecimal dqElementId;

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

    public BigDecimal getDqElementId() {
        return dqElementId;
    }

    public void setDqElementId(BigDecimal dqElementId) {
        this.dqElementId = dqElementId;
    }   
    
    
}
