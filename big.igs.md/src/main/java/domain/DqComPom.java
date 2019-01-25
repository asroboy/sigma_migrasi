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
public class DqComPom implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal dqDataQualityId;
    private BigDecimal dqCompletenessId;

    public DqComPom() {
    }

    public DqComPom(BigDecimal id) {
        this.id = id;
    }

    public DqComPom(BigDecimal id, BigDecimal dqDataQualityId, BigDecimal dqCompletenessId) {
        this.id = id;
        this.dqDataQualityId = dqDataQualityId;
        this.dqCompletenessId = dqCompletenessId;
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

    public BigDecimal getDqCompletenessId() {
        return dqCompletenessId;
    }

    public void setDqCompletenessId(BigDecimal dqCompletenessId) {
        this.dqCompletenessId = dqCompletenessId;
    }

    
    

}
