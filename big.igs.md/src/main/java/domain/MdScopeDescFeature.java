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
public class MdScopeDescFeature implements java.io.Serializable{
    
     
    private BigDecimal mdScopeDescriptionId;
    private String features;

    public MdScopeDescFeature() {
    }

    public MdScopeDescFeature(BigDecimal mdScopeDescriptionId) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
    }

    public MdScopeDescFeature(BigDecimal mdScopeDescriptionId, String features) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
        this.features = features;
    }

    public BigDecimal getMdScopeDescriptionId() {
        return mdScopeDescriptionId;
    }

    public void setMdScopeDescriptionId(BigDecimal mdScopeDescriptionId) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    
}
