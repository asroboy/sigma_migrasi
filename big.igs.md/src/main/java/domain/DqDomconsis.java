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
public class DqDomconsis implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal dqDataQualityId;
    private BigDecimal dqLogicalConsistencyId;

    public DqDomconsis() {
    }

    public DqDomconsis(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getDqDataQualityId() {
        return dqDataQualityId;
    }

    public void setDqDataQualityId(BigDecimal dqDataQualityId) {
        this.dqDataQualityId = dqDataQualityId;
    }

    public BigDecimal getDqLogicalConsistencyId() {
        return dqLogicalConsistencyId;
    }

    public void setDqLogicalConsistencyId(BigDecimal dqLogicalConsistencyId) {
        this.dqLogicalConsistencyId = dqLogicalConsistencyId;
    }

   
    
}
