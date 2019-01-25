/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.metadataconstraints;

/**
 *
 * @author wallet
 */
public class MdSecurityConstraints {
    
    private String subparent;
    private String current="gmd:MD_SecurityConstraints";
    private String classification="gmd:classification.gmd:MD_ClassificationCode";
    private String userNote="gmd:userNote.gco:CharacterString";
    private String classificationSystem="gmd:classificationSystem.gco:CharacterString";
    

    public MdSecurityConstraints(String parent) {
        this.subparent = parent+"."+current;
    }

    public String Classification() {
        return subparent+"."+classification;
    }

    public String UserNote() {
        return subparent+"."+userNote;
    }

    public String ClassificationSystem() {
        return subparent+"."+classificationSystem;
    }
    
}
