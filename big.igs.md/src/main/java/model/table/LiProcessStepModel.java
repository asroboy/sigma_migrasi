/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author wallet
 */
public class LiProcessStepModel {
    
    public static final String LI_LINEAGE="liLineageId";
    public static final String LI_SOURCEID="liSourceId";
    
    private BigDecimal id;
    private Timestamp dateTime;
    private String description;
    private String rationale;
    private BigDecimal liLineageId;
    private BigDecimal liSourceId;
    private String stringDateTime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    public BigDecimal getLiLineageId() {
        return liLineageId;
    }

    public void setLiLineageId(BigDecimal liLineageId) {
        this.liLineageId = liLineageId;
    }

    public BigDecimal getLiSourceId() {
        return liSourceId;
    }

    public void setLiSourceId(BigDecimal liSourceId) {
        this.liSourceId = liSourceId;
    }

    public String getStringDateTime() {
        return stringDateTime;
    }

    public void setStringDateTime(String stringDateTime) {
        this.stringDateTime = stringDateTime;
    }
    
    
}
