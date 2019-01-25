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
public class DqConformanceResultModel {
    
    private String explanation;
    private BigDecimal pass;
    private BigDecimal dqResultId;
    private String stringPass;

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

    public String getStringPass() {
        return stringPass;
    }

    public void setStringPass(String stringPass) {
        this.stringPass = stringPass;
    }

    
   
}
