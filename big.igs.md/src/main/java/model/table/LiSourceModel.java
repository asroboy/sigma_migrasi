package model.table;


import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wallet
 */
public class LiSourceModel {
    
    public static final String LI_LINEAGEID="liLineageId";
    public static final String LI_PROCESSSTEPID="liProcessStepId";
    
    private BigDecimal id;
    private String description;
    private BigDecimal liLineageId;
    private BigDecimal liProcessStepId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getLiLineageId() {
        return liLineageId;
    }

    public void setLiLineageId(BigDecimal liLineageId) {
        this.liLineageId = liLineageId;
    }

    public BigDecimal getLiProcessStepId() {
        return liProcessStepId;
    }

    public void setLiProcessStepId(BigDecimal liProcessStepId) {
        this.liProcessStepId = liProcessStepId;
    }
    
    
    
}
