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
public class MdMetadataExtensionInfo implements java.io.Serializable{
    
    private BigDecimal id;
    private BigDecimal mdMetadataId;

    public MdMetadataExtensionInfo() {
    }

    public MdMetadataExtensionInfo(BigDecimal id) {
        this.id = id;
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