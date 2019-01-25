/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author wallet
 */
public class LdapUserAttributeValueModel {
    
    private BigDecimal id;
    private Date tanggal;
    private String afliasi;
    private BigDecimal count;


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getAfliasi() {
        return afliasi;
    }

    public void setAfliasi(String afliasi) {
        this.afliasi = afliasi;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
