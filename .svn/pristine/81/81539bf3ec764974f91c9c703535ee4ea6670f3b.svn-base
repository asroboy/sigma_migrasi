/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author wallet
 */
public class LiProcessStep implements java.io.Serializable{
    
    private BigDecimal id;
    private Timestamp dateTime;
    private String description;
    private String rationale;
    private BigDecimal liLineageId;
    private BigDecimal liSourceId;

    public LiProcessStep() {
    }

    public LiProcessStep(BigDecimal id) {
        this.id = id;
    }

    public LiProcessStep(BigDecimal id, Timestamp dateTime, String description, String rationale, BigDecimal liLineageId, BigDecimal liSourceId) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.rationale = rationale;
        this.liLineageId = liLineageId;
        this.liSourceId = liSourceId;
    }

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
    
    
}
