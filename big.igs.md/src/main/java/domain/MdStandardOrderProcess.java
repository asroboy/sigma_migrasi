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
public class MdStandardOrderProcess implements java.io.Serializable{
    
    private BigDecimal id;
    private String fees;
    private String orderingInstruction;
    private String plannedAvailableDateTime;
    private String turnAround;
    private BigDecimal mdDistributorId;
    private BigDecimal svServiceIdentificationId;

    public MdStandardOrderProcess() {
    }

    public MdStandardOrderProcess(BigDecimal id) {
        this.id = id;
    }

    public MdStandardOrderProcess(BigDecimal id, String fees, String orderingInstruction, String plannedAvailableDateTime, String turnAround, BigDecimal mdDistributorId, BigDecimal svServiceIdentificationId) {
        this.id = id;
        this.fees = fees;
        this.orderingInstruction = orderingInstruction;
        this.plannedAvailableDateTime = plannedAvailableDateTime;
        this.turnAround = turnAround;
        this.mdDistributorId = mdDistributorId;
        this.svServiceIdentificationId = svServiceIdentificationId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getOrderingInstruction() {
        return orderingInstruction;
    }

    public void setOrderingInstruction(String orderingInstruction) {
        this.orderingInstruction = orderingInstruction;
    }

    public String getPlannedAvailableDateTime() {
        return plannedAvailableDateTime;
    }

    public void setPlannedAvailableDateTime(String plannedAvailableDateTime) {
        this.plannedAvailableDateTime = plannedAvailableDateTime;
    }

    public String getTurnAround() {
        return turnAround;
    }

    public void setTurnAround(String turnAround) {
        this.turnAround = turnAround;
    }

    public BigDecimal getMdDistributorId() {
        return mdDistributorId;
    }

    public void setMdDistributorId(BigDecimal mdDistributorId) {
        this.mdDistributorId = mdDistributorId;
    }

    public BigDecimal getSvServiceIdentificationId() {
        return svServiceIdentificationId;
    }

    public void setSvServiceIdentificationId(BigDecimal svServiceIdentificationId) {
        this.svServiceIdentificationId = svServiceIdentificationId;
    }
    
    
}
