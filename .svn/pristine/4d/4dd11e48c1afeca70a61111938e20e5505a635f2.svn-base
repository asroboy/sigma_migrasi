/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality.lilineage;

import model.metadata.xml.ParentElement;
import model.metadata.xml.metadataentitysetinformation.CiResponsibleParty;

/**
 *
 * @author WIN8
 */
public class LiProcessStep {
    
    private String subparent;
    private String current="gmd:LI_ProcessStep";
    private String description="gmd:description.gco:CharacterString";
    private String rationale="gmd:rationale.gco:CharacterString";
    private String dateTime="gmd:dateTime.gco:DateTime";
    private CiResponsibleParty ciResponsibleParty;

    
    public LiProcessStep(String parent) {
        subparent = parent+"."+current;
    }

    public String Description() {
        return subparent+"."+description;
    }

    public String Rationale() {
        return subparent+"."+rationale;
    }

    public String DateTime() {
        return subparent+"."+dateTime;
    }

    public CiResponsibleParty CiResponsibleParty() {
        ciResponsibleParty=new CiResponsibleParty(subparent+"."+ParentElement.PROCESSOR);
        return ciResponsibleParty;
    }
    
}
