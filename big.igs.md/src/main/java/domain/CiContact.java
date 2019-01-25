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
public class CiContact implements java.io.Serializable{
    
    private BigDecimal id;
    private String contactInstructions;
    private String houseOfService;
    private BigDecimal ciResponsiblePartyId;

    public CiContact() {
    }

    public CiContact(BigDecimal id, String contactInstructions, String houseOfService, BigDecimal ciResponsiblePartyId) {
        this.id = id;
        this.contactInstructions = contactInstructions;
        this.houseOfService = houseOfService;
        this.ciResponsiblePartyId = ciResponsiblePartyId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getContactInstructions() {
        return contactInstructions;
    }

    public void setContactInstructions(String contactInstructions) {
        this.contactInstructions = contactInstructions;
    }

    public String getHouseOfService() {
        return houseOfService;
    }

    public void setHouseOfService(String houseOfService) {
        this.houseOfService = houseOfService;
    }

    public BigDecimal getCiResponsiblePartyId() {
        return ciResponsiblePartyId;
    }

    public void setCiResponsiblePartyId(BigDecimal ciResponsiblePartyId) {
        this.ciResponsiblePartyId = ciResponsiblePartyId;
    }
       
}
