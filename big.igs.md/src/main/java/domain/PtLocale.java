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
public class PtLocale implements java.io.Serializable{
    
    private BigDecimal id;
    private String country;
    private String languageCode;
    private String CharacterEncoding;

    public PtLocale() {
    }

    public PtLocale(BigDecimal id) {
        this.id = id;
    }

    public PtLocale(BigDecimal id, String country, String languageCode, String CharacterEncoding) {
        this.id = id;
        this.country = country;
        this.languageCode = languageCode;
        this.CharacterEncoding = CharacterEncoding;
    }
    
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
