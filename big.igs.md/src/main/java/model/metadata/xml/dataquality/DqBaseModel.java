/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality;

import model.metadata.xml.ParentElement;
import model.metadata.xml.identificationinfo.aggregationInfo.MdIdentifier;
import model.metadata.xml.referencesystemInfo.CiCitation;

/**
 *
 * @author wallet
 */
public class DqBaseModel {
    
    private String subParent;
    private String nameOfMeasure="gmd:nameOfMeasure.gco:CharacterString";
    private String measureDescription="gmd:measureDescription.gco:CharacterString";
    private String evaluationMethodType="gmd:evaluationMethodType.gmd:DQ_EvaluationMethodTypeCode";
    private String evaluationMethodDescription="gmd:evaluationMethodDescription.gco:CharacterString";
    private String dateTime="gmd:dateTime.gco:DateTime";
    private DqConformanceResult dqConformanceResult;
    private DqQuantitativeResult dqQuantitativeResult;
    private MdIdentifier mdIdentifier;
    private CiCitation ciCitation;

    public DqBaseModel(String Parent) {
        this.subParent = Parent;
    }

    public String NameOfMeasure() {
        return subParent+"."+nameOfMeasure;
    }

    public String MeasureDescription() {
        return subParent+"."+measureDescription;
    }

    public String EvaluationMethodType() {
        return subParent+"."+evaluationMethodType;
    }

    public String EvaluationMethodDescription() {
        return subParent+"."+evaluationMethodDescription;
    }

    public String DateTime() {
        return subParent+"."+dateTime;
    }

    public DqConformanceResult DqConformanceResult() {
        dqConformanceResult = new DqConformanceResult(subParent+"."+ParentElement.RESULT);
        return dqConformanceResult;
    }

    public DqQuantitativeResult DqQuantitativeResult() {
        dqQuantitativeResult = new DqQuantitativeResult(subParent+"."+ParentElement.RESULT);
        return dqQuantitativeResult;
    }

    public MdIdentifier MdIdentifier() {
        mdIdentifier=new MdIdentifier(subParent+"."+ParentElement.MEASUREIDENTIFICATION);
        return mdIdentifier;
    }

    public CiCitation CiCitation() {
        ciCitation=new CiCitation(subParent+"."+ParentElement.EVALUATIONPROCEDURE);
        return ciCitation;
    }

}
