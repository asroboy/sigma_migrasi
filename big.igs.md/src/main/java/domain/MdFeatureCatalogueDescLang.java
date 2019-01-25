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
public class MdFeatureCatalogueDescLang implements java.io.Serializable{
    
     private BigDecimal mdFeatureCatalogueDescId;
     private String language;

    public MdFeatureCatalogueDescLang() {
    }

    public MdFeatureCatalogueDescLang(BigDecimal mdFeatureCatalogueDescId) {
        this.mdFeatureCatalogueDescId = mdFeatureCatalogueDescId;
    }

    public MdFeatureCatalogueDescLang(BigDecimal mdFeatureCatalogueDescId, String language) {
        this.mdFeatureCatalogueDescId = mdFeatureCatalogueDescId;
        this.language = language;
    }

    public BigDecimal getMdFeatureCatalogueDescId() {
        return mdFeatureCatalogueDescId;
    }

    public void setMdFeatureCatalogueDescId(BigDecimal mdFeatureCatalogueDescId) {
        this.mdFeatureCatalogueDescId = mdFeatureCatalogueDescId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
     
     
}
