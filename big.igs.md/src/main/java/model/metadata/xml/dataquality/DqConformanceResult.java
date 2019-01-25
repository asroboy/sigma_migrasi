/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality;

import model.metadata.xml.ParentElement;
import model.metadata.xml.referencesystemInfo.CiCitation;

/**
 *
 * @author wallet
 */
public class DqConformanceResult {
    
    private String subparent;
    private String current="gmd:DQ_ConformanceResult";
    private CiCitation ciCitation;
    private String explanation="gmd:explanation.gco:CharacterString";
    private String pass="gmd:pass.gco:Boolean";
    
    public DqConformanceResult(String parent) {
        subparent = parent+"."+current;
    }

    public String Explanation() {
        return subparent+"."+explanation;
    }

    public String Pass() {
        return subparent+"."+pass;
    }

    public CiCitation CiCitation() {
        ciCitation=new CiCitation(subparent+"."+ParentElement.SPESIFICATION);
        return ciCitation;
    }
    
    
}
