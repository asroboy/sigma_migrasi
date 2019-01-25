/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.metadataconstraints;

import model.metadata.xml.ParentElement;

/**
 *
 * @author wallet
 */
public class MdConstraints {
    
    private String subParent;
    private String current="gmd:MD_Constraints";
    private String useLimitation="gmd:useLimitation.gco:CharacterString";

    public MdConstraints(String parent) {
        subParent= parent+"."+current;
    }

    public String UseLimitation() {
        return subParent+"."+useLimitation;
    }
    
    
}
