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
public class MdIdentifierModel {
    
    public static final String MDAGGREGATEINFOID="mdAggregateInfoId"; 
    public static final String CICITATIONID="ciCitationId";
    public static final String DQELEMENTID="dqElementId";
    public static final String EXGEOGRAPHICDESCRIPTIONID="exgeographicdescriptionid";
    public static final String MDIMAGEDESCRIPTIONIQC="mdimagedescriptioniqc";
    public static final String MDIMAGEDESCRIPTIONPLC="mdimagedescriptionplc";
    private BigDecimal id;
    private String extendsType;
    private String code;
    private BigDecimal mdAggregationInfoId;
    private BigDecimal ciCitationId;
    private BigDecimal dqElementId;
    private BigDecimal exGeographicDescriptionId;
    private BigDecimal mdImageDescriptionIdIqc;
    private BigDecimal mdImageDescriptionIdPlc;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(String extendsType) {
        this.extendsType = extendsType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getMdAggregationInfoId() {
        return mdAggregationInfoId;
    }

    public void setMdAggregationInfoId(BigDecimal mdAggregationInfoId) {
        this.mdAggregationInfoId = mdAggregationInfoId;
    }

    public BigDecimal getCiCitationId() {
        return ciCitationId;
    }

    public void setCiCitationId(BigDecimal ciCitationId) {
        this.ciCitationId = ciCitationId;
    }

    public BigDecimal getDqElementId() {
        return dqElementId;
    }

    public void setDqElementId(BigDecimal dqElementId) {
        this.dqElementId = dqElementId;
    }

    public BigDecimal getExGeographicDescriptionId() {
        return exGeographicDescriptionId;
    }

    public void setExGeographicDescriptionId(BigDecimal exGeographicDescriptionId) {
        this.exGeographicDescriptionId = exGeographicDescriptionId;
    }

    public BigDecimal getMdImageDescriptionIdIqc() {
        return mdImageDescriptionIdIqc;
    }

    public void setMdImageDescriptionIdIqc(BigDecimal mdImageDescriptionIdIqc) {
        this.mdImageDescriptionIdIqc = mdImageDescriptionIdIqc;
    }

    public BigDecimal getMdImageDescriptionIdPlc() {
        return mdImageDescriptionIdPlc;
    }

    public void setMdImageDescriptionIdPlc(BigDecimal mdImageDescriptionIdPlc) {
        this.mdImageDescriptionIdPlc = mdImageDescriptionIdPlc;
    }
    
}
