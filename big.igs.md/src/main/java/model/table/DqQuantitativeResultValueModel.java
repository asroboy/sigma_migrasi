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
public class DqQuantitativeResultValueModel {
    
    private BigDecimal dqQuantitativeResultId;
    private String value;

    public BigDecimal getDqQuantitativeResultId() {
        return dqQuantitativeResultId;
    }

    public void setDqQuantitativeResultId(BigDecimal dqQuantitativeResultId) {
        this.dqQuantitativeResultId = dqQuantitativeResultId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
