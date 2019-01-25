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
public class SvOperationMetadataDcp implements java.io.Serializable{
    
    private BigDecimal svOperationMetadataId;
    private String dcp;

    public SvOperationMetadataDcp() {
    }

    public SvOperationMetadataDcp(BigDecimal svOperationMetadataId) {
        this.svOperationMetadataId = svOperationMetadataId;
    }

    public SvOperationMetadataDcp(BigDecimal svOperationMetadataId, String dcp) {
        this.svOperationMetadataId = svOperationMetadataId;
        this.dcp = dcp;
    }
    
    public BigDecimal getSvOperationMetadataId() {
        return svOperationMetadataId;
    }

    public void setSvOperationMetadataId(BigDecimal svOperationMetadataId) {
        this.svOperationMetadataId = svOperationMetadataId;
    }

    public String getDcp() {
        return dcp;
    }

    public void setDcp(String dcp) {
        this.dcp = dcp;
    }
    
    
}
