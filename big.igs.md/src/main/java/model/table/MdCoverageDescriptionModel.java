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
public class MdCoverageDescriptionModel {
 
    private String attributeDescription;
    private BigDecimal id;
    private String contentType;
    private BigDecimal mdContentInfoId;

    public String getAttributeDescription() {
        return attributeDescription;
    }

    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public BigDecimal getMdContentInfoId() {
        return mdContentInfoId;
    }

    public void setMdContentInfoId(BigDecimal mdContentInfoId) {
        this.mdContentInfoId = mdContentInfoId;
    }
    
}
