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
public class MdGeorectifiedCornerPointsModel {
    
    
    private BigDecimal mdGeorectifiedId;
    private String cornerPoints;
    
    public BigDecimal getMdGeorectifiedId() {
        return mdGeorectifiedId;
    }

    public void setMdGeorectifiedId(BigDecimal mdGeorectifiedId) {
        this.mdGeorectifiedId = mdGeorectifiedId;
    }

    public String getCornerPoints() {
        return cornerPoints;
    }

    public void setCornerPoints(String cornerPoints) {
        this.cornerPoints = cornerPoints;
    }
    
}
