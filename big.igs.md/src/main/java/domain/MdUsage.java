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
public class MdUsage implements java.io.Serializable{
    
    private BigDecimal id;
    private String spesificUsage;
    private String usageDateTime;
    private String userDeterminedLimitations;
    private BigDecimal mdIdentificationId;

    public MdUsage() {
    }

    public MdUsage(BigDecimal id) {
        this.id = id;
    }

    public MdUsage(BigDecimal id, String spesificUsage, String usageDateTime, String userDeterminedLimitations, BigDecimal mdIdentificationId) {
        this.id = id;
        this.spesificUsage = spesificUsage;
        this.usageDateTime = usageDateTime;
        this.userDeterminedLimitations = userDeterminedLimitations;
        this.mdIdentificationId = mdIdentificationId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSpesificUsage() {
        return spesificUsage;
    }

    public void setSpesificUsage(String spesificUsage) {
        this.spesificUsage = spesificUsage;
    }

    public String getUsageDateTime() {
        return usageDateTime;
    }

    public void setUsageDateTime(String usageDateTime) {
        this.usageDateTime = usageDateTime;
    }

    public String getUserDeterminedLimitations() {
        return userDeterminedLimitations;
    }

    public void setUserDeterminedLimitations(String userDeterminedLimitations) {
        this.userDeterminedLimitations = userDeterminedLimitations;
    }

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }
    
    
}
