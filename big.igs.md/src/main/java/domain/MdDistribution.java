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
public class MdDistribution implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal mdMetadataId;

    public MdDistribution() {
    }

    public MdDistribution(BigDecimal id) {
        this.id = id;
    }

    public MdDistribution(BigDecimal id, BigDecimal mdMetadataId) {
        this.id = id;
        this.mdMetadataId = mdMetadataId;
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
    
}
