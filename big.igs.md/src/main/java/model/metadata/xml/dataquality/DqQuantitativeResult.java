/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality;

import model.metadata.xml.ParentElement;

/**
 *
 * @author wallet
 */
public class DqQuantitativeResult {
    
    private String subparent;
    private String current="gmd:DQ_QuantitativeResult";
    private String valueType="gmd:valueType.gco:RecordType";
    private ValueUnit valueUnit;
    private String errorStatistic="gmd:errorStatistic.gco:CharacterString";
    private String value="gmd:value.gco:Record";

    public DqQuantitativeResult(String parent) {
        subparent = parent+"."+current;
    }

    public String ValueType() {
        return subparent+"."+valueType;
    }

    public ValueUnit ValueUnit() {
        valueUnit = new ValueUnit(subparent);
        return valueUnit;
    }

    public String ErrorStatistic() {
        return subparent+"."+errorStatistic;
    }

    public String Value() {
        return subparent+"."+value;
    }
    
}
