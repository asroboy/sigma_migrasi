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
public class LiLineage implements java.io.Serializable{
    
    private BigDecimal id;
    private String statement;
    private BigDecimal dqDataQualityId;

    public LiLineage() {
    }

    public LiLineage(BigDecimal id) {
        this.id = id;
    }

    public LiLineage(BigDecimal id, String statement, BigDecimal dqDataQualityId) {
        this.id = id;
        this.statement = statement;
        this.dqDataQualityId = dqDataQualityId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public BigDecimal getDqDataQualityId() {
        return dqDataQualityId;
    }

    public void setDqDataQualityId(BigDecimal dqDataQualityId) {
        this.dqDataQualityId = dqDataQualityId;
    }
    
}
