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
public class MdScopeDescFeatureModel {
    
    private BigDecimal mdScopeDescriptionId;
    private String features;

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
