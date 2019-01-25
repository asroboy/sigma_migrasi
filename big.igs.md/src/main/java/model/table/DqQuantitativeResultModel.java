/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author wallet
 */
public class DqQuantitativeResultModel {
    
    private String errorStatistic;
    private String valueType;
    private String valueUnit;
    private List valueUnitList;
    private BigDecimal dqResultId;

    public String getErrorStatistic() {
        return errorStatistic;
    }

    public void setErrorStatistic(String errorStatistic) {
        this.errorStatistic = errorStatistic;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    public BigDecimal getDqResultId() {
        return dqResultId;
    }

    public void setDqResultId(BigDecimal dqResultId) {
        this.dqResultId = dqResultId;
    }

    public List getValueUnitList() {
        return valueUnitList;
    }

    public void setValueUnitList(List valueUnitList) {
        this.valueUnitList = valueUnitList;
    }

    
}
