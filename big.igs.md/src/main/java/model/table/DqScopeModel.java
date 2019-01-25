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
public class DqScopeModel {
    
    private BigDecimal id;
    private String dqLevel;
    private BigDecimal dqDataQualityId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDqLevel() {
        return dqLevel;
    }

    public void setDqLevel(String dqLevel) {
        this.dqLevel = dqLevel;
    }

    public BigDecimal getDqDataQualityId() {
        return dqDataQualityId;
    }

    public void setDqDataQualityId(BigDecimal dqDataQualityId) {
        this.dqDataQualityId = dqDataQualityId;
    }
    
    
}
