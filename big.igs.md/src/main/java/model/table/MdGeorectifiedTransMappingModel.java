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
public class MdGeorectifiedTransMappingModel {
    
    private BigDecimal mdGeorecitifedId;
    private String tranformationDimensionMapping;

    public BigDecimal getMdGeorecitifedId() {
        return mdGeorecitifedId;
    }

    public void setMdGeorecitifedId(BigDecimal mdGeorecitifedId) {
        this.mdGeorecitifedId = mdGeorecitifedId;
    }

    public String getTranformationDimensionMapping() {
        return tranformationDimensionMapping;
    }

    public void setTranformationDimensionMapping(String tranformationDimensionMapping) {
        this.tranformationDimensionMapping = tranformationDimensionMapping;
    }
}
