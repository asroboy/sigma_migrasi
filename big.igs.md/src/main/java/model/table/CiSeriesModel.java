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
public class CiSeriesModel {
    
    private BigDecimal id;
    private String issueIdentification;
    private String name;
    private String page;
    private BigDecimal ciCitationId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getIssueIdentification() {
        return issueIdentification;
    }

    public void setIssueIdentification(String issueIdentification) {
        this.issueIdentification = issueIdentification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public BigDecimal getCiCitationId() {
        return ciCitationId;
    }

    public void setCiCitationId(BigDecimal ciCitationId) {
        this.ciCitationId = ciCitationId;
    }
    
}
