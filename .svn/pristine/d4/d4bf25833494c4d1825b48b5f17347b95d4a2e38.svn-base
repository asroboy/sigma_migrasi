/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.referencesystemInfo;

import model.metadata.xml.ParentElement;

/**
 *
 * @author wallet
 */
public class RsIdentifier {
    
    private String subParent;
    private String current="gmd:RS_Identifier";
    private CiCitation ciCitation;
    private String code="gmd:code.gco:CharacterString";
    private String codeSpace="gmd:codeSpace.gco:CharacterString";
    private String version="gmd:version.gco:CharacterString";

    public RsIdentifier(String parent) {
        subParent=parent+"."+current;
    }

    public CiCitation CiCitation() {
        ciCitation=new CiCitation(subParent+"."+ParentElement.AUTHORITY);
        return ciCitation;
    }

    public String Code() {
        return subParent+"."+code;
    }

    public String CodeSpace() {
        return subParent+"."+codeSpace;
    }

    public String Version() {
        return subParent+"."+version;
    }
   
}
