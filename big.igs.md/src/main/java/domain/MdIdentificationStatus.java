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
public class MdIdentificationStatus implements java.io.Serializable{
    
    private BigDecimal mdIdentificationId;
    private String status;

    public MdIdentificationStatus() {
    }

    public MdIdentificationStatus(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }

    public MdIdentificationStatus(BigDecimal mdIdentificationId, String status) {
        this.mdIdentificationId = mdIdentificationId;
        this.status = status;
    }

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
