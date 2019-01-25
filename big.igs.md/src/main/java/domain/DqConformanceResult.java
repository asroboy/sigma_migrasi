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
public class DqConformanceResult implements java.io.Serializable{
    
    private String explanation;
    private BigDecimal pass;
    private BigDecimal dqResultId;

    public DqConformanceResult() {
    }

    public DqConformanceResult(String explanation, BigDecimal pass, BigDecimal dqResultId) {
        this.explanation = explanation;
        this.pass = pass;
        this.dqResultId = dqResultId;
    }   
    
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public BigDecimal getPass() {
        return pass;
    }

    public void setPass(BigDecimal pass) {
        this.pass = pass;
    }
    
    public BigDecimal getDqResultId() {
        return dqResultId;
    }

    public void setDqResultId(BigDecimal dqResultId) {
        this.dqResultId = dqResultId;
    }

   
}
