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
public class MdAggregateInfo implements java.io.Serializable{
    
    private BigDecimal id;
    private String assosiationType;
    private BigDecimal mdIdentificationId;
    private String initiativeType;

    public MdAggregateInfo() {
    }

    public MdAggregateInfo(BigDecimal id) {
        this.id = id;
    }

    public MdAggregateInfo(BigDecimal id, String assosiationType, BigDecimal mdIdentificationId, String initiativeType) {
        this.id = id;
        this.assosiationType = assosiationType;
        this.mdIdentificationId = mdIdentificationId;
        this.initiativeType = initiativeType;
    }
    
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAssosiationType() {
        return assosiationType;
    }

    public void setAssosiationType(String assosiationType) {
        this.assosiationType = assosiationType;
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
