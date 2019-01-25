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
public class CiTelephone implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal ciContactId;

    public CiTelephone() {
    }

    public CiTelephone(BigDecimal id) {
        this.id = id;
    }
  
    public CiTelephone(BigDecimal id, BigDecimal ciContactId) {
        this.id = id;
        this.ciContactId = ciContactId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getCiContactId() {
        return ciContactId;
    }

    public void setCiContactId(BigDecimal ciContactId) {
        this.ciContactId = ciContactId;
    }
    
    
    
}
