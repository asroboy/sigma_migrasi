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
public class MdIdentificationCredit implements java.io.Serializable{
    
    private BigDecimal mdIdentificationId;
    private String credit;

    public MdIdentificationCredit() {
    }

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
    
    
    
}
