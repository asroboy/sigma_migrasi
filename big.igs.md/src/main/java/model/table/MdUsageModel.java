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
public class MdUsageModel {
    
    private BigDecimal id;
    private String spesificUsage;
    private String usageDateTime;
    private String userDeterminedLimitations;
    private BigDecimal mdIdentificationId;

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
