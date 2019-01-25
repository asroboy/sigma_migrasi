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
public class MdLegalConstraints {
    
    private String subparent;
    private String current="gmd:MD_LegalConstraints";
    private String otherConstraints="gmd:otherConstraints.gco:CharacterString";
   

    public MdLegalConstraints(String parent) {
        this.subparent = parent+"."+current;
    }

    public String OtherConstraints() {
        return subparent+"."+otherConstraints;
    }

    
}
