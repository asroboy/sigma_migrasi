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
public class TrSkalaNlpKabModel {
    
     
     private BigDecimal id;
     private BigDecimal idKab;
     private BigDecimal idSkalaNlp;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getIdKab() {
        return idKab;
    }

    public void setIdKab(BigDecimal idKab) {
        this.idKab = idKab;
    }

    public BigDecimal getIdSkalaNlp() {
        return idSkalaNlp;
    }

    public void setIdSkalaNlp(BigDecimal idSkalaNlp) {
        this.idSkalaNlp = idSkalaNlp;
    }
     
}
