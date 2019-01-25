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
public class MdSpatialRepresentation implements java.io.Serializable{
    
    private BigDecimal id;
    private String extendsType;
    private BigDecimal mdMetadataId;

    public MdSpatialRepresentation() {
    }

    public MdSpatialRepresentation(BigDecimal id) {
        this.id = id;
    }

    public MdSpatialRepresentation(BigDecimal id, String extendsType, BigDecimal mdMetadataId) {
        this.id = id;
        this.extendsType = extendsType;
        this.mdMetadataId = mdMetadataId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(String extendsType) {
        this.extendsType = extendsType;
    }

    public BigDecimal getMdMetadataId() {
        return mdMetadataId;
    }

    public void setMdMetadataId(BigDecimal mdMetadataId) {
        this.mdMetadataId = mdMetadataId;
    }
    
    
}
