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
public class MdExtendedElementInfoRat implements java.io.Serializable{
    
    private BigDecimal mdExtendedElementInfoId;
    private String rationale;

    public MdExtendedElementInfoRat() {
    }

    public MdExtendedElementInfoRat(BigDecimal mdExtendedElementInfoId) {
        this.mdExtendedElementInfoId = mdExtendedElementInfoId;
    }

    public MdExtendedElementInfoRat(BigDecimal mdExtendedElementInfoId, String rationale) {
        this.mdExtendedElementInfoId = mdExtendedElementInfoId;
        this.rationale = rationale;
    }
        
    public BigDecimal getMdExtendedElementInfoId() {
        return mdExtendedElementInfoId;
    }

    public void setMdExtendedElementInfoId(BigDecimal mdExtendedElementInfoId) {
        this.mdExtendedElementInfoId = mdExtendedElementInfoId;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }
    
    
}
