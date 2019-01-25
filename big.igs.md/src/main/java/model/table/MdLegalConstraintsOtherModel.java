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
public class MdLegalConstraintsOtherModel {
    
     
    private BigDecimal mdLegalConstraintsId;
    private String otherConstraints;
    
    public BigDecimal getMdLegalConstraintsId() {
        return mdLegalConstraintsId;
    }

    public void setMdLegalConstraintsId(BigDecimal mdLegalConstraintsId) {
        this.mdLegalConstraintsId = mdLegalConstraintsId;
    }

    public String getOtherConstraints() {
        return otherConstraints;
    }

    public void setOtherConstraints(String otherConstraints) {
        this.otherConstraints = otherConstraints;
    }
    
    
}
