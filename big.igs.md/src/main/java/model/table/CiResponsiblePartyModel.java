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
public class CiResponsiblePartyModel {
    
    public static final String CI_CITATIONID="ciCitationId";
    public static final String MD_DISTRIBUTORID="mdDistributorId";
    public static final String MD_EXTENDEDELEMENTINFOID="mdExtendedElementInfoId";
    public static final String MD_IDENTIFICATIONID="mdIdentificationId";
    public static final String MD_MAINTENANCEINFOID="mdMaintenanceInfoId";
    public static final String MD_METADATAID="mdMetadataId";
    public static final String LI_PROCESSSTEPID="liProcessStepId";
    public static final String MD_USAGEID="mdUsageId";
    public static final String ROLE="role";
    private BigDecimal id;
    private String individualName;
    private String organisationName;
    private String positionName;
    private BigDecimal ciCitationId;
    private BigDecimal mdDistributorId;
    private BigDecimal mdExtendedElementInfoId;
    private BigDecimal mdIdentificationId;
    private BigDecimal mdMaintenanceInfoId;
    private BigDecimal mdMetadataId;
    private BigDecimal liProcessStepId;
    private String role;
    private BigDecimal mdUsageId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getIndividualName() {
        return individualName;
    }

    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public BigDecimal getCiCitationId() {
        return ciCitationId;
    }

    public void setCiCitationId(BigDecimal ciCitationId) {
        this.ciCitationId = ciCitationId;
    }

    public BigDecimal getMdDistributorId() {
        return mdDistributorId;
    }

    public void setMdDistributorId(BigDecimal mdDistributorId) {
        this.mdDistributorId = mdDistributorId;
    }

    public BigDecimal getMdExtendedElementInfoId() {
        return mdExtendedElementInfoId;
    }

    public void setMdExtendedElementInfoId(BigDecimal mdExtendedElementInfoId) {
        this.mdExtendedElementInfoId = mdExtendedElementInfoId;
    }

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }

    public BigDecimal getMdMaintenanceInfoId() {
        return mdMaintenanceInfoId;
    }

    public void setMdMaintenanceInfoId(BigDecimal mdMaintenanceInfoId) {
        this.mdMaintenanceInfoId = mdMaintenanceInfoId;
    }

    public BigDecimal getMdMetadataId() {
        return mdMetadataId;
    }

    public void setMdMetadataId(BigDecimal mdMetadataId) {
        this.mdMetadataId = mdMetadataId;
    }

    public BigDecimal getLiProcessStepId() {
        return liProcessStepId;
    }

    public void setLiProcessStepId(BigDecimal liProcessStepId) {
        this.liProcessStepId = liProcessStepId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getMdUsageId() {
        return mdUsageId;
    }

    public void setMdUsageId(BigDecimal mdUsageId) {
        this.mdUsageId = mdUsageId;
    }
    
}
