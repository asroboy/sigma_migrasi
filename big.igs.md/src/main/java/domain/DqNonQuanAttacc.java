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
public class DqNonQuanAttacc implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal dqDataQualityId;
    private BigDecimal dqThematicAccuracyId;

    public DqNonQuanAttacc() {
    }

    public DqNonQuanAttacc(BigDecimal id) {
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

    public BigDecimal getDqThematicAccuracyId() {
        return dqThematicAccuracyId;
    }

    public void setDqThematicAccuracyId(BigDecimal dqThematicAccuracyId) {
        this.dqThematicAccuracyId = dqThematicAccuracyId;
    }


}
