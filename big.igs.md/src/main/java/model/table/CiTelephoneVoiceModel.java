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
public class CiTelephoneVoiceModel {
    
    public static final String CI_TELEPHONEID="ciTelephoneId";
    private BigDecimal ciTelephoneId;
    private String voice;

    public BigDecimal getCiTelephoneId() {
        return ciTelephoneId;
    }

    public void setCiTelephoneId(BigDecimal ciTelephoneId) {
        this.ciTelephoneId = ciTelephoneId;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
