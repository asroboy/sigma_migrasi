/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;

/**
 *
 * @author wallet
 */
public class MdDataIdentificationModel {
    
    private String environmentDescription;
    private String suplementationInformation;
    private BigDecimal id;
    private BigDecimal svServiceidentificationId;

 
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }
    
    public String getEnvironmentDescription() {
        return environmentDescription;
    }

    public void setEnvironmentDescription(String environmentDescription) {
        this.environmentDescription = environmentDescription;
    }

    public String getSuplementationInformation() {
        return suplementationInformation;
    }

    public void setSuplementationInformation(String suplementationInformation) {
        this.suplementationInformation = suplementationInformation;
    }

    public BigDecimal getSvServiceidentificationId() {
        return svServiceidentificationId;
    }

    public void setSvServiceidentificationId(BigDecimal svServiceidentificationId) {
        this.svServiceidentificationId = svServiceidentificationId;
    }
    
}
