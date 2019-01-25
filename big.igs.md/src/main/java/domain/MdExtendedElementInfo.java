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
public class MdExtendedElementInfo implements java.io.Serializable{
    
     private BigDecimal id;
     private String condition;
     private String definition;
     private BigDecimal domainCode;
     private String domainValue;
     private String maximumOccurrence;
     private String name;
     private String rule;
     private String shortName;
     private String dataType;
     private BigDecimal mdMetadataExtensionInfoId;
     private String obligation;

    public MdExtendedElementInfo() {
    }
    
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public BigDecimal getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(BigDecimal domainCode) {
        this.domainCode = domainCode;
    }

    public String getDomainValue() {
        return domainValue;
    }

    public void setDomainValue(String domainValue) {
        this.domainValue = domainValue;
    }

    public String getMaximumOccurrence() {
        return maximumOccurrence;
    }

    public void setMaximumOccurrence(String maximumOccurrence) {
        this.maximumOccurrence = maximumOccurrence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public BigDecimal getMdMetadataExtensionInfoId() {
        return mdMetadataExtensionInfoId;
    }

    public void setMdMetadataExtensionInfoId(BigDecimal mdMetadataExtensionInfoId) {
        this.mdMetadataExtensionInfoId = mdMetadataExtensionInfoId;
    }

    public String getObligation() {
        return obligation;
    }

    public void setObligation(String obligation) {
        this.obligation = obligation;
    }
     
     

               
}