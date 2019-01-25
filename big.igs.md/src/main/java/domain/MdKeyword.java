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
public class MdKeyword implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal mdIdentificationId;
    private BigDecimal svServiceIdentificationId;
    private String type;

    public MdKeyword() {
    }

    public MdKeyword(BigDecimal id) {
        this.id = id;
    }

    public MdKeyword(BigDecimal id, BigDecimal mdIdentificationId, BigDecimal svServiceIdentificationId, String type) {
        this.id = id;
        this.mdIdentificationId = mdIdentificationId;
        this.svServiceIdentificationId = svServiceIdentificationId;
        this.type = type;
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

    public BigDecimal getSvServiceIdentificationId() {
        return svServiceIdentificationId;
    }

    public void setSvServiceIdentificationId(BigDecimal svServiceIdentificationId) {
        this.svServiceIdentificationId = svServiceIdentificationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
