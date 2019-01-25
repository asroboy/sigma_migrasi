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
public class CiTelephoneFacsimile implements java.io.Serializable{
    
    private BigDecimal ciTelephoneId;
    private String facsimile;

    public CiTelephoneFacsimile() {
    }

    public CiTelephoneFacsimile(BigDecimal ciTelephoneId, String facsimile) {
        this.ciTelephoneId = ciTelephoneId;
        this.facsimile = facsimile;
    }

    public BigDecimal getCiTelephoneId() {
        return ciTelephoneId;
    }

    public void setCiTelephoneId(BigDecimal ciTelephoneId) {
        this.ciTelephoneId = ciTelephoneId;
    }

    public String getFacsimile() {
        return facsimile;
    }

    public void setFacsimile(String facsimile) {
        this.facsimile = facsimile;
    }
    
}
