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
public class MdExtendedElementInfoParentModel {
    
    private BigDecimal mdExtendedElementInfoId;
    private String parentEntity;

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
