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
public class DqNonQuanAttaccModel {
 
    private BigDecimal id;
    private BigDecimal dqDataQualityId;
    private BigDecimal dqThematicAccuracyId;

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

    public BigDecimal getDqThematicAccuracyId() {
        return dqThematicAccuracyId;
    }

    public void setDqThematicAccuracyId(BigDecimal dqThematicAccuracyId) {
        this.dqThematicAccuracyId = dqThematicAccuracyId;
    }

}
