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
public class TrAplUserModel {
    
    private BigDecimal id;
    private BigDecimal idApl;
    private String namaUser;
    private String ldapUser;
    private String pasword;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getIdApl() {
        return idApl;
    }

    public void setIdApl(BigDecimal idApl) {
        this.idApl = idApl;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getLdapUser() {
        return ldapUser;
    }

    public void setLdapUser(String ldapUser) {
        this.ldapUser = ldapUser;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
