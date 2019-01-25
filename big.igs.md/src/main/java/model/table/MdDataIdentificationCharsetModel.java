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
public class MdDataIdentificationCharsetModel {
    
    private BigDecimal mdDataIdentificationId;
    private String characterSet;

    public BigDecimal getMdDataIdentificationId() {
        return mdDataIdentificationId;
    }

    public void setMdDataIdentificationId(BigDecimal mdDataIdentificationId) {
        this.mdDataIdentificationId = mdDataIdentificationId;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }
    
}
