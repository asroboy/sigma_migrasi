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
public class MdScopeDescAttributes implements java.io.Serializable{
    
    private BigDecimal mdScopeDescriptionId;
    private String attributes;

    public MdScopeDescAttributes() {
    }

    public MdScopeDescAttributes(BigDecimal mdScopeDescriptionId) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
    }

    public MdScopeDescAttributes(BigDecimal mdScopeDescriptionId, String attributes) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
        this.attributes = attributes;
    }

    public BigDecimal getMdScopeDescriptionId() {
        return mdScopeDescriptionId;
    }

    public void setMdScopeDescriptionId(BigDecimal mdScopeDescriptionId) {
        this.mdScopeDescriptionId = mdScopeDescriptionId;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
    
    
}
