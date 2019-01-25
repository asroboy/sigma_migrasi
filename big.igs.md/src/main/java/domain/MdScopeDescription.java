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
public class MdScopeDescription implements java.io.Serializable{
    
    private BigDecimal id;
    private String dataSet;
    private String other;
    private BigDecimal mdMaintenanceInfoId;
    private BigDecimal dqScopeId;

    public MdScopeDescription() {
    }

    public MdScopeDescription(BigDecimal id) {
        this.id = id;
    }

    public MdScopeDescription(BigDecimal id, String dataSet, String other, BigDecimal mdMaintenanceInfoId, BigDecimal dqScopeId) {
        this.id = id;
        this.dataSet = dataSet;
        this.other = other;
        this.mdMaintenanceInfoId = mdMaintenanceInfoId;
        this.dqScopeId = dqScopeId;
    }

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
