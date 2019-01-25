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
public class RsIdentifier implements java.io.Serializable{
    
    private BigDecimal id;
    private String version;
    private String codeSpace;
    private String code;
    private BigDecimal mdIdentifierId;
    private BigDecimal mdReferenceSystemId;

    public RsIdentifier() {
    }

    public RsIdentifier(BigDecimal id) {
        this.id = id;
    }

    public RsIdentifier(BigDecimal id, String version, String codeSpace, BigDecimal mdReferenceSystemId,BigDecimal mdIdentifierId) {
        this.id = id;
        this.version = version;
        this.codeSpace = codeSpace;
        this.mdReferenceSystemId = mdReferenceSystemId;
        this.mdIdentifierId = mdIdentifierId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }

    public BigDecimal getMdReferenceSystemId() {
        return mdReferenceSystemId;
    }

    public void setMdReferenceSystemId(BigDecimal mdReferenceSystemId) {
        this.mdReferenceSystemId = mdReferenceSystemId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getMdIdentifierId() {
        return mdIdentifierId;
    }

    public void setMdIdentifierId(BigDecimal mdIdentifierId) {
        this.mdIdentifierId = mdIdentifierId;
    }
    
    

    
}
