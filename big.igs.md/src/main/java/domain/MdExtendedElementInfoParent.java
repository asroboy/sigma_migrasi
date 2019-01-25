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
public class MdExtendedElementInfoParent implements java.io.Serializable{
    
    private BigDecimal mdExtendedElementInfoId;
    private String parentEntity;

    public MdExtendedElementInfoParent() {
    }

    public MdExtendedElementInfoParent(BigDecimal mdExtendedElementInfoId) {
        this.mdExtendedElementInfoId = mdExtendedElementInfoId;
    }

    public BigDecimal getMdExtendedElementInfoId() {
        return mdExtendedElementInfoId;
    }

    public void setMdExtendedElementInfoId(BigDecimal mdExtendedElementInfoId) {
        this.mdExtendedElementInfoId = mdExtendedElementInfoId;
    }

    public String getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(String parentEntity) {
        this.parentEntity = parentEntity;
    }
    
    
}
