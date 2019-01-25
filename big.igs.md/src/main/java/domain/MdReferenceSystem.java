/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;

/**
 *
 * @author wallet
 */
public class MdReferenceSystem implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal mdMetadataId;
    private BigDecimal liSourceId;

    public MdReferenceSystem() {
    }

    public MdReferenceSystem(BigDecimal id) {
        this.id = id;
    }

    public MdReferenceSystem(BigDecimal id, BigDecimal mdMetadataId, BigDecimal liSourceId) {
        this.id = id;
        this.mdMetadataId = mdMetadataId;
        this.liSourceId = liSourceId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getMdMetadataId() {
        return mdMetadataId;
    }

    public void setMdMetadataId(BigDecimal mdMetadataId) {
        this.mdMetadataId = mdMetadataId;
    }

    public BigDecimal getLiSourceId() {
        return liSourceId;
    }

    public void setLiSourceId(BigDecimal liSourceId) {
        this.liSourceId = liSourceId;
    }
    
    
}
