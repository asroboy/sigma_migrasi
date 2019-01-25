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
public class MdConstraints implements java.io.Serializable{
    
    private String extendsType;
    private BigDecimal id;
    private BigDecimal mdIdentificationId;
    private BigDecimal mdMetadataId;
    private BigDecimal svServiceIdentificationId;

    public MdConstraints() {
    }

    public MdConstraints(BigDecimal id) {
        this.id = id;
    }

    public MdConstraints(String extendsType, BigDecimal id, BigDecimal mdIdentificationId, BigDecimal mdMetadataId, BigDecimal svServiceIdentificationId) {
        this.extendsType = extendsType;
        this.id = id;
        this.mdIdentificationId = mdIdentificationId;
        this.mdMetadataId = mdMetadataId;
        this.svServiceIdentificationId = svServiceIdentificationId;
    }
       
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

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }

    public BigDecimal getMdMetadataId() {
        return mdMetadataId;
    }

    public void setMdMetadataId(BigDecimal mdMetadataId) {
        this.mdMetadataId = mdMetadataId;
    }
  
    public BigDecimal getSvServiceIdentificationId() {
        return svServiceIdentificationId;
    }

    public void setSvServiceIdentificationId(BigDecimal svServiceIdentificationId) {
        this.svServiceIdentificationId = svServiceIdentificationId;
    }
    
    
}
