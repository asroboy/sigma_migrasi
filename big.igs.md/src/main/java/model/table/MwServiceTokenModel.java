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
public class MwServiceTokenModel {
    
    private BigDecimal id;
    private String token;
    private String status;
    private Date loginAt;
    private Date logoutAt;
    private Date lastAccess;
    private BigDecimal serviceUserIdFk;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }

    public Date getLogoutAt() {
        return logoutAt;
    }

    public void setLogoutAt(Date logoutAt) {
        this.logoutAt = logoutAt;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    public BigDecimal getServiceUserIdFk() {
        return serviceUserIdFk;
    }

    public void setServiceUserIdFk(BigDecimal serviceUserIdFk) {
        this.serviceUserIdFk = serviceUserIdFk;
    }

}
