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
public class MdDataIdentificationLangModel {
    
    private BigDecimal mdDataIdentificationId;
    private String language;

    public BigDecimal getMdDataIdentificationId() {
        return mdDataIdentificationId;
    }

    public void setMdDataIdentificationId(BigDecimal mdDataIdentificationId) {
        this.mdDataIdentificationId = mdDataIdentificationId;
    }
    
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
