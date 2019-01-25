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
public class MdMediumDensity implements java.io.Serializable{
    
    private BigDecimal mdMetadataId;
    private BigDecimal float_;

    public MdMediumDensity() {
    }

    public MdMediumDensity(BigDecimal mdMetadataId) {
        this.mdMetadataId = mdMetadataId;
    }

    public MdMediumDensity(BigDecimal mdMetadataId, BigDecimal float_) {
        this.mdMetadataId = mdMetadataId;
        this.float_ = float_;
    }

    public BigDecimal getMdMetadataId() {
        return mdMetadataId;
    }

    public void setMdMetadataId(BigDecimal mdMetadataId) {
        this.mdMetadataId = mdMetadataId;
    }

    public BigDecimal getFloat_() {
        return float_;
    }

    public void setFloat_(BigDecimal float_) {
        this.float_ = float_;
    }
    
    
}
