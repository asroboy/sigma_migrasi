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
public class MdFeatureCatalogueDescLangModel {
     
    
    private BigDecimal mdFeatureCatalogueDescId;
    private String language;

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
