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
public class MdRangeDimensionModel {
    
    private String extendsType;
    private BigDecimal id;
    private String descriptor;
    private String sequenceIdentifier;
    private BigDecimal mdCoverageDescriptionId;

    public String getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(String extendsType) {
        this.extendsType = extendsType;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getSequenceIdentifier() {
        return sequenceIdentifier;
    }

    public void setSequenceIdentifier(String sequenceIdentifier) {
        this.sequenceIdentifier = sequenceIdentifier;
    }

    public BigDecimal getMdCoverageDescriptionId() {
        return mdCoverageDescriptionId;
    }

    public void setMdCoverageDescriptionId(BigDecimal mdCoverageDescriptionId) {
        this.mdCoverageDescriptionId = mdCoverageDescriptionId;
    }
    
    
}