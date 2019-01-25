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
public class MdScopeDescAttributesInst implements java.io.Serializable{
    
    private BigDecimal mdScopeDescriptionId;
    private String attributesInstances;

    public MdScopeDescAttributesInst() {
    }

    public MdScopeDescAttributesInst(BigDecimal mdScopeDescriptionId) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
    }

    public MdScopeDescAttributesInst(BigDecimal mdScopeDescriptionId, String attributesInstances) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
        this.attributesInstances = attributesInstances;
    }

    public BigDecimal getMdScopeDescriptionId() {
        return mdScopeDescriptionId;
    }

    public void setMdScopeDescriptionId(BigDecimal mdScopeDescriptionId) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
    }

    public String getAttributesInstances() {
        return attributesInstances;
    }

    public void setAttributesInstances(String attributesInstances) {
        this.attributesInstances = attributesInstances;
    }

    
}
