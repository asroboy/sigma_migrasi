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
public class DqElementModel { 
     
    public static final String DQ_COMPCOMMID="dqCompCommId";
    public static final String DQ_COMPOMID="dqCompOmId";
    public static final String DQ_CONCCONSISID="dqConcConsisId";
    public static final String DQ_DOMCONSISID="dqDomConsisId"; 
    public static final String DQ_FORMCONSISID="dqFormConsisId";
    public static final String DQ_TOPCONSISID="dqTopConsisId";
    public static final String DQ_ABSEXTPOSACCID="dqAbsExtPosAccId";
    public static final String DQ_GRIDDATAPOSACCID="dqGridDataPosAccId";
    public static final String DQ_RELLNTPOSACCID="dqRellNtPosAccId";
    public static final String DQ_ACCTIMEMEASID="dqAccTimeMeAsId";
    public static final String DQ_TEMPCONSISID="dqTempConsisId";
    public static final String DQ_TEMPVALIDID="dqTempValidId";
    public static final String DQ_THEMCLASSCORID="dqThemClassCorId";
    public static final String DQ_NONQUANATTACCID="dqNonQuanAttaccId";
    public static final String DQ_QUANATTACCID="dqQuanAttaccId";
             
    private BigDecimal id;
    private String evaluationMethodDescription;
    private String extendsType;
    private String measureDescription;
    private BigDecimal dqDataQualityId;
    private String evaluationMethodType;
    private BigDecimal dqCompCommId;
    private BigDecimal dqCompOmId;
    private BigDecimal dqConcConsisId;
    private BigDecimal dqDomConsisId;
    private BigDecimal dqFormConsisId;
    private BigDecimal dqTopConsisId;
    private BigDecimal dqAbsExtPosAccId;
    private BigDecimal dqGridDataPosAccId;
    private BigDecimal dqRellNtPosAccId;
    private BigDecimal dqAccTimeMeAsId;
    private BigDecimal dqTempConsisId;
    private BigDecimal dqTempValidId;
    private BigDecimal dqThemClassCorId;
    private BigDecimal dqNonQuanAttaccId;
    private BigDecimal dqQuanAttaccId;

    public DqElementModel(BigDecimal id) {
        this.id = id;
    }

    public DqElementModel() {
    }
    
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEvaluationMethodDescription() {
        return evaluationMethodDescription;
    }

    public void setEvaluationMethodDescription(String evaluationMethodDescription) {
        this.evaluationMethodDescription = evaluationMethodDescription;
    }

    public String getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(String extendsType) {
        this.extendsType = extendsType;
    }

    public String getMeasureDescription() {
        return measureDescription;
    }

    public void setMeasureDescription(String measureDescription) {
        this.measureDescription = measureDescription;
    }

    public BigDecimal getDqDataQualityId() {
        return dqDataQualityId;
    }

    public void setDqDataQualityId(BigDecimal dqDataQualityId) {
        this.dqDataQualityId = dqDataQualityId;
    }

    public String getEvaluationMethodType() {
        return evaluationMethodType;
    }

    public void setEvaluationMethodType(String evaluationMethodType) {
        this.evaluationMethodType = evaluationMethodType;
    }

    public BigDecimal getDqCompCommId() {
        return dqCompCommId;
    }

    public void setDqCompCommId(BigDecimal dqCompCommId) {
        this.dqCompCommId = dqCompCommId;
    }

    public BigDecimal getDqCompOmId() {
        return dqCompOmId;
    }

    public void setDqCompOmId(BigDecimal dqCompOmId) {
        this.dqCompOmId = dqCompOmId;
    }

    public BigDecimal getDqConcConsisId() {
        return dqConcConsisId;
    }

    public void setDqConcConsisId(BigDecimal dqConcConsisId) {
        this.dqConcConsisId = dqConcConsisId;
    }

    public BigDecimal getDqDomConsisId() {
        return dqDomConsisId;
    }

    public void setDqDomConsisId(BigDecimal dqDomConsisId) {
        this.dqDomConsisId = dqDomConsisId;
    }

    public BigDecimal getDqFormConsisId() {
        return dqFormConsisId;
    }

    public void setDqFormConsisId(BigDecimal dqFormConsisId) {
        this.dqFormConsisId = dqFormConsisId;
    }

    public BigDecimal getDqTopConsisId() {
        return dqTopConsisId;
    }

    public void setDqTopConsisId(BigDecimal dqTopConsisId) {
        this.dqTopConsisId = dqTopConsisId;
    }

    public BigDecimal getDqAbsExtPosAccId() {
        return dqAbsExtPosAccId;
    }

    public void setDqAbsExtPosAccId(BigDecimal dqAbsExtPosAccId) {
        this.dqAbsExtPosAccId = dqAbsExtPosAccId;
    }

    public BigDecimal getDqGridDataPosAccId() {
        return dqGridDataPosAccId;
    }

    public void setDqGridDataPosAccId(BigDecimal dqGridDataPosAccId) {
        this.dqGridDataPosAccId = dqGridDataPosAccId;
    }

    public BigDecimal getDqRellNtPosAccId() {
        return dqRellNtPosAccId;
    }

    public void setDqRellNtPosAccId(BigDecimal dqRellNtPosAccId) {
        this.dqRellNtPosAccId = dqRellNtPosAccId;
    }

    public BigDecimal getDqAccTimeMeAsId() {
        return dqAccTimeMeAsId;
    }

    public void setDqAccTimeMeAsId(BigDecimal dqAccTimeMeAsId) {
        this.dqAccTimeMeAsId = dqAccTimeMeAsId;
    }

    public BigDecimal getDqTempConsisId() {
        return dqTempConsisId;
    }

    public void setDqTempConsisId(BigDecimal dqTempConsisId) {
        this.dqTempConsisId = dqTempConsisId;
    }

    public BigDecimal getDqTempValidId() {
        return dqTempValidId;
    }

    public void setDqTempValidId(BigDecimal dqTempValidId) {
        this.dqTempValidId = dqTempValidId;
    }

    public BigDecimal getDqThemClassCorId() {
        return dqThemClassCorId;
    }

    public void setDqThemClassCorId(BigDecimal dqThemClassCorId) {
        this.dqThemClassCorId = dqThemClassCorId;
    }

    public BigDecimal getDqNonQuanAttaccId() {
        return dqNonQuanAttaccId;
    }

    public void setDqNonQuanAttaccId(BigDecimal dqNonQuanAttaccId) {
        this.dqNonQuanAttaccId = dqNonQuanAttaccId;
    }

    public BigDecimal getDqQuanAttaccId() {
        return dqQuanAttaccId;
    }

    public void setDqQuanAttaccId(BigDecimal dqQuanAttaccId) {
        this.dqQuanAttaccId = dqQuanAttaccId;
    }

  
   
    
    
}
