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
public class SvServiceIdentificationVer implements java.io.Serializable{
    
    private BigDecimal svServiceIdentificationId;
    private String serviceTypeVersion;

    public SvServiceIdentificationVer() {
    }

    public SvServiceIdentificationVer(BigDecimal svServiceIdentificationId) {
        this.svServiceIdentificationId = svServiceIdentificationId;
    }

    public SvServiceIdentificationVer(BigDecimal svServiceIdentificationId, String serviceTypeVersion) {
        this.svServiceIdentificationId = svServiceIdentificationId;
        this.serviceTypeVersion = serviceTypeVersion;
    }
   
    public BigDecimal getSvServiceIdentificationId() {
        return svServiceIdentificationId;
    }

    public void setSvServiceIdentificationId(BigDecimal svServiceIdentificationId) {
        this.svServiceIdentificationId = svServiceIdentificationId;
    }

    public String getServiceTypeVersion() {
        return serviceTypeVersion;
    }

    public void setServiceTypeVersion(String serviceTypeVersion) {
        this.serviceTypeVersion = serviceTypeVersion;
    }
    
    
    
}
