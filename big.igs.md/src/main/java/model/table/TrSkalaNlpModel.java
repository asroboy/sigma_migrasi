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
public class TrSkalaNlpModel {
    
    private BigDecimal id;
    private BigDecimal idSkala;
    private String noNlp;
    private BigDecimal latKa;
    private BigDecimal lonKa;
    private BigDecimal latKb;
    private BigDecimal lonKb;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getIdSkala() {
        return idSkala;
    }

    public void setIdSkala(BigDecimal idSkala) {
        this.idSkala = idSkala;
    }

    public String getNoNlp() {
        return noNlp;
    }

    public void setNoNlp(String noNlp) {
        this.noNlp = noNlp;
    }

    public BigDecimal getLatKa() {
        return latKa;
    }

    public void setLatKa(BigDecimal latKa) {
        this.latKa = latKa;
    }

    public BigDecimal getLonKa() {
        return lonKa;
    }

    public void setLonKa(BigDecimal lonKa) {
        this.lonKa = lonKa;
    }

    public BigDecimal getLatKb() {
        return latKb;
    }

    public void setLatKb(BigDecimal latKb) {
        this.latKb = latKb;
    }

    public BigDecimal getLonKb() {
        return lonKb;
    }

    public void setLonKb(BigDecimal lonKb) {
        this.lonKb = lonKb;
    }
    
}
