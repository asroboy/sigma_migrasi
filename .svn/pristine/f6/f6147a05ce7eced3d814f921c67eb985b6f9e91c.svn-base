/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.applicationschemaInfo;

import model.metadata.xml.ParentElement;
import model.metadata.xml.referencesystemInfo.CiCitation;

/**
 *
 * @author wallet
 */
public class MdApplicationSchemaInformation {
 
    private String current="gmd:MD_ApplicationSchemaInformation";
    private String subparent;
    private String title="gmd:title.gco:CharacterString";
    private String schemaLanguage="gmd:schemaLanguage.gco:CharacterString";
    private String constraintLanguage="gmd:constraintLanguage.gco:CharacterString";
    private CiCitation ciCitation;
   
    public MdApplicationSchemaInformation(String parent) {
        this.subparent = parent+"."+current;
    }

    public String SchemaLanguage() {
        return subparent+"."+schemaLanguage;
    }

    public String ConstraintLanguage() {
        return subparent+"."+constraintLanguage;
    }

    public CiCitation CiCitation() {
        ciCitation = new CiCitation(subparent+"."+ParentElement.NAME);
        return ciCitation;
    }
    
}
