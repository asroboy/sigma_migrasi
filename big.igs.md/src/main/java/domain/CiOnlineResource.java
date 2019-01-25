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
public class CiOnlineResource implements java.io.Serializable{
    
     private BigDecimal id;
     private String applicationProfile;
     private String description;
     private String linkage;
     private String name;
     private String protocol;
     private BigDecimal ciContactId;
     private BigDecimal mdDigitalTransferOptionsId;
     private String function_;
     private BigDecimal mdMetadataExtensionInfoId;
     private BigDecimal svOperationMetadataId;

    public CiOnlineResource() {
    }

    public CiOnlineResource(BigDecimal id) {
        this.id = id;
    }

    public CiOnlineResource(BigDecimal id, String applicationProfile, String description, String linkage, String name, String protocol, BigDecimal ciContactId, BigDecimal mdDigitalTransferOptionsId, String function_, BigDecimal mdMetadataExtensionInfoId, BigDecimal svOperationMetadataId) {
        this.id = id;
        this.applicationProfile = applicationProfile;
        this.description = description;
        this.linkage = linkage;
        this.name = name;
        this.protocol = protocol;
        this.ciContactId = ciContactId;
        this.mdDigitalTransferOptionsId = mdDigitalTransferOptionsId;
        this.function_ = function_;
        this.mdMetadataExtensionInfoId = mdMetadataExtensionInfoId;
        this.svOperationMetadataId = svOperationMetadataId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getApplicationProfile() {
        return applicationProfile;
    }

    public void setApplicationProfile(String applicationProfile) {
        this.applicationProfile = applicationProfile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkage() {
        return linkage;
    }

    public void setLinkage(String linkage) {
        this.linkage = linkage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public BigDecimal getCiContactId() {
        return ciContactId;
    }

    public void setCiContactId(BigDecimal ciContactId) {
        this.ciContactId = ciContactId;
    }

    public BigDecimal getMdDigitalTransferOptionsId() {
        return mdDigitalTransferOptionsId;
    }

    public void setMdDigitalTransferOptionsId(BigDecimal mdDigitalTransferOptionsId) {
        this.mdDigitalTransferOptionsId = mdDigitalTransferOptionsId;
    }

    public String getFunction_() {
        return function_;
    }

    public void setFunction_(String function_) {
        this.function_ = function_;
    }

    public BigDecimal getMdMetadataExtensionInfoId() {
        return mdMetadataExtensionInfoId;
    }

    public void setMdMetadataExtensionInfoId(BigDecimal mdMetadataExtensionInfoId) {
        this.mdMetadataExtensionInfoId = mdMetadataExtensionInfoId;
    }

    public BigDecimal getSvOperationMetadataId() {
        return svOperationMetadataId;
    }

    public void setSvOperationMetadataId(BigDecimal svOperationMetadataId) {
        this.svOperationMetadataId = svOperationMetadataId;
    }
     
    
}
