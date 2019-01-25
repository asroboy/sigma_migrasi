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
public class PtLocaleModel {
    
    private BigDecimal id;
    private String country;
    private String languageCode;
    private String CharacterEncoding;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCharacterEncoding() {
        return CharacterEncoding;
    }

    public void setCharacterEncoding(String CharacterEncoding) {
        this.CharacterEncoding = CharacterEncoding;
    }
}
