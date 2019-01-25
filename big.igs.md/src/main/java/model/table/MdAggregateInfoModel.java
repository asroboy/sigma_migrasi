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
public class MdAggregateInfoModel {
    
    private BigDecimal id;
    private String assositionType;
    private BigDecimal mdIdentificationId;
    private String initiativeType;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAssositionType() {
        return assositionType;
    }

    public void setAssositionType(String assositionType) {
        this.assositionType = assositionType;
    }

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }

    public String getInitiativeType() {
        return initiativeType;
    }

    public void setInitiativeType(String initiativeType) {
        this.initiativeType = initiativeType;
    }
}
