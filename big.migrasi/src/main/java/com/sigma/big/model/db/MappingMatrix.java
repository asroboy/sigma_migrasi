/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.model.db;

import java.sql.Date;

/**
 *
 * @author Ridho
 */
public class MappingMatrix {

    int id;
    String name;
    String tableSource;
    String tableTarget;
    Date createdDate;
    String createdBy;
    DBConConfiguration connSumber;
    String whereClause;

    public String getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(String whereClause) {
        this.whereClause = whereClause;
    }

    public DBConConfiguration getConnSumber() {
        return connSumber;
    }

    public void setConnSumber(DBConConfiguration connSumber) {
        this.connSumber = connSumber;
    }

    public DBConConfiguration getConnTarget() {
        return connTarget;
    }

    public void setConnTarget(DBConConfiguration connTarget) {
        this.connTarget = connTarget;
    }
    DBConConfiguration connTarget;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableSource() {
        return tableSource;
    }

    public void setTableSource(String tableSource) {
        this.tableSource = tableSource;
    }

    public String getTableTarget() {
        return tableTarget;
    }

    public void setTableTarget(String tableTarget) {
        this.tableTarget = tableTarget;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
