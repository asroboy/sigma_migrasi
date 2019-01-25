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
public class MdMaintenanceInfoScope implements java.io.Serializable{
    
    private BigDecimal mdMaintenanceInfoId;
    private String updateScope;

    public MdMaintenanceInfoScope() {
    }

    public MdMaintenanceInfoScope(BigDecimal mdMaintenanceInfoId) {
        this.mdMaintenanceInfoId = mdMaintenanceInfoId;
    }

    public MdMaintenanceInfoScope(BigDecimal mdMaintenanceInfoId, String updateScope) {
        this.mdMaintenanceInfoId = mdMaintenanceInfoId;
        this.updateScope = updateScope;
    }

    public BigDecimal getMdMaintenanceInfoId() {
        return mdMaintenanceInfoId;
    }

    public void setMdMaintenanceInfoId(BigDecimal mdMaintenanceInfoId) {
        this.mdMaintenanceInfoId = mdMaintenanceInfoId;
    }

    public String getUpdateScope() {
        return updateScope;
    }

    public void setUpdateScope(String updateScope) {
        this.updateScope = updateScope;
    }

   
}
