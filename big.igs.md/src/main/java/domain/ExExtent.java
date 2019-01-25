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
public class ExExtent implements java.io.Serializable{
    
    private BigDecimal id;
    private String description;
    private BigDecimal mdDataIdentificationId;
    private BigDecimal dqScopeId;
    private BigDecimal svServiceIdentificationId;
    private BigDecimal liSourceId;

    public ExExtent() {
    }

    public ExExtent(BigDecimal id) {
        this.id = id;
    }

    public ExExtent(BigDecimal id, String description, BigDecimal mdDataIdentificationId, BigDecimal dqScopeId, BigDecimal svServiceIdentificationId, BigDecimal liSourceId) {
        this.id = id;
        this.description = description;
        this.mdDataIdentificationId = mdDataIdentificationId;
        this.dqScopeId = dqScopeId;
        this.svServiceIdentificationId = svServiceIdentificationId;
        this.liSourceId = liSourceId;
    }
    
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMdDataIdentificationId() {
        return mdDataIdentificationId;
    }

    public void setMdDataIdentificationId(BigDecimal mdDataIdentificationId) {
        this.mdDataIdentificationId = mdDataIdentificationId;
    }

    public BigDecimal getDqScopeId() {
        return dqScopeId;
    }

    public void setDqScopeId(BigDecimal dqScopeId) {
        this.dqScopeId = dqScopeId;
    }

    public BigDecimal getSvServiceIdentificationId() {
        return svServiceIdentificationId;
    }

    public void setSvServiceIdentificationId(BigDecimal svServiceIdentificationId) {
        this.svServiceIdentificationId = svServiceIdentificationId;
    }

    public BigDecimal getLiSourceId() {
        return liSourceId;
    }

    public void setLiSourceId(BigDecimal liSourceId) {
        this.liSourceId = liSourceId;
    }
    
    
    
}
