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
public class MdScopeDescriptionModel {
 
    private BigDecimal id;
    private String dataSet;
    private String other;
    private BigDecimal mdMaintenanceInfoId;
    private BigDecimal dqScopeId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDataSet() {
        return dataSet;
    }

    public void setDataSet(String dataSet) {
        this.dataSet = dataSet;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public BigDecimal getMdMaintenanceInfoId() {
        return mdMaintenanceInfoId;
    }

    public void setMdMaintenanceInfoId(BigDecimal mdMaintenanceInfoId) {
        this.mdMaintenanceInfoId = mdMaintenanceInfoId;
    }

    public BigDecimal getDqScopeId() {
        return dqScopeId;
    }

    public void setDqScopeId(BigDecimal dqScopeId) {
        this.dqScopeId = dqScopeId;
    }
    
    
}
