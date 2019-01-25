/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.aggregationInfo;

import model.metadata.xml.ParentElement;
import model.metadata.xml.referencesystemInfo.CiCitation;

/**
 *
 * @author wallet
 */
public class MdIdentifier {
    
    private String subParent;
    private String current="gmd:MD_Identifier";
    private String code="gmd:code.gco:CharacterString";
    private CiCitation ciCitation;
    
    public MdIdentifier(String parent) {
        subParent = parent+"."+current;
    }
    
    public String Code() {
        return subParent+"."+code;
    }

    public CiCitation CiCitation() {
        ciCitation=new CiCitation(subParent+"."+ParentElement.AUTHORITY);
        return ciCitation;
    }
        
    
}
